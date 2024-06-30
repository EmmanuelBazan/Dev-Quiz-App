package com.bazan.devquiz.presentation.pages.home.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bazan.devquiz.data.database.entities.ReminderEntity
import com.bazan.devquiz.domain.useCases.reminder.GetAllRemindersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllRemindersUseCase: GetAllRemindersUseCase
) : ViewModel() {
    val questionReminders = MutableLiveData<List<ReminderEntity>?>(emptyList())

    init {
        getAllReminders()
    }

    private fun getAllReminders() {
        viewModelScope.launch {
            val res = getAllRemindersUseCase()
            questionReminders.postValue(res)
        }
    }
}