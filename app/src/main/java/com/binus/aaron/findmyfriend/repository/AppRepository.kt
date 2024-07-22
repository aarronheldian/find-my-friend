package com.binus.aaron.findmyfriend.repository

import com.binus.aaron.findmyfriend.model.ProfileModel
import com.binus.aaron.findmyfriend.service.ApiService
import com.binus.aaron.findmyfriend.service.RetrofitInstance
import retrofit2.Response

class AppRepository : ApiService {
    override suspend fun getProfile(): Response<List<ProfileModel>> {
        return RetrofitInstance.api.getProfile()
    }

    override suspend fun getProfileDetail(id: Int): Response<ProfileModel> {
        return RetrofitInstance.api.getProfileDetail(id)
    }
}