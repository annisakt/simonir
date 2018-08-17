package com.example.annis.apps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import com.example.annis.apps.api.ApiService;
import com.example.annis.apps.api.RetrofitClient;
import com.example.annis.apps.api.UtilsApi;
import com.example.annis.apps.modal.Result;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UploadImageActivity extends AppCompatActivity {

    private Button mBtnUpload;
    public static final int PICK_IMAGE = 100;

    String nama_pelapor = "annisa";
    String no_hp = "085";
    String waktu = "17.00";
    String nama_sungai = "Bengawan Solo";
    String lokasi_sungai = "Ngawi";
    String deskripsi = "Normal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaduan);

        mBtnUpload = (Button) findViewById(R.id.btnsave);
        mBtnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent membuka Gallery
                Intent openGalleryIntent = new Intent(Intent.ACTION_PICK);
                openGalleryIntent.setType("image/*");
                startActivityForResult(openGalleryIntent, PICK_IMAGE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {

            android.net.Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            android.database.Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);

            String filePath = selectedImage.getPath();
            if (cursor != null){
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                filePath = cursor.getString(columnIndex);
                cursor.close();
            }

            File file = new File(filePath);

            RequestBody reqFile = RequestBody.create(MediaType.parse("image/*"), file);
            MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), reqFile);
            RequestBody name = RequestBody.create(MediaType.parse("text/plain"), file.getName());

            //Upload Image Retrofit
            ApiService service = UtilsApi.getClient().create(ApiService.class);
            Call<Result> uploadImage = service.uploadImage(body, name, nama_pelapor, no_hp, nama_sungai, lokasi_sungai, deskripsi);
            uploadImage.enqueue(new Callback<Result>() {
                @Override
                public void onResponse(Call<Result> call, Response<Result> response) {
                    if (response.isSuccessful() && response.body().getError().equals(false)){
                        //Upload Berhasil
                        Toast.makeText(UploadImageActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        //Upload Gagal
                        Toast.makeText(UploadImageActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Result> call, Throwable t) {
                    //Tidak Bisa Terhubung Ke Server
                    Toast.makeText(UploadImageActivity.this, "Gagal Terhubung Ke Server", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
