package br.com.ztx.beagle_1

import android.app.Application
import br.com.ztx.beagle_1.beagle.BeagleSetup

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        BeagleSetup().init(this)
    }
}