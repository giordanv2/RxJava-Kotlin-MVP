package com.example.rxjavakotlinmvp.presenter

import android.annotation.SuppressLint
import com.example.rxjavakotlinmvp.model.api.CharactersModel
import com.example.rxjavakotlinmvp.view.CharactersView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class CharactersPresenter(private val view: CharactersView) {
    private val model = CharactersModel()

    @SuppressLint("CheckResult")
    fun loadCharacters() {
        model.fetchCharacters()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                view.updateCharacters(response.results)
            }, { error ->
                view.showError(error.message ?: "Error fetching characters")
            })
    }
}
