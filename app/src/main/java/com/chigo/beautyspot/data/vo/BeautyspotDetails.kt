package com.chigo.beautyspot.data.vo


import com.google.gson.annotations.SerializedName

data class BeautyspotDetails(
    val geometry: Geometry,
    val icon: String,
    val id: String,
    val name: String,
    @SerializedName("opening_hours")
    val openingHours: OpeningHours,
    val photos: List<Photo>,
    @SerializedName("place_id")
    val placeId: String,
    @SerializedName("plus_code")
    val plusCode: PlusCode,
    @SerializedName("price_level")
    val priceLevel: Int,
    val rating: Int,
    val reference: String,
    val scope: String,
    val types: List<String>,
    @SerializedName("user_ratings_total")
    val userRatingsTotal: Int,
    val vicinity: String
)