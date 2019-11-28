package com.dreamer.openweather22.Retrofit

import retrofit2.Call
import retrofit2.http.GET
import com.dreamer.openweather22.Model.CountryModel

interface RestApi {

    @GET("all")
    fun getAllCountries() : Call<List<CountryModel>>
}