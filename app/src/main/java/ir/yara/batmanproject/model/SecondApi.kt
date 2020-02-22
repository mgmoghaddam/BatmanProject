package ir.yara.batmanproject.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import ir.yara.batmanproject.utils.db.Converters
import ir.yara.batmanproject.utils.db.RatingsConverters

@Entity(tableName = "filmDetails")
data class SecondApi (
	@PrimaryKey(autoGenerate = true) val id : Int,
	@ColumnInfo(name = "Title")@SerializedName("Title") val title : String,
	@ColumnInfo(name = "Year")@SerializedName("Year") val year : Int,
	@ColumnInfo(name = "Rated")@SerializedName("Rated") val rated : String,
	@ColumnInfo(name = "Released")@SerializedName("Released") val released : String,
	@ColumnInfo(name = "Runtime")@SerializedName("Runtime") val runtime : String,
	@ColumnInfo(name = "Genre")@SerializedName("Genre") val genre : String,
	@ColumnInfo(name = "Director")@SerializedName("Director") val director : String,
	@ColumnInfo(name = "Writer")@SerializedName("Writer") val writer : String,
	@ColumnInfo(name = "Actors")@SerializedName("Actors") val actors : String,
	@ColumnInfo(name = "Plot")@SerializedName("Plot") val plot : String,
	@ColumnInfo(name = "Language")@SerializedName("Language") val language : String,
	@ColumnInfo(name = "Country")@SerializedName("Country") val country : String,
	@ColumnInfo(name = "Awards")@SerializedName("Awards") val awards : String,
	@ColumnInfo(name = "Poster")@SerializedName("Poster") val poster : String,
	@TypeConverters(RatingsConverters::class)
	@ColumnInfo(name = "Ratings")@SerializedName("Ratings") val ratings : List<Ratings>,
	@ColumnInfo(name = "Metascore")@SerializedName("Metascore") val metascore : Int,
	@ColumnInfo(name = "imdbRating")@SerializedName("imdbRating") val imdbRating : Double,
	@ColumnInfo(name = "imdbVotes")@SerializedName("imdbVotes") val imdbVotes : String,
	@ColumnInfo(name = "imdbID")@SerializedName("imdbID") val imdbID : String,
	@ColumnInfo(name = "Type")@SerializedName("Type") val type : String,
	@ColumnInfo(name = "DVD")@SerializedName("DVD") val dVD : String,
	@ColumnInfo(name = "BoxOffice")@SerializedName("BoxOffice") val boxOffice : String,
	@ColumnInfo(name = "Production")@SerializedName("Production") val production : String,
	@ColumnInfo(name = "Website")@SerializedName("Website") val website : String,
	@ColumnInfo(name = "Response")@SerializedName("Response") val response : Boolean
)