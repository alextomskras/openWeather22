package com.dreamer.openweather22.Model


import com.google.gson.annotations.SerializedName

data class Language(
        @SerializedName("iso639_1")
        var iso6391: String, // nd
        @SerializedName("iso639_2")
        var iso6392: String, // nde
        var name: String, // Northern Ndebele
        var nativeName: String // isiNdebele
)