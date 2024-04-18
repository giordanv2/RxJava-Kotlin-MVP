package com.example.rxjavakotlinmvp.view

import CharactersAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rxjavakotlinmvp.R
import com.example.rxjavakotlinmvp.model.dto.Character
import com.example.rxjavakotlinmvp.presenter.CharactersPresenter

class CharactersActivity : AppCompatActivity(), CharactersView {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CharactersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters)

        recyclerView = findViewById(R.id.recyclerView)
        adapter = CharactersAdapter(emptyList())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val presenter = CharactersPresenter(this)
        presenter.loadCharacters()
    }

    override fun updateCharacters(characters: List<Character>) {
        adapter.updateData(characters)
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }
}
