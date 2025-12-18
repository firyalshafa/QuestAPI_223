package com.example.praktikum12.viewmodel



import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.praktikum12.modeldata.DataSiswa
import com.example.praktikum12.repositori.RepositoryDataSiswa
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface StatusUiSiswa {

}

