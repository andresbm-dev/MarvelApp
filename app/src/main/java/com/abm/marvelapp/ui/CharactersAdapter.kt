package com.abm.marvelapp.ui

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abm.marvelapp.databinding.ItemAdapterCharacterBinding
import com.abm.marvelapp.domain.model.ResultsMarvel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CharactersAdapter (
    private val characters: List<ResultsMarvel>,
    private val callbackDetail:(ResultsMarvel)->Unit
        ) : RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemAdapterCharacterBinding) :RecyclerView.ViewHolder(binding.root){
        @SuppressLint("CheckResult")
        fun bind(character: ResultsMarvel, callbackDetail: (ResultsMarvel) -> Unit) {
               val image = character.thumbnail?.path + '.' +character.thumbnail?.extension
                Log.d("image", image)
            val imageParse = image.replace("http", "https")
            Glide.with(binding.root).load(imageParse).into(binding.imageHeroe)


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