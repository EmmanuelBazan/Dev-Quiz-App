package com.bazan.devquiz.core.dagger

import android.content.Context
import androidx.room.Room
import com.bazan.devquiz.data.database.DatabaseCallBack
import com.bazan.devquiz.data.database.DevQuizDatabase
import com.bazan.devquiz.data.database.dao.DifficultyDao
import com.bazan.devquiz.data.database.dao.ReminderDao
import com.bazan.devquiz.data.database.dao.TechnologyDao
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
    fun provideRoom(
        @ApplicationContext context: Context,
        callback: DatabaseCallBack
    ): DevQuizDatabase {
        return Room.databaseBuilder(context, DevQuizDatabase::class.java, DEVQUIZ_DATABASE_NAME)
            .addCallback(callback)
            .build()
    }

    @Singleton
    @Provides
    fun provideDatabaseCallBack(
        technologyDaoProvider: javax.inject.Provider<TechnologyDao>,
        difficultyDaoProvider: javax.inject.Provider<DifficultyDao>
    ): DatabaseCallBack {
        return DatabaseCallBack(
            { technologyDaoProvider.get() },
            { difficultyDaoProvider.get() }
        )
    }

    @Singleton
    @Provides
    fun provideTechnologyDao(db: DevQuizDatabase): TechnologyDao {
        return db.getTechnologyDao()
    }

    @Singleton
    @Provides
    fun provideDifficultyDao(db: DevQuizDatabase): DifficultyDao {
        return db.getDifficultyDao()
    }

    @Singleton
    @Provides
    fun provideReminderDao(db: DevQuizDatabase): ReminderDao {
        return db.getReminderDao()
    }
}
