package com.example.mycolabapplication.ui.people

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycolabapplication.data.api.RetroFitInstance
import com.example.mycolabapplication.data.model.people_package.PeopleItemModel
import com.example.mycolabapplication.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(
    val repository: Repository
) : ViewModel() {

    private val _productList = MutableLiveData<ArrayList<PeopleItemModel>>()
    val productList: LiveData<ArrayList<PeopleItemModel>> = _productList

    val dataShare = flow<String>{ }
    val dataShareState = MutableStateFlow("Hello")

    init {
        getPeopleList()
    }

    private fun getPeopleList() {
        viewModelScope.launch {
            val result = repository.getPeople()
            if(!result.isNullOrEmpty()) {
                _productList.postValue(result as ArrayList<PeopleItemModel>?)
            }
            dataShareState.emit("World")
        }
    }
}