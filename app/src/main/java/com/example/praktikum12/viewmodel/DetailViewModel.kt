package com.example.praktikum12.viewmodel

import com.example.praktikum12.modeldata.DataSiswa


sealed interface StatusUIDetail {
    data class Success(val satusiswa: DataSiswa) : StatusUIDetail
    object Error : StatusUIDetail
    object Loading : StatusUIDetail
}

class DetailViewModel {
}