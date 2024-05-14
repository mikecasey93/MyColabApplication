package com.example.mycolabapplication.data.repository

import com.example.mycolabapplication.data.api.ApiEndpoints
import com.example.mycolabapplication.data.model.people_package.PeopleItemModel
import com.example.mycolabapplication.data.model.rooms_package.RoomsItemModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor (
    private val apiDetails: ApiEndpoints
) : Repository {
    override suspend fun getPeople(): List<PeopleItemModel> = apiDetails.getPeople()
    override suspend fun getRooms(): List<RoomsItemModel> = apiDetails.getRooms()


}