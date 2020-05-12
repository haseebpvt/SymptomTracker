package com.pensource.android.symptomtracker.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pensource.android.symptomtracker.MyApplication
import com.pensource.android.symptomtracker.R
import com.pensource.android.symptomtracker.data.Symptom
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val symptom = Symptom(
            0,
            "Ear itch",
            "01",
            2,
            "This is worth noting",
            "left ear",
            30000,
            "red"
        )

        runBlocking {
            mainViewModel.insertSymptom(symptom)
        }

    }
}
