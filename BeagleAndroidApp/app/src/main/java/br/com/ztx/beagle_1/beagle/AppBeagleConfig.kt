package br.com.ztx.beagle_1.beagle

import br.com.ztx.beagle_1.beagle.AppBeagleConfig.Constants.DEFAULT_CACHE_ENABLED
import br.com.ztx.beagle_1.beagle.AppBeagleConfig.Constants.DEFAULT_MAX_AGE
import br.com.ztx.beagle_1.beagle.AppBeagleConfig.Constants.DEFAULT_MEMORY_MAX_CAPACITY
import br.com.zup.beagle.annotation.BeagleComponent
import br.com.zup.beagle.setup.BeagleConfig
import br.com.zup.beagle.setup.Cache
import br.com.zup.beagle.setup.Environment

@BeagleComponent
class AppBeagleConfig : BeagleConfig {

    override val baseUrl: String get() = "http://${Config.HOST_3G}:8080/custom_screen"

    override val environment: Environment get() = Environment.DEBUG

    override val cache: Cache = Cache(
        enabled = DEFAULT_CACHE_ENABLED,
        maxAge = DEFAULT_MAX_AGE,
        memoryMaximumCapacity = DEFAULT_MEMORY_MAX_CAPACITY
    )

    private object Config {
        const val HOST_3G = "192.168.43.18"
        const val HOST_WIFI = "192.168.0.29"
    }

    private object Constants {
        const val DEFAULT_CACHE_ENABLED = false
        const val DEFAULT_MAX_AGE = 300L
        const val DEFAULT_MEMORY_MAX_CAPACITY = 15
    }

}