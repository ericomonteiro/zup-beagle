package br.com.ztx.beagle_1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.ztx.beagle_1.MainViewModel.Constants.BASE_URL
import br.com.ztx.beagle_1.MainViewModel.StatusCode.SUCCESS
import br.com.ztx.beagle_1.beagle.AppCustomClient
import br.com.zup.beagle.networking.HttpMethod
import br.com.zup.beagle.networking.RequestData
import java.net.URI

class MainViewModel : ViewModel() {

    fun getRemoteScreen(): LiveData<String> {
        val screen = MutableLiveData<String>()

        val uri = URI(BASE_URL)
        val requestData = RequestData(uri, HttpMethod.GET)

        AppCustomClient().execute(requestData,
            onSuccess = {
                val status = it.statusCode
                if (status == SUCCESS) {
                    screen.postValue("Connection implemented with success! Body: ${it.data.toString()}")
                } else {
                    screen.postValue("Connection not 200! Data: ${it.data.toString()}")
                }
            },
            onError = {
                screen.postValue("Connection error! Error: ${it.message}")
            })
        return screen
    }

    private object Constants {
        const val BASE_URL = "http://192.168.0.29:8080/beagle/screen"
    }

    private object StatusCode {
        const val SUCCESS = 200
        const val NOT_FOUND = 404
        const val NOT_AUTHORIZED = 302
        const val SERVER_ERROR = 500
    }

    class ViewModelFactory() : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                return MainViewModel() as T
            }
            throw IllegalArgumentException("Invalid View Model")
        }
    }

}