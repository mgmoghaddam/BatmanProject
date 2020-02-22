package ir.yara.batmanproject.utils.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ir.yara.batmanproject.model.Ratings
import java.util.*

class RatingsConverters {
    private val gson = Gson()
    @TypeConverter
    fun stringToList(data: String?): List<Ratings> {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType = object : TypeToken<List<Ratings>>() {

        }.type

        return gson.fromJson<List<Ratings>>(data, listType)
    }

    @TypeConverter
    fun listToString(someObjects: List<Ratings>): String {
        return gson.toJson(someObjects)
    }
}