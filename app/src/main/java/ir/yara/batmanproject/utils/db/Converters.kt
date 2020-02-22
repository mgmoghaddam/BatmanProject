package ir.yara.batmanproject.utils.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ir.yara.batmanproject.model.Ratings
import java.util.*

class Converters {
    @TypeConverter
    fun fromString(value: String?): ArrayList<Ratings> {
        val listType =
            object : TypeToken<ArrayList<Ratings?>?>() {}.type
        return Gson().fromJson<ArrayList<Ratings>>(value, listType)
    }

    @TypeConverter
    fun fromArrayLisr(list: ArrayList<Ratings?>?): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}