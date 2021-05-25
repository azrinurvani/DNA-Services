package com.mobile.azrinurvani.dnaproject.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mobile.azrinurvani.dnaproject.model.BiroJasa
import com.mobile.azrinurvani.dnaproject.model.User
import com.mobile.azrinurvani.dnaproject.model.db.dao.BiroJasaDao
import com.mobile.azrinurvani.dnaproject.model.db.dao.UserDao

const val DB_VERSION = 1
const val DB_NAME = "DNAServices.db"

@Database(entities = [User::class,BiroJasa::class],version = DB_VERSION,exportSchema = false)
abstract class DnaDatabase : RoomDatabase() {
    abstract fun userDao() : UserDao
    abstract fun biroJasaDao():BiroJasaDao

    companion object{
        @Volatile
        private var databaseInstance : DnaDatabase? = null

        fun getDatabaseInstance(mContext : Context): DnaDatabase =
            databaseInstance ?: synchronized(this){
                databaseInstance ?: buildDatabaseInstance(mContext).also{
                    databaseInstance = it
                }
            }

        private fun buildDatabaseInstance(mContext: Context) =
            Room.databaseBuilder(mContext,DnaDatabase::class.java, DB_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }

}