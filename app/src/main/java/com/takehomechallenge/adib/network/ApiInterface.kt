package com.takehomechallenge.adib.network

import com.takehomechallenge.adib.models.CharactersResponse
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    fun getAllCharacters(): retrofit2.Call<CharactersResponse>
}