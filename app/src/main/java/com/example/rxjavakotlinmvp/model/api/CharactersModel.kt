package com.example.rxjavakotlinmvp.model.api

import com.example.rxjavakotlinmvp.model.dto.CharactersResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CharactersModel {
    private val apiService = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
        .create(ApiService::class.java)

    fun fetchCharacters(): Observable<CharactersResponse> {
        return apiService.getAllCharacters()
    }
}
