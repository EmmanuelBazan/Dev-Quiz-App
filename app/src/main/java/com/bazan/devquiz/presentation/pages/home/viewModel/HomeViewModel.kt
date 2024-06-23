package com.bazan.devquiz.presentation.pages.home.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel() : ViewModel() {
    val questionReminders = MutableLiveData<List<String>?>(listOf("","","","","","",""))
}