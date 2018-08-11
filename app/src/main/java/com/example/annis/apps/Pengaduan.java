package com.example.annis.apps;
import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.annis.apps.api.ApiService;
import com.example.annis.apps.api.UtilsApi;
import com.example.annis.apps.modal.DataSungai;
import com.example.annis.apps.modal.Result;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.example.annis.apps.modal.DataPengaduan;

import java.io.File;
import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

public class Pengaduan extends Fragment {

//    private static final int REQUEST_EXTERNAL_STORAGE = 1;
//    private static String[] PERMISSIONS_STORAGE = {
//            Manifest.permission.READ_EXTERNAL_STORAGE,
//            Manifest.permission.WRITE_EXTERNAL_STORAGE
//    };
//
    EditText editText4, editText2,editText3, editText, editText1;
    Button button1, btnsave;
    TextView txt1, txt2,txt3, txt4, txt5, txthp, txtfoto;
    ImageView fbukti;
    String imagePath;

    View v;
    public ArrayList<DataSungai> data;
    ProgressBar progressBar;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Adu");

    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_pengaduan, container, false);
//        verifyStoragePermissions(getActivity());
        txtfoto = (TextView)rootView.findViewById(R.id.textt);
        txt1 = (TextView) rootView.findViewById(R.id.txt1);
        txthp = (TextView) rootView.findViewById(R.id.txthp);
        txt2 = (TextView) rootView.findViewById(R.id.txt2);
        txt3 = (TextView) rootView.findViewById(R.id.txt1);
        txt4 = (TextView) rootView.findViewById(R.id.txt2);
        txt5 = (TextView) rootView.findViewById(R.id.txt1);
        editText = (EditText) rootView.findViewById(R.id.editText);
        editText1 = (EditText) rootView.findViewById(R.id.editText1);
        editText2 = (EditText) rootView.findViewById(R.id.editText2);
        editText3 = (EditText) rootView.findViewById(R.id.editText3);
        editText4 = (EditText) rootView.findViewById(R.id.editText4);
        progressBar = (ProgressBar) rootView.findViewById(R.id.progressbar);
        fbukti = (ImageView)rootView.findViewById(R.id.fotobukti);
        progressBar.setVisibility(View.GONE);

        // btn browse
//        button1 = (Button)rootView.findViewById(R.id.button1);
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final Intent galleryIntent = new Intent();
//                galleryIntent.setType("image/*");
//                galleryIntent.setAction(Intent.ACTION_PICK);
//
//                final Intent chooserIntent = Intent.createChooser(galleryIntent, "Choose image");
//                startActivityForResult(chooserIntent, 100);
//            }
//        });
        btnsave = (Button) rootView.findViewById(R.id.buttonsave);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                uploadImage();
                //simpan();
            }
        });
        return rootView;
    }

    private void simpan() {
        progressBar.setVisibility(View.VISIBLE);
        koneksi();
        String nama_pelapor = editText.getText().toString().trim();
        String no_hp = editText1.getText().toString().trim();
        String nama_sungai = editText2.getText().toString().trim();
        String lokasi_sungai = editText3.getText().toString().trim();
        String deskripsi = editText4.getText().toString().trim();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UtilsApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService api = retrofit.create(ApiService.class);
        Call<Result> call = api.insertLapo(nama_pelapor, no_hp, nama_sungai, lokasi_sungai, deskripsi,"bukti");
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                String value = response.body().getValue();
                String message = response.body().getMessage();
                progressBar.setVisibility(View.GONE);
                if (value.equals("1")) {
                    Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
                    Toast.makeText(getContext(), "Terimakasih atas laporan Anda.", Toast.LENGTH_SHORT).show();
                    Kosong();
                } else {
                    Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getContext(), "Jaringan Error!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void Kosong(){
        editText.setText("");
        editText1.setText("");
        editText2.setText("");
        editText3.setText("");
        editText4.setText("");
    }

//    public static void verifyStoragePermissions(Activity activity) {
//        // Check if we have write permission
//        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
//
//        if (permission != PackageManager.PERMISSION_GRANTED) {
//            // We don't have permission so prompt the user
//            ActivityCompat.requestPermissions(
//                    activity,
//                    PERMISSIONS_STORAGE,
//                    REQUEST_EXTERNAL_STORAGE
//            );
//        }
//    }

    private void uploadImage() {
        progressBar.setVisibility(View.VISIBLE);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://simonir.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        File file;
        if(imagePath != null) {
            file = new File(imagePath);
        }else {
            file = new File("image");
        }


        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        String nama_pelapor = editText.getText().toString().trim();
        String no_hp = editText1.getText().toString().trim();
        String nama_sungai = editText2.getText().toString().trim();
        String lokasi_sungai = editText3.getText().toString().trim();
        String deskripsi = editText4.getText().toString().trim();
        MultipartBody.Part body =
                MultipartBody.Part.createFormData("file", file.getName(), requestFile);
        MultipartBody.Part text1 = MultipartBody.Part.createFormData("nama_pelapor", editText.getText().toString().trim());
        MultipartBody.Part text2 = MultipartBody.Part.createFormData("no_hp", editText1.getText().toString().trim());
        MultipartBody.Part text3 = MultipartBody.Part.createFormData("nama_sungai", editText2.getText().toString().trim());
        MultipartBody.Part text4 = MultipartBody.Part.createFormData("lokasi_sungai", editText3.getText().toString().trim());
        MultipartBody.Part text5 = MultipartBody.Part.createFormData("deskripsi", editText4.getText().toString().trim());

        ApiService request = retrofit.create(ApiService.class);
        Call<Result> call = request.insertLaporan(text1, text2, text3, text4, text5,body);
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                if (response.isSuccessful()) {
                    progressBar.setVisibility(View.GONE);
                    if (response.body().getValue().equals("1")) {
                        Toast.makeText(getContext(), "Berhasil", Toast.LENGTH_SHORT).show();
                        Toast.makeText(getContext(), "Terimakasih atas laporan Anda.", Toast.LENGTH_SHORT).show();
                        Kosong();
                    } else {
                        Toast.makeText(getContext(), "Berhasil", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(getContext(),response.body().getMessage(),Toast.LENGTH_LONG).show();
                }

                //ifoto.setImageDrawable(null);
                imagePath = null;
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getContext(),"Jaringan Error",Toast.LENGTH_LONG).show();
            }
        });
    }

    private String getRealPathFromURI(Uri contentUri) {
        String[] proj = { MediaStore.Images.Media.DATA };
        CursorLoader loader = new CursorLoader(getContext(), contentUri, proj, null, null, null);
        Cursor cursor = loader.loadInBackground();
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String result = cursor.getString(column_index);
        cursor.close();
        return result;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 100) {
            if (data == null) {
                Toast.makeText(getContext(),"Unable to pick image",Toast.LENGTH_LONG).show();
                return;
            }

            Uri imageUri = data.getData();
            fbukti.setImageURI(imageUri);
            imagePath =getRealPathFromURI(imageUri);
            Toast.makeText(getContext(),imagePath, Toast.LENGTH_SHORT).show();
            txtfoto.setText(imagePath);

        }
    }

    private boolean adaInternet(){
        ConnectivityManager koneksi = (ConnectivityManager)getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        return koneksi.getActiveNetworkInfo() != null;
    }
    private void koneksi(){
        if(adaInternet()){
//            Toast.makeText(HalamanUtama.this, "Terhubung ke internet", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getContext(), "Tidak ada koneksi internet", Toast.LENGTH_LONG).show();
        }
    }
}

