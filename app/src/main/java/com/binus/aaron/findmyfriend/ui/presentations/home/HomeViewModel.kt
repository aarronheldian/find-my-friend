package com.binus.aaron.findmyfriend.ui.presentations.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.binus.aaron.findmyfriend.model.ProfileModel
import com.binus.aaron.findmyfriend.repository.AppRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val repository = AppRepository()

    private val _profile = MutableStateFlow<List<ProfileModel>>(emptyList())
    val profile: StateFlow<List<ProfileModel>> = _profile

    init {
        getProfileList()
    }

    private fun getProfileList() {
        viewModelScope.launch {
            val response = repository.getProfile()
            if (response.isSuccessful) {
                val data = response.body()
                if (data != null) {
                    _profile.value = data
                }
            }
        }
    }
}