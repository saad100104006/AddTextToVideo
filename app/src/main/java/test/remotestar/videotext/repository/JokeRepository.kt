package test.remotestar.videotext.repository

import test.remotestar.videotext.service.RetrofitService

class JokeRepository constructor(private val retrofitService: RetrofitService) {

    suspend fun getJoke() = retrofitService.getJoke()
}