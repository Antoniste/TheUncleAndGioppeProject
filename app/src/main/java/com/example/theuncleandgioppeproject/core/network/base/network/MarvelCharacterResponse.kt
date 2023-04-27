package com.example.theuncleandgioppeproject.core.network.base.network

data class MarvelCharacterResponse(
    val attributionHTML: String,
    val attributionText: String,
    val code: String,
    val copyright: String,
    val `data`: Data,
    val eTag: String,
    val status: String
) {
    data class Data(
        val count: String,
        val limit: String,
        val offset: String,
        val results: List<Result>,
        val total: String
    ) {
        data class Result(
            val comics: Comics,
            val description: String,
            val events: Events,
            val id: String,
            val modified: String,
            val name: String,
            val resourceURI: String,
            val series: Series,
            val stories: Stories,
            val thumbnail: Thumbnail,
            val urls: List<Url>
        ) {
            data class Comics(
                val available: String,
                val collectionURI: String,
                val items: List<Item>,
                val returned: String
            ) {
                data class Item(
                    val name: String,
                    val resourceURI: String
                )
            }

            data class Events(
                val available: String,
                val collectionURI: String,
                val items: List<Item>,
                val returned: String
            ) {
                data class Item(
                    val name: String,
                    val resourceURI: String
                )
            }

            data class Series(
                val available: String,
                val collectionURI: String,
                val items: List<Item>,
                val returned: String
            ) {
                data class Item(
                    val name: String,
                    val resourceURI: String
                )
            }

            data class Stories(
                val available: String,
                val collectionURI: String,
                val items: List<Item>,
                val returned: String
            ) {
                data class Item(
                    val name: String,
                    val resourceURI: String,
                    val type: String
                )
            }

            data class Thumbnail(
                val extension: String,
                val path: String
            )

            data class Url(
                val type: String,
                val url: String
            )
        }
    }
}