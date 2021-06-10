package com.mobile.azrinurvani.dnaproject.model.db.dao

import androidx.room.*
import com.mobile.azrinurvani.dnaproject.model.Ekspedisi
import io.reactivex.Completable
import io.reactivex.Single


@Dao
interface EkspedisiDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEkspedisi(data: Ekspedisi): Completable

    @Query("SELECT * FROM ${Ekspedisi.TABLE_NAME}")
    fun getAllEkspedisi() : Single<List<Ekspedisi>>

    @Query("SELECT * FROM ${Ekspedisi.TABLE_NAME} WHERE id=:id")
    fun getEkspedisiById(id:Int): Single<Ekspedisi>

    //update status aproval
    //menggunakan query

    @Query("UPDATE t_ekspedisi SET status=:status WHERE id = :id")
    fun updateStatusEkspedisi(status: Int, id: Int) : Completable

    @Query("UPDATE t_ekspedisi SET tgl_diterima=:tgl, status=:status WHERE id = :id")
    fun updateEkspedisiDiterima(tgl:String, status: Int, id: Int) : Completable


    //update menggunakan object
    @Update
    fun updateEkspedisi(data: Ekspedisi?): Completable


    //contoh penggunaan
//    fun updateStatus(id: Int, status: Int) {
//        val tour: BiroJasa = getBiroJasaById(id)
//        tour.end_address = end_address
//        updateTour(tour)
//    }



}