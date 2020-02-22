package ir.yara.batmanproject.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "listOfFilms")
data class Search (

	@PrimaryKey(autoGenerate = true)
	val id : Int,

	@ColumnInfo(name = "imdbID")
	@SerializedName("imdbID")
	val imdbID : String,

	@ColumnInfo(name = "Title")
	@SerializedName("Title")
	val title : String,

	@ColumnInfo(name = "Year")
	@SerializedName("Year")
	val year : String,

	@ColumnInfo(name = "Type")
	@SerializedName("Type")
	val type : String,

	@ColumnInfo(name = "Poster")
	@SerializedName("Poster")
	val poster : String
)