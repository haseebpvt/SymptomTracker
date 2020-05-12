package com.pensource.android.symptomtracker.data.source

import com.pensource.android.symptomtracker.data.Result
import com.pensource.android.symptomtracker.data.Symptom
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class DefaultSymptomRepository @Inject constructor(
    private val symptomLocalDataSource: SymptomDataSource,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): SymptomRepository {

    override suspend fun insertSymptom(symptom: Symptom) {
        symptomLocalDataSource.insertSymptom(symptom)
    }

    override suspend fun getSymptom(): Result<List<Symptom>> {
        return symptomLocalDataSource.getSymptom()
    }

}