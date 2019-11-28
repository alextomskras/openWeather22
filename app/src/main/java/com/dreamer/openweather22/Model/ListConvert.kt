package com.dreamer.openweather22.Model

import android.util.Log
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListConvert {

    @TypeConverter
    fun fromString(value: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        Log.d(this@ListConvert.toString(), "fromString with error code: $String")
        return Gson().fromJson(value, listType)

    }

    @TypeConverter
    fun fromListLisr(list: List<String>): String {
        val gson = Gson()
        Log.d(this@ListConvert.toString(), "fromListLisr with1 error code: ${list.last()}")
        return gson.toJson(list.last()
        )
    }

//    class ReposPersistentConverter {
//        // RepoOwner
//        @TypeConverter
//        fun storeRepoOwnerToString(data: Currency): String = data.toJson()
//
//        @TypeConverter
//        fun storeStringToRepoOwner(value: String): Currency {
//            val gson = Gson()
//            return Gson().value.fromJson()
//        }
//    }

}