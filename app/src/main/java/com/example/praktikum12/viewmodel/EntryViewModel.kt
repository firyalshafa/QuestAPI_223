package com.example.praktikum12.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.praktikum12.modeldata.UIStateSiswa
import com.example.praktikum12.repositori.RepositoryDataSiswa

class EntryViewModel(private val repositoryDataSiswa: RepositoryDataSiswa):
    ViewModel(){
    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    }