package com.bazan.devquiz.presentation.utils

object IdGenerator {
    private const val MAX_RANDOM_PART = 1000L
    private var counter: Int = 0

    fun generateId(): Long {
        val timestamp = System.currentTimeMillis() % 1000000000 // Reducir a 9 dígitos
        synchronized(this) {
            counter = ((counter + 1) % MAX_RANDOM_PART).toInt()
        }
        return timestamp * MAX_RANDOM_PART + counter
    }
}