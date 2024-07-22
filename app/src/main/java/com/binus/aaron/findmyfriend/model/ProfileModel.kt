package com.binus.aaron.findmyfriend.model

data class ProfileModel(
    val userId: Int,
    val profilePic: String,
    val coverPhoto: String,
    val username: String,
    val fullName: String,
    val education: String,
    val bio: String,
    val gender: String,
    val email: String,
    val work: String,
    val contactInfo: ContactInfoModel
) {
    data class ContactInfoModel(
        val phone: String,
    )
}