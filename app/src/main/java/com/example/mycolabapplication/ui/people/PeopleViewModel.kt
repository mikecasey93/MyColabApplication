package com.example.mycolabapplication.ui.people

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycolabapplication.data.api.RetroFitInstance
import com.example.mycolabapplication.data.model.people_package.PeopleItemModel
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class PeopleViewModel : ViewModel() {

    private val _productList = MutableLiveData<ArrayList<PeopleItemModel>>()
    val productList: LiveData<ArrayList<PeopleItemModel>> = _productList

    init {
        getPeopleList()
    }

    private fun getPeopleList() {
        viewModelScope.launch {
            val result = RetroFitInstance.apiClient.getPeople()
            if(!result.isNullOrEmpty()) {
                _productList.postValue(result as ArrayList<PeopleItemModel>?)
            }
        }
    }
}