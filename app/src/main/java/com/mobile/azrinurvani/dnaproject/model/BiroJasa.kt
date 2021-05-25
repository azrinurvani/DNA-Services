package com.mobile.azrinurvani.dnaproject.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Entity untuk transaksi
@Entity(tableName = BiroJasa.TABLE_NAME)
class BiroJasa(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id :Int? = null,

    @ColumnInfo(name = "name")
    var name:String? = null,

    @ColumnInfo(name = "no_ktp")
    var noKtp:String? = null,

    @ColumnInfo(name = "phone")
    var phone:String? = null,

    @ColumnInfo(name = "bpkb_avail")
    var bpkbAvail: Boolean? = false,

    @ColumnInfo(name = "stnk_avail")
    var stnkAvail: Boolean? = false,

    @ColumnInfo(name = "ktp_avail")
    var ktpAvail: Boolean? = false,

    @ColumnInfo(name = "ktp_image_path")
    var ktpImagePath:String? = null,

    @ColumnInfo(name = "status")
    var status : Int? = null

) {
    companion object{
        const val TABLE_NAME="t_biro_jasa"
    }
}