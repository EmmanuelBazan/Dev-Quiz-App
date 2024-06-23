package com.bazan.devquiz.presentation.utils

class DateTimeUtils {
    fun convertTo12HourFormat(time: String): String {
        // Descomponer la cadena de tiempo en horas y minutos
        val (hours, minutes) = time.split(":").map { it.toInt() }

        // Determinar si es AM o PM
        val period = if (hours >= 12) "PM" else "AM"

        // Convertir las horas al formato de 12 horas
        val adjustedHours = if (hours % 12 == 0) 12 else hours % 12

        // Formatear el resultado con un espacio alrededor del ":"
        return String.format("%02d : %02d %s", adjustedHours, minutes, period)
    }
}