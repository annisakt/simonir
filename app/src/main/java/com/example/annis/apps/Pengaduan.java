package com.example.annis.apps;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.annis.apps.api.ApiService;
import com.example.annis.apps.api.UtilsApi;
import com.example.annis.apps.modal.Result;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

    public class Pengaduan extends AppCompatActivity {

        private EditText mNamaPelapor;
        private EditText mNoHp;
        private EditText mNamaSungai;
        private EditText mLokasiSungai;
        private EditText mDeskripsi;
        private Button mBtnUpload;
        private Button mBtnSimpan;
        public static final int PICK_IMAGE = 100;

        MultipartBody.Part body;
        RequestBody name;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_pengaduan);

            mNamaPelapor = (EditText) findViewById(R.id.editText);
            mNoHp = (EditText) findViewById(R.id.editText1);
            mNamaSungai = (EditText) findViewById(R.id.editText2);
            mLokasiSungai = (EditText) findViewById(R.id.editText3);
            mDeskripsi = (EditText) findViewById(R.id.editText4);
            mBtnUpload = (Button) findViewById(R.id.btn_upload);
            mBtnSimpan = (Button) findViewById(R.id.btnsave);

            mBtnUpload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Intent membuka Gallery
                    Intent openGalleryIntent = new Intent(Intent.ACTION_PICK);
                    openGalleryIntent.setType("image/*");
                    startActivityForResult(openGalleryIntent, PICK_IMAGE);
                }
            });

            mBtnSimpan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    simpanKeServer(body,
                            name,
                            mNamaPelapor.getText().toString(),
                            mNoHp.getText().toString(),
                            mNamaSungai.getText().toString(),
                            mLokasiSungai.getText().toString(),
                            mDeskripsi.getText().toString());
                }
            });

        }

        private void simpanKeServer(MultipartBody.Part body, RequestBody name, String nama_pelapor, String no_hp, String nama_sungai, String lokasi_sungai, String deskripsi) {
            //Upload Image Retrofit
            ApiService service = UtilsApi.getClient().create(ApiService.class);
            Call<Result> uploadImage = service.uploadImage(body, name, nama_pelapor, no_hp, nama_sungai, lokasi_sungai, deskripsi);
            uploadImage.enqueue(new Callback<Result>() {
                @Override
                public void onResponse(Call<Result> call, Response<Result> response) {
                    if (response.isSuccessful() && response.body().getError().equals(false)) {
                        //Upload Berhasil
                        Toast.makeText(Pengaduan.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        //Upload Gagal
                        Toast.makeText(Pengaduan.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Result> call, Throwable t) {
                    t.printStackTrace();
                    //Tidak Bisa Terhubung Ke Server
                    Toast.makeText(Pengaduan.this, "Gagal Terhubung Ke Server", Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {

                Uri selectedImage = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);

                String filePath = selectedImage.getPath();
                if (cursor != null) {
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    filePath = cursor.getString(columnIndex);
                    cursor.close();
                }

                File file = new File(filePath);

                RequestBody reqFile = RequestBody.create(MediaType.parse("image/*"), file);
                body = MultipartBody.Part.createFormData("file", file.getName(), reqFile);
                name = RequestBody.create(MediaType.parse("text/plain"), file.getName());

            }
        }

    }
