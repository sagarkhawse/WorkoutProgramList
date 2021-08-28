package com.laboontech.kotlinworkoutlist

import android.app.Application
import com.laboontech.kotlinworkoutlist.data.db.WorkoutDatabase
import com.laboontech.kotlinworkoutlist.data.repositories.WorkoutRepository
import com.laboontech.kotlinworkoutlist.ui.workoutlist.WorkoutViewModelFactory
import kotlinx.coroutines.InternalCoroutinesApi
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class App : Application(), KodeinAware {
    @InternalCoroutinesApi
    override val kodein: Kodein
        get() = Kodein.lazy {
            import(androidXModule(this@App))
            bind() from singleton { WorkoutDatabase(instance()) }
            bind() from singleton { WorkoutRepository(instance()) }
            bind() from provider { WorkoutViewModelFactory(instance()) }
        }
}