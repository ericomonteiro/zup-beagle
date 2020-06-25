package br.com.ztx.beagle_1

import android.app.Application

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        BeagleSetup().init(this)
    }
}