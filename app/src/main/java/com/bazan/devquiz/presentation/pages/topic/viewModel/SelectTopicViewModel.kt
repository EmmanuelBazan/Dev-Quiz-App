package com.bazan.devquiz.presentation.pages.topic.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SelectTopicViewModel(): ViewModel() {
    val topicList = MutableLiveData<List<String>?>(listOf("","","",""))
}