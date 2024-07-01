package com.bazan.devquiz.presentation.utils

import com.bazan.devquiz.R

object IconMapper {
    private val iconMap = mapOf(
        1 to R.drawable.react,
        2 to R.drawable.javascript_icon,
        // Agrega más mapeos aquí según tus iconos locales y sus IDs en la base de datos
    )

    fun getIconResource(id: Int): Int {
        return iconMap[id] ?: R.drawable.react // Usa un icono por defecto si no se encuentra el ID
    }
}
