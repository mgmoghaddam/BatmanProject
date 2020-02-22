package ir.yara.batmanproject.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

//@Entity(tableName = "listOfFilms")
data class FirstApi(
//    @PrimaryKey(autoGenerate = true) val id: Int,
//    @ColumnInfo(name = "Search")
    @SerializedName("Search") val search: List<Search>,
//    @ColumnInfo(name = "totalResults")
    @SerializedName("totalResults") val totalResults: Int,
//    @ColumnInfo(name = "Response")
    @SerializedName("Response") val response: Boolean
)