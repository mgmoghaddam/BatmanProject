package ir.yara.batmanproject.utils.db

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Observable
import ir.yara.batmanproject.model.FirstApi
import ir.yara.batmanproject.model.Search

@Dao
interface ListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(oneMovie: Search?): Completable?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(moviesList: List<Search?>?): Completable?

    @Insert
    fun insertNew(moviesList: List<Search?>?): Completable?

    @Update
    fun update(oneMovie: Search?): Completable?

    @Delete
    fun delete(oneMovie: Search?): Completable?

    @Delete
    fun deleteList(moviesList: List<Search?>?): Completable?

    @Query("DELETE FROM listOfFilms WHERE id IN (:id)")
    fun deleteWithId(id: Int): Completable?

    @Query("SELECT * FROM listOfFilms")
    fun getAllList(): Observable<List<Search>>

    @Query("SELECT * FROM listOfFilms")
    fun getAll(): Observable<Search>

    @Query("SELECT * FROM listOfFilms WHERE id IN (:id)")
    fun getMovieWithID(id: Int): Observable<Search>
}