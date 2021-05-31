package com.mobile.azrinurvani.dnaproject.model.db.dao

import androidx.room.*
import com.mobile.azrinurvani.dnaproject.model.BiroJasa
import io.reactivex.Completable
import io.reactivex.Single


@Dao
interface BiroJasaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBiroJasa(data: BiroJasa): Completable

    @Query("SELECT * FROM ${BiroJasa.TABLE_NAME}")
    fun getAllBiroJasa() : Single<List<BiroJasa>>

    @Query("SELECT * FROM ${BiroJasa.TABLE_NAME} WHERE id=:id")
    fun getBiroJasaById(id:Int): Single<BiroJasa>

    //update status aproval
    //menggunakan query




    //contoh update
    @Update
    fun updateBiroJasa(data: BiroJasa?): Completable


    //contoh penggunaan
//    fun updateStatus(id: Int, status: Int) {
//        val tour: BiroJasa = getBiroJasaById(id)
//        tour.end_address = end_address
//        updateTour(tour)
//    }



}