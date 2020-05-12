package com.pensource.android.symptomtracker.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pensource.android.symptomtracker.data.Symptom

@Database(entities = [Symptom::class], version = 1, exportSchema = false)
abstract class SymptomDatabase: RoomDatabase() {
    abstract fun symptomDao(): SymptomDao
}