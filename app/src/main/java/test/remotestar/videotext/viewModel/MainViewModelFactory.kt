package test.remotestar.videotext.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import test.remotestar.videotext.repository.JokeRepository

class MyViewModelFactory constructor(private val repository: JokeRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}