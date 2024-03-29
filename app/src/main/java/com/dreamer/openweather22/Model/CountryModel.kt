package com.dreamer.openweather22.Model

import android.util.Log
import androidx.room.*
import com.dreamer.myweather2.data.db.entity.openweatherapi.Coord
import com.dreamer.myweather2.data.db.entity.openweatherapi.Main
import com.dreamer.myweather2.data.db.entity.openweatherapi.WeatherEntry
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken

@Entity(tableName = "Countries")
@TypeConverters(ListConvert::class, ReposPersistentConverter::class,
        WeatherConverter::class,
        CoordConverter::class,
        MainConverter::class)
data class CountryModel(
        val base: String, // stations
//        @Embedded(prefix = "clouds_")
//        val clouds: Clouds,
        val cod: Int, // 200
////        val coord: Coord = Coord(),
        val dt: Int, // 1573150768
        @PrimaryKey
        val id: Int, // 524901
        @SerializedName("main")
        @Embedded(prefix = "main_")
        var main: Main,
//        val main: Mainnnn2,
        @SerializedName("name")
        val name: String, // Moscow
//        @Embedded(prefix = "sys_")
//        val sys: Sys,
        val timezone: Int, // 10800
        val visibility: Int, // 10000
        @SerializedName("weather")
//////        val weather: WeatherDayContainer,
//////        @Embedded( prefix = "weath_")
        var weather: List<WeatherEntry>,
////        val weather: Mainnnn2?,
        @SerializedName("coord")
        @Embedded(prefix = "location_")
//        var location: List<String>
        var location: Coord
//        @Embedded(prefix = "wind_")
//        val wind: Wind
)

class CoordConverter {
        @TypeConverter
        fun fromString(value: String?): List<Coord?>? = Gson().fromJson(value, object : TypeToken<List<Coord?>?>() {}.type)

        @TypeConverter
        fun fromJson(value: List<Coord?>?): String? = Gson().toJson(value)

}

class WeatherConverter {
        @TypeConverter
        fun fromString(value: String): List<WeatherEntry> {
                Log.e(this@WeatherConverter.toString(), "fromerror1: ${value.last()}")
                return Gson().fromJson(value, object : TypeToken<List<WeatherEntry>>() {}.type)
        }

        @TypeConverter
        fun fromJson(value: List<WeatherEntry>): String {
                Log.e(this@WeatherConverter.toString(), "fromerror2: ${value.last()}")
                return Gson().toJson(value)
        }

}

class MainConverter {
        @TypeConverter
        fun fromString1(value: String): List<Main> = Gson().fromJson(value, object : TypeToken<List<Main>>() {}.type)

        @TypeConverter
        fun fromJson(value: List<Main>): String? = Gson().toJson(value)

}

class ReposPersistentConverter {
        @TypeConverter
        fun fromString(value: String): List<Currency> = Gson().fromJson(value, object : TypeToken<List<Currency>>() {}.type)

        @TypeConverter
        fun fromModel(value: List<Currency>): String = Gson().toJson(value)

}

