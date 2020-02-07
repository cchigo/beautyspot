package com.chigo.beautyspot.data.api

import com.chigo.beautyspot.data.vo.Location
import retrofit2.http.GET
import retrofit2.http.Path

interface TheMovieDBInterface {
    //https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=500&types=food&name=harbour&key=AIzaSyDxeQW0YiShwDz1ireJ8e3hwM5EZ0M6CTE
    //baseurl
    //https://maps.googleapis.com/maps/api/place/nearbysearch
    @GET("location/radius")
    fun getSpotDetails(@Path("location")location: Location)
}