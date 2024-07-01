package com.bazan.devquiz.presentation.pages.topic.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bazan.devquiz.data.database.entities.TechnologyEntity
import com.bazan.devquiz.domain.useCases.technology.GetAllTechnologyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SelectTopicViewModel @Inject constructor(
    private val getAllTechnologyUseCase: GetAllTechnologyUseCase
): ViewModel() {
    val topicList = MutableLiveData<List<TechnologyEntity>>(emptyList())

    var idTechnology = 1

    init {
        getAllTechnologies()
    }

    private fun getAllTechnologies() {
        viewModelScope.launch {
            val res = getAllTechnologyUseCase()
            println("$res")
            topicList.postValue(res)
        }
    }
}