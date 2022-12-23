package com.abm.marvelapp.domain.model

import com.google.gson.annotations.SerializedName

data class CharactersDTO(
    @SerializedName("code") var code: Int? = null,
    @SerializedName("status") var status:String ? =null,
    @SerializedName("data") var data: DataMarvelDTO? = null
)

data class DataMarvelDTO(
    @SerializedName("results") var results: List<ResultsMarvel>? = null
)

data class ResultsMarvel(
    @SerializedName("name") var name: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("thumbnail") var thumbnail: thumbnailMarvel? = null,
)

data class thumbnailMarvel(
    @SerializedName("path") var path: String? = null,
    @SerializedName("extension") var extension: String? = null,
)
