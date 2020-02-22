package ir.yara.batmanproject.utils.db

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Observable
import ir.yara.batmanproject.model.WishList


@Dao
interface WishListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(wish: WishList?): Completable?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(wishList: List<WishList?>?): Completable?

    @Insert
    fun insertNew(wish: List<WishList?>?): Completable?

    @Update
    fun update(wish: WishList?): Completable?

    @Delete
    fun delete(wish: WishList?): Completable?

    @Delete
    fun deleteList(wishList: List<WishList?>?): Completable?

    @Query("DELETE FROM wishList WHERE id IN (:id)")
    fun deleteWithId(id: Int): Completable?

    @Query("DELETE FROM wishList WHERE imdbID IN (:id)")
    fun deleteWithImdbId(id: String): Completable?

    @Query("SELECT * FROM wishList")
    fun getAllWishList(): Observable<List<WishList>>

    @Query("SELECT * FROM wishList WHERE id IN (:id)")
    fun getWishWithID(id: Int): Observable<WishList>

    @Query("SELECT * FROM wishList WHERE imdbID IN (:id)")
    fun getWishWithImdbID(id: String): Observable<WishList>



}