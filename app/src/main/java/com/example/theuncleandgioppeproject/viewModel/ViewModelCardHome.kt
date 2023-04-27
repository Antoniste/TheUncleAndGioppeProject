package com.example.theuncleandgioppeproject.viewModel

import com.example.theuncleandgioppeproject.core.network.base.network.MarvelCharacterResponse

data class ViewModelCardHome(var description:String, var name:String, var urls: List<MarvelCharacterResponse.Data.Result.Url>)