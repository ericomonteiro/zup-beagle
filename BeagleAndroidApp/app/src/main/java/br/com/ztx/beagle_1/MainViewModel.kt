package br.com.ztx.beagle_1

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModel(val repository: MainRepository) : ViewModel() {

    fun getRemoteScreen(): LiveData<String> {
        return repository.getRemoteScreen()
    }

    class ViewModelFactory(val repository: MainRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                return MainViewModel(repository) as T
            }
            throw IllegalArgumentException("Invalid View Model")
        }
    }
}