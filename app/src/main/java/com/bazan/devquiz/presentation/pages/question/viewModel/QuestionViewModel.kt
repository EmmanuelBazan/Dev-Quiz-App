package com.bazan.devquiz.presentation.pages.question.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bazan.devquiz.data.database.relations.FullQuestion
import com.bazan.devquiz.domain.useCases.question.GetQuestionByTechAndDifficultyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionViewModel @Inject constructor (
    private val getQuestionByTechAndDifficultyUseCase: GetQuestionByTechAndDifficultyUseCase
):ViewModel() {
    val questionList = MutableLiveData<List<FullQuestion>>(emptyList())

    fun getQuestionByTechAndDifficulty(idTech:Int,idDifficulty:Int) {
        viewModelScope.launch {
            val res = getQuestionByTechAndDifficultyUseCase(idTech, idDifficulty)
            questionList.postValue(res)
        }
    }
}