package com.example.rxjavakotlinmvp.model.api

import com.example.rxjavakotlinmvp.model.dto.CharactersResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    fun getAllCharacters(): Observable<CharactersResponse>
}
