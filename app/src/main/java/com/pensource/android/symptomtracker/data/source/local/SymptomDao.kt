package com.pensource.android.symptomtracker.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pensource.android.symptomtracker.data.Symptom

@Dao
interface SymptomDao {

    @Insert
    suspend fun insertSymptom(symptom: Symptom)

    @Query("SELECT * FROM table_symptom")
    suspend fun getSymptom(): List<Symptom>

}