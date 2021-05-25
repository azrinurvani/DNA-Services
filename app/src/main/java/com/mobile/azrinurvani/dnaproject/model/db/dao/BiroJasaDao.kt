package com.mobile.azrinurvani.dnaproject.model.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mobile.azrinurvani.dnaproject.model.BiroJasa
import com.mobile.azrinurvani.dnaproject.model.User
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


}