package com.example.praktikum12.apiservice

import com.example.praktikum12.modeldata.DataSiswa
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ServiceApiSiswa {
    @GET(value = "bacateman.php")
    suspend fun getsiswa(): List<DataSiswa>

    @POST(value = "insertTM.php")
    suspend fun postsiswa(@Body datasiswa: DataSiswa): retrofit2.Response<Void>)
}