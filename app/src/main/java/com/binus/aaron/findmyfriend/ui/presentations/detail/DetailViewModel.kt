package com.binus.aaron.findmyfriend.ui.presentations.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.binus.aaron.findmyfriend.model.ProfileModel
import com.binus.aaron.findmyfriend.repository.AppRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {
    private val repository = AppRepository()

    private val _profile = MutableStateFlow<ProfileModel?>(null)
    val profileDetail: StateFlow<ProfileModel?> = _profile

    fun getProfileDetail(id: Int) {
        viewModelScope.launch {
            val response = repository.getProfileDetail(id)
            if (response.isSuccessful) {
                val data = response.body()
                if (data != null) {
                    _profile.value = data
                }
            }
        }
    }
}