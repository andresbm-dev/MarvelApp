package com.abm.marvelapp.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.annotation.MainThread
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abm.marvelapp.R
import com.abm.marvelapp.databinding.ActivityMainBinding
import com.abm.marvelapp.domain.model.CharactersDTO
import com.abm.marvelapp.ui.CharactersAdapter
import com.abm.marvelapp.ui.viewmodel.MarvelViewModelImp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel:MarvelViewModelImp by viewModels()
    private var character :List<CharactersDTO> = mutableListOf()
    private var adapterCharacter :CharactersAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.getCharacters()
        viewModel.charactersLiveData.observe(this){
            it?.let {
                character = it
                Log.d("response api", character.toString())
                setRecyclerView()
            }
        }

    }

    private fun setRecyclerView() {
        adapterCharacter = CharactersAdapter(character) { charact ->
            onCharacterSelected(charact)
        }
        binding.recycler.apply {
            adapter = adapterCharacter
            layoutManager = LinearLayoutManager( this@MainActivity,LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun onCharacterSelected(charact: CharactersDTO) {

    }
}