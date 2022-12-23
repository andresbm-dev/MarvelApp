package com.abm.marvelapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abm.marvelapp.databinding.ItemAdapterCharacterBinding
import com.abm.marvelapp.domain.model.CharactersDTO
import com.abm.marvelapp.utils.MarvelApplication.Companion.context
import com.bumptech.glide.Glide

class CharactersAdapter (
    private val characters: List<CharactersDTO>,
    private val callbackDetail:(CharactersDTO)->Unit
        ) : RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemAdapterCharacterBinding) :RecyclerView.ViewHolder(binding.root){
        fun bind(character: CharactersDTO, callbackDetail: (CharactersDTO) -> Unit) {
           character.data?.results?.forEach {
               val image = it.thumbnail?.path + it.thumbnail?.extension
               Glide.with(context).load(image).into(binding.imageHeroe)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemAdapterCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(characters[position], callbackDetail)
    }

    override fun getItemCount(): Int = characters.size
}