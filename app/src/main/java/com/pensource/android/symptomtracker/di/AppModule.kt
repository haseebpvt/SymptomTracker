package com.pensource.android.symptomtracker.di

import android.content.Context
import androidx.room.Room
import com.pensource.android.symptomtracker.data.source.DefaultSymptomRepository
import com.pensource.android.symptomtracker.data.source.SymptomDataSource
import com.pensource.android.symptomtracker.data.source.SymptomRepository
import com.pensource.android.symptomtracker.data.source.local.SymptomDao
import com.pensource.android.symptomtracker.data.source.local.SymptomDatabase
import com.pensource.android.symptomtracker.data.source.local.SymptomLocalDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun provideDefaultSymptomRepository(localDataSource: SymptomDataSource): SymptomRepository {
        return DefaultSymptomRepository(localDataSource)
    }

    @Provides
    fun provideSymptomLocalDataSource(dao: SymptomDao): SymptomDataSource {
        return SymptomLocalDataSource(dao)
    }

    @Singleton
    @Provides
    fun provideDatabase(context: Context): SymptomDatabase {
        return Room.databaseBuilder(
            context,
            SymptomDatabase::class.java,
            "Symptom.db"
        ).build()
    }

    @Provides
    fun provideSymptomDao(database: SymptomDatabase): SymptomDao {
        return database.symptomDao()
    }

}