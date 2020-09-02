package com.humo.mootty

import android.app.Application
import com.humo.mootty.data.firebase.FirebaseSource
import com.humo.mootty.data.repositories.UserRepository
import com.humo.mootty.ui.auth.AuthViewModelFactory
import com.humo.mootty.ui.viewmodels.HomeViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MoottyApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@MoottyApplication))

        bind() from singleton { FirebaseSource() }
        bind() from singleton { UserRepository(instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }
        bind() from provider { HomeViewModelFactory(instance()) }

    }
}