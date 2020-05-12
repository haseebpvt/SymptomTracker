package com.pensource.android.symptomtracker.di

import android.content.Context
import com.pensource.android.symptomtracker.main.MainActivity
import com.pensource.android.symptomtracker.main.MainFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(mainFragment: MainFragment)
    fun inject(mainActivity: MainActivity)

}