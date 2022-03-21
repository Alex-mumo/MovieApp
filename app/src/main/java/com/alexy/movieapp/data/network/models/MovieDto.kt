package com.alexy.movieapp.data.network.models

import com.google.gson.annotations.SerializedName

data class MovieDto (
    @SerializedName("id")
    val id: String,
    @SerializedName("imDbRating")
    val imDbRating: String?,
    @SerializedName("imDbRatingCount")
    val imDbRatingCount: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("category")
    val category: String?
)