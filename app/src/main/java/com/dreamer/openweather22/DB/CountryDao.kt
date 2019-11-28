package com.dreamer.openweather22.DB

import androidx.lifecycle.LiveData
import androidx.room.*
import com.dreamer.openweather22.Model.CountryModel

import com.dreamer.openweather22.Model.ListConvert

@Dao
@TypeConverters(ListConvert::class)
interface CountryDao {

    @Query("SELECT * FROM Countries")
    fun getAllCountries() : LiveData<List<CountryModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCountries(countryList: List<CountryModel>)

    @Query("DELETE FROM Countries")
    fun deleteAllCountries()
}