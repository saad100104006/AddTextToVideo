package test.remotestar.videotext.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import test.remotestar.videotext.data.JokeData
import test.remotestar.videotext.repository.JokeRepository
import kotlinx.coroutines.*
/**
 * Business logic for the joke API
 */
class MainViewModel constructor(private val mainRepository: JokeRepository) : ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val joke = MutableLiveData<JokeData>()
    var job: Job? = null
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }
    val loading = MutableLiveData<Boolean>()

    fun getJoke() {

        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            loading.postValue(true)
            val response = mainRepository.getJoke()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    joke.postValue(response.body())
                    loading.value = false
                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }
    }

    private fun onError(message: String) {
        errorMessage.postValue(message)
        loading.postValue(false)
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}