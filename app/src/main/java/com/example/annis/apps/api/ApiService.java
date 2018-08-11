package com.example.annis.apps.api;

import com.example.annis.apps.modal.Result;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Url;

/**
 * Created by annis on 04/05/2018.
 */

public interface ApiService {
    @GET()
    Call<JsonList>getData(@Url String url);

    @GET()
    Call<JsonList>getRekap(@Url String url);

    //insertdata
    @Multipart
    @POST("upload.php")
    Call<Result> insertLaporan(@Part MultipartBody.Part nama_pelapor,
                               @Part MultipartBody.Part no_hp,
                               @Part MultipartBody.Part nama_sungai,
                               @Part MultipartBody.Part lokasi_sungai,
                               @Part MultipartBody.Part deskripsi,
                               @Part MultipartBody.Part file);
    @FormUrlEncoded
    @POST("insert_laporan.php")
    Call<Result> insertLapo(@Field("nama_pelapor") String nama_pelapor,
                               @Field("no_hp") String no_hp,
                               @Field("nama_sungai") String nama_sungai,
                               @Field("lokasi_sungai") String lokasi_sungai,
                               @Field("deskripsi") String deskripsi,
                               @Field("bukti") String bukti);
    @Multipart
    @POST("insert_laporan.php")
    Call<Result> uploadBukti(@Part MultipartBody.Part file,
                             @Part MultipartBody.Part id_laporan);

}
