package com.pensource.android.symptomtracker

import android.app.Application
import com.pensource.android.symptomtracker.di.AppComponent
import com.pensource.android.symptomtracker.di.DaggerAppComponent

class MyApplication: Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }

}