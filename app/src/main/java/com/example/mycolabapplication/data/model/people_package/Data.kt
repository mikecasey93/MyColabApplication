package com.example.mycolabapplication.data.model.people_package


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("body")
    val body: String? = "",
    @SerializedName("fromId")
    val fromId: String? = "",
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("meetingid")
    val meetingid: String? = "",
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("toId")
    val toId: String? = ""
)