package com.pensource.android.symptomtracker.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pensource.android.symptomtracker.data.Symptom
import com.pensource.android.symptomtracker.data.source.SymptomRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: SymptomRepository
): ViewModel() {

    private val _symptom = MutableLiveData<List<Symptom>>()
    val symptom: LiveData<List<Symptom>> = _symptom


    suspend fun insertSymptom(symptom: Symptom) = withContext(Dispatchers.IO) {
        repository.insertSymptom(symptom)
    }

    fun getSymptom() {
        viewModelScope.launch {

        }
    }

}