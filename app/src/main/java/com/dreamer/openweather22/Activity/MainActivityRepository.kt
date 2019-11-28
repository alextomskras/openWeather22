package com.dreamer.openweather22.Activity

import android.util.Log
import androidx.lifecycle.LiveData
import com.google.gson.Gson
import com.dreamer.openweather22.Model.CountryModel
import com.dreamer.openweather22.Retrofit.RestApi
import com.dreamer.openweather22.openweather22
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//https://api.openweathermap.org/data/2.5/weather?q=moscow&lang=en&appid=f9d142fda1995a149d1b35f11bc9a928

const val APP_KEY = "f9d142fda1995a149d1b35f11bc9a928"

class MainActivityRepository {

    val BASE_URL = "https://api.openweathermap.org/data/2.5/weather?q=moscow&lang=en&appid=f9d142fda1995a149d1b35f11bc9a928"
//    val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    val TAG = MainActivityRepository::class.java.simpleName

    fun getCountries() : LiveData<List<CountryModel>>
    {
        return openweather22.database!!.countryDao().getAllCountries()

    }

    fun ApiCallAndPutInDB()
    {
        val gson = Gson()
        val retrofit =  Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build()

        val restApi = retrofit.create<RestApi>(RestApi::class.java)

        restApi.getAllCountries().enqueue(object : Callback<List<CountryModel>>{

            override fun onFailure(call: Call<List<CountryModel>>?, t: Throwable?) {
                Log.e(TAG, "OOPS!! something went wrong.. $t")
            }

            override fun onResponse(call: Call<List<CountryModel>>?, response: Response<List<CountryModel>>?) {

                Log.e(TAG,response!!.body().toString())
                when(response.code())
                {
                    200 ->{
                        Thread(Runnable {

                            openweather22.database!!.countryDao().deleteAllCountries()
                            openweather22.database!!.countryDao().insertAllCountries(response.body()!!)

                        }).start()
                    }
                }

            }
        })


    }
}