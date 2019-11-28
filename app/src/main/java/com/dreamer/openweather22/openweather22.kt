package com.dreamer.openweather22

import android.app.Application
import androidx.room.Room
import com.dreamer.openweather22.DB.CountryDatabase

class openweather22 : Application() {

    companion object {
        var database: CountryDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        database =  Room.databaseBuilder(applicationContext, CountryDatabase::class.java, "country_db").fallbackToDestructiveMigration().build()
    }
}