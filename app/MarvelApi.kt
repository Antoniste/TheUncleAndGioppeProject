data class MarvelApi(
    val apiVersion: String,
    val apis: List<Api>,
    val basePath: String,
    val models: Models,
    val resourcePath: String,
    val swaggerVersion: String
) {
    data class Api(
        val description: String,
        val operations: List<Operation>,
        val path: String
    ) {
        data class Operation(
            val _id: String,
            val errorResponses: List<ErrorResponse>,
            val httpMethod: String,
            val nickname: String,
            val notes: String,
            val parameters: List<Parameter>,
            val responseClass: String,
            val summary: String
        ) {
            data class ErrorResponse(
                val _id: String,
                val code: Int,
                val reason: String
            )

            data class Parameter(
                val _id: String,
                val allowMultiple: Boolean,
                val allowableValues: AllowableValues,
                val dataType: String,
                val description: String,
                val name: String,
                val paramType: String,
                val required: Boolean
            ) {
                data class AllowableValues(
                    val _id: String,
                    val max: Int,
                    val min: Int,
                    val valueType: String,
                    val values: List<String>
                )
            }
        }
    }

    data class Models(
        val Character: Character,
        val CharacterDataContainer: CharacterDataContainer,
        val CharacterDataWrapper: CharacterDataWrapper,
        val CharacterList: CharacterList,
        val CharacterSummary: CharacterSummary,
        val Comic: Comic,
        val ComicDataContainer: ComicDataContainer,
        val ComicDataWrapper: ComicDataWrapper,
        val ComicDate: ComicDate,
        val ComicList: ComicList,
        val ComicPrice: ComicPrice,
        val ComicSummary: ComicSummary,
        val Creator: Creator,
        val CreatorDataContainer: CreatorDataContainer,
        val CreatorDataWrapper: CreatorDataWrapper,
        val CreatorList: CreatorList,
        val CreatorSummary: CreatorSummary,
        val Event: Event,
        val EventDataContainer: EventDataContainer,
        val EventDataWrapper: EventDataWrapper,
        val EventList: EventList,
        val EventSummary: EventSummary,
        val Image: Image,
        val Series: Series,
        val SeriesDataContainer: SeriesDataContainer,
        val SeriesDataWrapper: SeriesDataWrapper,
        val SeriesList: SeriesList,
        val SeriesSummary: SeriesSummary,
        val Story: Story,
        val StoryDataContainer: StoryDataContainer,
        val StoryDataWrapper: StoryDataWrapper,
        val StoryList: StoryList,
        val StorySummary: StorySummary,
        val TextObject: TextObject,
        val Url: Url
    ) {
        data class Character(
            val id: String,
            val properties: Properties
        ) {
            data class Properties(
                val comics: Comics,
                val description: Description,
                val events: Events,
                val id: Id,
                val modified: Modified,
                val name: Name,
                val resourceURI: ResourceURI,
                val series: Series,
                val stories: Stories,
                val thumbnail: Thumbnail,
                val urls: Urls
            ) {
                data class Comics(
                    val description: String,
                    val type: String
                )

                data class Description(
                    val description: String,
                    val type: String
                )

                data class Events(
                    val description: String,
                    val type: String
                )

                data class Id(
                    val description: String,
                    val type: String
                )

                data class Modified(
                    val description: String,
                    val type: String
                )

                data class Name(
                    val description: String,
                    val type: String
                )

                data class ResourceURI(
                    val description: String,
                    val type: String
                )

                data class Series(
                    val description: String,
                    val type: String
                )

                data class Stories(
                    val description: String,
                    val type: String
                )

                data class Thumbnail(
                    val description: String,
                    val type: String
                )

                data class Urls(
                    val description: String,
                    val items: Items,
                    val type: String
                ) {
                    data class Items(
                        val `$ref`: String
                    )
                }
            }
        }

        data class CharacterDataContainer(
            val id: String,
            val properties: Properties
        ) {
            data class Properties(
                val count: Count,
                val limit: Limit,
                val offset: Offset,
                val results: Results,
                val total: Total
            ) {
                data class Count(
                    val description: String,
                    val type: String
                )

                data class Limit(
                    val description: String,
                    val type: String
                )

                data class Offset(
                    val description: String,
                    val type: String
                )

                data class Results(
                    val description: String,
                    val items: Items,
                    val type: String
                ) {
                    data class Items(
                        val `$ref`: String
                    )
                }

                data class Total(
                    val description: String,
                    val type: String
                )
            }
        }

        data class CharacterDataWrapper(
            val id: String,
            val properties: Properties
        ) {
            data class Properties(
                val attributionHTML: AttributionHTML,
                val attributionText: AttributionText,
                val code: Code,
                val copyright: Copyright,
                val `data`: Data,
                val etag: Etag,
                val status: Status
            ) {
                data class AttributionHTML(
                    val description: String,
                    val type: String
                )

                data class AttributionText(
                    val description: String,
                    val type: String
                )

                data class Code(
                    val description: String,
                    val type: String
                )

                data class Copyright(
                    val description: String,
                    val type: String
                )

                data class Data(
                    val description: String,
                    val type: String
                )

                data class Etag(
                    val description: String,
                    val type: String
                )

                data class Status(
                    val description: String,
                    val type: String
                )
            }
        }

        data class CharacterList(
            val id: String,
            val properties: Properties
        ) {
            data class Properties(
                val available: Available,
                val collectionURI: CollectionURI,
                val items: Items,
                val returned: Returned
            ) {
                data class Available(
                    val description: String,
                    val type: String
                )

                data class CollectionURI(
                    val description: String,
                    val type: String
                )

                data class Items(
                    val description: String,
                    val items: Items,
                    val type: String
                ) {
                    data class Items(
                        val `$ref`: String
                    )
                }

                data class Returned(
                    val description: String,
                    val type: String
                )
            }
        }

        data class CharacterSummary(
            val id: String,
            val properties: Properties
        ) {
            data class Properties(
                val name: Name,
                val resourceURI: ResourceURI,
                val role: Role
            ) {
                data class Name(
                    val description: String,
                    val type: String
                )

                data class ResourceURI(
                    val description: String,
                    val type: String
                )

                data class Role(
                    val description: String,
                    val type: String
                )
            }
        }

        data class Comic(
            val id: String,
            val properties: Properties
        ) {
            data class Properties(
                val characters: Characters,
                val collectedIssues: CollectedIssues,
                val collections: Collections,
                val creators: Creators,
                val dates: Dates,
                val description: Description,
                val diamondCode: DiamondCode,
                val digitalId: DigitalId,
                val ean: Ean,
                val events: Events,
                val format: Format,
                val id: Id,
                val images: Images,
                val isbn: Isbn,
                val issn: Issn,
                val issueNumber: IssueNumber,
                val modified: Modified,
                val pageCount: PageCount,
                val prices: Prices,
                val resourceURI: ResourceURI,
                val series: Series,
                val stories: Stories,
                val textObjects: TextObjects,
                val thumbnail: Thumbnail,
                val title: Title,
                val upc: Upc,
                val urls: Urls,
                val variantDescription: VariantDescription,
                val variants: Variants
            ) {
                data class Characters(
                    val description: String,
                    val type: String
                )

                data class CollectedIssues(
                    val description: String,
                    val items: Items,
                    val type: String
                ) {
                    data class Items(
                        val `$ref`: String
                    )
                }

                data class Collections(
                    val description: String,
                    val items: Items,
                    val type: String
                ) {
                    data class Items(
                        val `$ref`: String
                    )
                }

                data class Creators(
                    val description: String,
                    val type: String
                )

                data class Dates(
                    val description: String,
                    val items: Items,
                    val type: String
                ) {
                    data class Items(
                        val `$ref`: String
                    )
                }

                data class Description(
                    val description: String,
                    val type: String
                )

                data class DiamondCode(
                    val description: String,
                    val type: String
                )

                data class DigitalId(
                    val description: String,
                    val type: String
                )

                data class Ean(
                    val description: String,
                    val type: String
                )

                data class Events(
                    val description: String,
                    val type: String
                )

                data class Format(
                    val description: String,
                    val type: String
                )

                data class Id(
                    val description: String,
                    val type: String
                )

                data class Images(
                    val description: String,
                    val items: Items,
                    val type: String
                ) {
                    data class Items(
                        val `$ref`: String
                    )
                }

                data class Isbn(
                    val description: String,
                    val type: String
                )

                data class Issn(
                    val description: String,
                    val type: String
                )

                data class IssueNumber(
                    val description: String,
                    val type: String
                )

                data class Modified(
                    val description: String,
                    val type: String
                )

                data class PageCount(
                    val description: String,
                    val type: String
                )

                data class Prices(
                    val description: String,
                    val items: Items,
                    val type: String
                ) {
                    data class Items(
                        val `$ref`: String
                    )
                }

                data class ResourceURI(
                    val description: String,
                    val type: String
                )

                data class Series(
                    val description: String,
                    val type: String
                )

                data class Stories(
                    val description: String,
                    val type: String
                )

                data class TextObjects(
                    val description: String,
                    val items: Items,
                    val type: String
                ) {
                    data class Items(
                        val `$ref`: String
                    )
                }

                data class Thumbnail(
                    val description: String,
                    val type: String
                )

                data class Title(
                    val description: String,
                    val type: String
                )

                data class Upc(
                    val description: String,
                    val type: String
                )

                data class Urls(
                    val description: String,
                    val items: Items,
                    val type: String
                ) {
                    data class Items(
                        val `$ref`: String
                    )
                }

                data class VariantDescription(
                    val description: String,
                    val type: String
                )

                data class Variants(
                    val description: String,
                    val items: Items,
                    val type: String
                ) {
                    data class Items(
                        val `$ref`: String
                    )
                }
            }
        }

        data class ComicDataContainer(
            val id: String,
            val properties: Properties
        ) {
            data class Properties(
                val count: Count,
                val limit: Limit,
                val offset: Offset,
                val results: Results,
                val total: Total
            ) {
                data class Count(
                    val description: String,
                    val type: String
                )

                data class Limit(
                    val description: String,
                    val type: String
                )

                data class Offset(
                    val description: String,
                    val type: String
                )

                data class Results(
                    val description: String,
                    val items: Items,
                    val type: String
                ) {
                    data class Items(
                        val `$ref`: String
                    )
                }

                data class Total(
                    val description: String,
                    val type: String
                )
            }
        }

        data class ComicDataWrapper(
            val id: String,
            val properties: Properties
        ) {
            data class Properties(
                val attributionHTML: AttributionHTML,
                val attributionText: AttributionText,
                val code: Code,
                val copyright: Copyright,
                val `data`: Data,
                val etag: Etag,
                val status: Status
            ) {
                data class AttributionHTML(
                    val description: String,
                    val type: String
                )

                data class AttributionText(
                    val description: String,
                    val type: String
                )

                data class Code(
                    val description: String,
                    val type: String
                )

                data class Copyright(
                    val description: String,
                    val type: String
                )

                data class Data(
                    val description: String,
                    val type: String
                )

                data class Etag(
                    val description: String,
                    val type: String
                )

                data class Status(
                    val description: String,
                    val type: String
                )
            }
        }

        data class ComicDate(
            val id: String,
            val properties: Properties
        ) {
            data class Properties(
                val date: Date,
                val type: Type
            ) {
                data class Date(
                    val description: String,
                    val type: String
                )

                data class Type(
                    val description: String,
                    val type: String
                )
            }
        }

        data class ComicList(
            val id: String,
            val properties: Properties
        ) {
            data class Properties(
                val available: Available,
                val collectionURI: CollectionURI,
                val items: Items,
                val returned: Returned
            ) {
                data class Available(
                    val description: String,
                    val type: String
                )

                data class CollectionURI(
                    val description: String,
                    val type: String
                )

                data class Items(
                    val description: String,
                    val items: Items,
                    val type: String
                ) {
                    data class Items(
                        val `$ref`: String
                    )
                }

                data class Returned(
                    val description: String,
                    val type: String
                )
            }
        }

        data class ComicPrice(
            val id: String,
            val properties: Properties
        ) {
            data class Properties(
                val price: Price,
                val type: Type
            ) {
                data class Price(
                    val description: String,
                    val type: String
                )

                data class Type(
                    val description: String,
                    val type: String
                )
            }
        }

        data class ComicSummary(
            val id: String,
            val properties: Properties
        ) {
            data class Properties(
                val name: Name,
                val resourceURI: ResourceURI
            ) {
                data class Name(
                    val description: String,
                    val type: String
                )

                data class ResourceURI(
                    val description: String,
                    val type: String
                )
            }
        }

        data class Creator(
            val id: String,
            val properties: Properties
        ) {
            data class Properties(
                val comics: Comics,
                val events: Events,
                val firstName: FirstName,
                val fullName: FullName,
                val id: Id,
                val lastName: LastName,
                val middleName: MiddleName,
                val modified: Modified,
                val resourceURI: ResourceURI,
                val series: Series,
                val stories: Stories,
                val suffix: Suffix,
                val thumbnail: Thumbnail,
                val urls: Urls
            ) {
                data class Comics(
                    val description: String,
                    val type: String
                )

                data class Events(
                    val description: String,
                    val type: String
                )

                data class FirstName(
                    val description: String,
                    val type: String
                )

                data class FullName(
                    val description: String,
                    val type: String
                )

                data class Id(
                    val description: String,
                    val type: String
                )

                data class LastName(
                    val description: String,
                    val type: String
                )

                data class MiddleName(
                    val description: String,
                    val type: String
                )

                data class Modified(
                    val description: String,
                    val type: String
                )

                data class ResourceURI(
                    val description: String,
                    val type: String
                )

                data class Series(
                    val description: String,
                    val type: String
                )

                data class Stories(
                    val description: String,
                    val type: String
                )

                data class Suffix(
                    val description: String,
                    val type: String
                )

                data class Thumbnail(
                    val description: String,
                    val type: String
                )

                data class Urls(
                    val description: String,
                    val items: Items,
                    val type: String
                ) {
                    data class Items(
                        val `$ref`: String
                    )
                }
            }
        }

        data class CreatorDataContainer(
            val id: String,
            val properties: Properties
        ) {
            data class Properties(
                val count: Count,
                val limit: Limit,
                val offset: Offset,
                val results: Results,
                val total: Total
            ) {
                data class Count(
                    val description: String,
                    val type: String
                )

                data class Limit(
                    val description: String,
                    val type: String
                )

                data class Offset(
                    val description: String,
                    val type: String
                )

                data class Results(
                    val description: String,
                    val items: Items,
                    val type: String
                ) {
                    data class Items(
                        val `$ref`: String
                    )
                }

                data class Total(
                    val description: String,
                    val type: String
                )
            }
        }

        data class CreatorDataWrapper(
            val id: String,
            val properties: Properties
        ) {
            data class Properties(
                val attributionHTML: AttributionHTML,
                val attributionText: AttributionText,
                val code: Code,
                val copyright: Copyright,
                val `data`: Data,
                val etag: Etag,
                val status: Status
            ) {
                data class AttributionHTML(
                    val description: String,
                    val type: String
                )

                data class AttributionText(
                    val description: String,
                    val type: String
                )

                data class Code(
                    val description: String,
                    val type: String
                )

                data class Copyright(
                    val description: String,
                    val type: String
                )

                data class Data(
                    val description: String,
                    val type: String
                )

                data class Etag(
                    val description: String,
                    val type: String
                )

                data class Status(
                    val description: String,
                    val type: String
                )
            }
        }

        data class CreatorList(
            val id: String,
            val properties: Properties
        ) {
            data class Properties(
                val available: Available,
                val collectionURI: CollectionURI,
                val items: Items,
                val returned: Returned
            ) {
                data class Available(
                    val description: String,
                    val type: String
                )

                data class CollectionURI(
                    val description: String,
                    val type: String
                )

                data class Items(
                    val description: String,
                    val items: Items,
                    val type: String
                ) {
                    data class Items(
                        val `$ref`: String
                    )
                }

                data class Returned(
                    val description: String,
                    val type: String
                )
            }
        }

        data class CreatorSummary(
            val id: String,
            val properties: Properties
        ) {
            data class Properties(
                val name: Name,
                val resourceURI: ResourceURI,
                val role: Role
            ) {
                data class Name(
                    val description: String,
                    val type: String
                )

                data class ResourceURI(
                    val description: String,
                    val type: String
                )

                data class Role(
                    val description: String,
                    val type: String
                )
            }
        }

        data class Event(
            val id: String,
            val properties: Properties
        ) {
            data class Properties(
                val characters: Characters,
                val comics: Comics,
                val creators: Creators,
                val description: Description,
                val end: End,
                val id: Id,
                val modified: Modified,
                val next: Next,
                val previous: Previous,
                val resourceURI: ResourceURI,
                val series: Series,
                val start: Start,
                val stories: Stories,
                val thumbnail: Thumbnail,
                val title: Title,
                val urls: Urls
            ) {
                data class Characters(
                    val description: String,
                    val type: String
                )

                data class Comics(
                    val description: String,
                    val type: String
                )

                data class Creators(
                    val description: String,
                    val type: String
                )

                data class Description(
                    val description: String,
                    val type: String
                )

                data class End(
                    val description: String,
                    val type: String
                )

                data class Id(
                    val description: String,
                    val type: String
                )

                data class Modified(
                    val description: String,
                    val type: String
                )

                data class Next(
                    val description: String,
                    val type: String
                )

                data class Previous(
                    val description: String,
                    val type: String
                )

                data class ResourceURI(
                    val description: String,
                    val type: String
                )

                data class Series(
                    val description: String,
                    val type: String
                )

                data class Start(
                    val description: String,
                    val type: String
                )

                data class Stories(
                    val description: String,
                    val type: String
                )

                data class Thumbnail(
                    val description: String,
                    val type: String
                )

                data class Title(
                    val description: String,
                    val type: String
                )

                data class Urls(
                    val description: String,
                    val items: Items,
                    val type: String
                ) {
                    data class Items(
                        val `$ref`: String
                    )
                }
            }
        }

        data class EventDataContainer(
            val id: String,
            val properties: Properties
        ) {
            data class Properties(
                val count: Count,
                val limit: Limit,
                val offset: Offset,
                val results: Results,
                val total: Total
            ) {
                data class Count(
                    val description: String,
                    val type: String
                )

                data class Limit(
                    val description: String,
                    val type: String
                )

                data class Offset(
                    val description: String,
                    val type: String
                )

                data class Results(
                    val description: String,
                    val items: Items,
                    val type: String
                ) {
                    data class Items(
                        val `$ref`: String
                    )
                }

                data class Total(
                    val description: String,
                    val type: String
                )
            }
        }

        data class EventDataWrapper(
            val id: String,
            val properties: Properties
        ) {
            data class Properties(
                val attributionHTML: AttributionHTML,
                val attributionText: AttributionText,
                val code: Code,
                val copyright: Copyright,
                val `data`: Data,
                val etag: Etag,
                val status: Status
            ) {
                data class AttributionHTML(
                    val description: String,
                    val type: String
                )

                data class AttributionText(
                    val description: String,
                    val type: String
                )

                data class Code(
                    val description: String,
                    val type: String
                )

                data class Copyright(
                    val description: String,
                    val type: String
                )

                data class Data(
                    val description: String,
                    val type: String
                )

                data class Etag(
                    val description: String,
                    val type: String
                )

                data class Status(
                    val description: String,
                    val type: String
                )
            }
        }

        data class EventList(
            val id: String,
            val properties: Properties
        ) {
            data class Properties(
                val available: Available,
                val collectionURI: CollectionURI,
                val items: Items,
                val returned: Returned
            ) {
                data class Available(
                    val description: String,
                    val type: String
                )

                data class CollectionURI(
                    val description: String,
                    val type: String
                )

                data class Items(
                    val description: String,
                    val items: Items,
                    val type: String
                ) {
                    data class Items(
                        val `$ref`: String
                    )
                }

                data class Returned(
                    val description: String,
                    val type: String
                )
            }
        }

        data class EventSummary(
            val id: String,
            val properties: Properties
        ) {
            data class Properties(
                val name: Name,
                val resourceURI: ResourceURI
            ) {
                data class Name(
                    val description: String,
                    val type: String
                )

                data class ResourceURI(
                    val description: String,
                    val type: String
                )
            }
        }

        data class Image(
            val id: String,
            val properties: Properties
        ) {
            data class Properties(
                val extension: Extension,
                val path: Path
            ) {
                data class Extension(
                    val description: String,
                    val type: String
                )

                data class Path(
                    val description: String,
                    val type: String
                )
            }
        }

        data class Series(
            val id: String,
            val properties: Properties
        ) {
            data class Properties(
                val characters: Characters,
                val comics: Comics,
                val creators: Creators,
                val description: Description,
                val endYear: EndYear,
                val events: Events,
                val id: Id,
                val modified: Modified,
                val next: Next,
                val previous: Previous,
                val rating: Rating,
                val resourceURI: ResourceURI,
                val startYear: StartYear,
                val stories: Stories,
                val thumbnail: Thumbnail,
                val title: Title,
                val urls: Urls
            ) {
                data class Characters(
                    val description: String,
                    val type: String
                )

                data class Comics(
                    val description: String,
                    val type: String
                )

                data class Creators(
                    val description: String,
                    val type: String
                )

                data class Description(
                    val description: String,
                    val type: String
                )

                data class EndYear(
                    val description: String,
                    val type: String
                )

                data class Events(
                    val description: String,
                    val type: String
                )

                data class Id(
                    val description: String,
                    val type: String
                )

                data class Modified(
                    val description: String,
                    val type: String
                )

                data class Next(
                    val description: String,
                    val type: String
                )

                data class Previous(
                    val description: String,
                    val type: String
                )

                data class Rating(
                    val description: String,
                    val type: String
                )

                data class ResourceURI(
                    val description: String,
                    val type: String
                )

                data class StartYear(
                    val description: String,
                    val type: String
                )

                data class Stories(
                    val description: String,
                    val type: String
                )

                data class Thumbnail(
                    val description: String,
                    val type: String
                )

                data class Title(
                    val description: String,
                    val type: String
                )

                data class Urls(
                    val description: String,
                    val items: Items,
                    val type: String
                ) {
                    data class Items(
                        val `$ref`: String
                    )
                }
            }
        }

        data class SeriesDataContainer(
            val id: String,
            val properties: Properties
        ) {
            data class Properties(
                val count: Count,
                val limit: Limit,
                val offset: Offset,
                val results: Results,
                val total: Total
            ) {
                data class Count(
                    val description: String,
                    val type: String
                )

                data class Limit(
                    val description: String,
                    val type: String
                )

                data class Offset(
                    val description: String,
                    val type: String
                )

                data class Results(
                    val description: String,
                    val items: Items,
                    val type: String
                ) {
                    data class Items(
                        val `$ref`: String
                    )
                }

                data class Total(
                    val description: String,
                    val type: String
                )
            }
        }

        data class SeriesDataWrapper(
            val id: String,
            val properties: Properties
        ) {
            data class Properties(
                val attributionHTML: AttributionHTML,
                val attributionText: AttributionText,
                val code: Code,
                val copyright: Copyright,
                val `data`: Data,
                val etag: Etag,
                val status: Status
            ) {
                data class AttributionHTML(
                    val description: String,
                    val type: String
                )

                data class AttributionText(
                    val description: String,
                    val type: String
                )

                data class Code(
                    val description: String,
                    val type: String
                )

                data class Copyright(
                    val description: String,
                    val type: String
                )

                data class Data(
                    val description: String,
                    val type: String
                )

                data class Etag(
                    val description: String,
                    val type: String
                )

                data class Status(
                    val description: String,
                    val type: String
                )
            }
        }

        data class SeriesList(
            val id: String,
            val properties: Properties
        ) {
            data class Properties(
                val available: Available,
                val collectionURI: CollectionURI,
                val items: Items,
                val returned: Returned
            ) {
                data class Available(
                    val description: String,
                    val type: String
                )

                data class CollectionURI(
                    val description: String,
                    val type: String
                )

                data class Items(
                    val description: String,
                    val items: Items,
                    val type: String
                ) {
                    data class Items(
                        val `$ref`: String
                    )
                }

                data class Returned(
                    val description: String,
                    val type: String
                )
            }
        }

        data class SeriesSummary(
            val id: String,
            val properties: Properties
        ) {
            data class Properties(
                val name: Name,
                val resourceURI: ResourceURI
            ) {
                data class Name(
                    val description: String,
                    val type: String
                )

                data class ResourceURI(
                    val description: String,
                    val type: String
                )
            }
        }

        data class Story(
            val id: String,
            val properties: Properties
        ) {
            data class Properties(
                val characters: Characters,
                val comics: Comics,
                val creators: Creators,
                val description: Description,
                val events: Events,
                val id: Id,
                val modified: Modified,
                val originalissue: Originalissue,
                val resourceURI: ResourceURI,
                val series: Series,
                val thumbnail: Thumbnail,
                val title: Title,
                val type: Type
            ) {
                data class Characters(
                    val description: String,
                    val type: String
                )

                data class Comics(
                    val description: String,
                    val type: String
                )

                data class Creators(
                    val description: String,
                    val type: String
                )

                data class Description(
                    val description: String,
                    val type: String
                )

                data class Events(
                    val description: String,
                    val type: String
                )

                data class Id(
                    val description: String,
                    val type: String
                )

                data class Modified(
                    val description: String,
                    val type: String
                )

                data class Originalissue(
                    val description: String,
                    val type: String
                )

                data class ResourceURI(
                    val description: String,
                    val type: String
                )

                data class Series(
                    val description: String,
                    val type: String
                )

                data class Thumbnail(
                    val description: String,
                    val type: String
                )

                data class Title(
                    val description: String,
                    val type: String
                )

                data class Type(
                    val description: String,
                    val type: String
                )
            }
        }

        data class StoryDataContainer(
            val id: String,
            val properties: Properties
        ) {
            data class Properties(
                val count: Count,
                val limit: Limit,
                val offset: Offset,
                val results: Results,
                val total: Total
            ) {
                data class Count(
                    val description: String,
                    val type: String
                )

                data class Limit(
                    val description: String,
                    val type: String
                )

                data class Offset(
                    val description: String,
                    val type: String
                )

                data class Results(
                    val description: String,
                    val items: Items,
                    val type: String
                ) {
                    data class Items(
                        val `$ref`: String
                    )
                }

                data class Total(
                    val description: String,
                    val type: String
                )
            }
        }

        data class StoryDataWrapper(
            val id: String,
            val properties: Properties
        ) {
            data class Properties(
                val attributionHTML: AttributionHTML,
                val attributionText: AttributionText,
                val code: Code,
                val copyright: Copyright,
                val `data`: Data,
                val etag: Etag,
                val status: Status
            ) {
                data class AttributionHTML(
                    val description: String,
                    val type: String
                )

                data class AttributionText(
                    val description: String,
                    val type: String
                )

                data class Code(
                    val description: String,
                    val type: String
                )

                data class Copyright(
                    val description: String,
                    val type: String
                )

                data class Data(
                    val description: String,
                    val type: String
                )

                data class Etag(
                    val description: String,
                    val type: String
                )

                data class Status(
                    val description: String,
                    val type: String
                )
            }
        }

        data class StoryList(
            val id: String,
            val properties: Properties
        ) {
            data class Properties(
                val available: Available,
                val collectionURI: CollectionURI,
                val items: Items,
                val returned: Returned
            ) {
                data class Available(
                    val description: String,
                    val type: String
                )

                data class CollectionURI(
                    val description: String,
                    val type: String
                )

                data class Items(
                    val description: String,
                    val items: Items,
                    val type: String
                ) {
                    data class Items(
                        val `$ref`: String
                    )
                }

                data class Returned(
                    val description: String,
                    val type: String
                )
            }
        }

        data class StorySummary(
            val id: String,
            val properties: Properties
        ) {
            data class Properties(
                val name: Name,
                val resourceURI: ResourceURI,
                val type: Type
            ) {
                data class Name(
                    val description: String,
                    val type: String
                )

                data class ResourceURI(
                    val description: String,
                    val type: String
                )

                data class Type(
                    val description: String,
                    val type: String
                )
            }
        }

        data class TextObject(
            val id: String,
            val properties: Properties
        ) {
            data class Properties(
                val language: Language,
                val text: Text,
                val type: Type
            ) {
                data class Language(
                    val description: String,
                    val type: String
                )

                data class Text(
                    val description: String,
                    val type: String
                )

                data class Type(
                    val description: String,
                    val type: String
                )
            }
        }

        data class Url(
            val id: String,
            val properties: Properties
        ) {
            data class Properties(
                val type: Type,
                val url: Url
            ) {
                data class Type(
                    val description: String,
                    val type: String
                )

                data class Url(
                    val description: String,
                    val type: String
                )
            }
        }
    }
}