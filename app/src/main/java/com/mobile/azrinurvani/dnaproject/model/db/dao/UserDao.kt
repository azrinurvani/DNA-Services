package com.mobile.azrinurvani.dnaproject.model.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mobile.azrinurvani.dnaproject.model.User
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user:User):Completable

    @Query("SELECT * FROM ${User.TABLE_NAME} WHERE id=:id")
    fun getUserById(id:Int) : Single<User>


}