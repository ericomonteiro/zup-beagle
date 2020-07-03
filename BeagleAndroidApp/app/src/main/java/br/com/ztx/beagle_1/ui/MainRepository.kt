package br.com.ztx.beagle_1.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.ztx.beagle_1.ui.MainRepository.StatusCode.SUCCESS
import br.com.ztx.beagle_1.ui.MainRepository.StatusMessage.CONN_ERROR
import br.com.ztx.beagle_1.ui.MainRepository.StatusMessage.CONN_SUCCESS
import br.com.ztx.beagle_1.ui.MainRepository.StatusMessage.CONN_UNEXPECTED
import br.com.ztx.beagle_1.beagle.AppBeagleConfig
import br.com.ztx.beagle_1.beagle.AppCustomClient
import br.com.zup.beagle.networking.HttpMethod
import br.com.zup.beagle.networking.RequestData
import java.net.URI

class MainRepository {

    fun getRemoteScreen(): LiveData<String> {
        val screen = MutableLiveData<String>()
        val uri = URI(AppBeagleConfig().baseUrl)
        val requestData = RequestData(uri, HttpMethod.GET)

        AppCustomClient().execute(requestData,
            onSuccess = {
                val status = it.statusCode
                if (status == SUCCESS) {
                    screen.postValue("$CONN_SUCCESS ${it.data}")
                } else {
                    screen.postValue("$CONN_UNEXPECTED ${it.data}")
                }
            },
            onError = {
                screen.postValue("$CONN_ERROR ${it.message}")
            })
        return screen
    }

    private object StatusMessage {
        const val CONN_SUCCESS = "Connection implemented with success! Body: "
        const val CONN_UNEXPECTED = "Connection not 200! Data: "
        const val CONN_ERROR = "Connection error! Error: "
    }

    private object StatusCode {
        const val SUCCESS = 200
        const val NOT_FOUND = 404
        const val NOT_AUTHORIZED = 302
        const val SERVER_ERROR = 500
    }

}