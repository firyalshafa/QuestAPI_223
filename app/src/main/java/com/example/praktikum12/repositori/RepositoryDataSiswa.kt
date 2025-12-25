package com.example.praktikum12.repositori

import com.example.praktikum12.apiservice.ServiceApiSiswa
import com.example.praktikum12.modeldata.DataSiswa
import retrofit2.Response
import retrofit2.Retrofit

interface RepositoryDataSiswa {
    suspend fun getDataSiswa() : List<DataSiswa>
    suspend fun postDataSiswa(dataSiswa: DataSiswa) :retrofit2.Response<Void>
    suspend fun getSatuSiswa(id:Int) : DataSiswa



}