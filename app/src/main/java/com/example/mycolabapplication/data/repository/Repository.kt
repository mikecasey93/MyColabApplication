package com.example.mycolabapplication.data.repository

import com.example.mycolabapplication.data.api.ApiDetails
import com.example.mycolabapplication.data.model.people_package.PeopleItemModel
import com.example.mycolabapplication.data.model.rooms_package.RoomsItemModel
import retrofit2.http.GET

interface Repository {
    suspend fun getPeople() : List<PeopleItemModel>

    suspend fun getRooms() : List<RoomsItemModel>
}