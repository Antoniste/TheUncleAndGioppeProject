package com.example.theuncleandgioppeproject.core.network.base.network

import com.google.gson.annotations.SerializedName

class UncleRequest (
    @SerializedName("offset")
    val offset: String?,
    @SerializedName("pornId")
    val pornId: Int?,
    @SerializedName("producerId")
    val producerId: Int?,
    @SerializedName("pornType")
    val pornType: Int?,
    @SerializedName("offset")
    val includeImages: Boolean?,
    @SerializedName("count")
    val count: String?,
    @SerializedName("actorId")
    val actorId: Int?,
    @SerializedName("genreId")
    val genreId: Int?,
    @SerializedName("includeDownloads")
    val includeDownloads: Boolean?,
)
