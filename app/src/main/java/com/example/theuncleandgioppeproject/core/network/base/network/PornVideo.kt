package com.example.theuncleandgioppeproject.core.network.base.network

import com.google.gson.annotations.SerializedName

data class PornVideo(
    @SerializedName("name")
    val name: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("sourceUrl")
    val sourceUrl: String?,
    @SerializedName("produceKeyId")
    val produceKeyId: Int?,
    @SerializedName("imageKeyIds")
    val imageKeyIds: List<Long>?,
    @SerializedName("actorKeyIds")
    val actorKeyIds: Int?,
    @SerializedName("genreKeyIds")
    val genreKeyIds: List<Long>?,
    @SerializedName("downloads")
    val downloads: List<HashMap<String, Downloads>>)


data class Downloads(
    @SerializedName("key")
    val key:Key?,
    @SerializedName("fileSize")
    val filesize: Int?,
    @SerializedName("hosterKeyId")
    val hosterKeyId: Long?,


    )

data class Key(
    @SerializedName("parentKey")
    val parentKey: ParentKey?,
    @SerializedName("kind")
    val kind: String?,
    @SerializedName("id")
    val id: Long?,
)

data class ParentKey(
    @SerializedName("kind")
    val kind: String?,
    @SerializedName("id")
    val id: Long?,
)