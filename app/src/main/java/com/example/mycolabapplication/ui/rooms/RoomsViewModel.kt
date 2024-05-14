package com.example.mycolabapplication.ui.rooms

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycolabapplication.data.api.RetroFitInstance
import com.example.mycolabapplication.data.model.rooms_package.RoomsItemModel
import com.example.mycolabapplication.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomsViewModel @Inject constructor(
    val repository: Repository
) : ViewModel() {

    private val _roomsList = MutableLiveData<ArrayList<RoomsItemModel>>()
    val roomsList: LiveData<ArrayList<RoomsItemModel>> = _roomsList

    init {
        getRoomsList()
    }

    private fun getRoomsList() {
        viewModelScope.launch {
            val result = repository.getRooms()
            if (!result.isNullOrEmpty()) {
                _roomsList.postValue(result as ArrayList<RoomsItemModel>?)
            }
        }
    }
}