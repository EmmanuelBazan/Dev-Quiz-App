package com.bazan.devquiz.presentation.pages.schedule.viewModel

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bazan.devquiz.NotificationBroadcast
import com.bazan.devquiz.data.database.entities.ReminderEntity
import com.bazan.devquiz.domain.useCases.reminder.GetReminderFullByIdUseCase
import com.bazan.devquiz.domain.useCases.reminder.InsertReminderUseCase
import com.bazan.devquiz.domain.useCases.technology.GetTechnologyByIdUseCase
import com.bazan.devquiz.presentation.utils.DateTimeUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class ScheduleScreenViewModel @Inject constructor(
    private val insertReminderUseCase: InsertReminderUseCase,
    private val getTechnologyByIdUseCase: GetTechnologyByIdUseCase,
) : ViewModel() {

    private val dateTimeUtils = DateTimeUtils()

    val daysToSchedule =
        MutableLiveData<List<Boolean>>(arrayListOf(true, true, true, true, true, true, true))

    val mutableName = MutableLiveData<String>("")
    val mutableHour = MutableLiveData<String>("")

    private var setHours = 0
    private var setMinutes = 0

    var reminderName = ""
    var reminderSchedule = ""
    var idDifficulty = 1
    var idTechnology = 1

    init {

    }

    fun getCurrentHour() {
        val current = dateTimeUtils.getCurrentHour()
        val (hours, _, minutes) = current.split(" ").map { it }
        setHours = hours.toInt()
        setMinutes = minutes.toInt()
        mutableHour.postValue(current)
    }

    fun getReminderDefaultName() {
        viewModelScope.launch {
            val res = getTechnologyByIdUseCase(idTechnology)
            reminderName = "Recordatorio para ${res.name}"
            mutableName.postValue("Recordatorio para ${res.name}")
        }
    }

    fun switchDayToSchedule(index: Int) {
        val currentDays = daysToSchedule.value ?: return

        val modifiedDays = currentDays.toMutableList().apply {
            this[index] = !this[index]
        }

        daysToSchedule.postValue(modifiedDays)
    }

    fun onTimeSelected(time: String, textView: TextView) {
        mutableHour.postValue(dateTimeUtils.convertTo12HourFormat(time))

        // Descomponer la cadena de tiempo en horas y minutos
        val (hours, minutes) = time.split(":").map { it.toInt() }
        setHours = hours
        setMinutes = minutes
    }

    private fun setDailyNotification(
        context: Context,
        setHours: Int,
        setMinutes: Int,
        dayOfWeek: Int
    ) {
        val calendar = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            set(Calendar.DAY_OF_WEEK, dayOfWeek)
            set(Calendar.HOUR_OF_DAY, setHours)
            set(Calendar.MINUTE, setMinutes)
            set(Calendar.SECOND, 0)

            // Si la fecha ya ha pasado, ajustamos para la próxima semana
            if (before(Calendar.getInstance())) {
                add(Calendar.WEEK_OF_YEAR, 1)
            }
        }

        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, NotificationBroadcast::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            context,
            dayOfWeek,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY * 7, // Repetir cada semana
            pendingIntent
        )
    }

    fun setNotificationsForSelectedDays(context: Context) {
        if (daysToSchedule.value != null) {
            if (daysToSchedule.value!!.size != 7) {
                throw IllegalArgumentException("daysOfWeek must have 7 elements")
            }

            val days = arrayOf(
                Calendar.SUNDAY,
                Calendar.MONDAY,
                Calendar.TUESDAY,
                Calendar.WEDNESDAY,
                Calendar.THURSDAY,
                Calendar.FRIDAY,
                Calendar.SATURDAY
            )

            for (i in days.indices) {
                if (daysToSchedule.value!![i]) {
                    setDailyNotification(context, setHours, setMinutes, days[i])
                }
            }
        }
    }

    private fun getShortWeekDay(index: Int, value: Boolean): String {
        return when (index) {
            0 -> if (value) "Lu " else ""
            1 -> if (value) "Ma " else ""
            2 -> if (value) "Mi " else ""
            3 -> if (value) "Ju " else ""
            4 -> if (value) "Vi " else ""
            5 -> if (value) "Sa " else ""
            6 -> if (value) "Do" else ""
            else -> ""
        }
    }

    fun insertReminder() {
        viewModelScope.launch {
            val reminder: ReminderEntity = ReminderEntity(
                name = reminderName,
                schedule = "${getReminderScheduleDescription()} • ${mutableHour.value}",
                difficulty = idDifficulty,
                technology = idTechnology
            )

            insertReminderUseCase(reminder)
        }
    }

    private fun getReminderScheduleDescription(): String {
        reminderSchedule = ""
        for (i in daysToSchedule.value!!.indices) {
            reminderSchedule += getShortWeekDay(i, daysToSchedule.value!![i])
        }
        return reminderSchedule
    }
}