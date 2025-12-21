package fr.clem.tp

import android.app.Application
import fr.clem.tp.common.spec.AppInitializer

class MyApplication : Application() {

    companion object {
        lateinit var instance: MyApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        AppInitializer.init()
    }
}