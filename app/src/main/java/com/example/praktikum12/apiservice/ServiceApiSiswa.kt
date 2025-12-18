package com.example.praktikum12.apiservice

import com.example.praktikum12.modeldata.DataSiswa
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ServiceApiSiswa {
    @GET("bacateman.php")
    suspend fun getsiswa(): List<DataSiswa>

    @FormUrlEncoded
    @POST("insertTM.php")
    suspend fun postsiswa(
        @Field("nama") nama: String,
        @Field("alamat") alamat: String,
        @Field("telpon") telpon: String
    ): Response<Void>
}