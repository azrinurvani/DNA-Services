package com.mobile.azrinurvani.dnaproject.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

//Entity untuk transaksi
@Parcelize
@Entity(tableName = BiroJasa.TABLE_NAME)
class BiroJasa(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id :Int? = null,

    @ColumnInfo(name = "jenis_doc")
    var jenisDoc:Int? = null, //1 = STNK Tahunan, 2=STNK 5 Tahunan, 3= STNK Hilang, 4 = Mutasi, 5 = Balik Nama

    @ColumnInfo(name = "name")
    var name:String? = null,

    @ColumnInfo(name = "no_ktp")
    var noKtp:String? = null,

    @ColumnInfo(name = "no_polisi")
    var noPolisi:String? = null,

    @ColumnInfo(name = "phone")
    var phone:String? = null,

    @ColumnInfo(name = "address")
    var address:String? = null,

    @ColumnInfo(name = "bpkb_avail")
    var bpkbAvail: Boolean? = false,

    @ColumnInfo(name = "stnk_avail")
    var stnkAvail: Boolean? = false,

    @ColumnInfo(name = "cpv_avail")
    var cpvAvail: Boolean? = false,

    @ColumnInfo(name = "ktp_avail")
    var ktpAvail: Boolean? = false,

    @ColumnInfo(name = "ktp_image_path")
    var ktpImagePath:String? = null,

    @ColumnInfo(name = "status")
    var status : Int? = null // 0 = Form rejected, 1 = Sedang di proses, 2 = Form disetujui, 3 = Dokumen segera dijemput, 4 = Menunggu pembayaran, 5 = Done

) : Parcelable {
    companion object{
        const val TABLE_NAME="t_biro_jasa"
    }
}