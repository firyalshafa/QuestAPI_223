package com.example.praktikum12.repositori

import android.R.attr.level
import android.app.Application
import com.example.praktikum12.apiservice.ServiceApiSiswa
import okhttp3.OkHttpClient
import retrofit2.Retrofit

interface ContainerApp{
    val repositoryDataSiswa : RepositoryDataSiswa
}

class DefaultContainerApp : ContainerApp{
    private val baseurl="http://10.0.2.2/umyTI"
    val logging = HttploggingInterceptor()apply{
        level = HttploggingInterceptor.level.BODY
    }
    val klien = OkHttpClient.Builder()
        .addInterceptor (interceptor = logging)
        .build()

    private  val retrofit: Retrofit.Builder()
            .baseUrl(baseUrl = bsaeurl)
            .addConverterFactory(
                factory = Json{
                    ignoreUnknownKeys = true
                    prettyprint = true
                    isLenient = true
                }.asConvertFctory(con)
            )

    private val retrofitService: ServiceApiSiswa by lazy {
        retrofit.create(ServiceApiSiswa::class.java)
    }
    override val repositoryDataSiswa: RepositoryDataSiswa by lazy {
        JaringanRepositoryDataSiswa(serviceApiSiswa =  retrofitService)
    }

    class AplikasiDataSiswa : Application(){
        lateinit var  container: ContainerApp
        override  fun
    }


}