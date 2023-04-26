package com.example.theuncleandgioppeproject.core.network.base.network

import com.google.gson.annotations.SerializedName

data class PornVideo(
    val content: List<Content>,
    val statusCode: Int,
    val statusMessage: String
) {
    data class Content(
        val actorKeyIds: List<Long>,
        val description: String,
        val downloads: List<Download>,
        val entryType: Int,
        val genreKeyIds: List<Long>,
        val imageKeyIds: List<Long>,
        val key: Key,
        val name: String,
        val pornType: Int,
        val producerKeyId: Int,
        val publishDate: Long,
        val sourceUrl: String
    ) {
        data class Download(
            val downloadType: Int,
            val entryType: Int,
            val fileSize: Int,
            val hosterKeyId: Long,
            val key: Key,
            val url: String
        ) {
            data class Key(
                val id: Long,
                val kind: String,
                val parentKey: ParentKey
            ) {
                data class ParentKey(
                    val id: Long,
                    val kind: String
                )
            }
        }

        data class Key(
            val id: Long,
            val kind: String
        )
    }
}