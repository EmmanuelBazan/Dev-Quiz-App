package com.bazan.devquiz.presentation.pages.home.viewModel

import com.bazan.devquiz.data.database.relations.ReminderFull
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bazan.devquiz.data.database.entities.ReminderEntity
import com.bazan.devquiz.domain.useCases.reminder.GetAllRemindersUseCase
import com.bazan.devquiz.domain.useCases.reminder.GetAllRemindersFullUseCase
import com.bazan.devquiz.domain.useCases.reminder.GetgetReminderWithTechnologyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllRemindersUseCase: GetAllRemindersUseCase,
    private val getgetReminderWithTechnologyUseCase: GetgetReminderWithTechnologyUseCase,
    private val getAllRemindersFullUseCase: GetAllRemindersFullUseCase,
) : ViewModel() {
    val questionReminders = MutableLiveData<List<ReminderEntity>?>(emptyList())
    val reminderFullList = MutableLiveData<List<ReminderFull>>(emptyList())

    init {
//        getAllReminders()
    }

    fun getAllReminders() {
        viewModelScope.launch {
            val res = getAllRemindersUseCase()
            questionReminders.postValue(res)
        }
    }

    fun getAllRemindersFull() {
        viewModelScope.launch {
            val res = getAllRemindersFullUseCase()
            reminderFullList.postValue(res)
        }
    }

    fun getReminderWithTech(id: Int) {
        viewModelScope.launch {
            val res = getgetReminderWithTechnologyUseCase(id)
        }
    }
}