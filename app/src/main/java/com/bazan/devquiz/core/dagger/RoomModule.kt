package com.bazan.devquiz.core.dagger

import android.content.Context
import androidx.room.Room
import com.bazan.devquiz.data.database.DevQuizDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    private const val DEVQUIZ_DATABASE_NAME = "devquiz_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, DevQuizDatabase::class.java, DEVQUIZ_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideReminderDao(db: DevQuizDatabase) = db.getReminderDao()
}