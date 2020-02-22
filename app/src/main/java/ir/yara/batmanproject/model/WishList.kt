package ir.yara.batmanproject.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "wishList")
data class WishList(


    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    val id: Int,

    @ColumnInfo(name = "imdbID")
    @SerializedName("imdbID")
    val imdbID: String

)