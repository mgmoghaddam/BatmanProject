package ir.yara.batmanproject.utils.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ir.yara.batmanproject.model.FirstApi
import ir.yara.batmanproject.model.Search
import ir.yara.batmanproject.model.SecondApi
import ir.yara.batmanproject.model.WishList
import ir.yara.batmanproject.utils.BatmanMovies


@Database(
    entities = [Search::class,
        SecondApi::class,
        WishList::class],
    version = 4,
    exportSchema = false
)

@TypeConverters(RatingsConverters::class)
abstract class AppDataBase : RoomDatabase() {
    private val DB_NAME = "batman_db"
//    private var instance: AppDataBase? = null
//
//    @Synchronized
//    open fun getInstance(context: Context?): AppDataBase? {
//        if (instance == null) {
//            instance = Room.databaseBuilder(context!!, AppDataBase::class.java, DB_NAME)
//                .fallbackToDestructiveMigration()
//                .build()
//        }
//        return instance
//    }

    companion object {
        @Volatile private var instance: AppDataBase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            AppDataBase::class.java, "batman_db")
            .fallbackToDestructiveMigration()
            .build()

    }


    abstract fun moviesList(): ListDao?

    abstract fun detailsList(): DetailDao?

    abstract fun wishList(): WishListDao?

}