package ir.yara.batmanproject.utils.db

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Observable
import ir.yara.batmanproject.model.SecondApi


@Dao
interface DetailDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(detail: SecondApi?): Completable?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(detailsList: List<SecondApi?>?): Completable?

    @Insert
    fun insertNew(detailsList: List<SecondApi?>?): Completable?

    @Update
    fun update(oneDetail: SecondApi?): Completable?

    @Delete
    fun delete(oneDetail: SecondApi?): Completable?

    @Delete
    fun deleteList(detailsList: List<SecondApi?>?): Completable?

    @Query("DELETE FROM filmDetails WHERE id IN (:id)")
    fun deleteWithId(id: Int): Completable?

    @Query("SELECT * FROM filmDetails")
    fun getAllDetails(): Observable<List<SecondApi>>

    @Query("SELECT * FROM filmDetails WHERE id IN (:id)")
    fun getDetailWithID(id: Int): Observable<SecondApi>

}