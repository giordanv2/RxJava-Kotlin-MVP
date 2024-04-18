package com.example.rxjavakotlinmvp.view

import com.example.rxjavakotlinmvp.model.dto.Character

interface CharactersView {
    fun updateCharacters(characters: List<Character>)
    fun showError(error: String)
}
