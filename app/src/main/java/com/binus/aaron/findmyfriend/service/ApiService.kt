package com.binus.aaron.findmyfriend.service

import com.binus.aaron.findmyfriend.model.ProfileModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("social-profiles")
    suspend fun getProfile(): Response<List<ProfileModel>>

    @GET("social-profiles/{id}")
    suspend fun getProfileDetail(@Path("id") id: Int): Response<ProfileModel>
}