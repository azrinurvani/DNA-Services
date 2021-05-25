package com.mobile.azrinurvani.dnaproject.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = User.TABLE_NAME)
class User(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Int? = null,
    var fullname:String? = null,
    var username:String? = null,
    var phone:String? = null,
    var address:String? = null,
    var email:String? = null,
    var status:Int? = null

    ) {

    companion object{
        const val TABLE_NAME = "t_user"
    }
}