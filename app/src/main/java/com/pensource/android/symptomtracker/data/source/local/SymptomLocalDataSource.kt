package com.pensource.android.symptomtracker.data.source.local

import android.util.Log
import com.pensource.android.symptomtracker.data.Result
import com.pensource.android.symptomtracker.data.Symptom
import com.pensource.android.symptomtracker.data.source.SymptomDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class SymptomLocalDataSource @Inject constructor(
    private val symptomDao: SymptomDao,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): SymptomDataSource{

    override suspend fun insertSymptom(symptom: Symptom) = withContext(dispatcher) {
        symptomDao.insertSymptom(symptom)
    }

    override suspend fun getSymptom(): Result<List<Symptom>> = withContext(dispatcher) {
        try {
            val symptomList = symptomDao.getSymptom()

            if (symptomList != null) {
                return@withContext Result.Success(symptomList)
            } else {
                return@withContext Result.Error(Exception("No symptom found"))
            }
        } catch (e: Exception) {
            return@withContext Result.Error(e)
        }
    }


}