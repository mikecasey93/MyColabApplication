package com.example.mycolabapplication.data.api

import com.example.mycolabapplication.data.model.people_package.PeopleItemModel
import com.example.mycolabapplication.data.model.rooms_package.RoomsItemModel
import retrofit2.http.GET

interface ApiEndpoints {

    @GET(ApiDetails.PEOPLE_ENDPOINT)
    suspend fun getPeople() : List<PeopleItemModel>

    @GET(ApiDetails.ROOMS_ENDPOINT)
    suspend fun getRooms() : List<RoomsItemModel>

}