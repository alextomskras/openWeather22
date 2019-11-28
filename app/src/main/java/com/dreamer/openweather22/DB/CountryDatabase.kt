package com.dreamer.openweather22.DB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dreamer.openweather22.Model.CountryModel

@Database(entities = [(CountryModel::class)], version = 1)
abstract class CountryDatabase :RoomDatabase(){

    abstract fun countryDao() : CountryDao
}


