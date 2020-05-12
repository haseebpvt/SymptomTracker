package com.pensource.android.symptomtracker.data.source

import com.pensource.android.symptomtracker.data.Result
import com.pensource.android.symptomtracker.data.Symptom

interface SymptomDataSource {

    suspend fun insertSymptom(symptom: Symptom)

    suspend fun getSymptom(): Result<List<Symptom>>

}