package com.mobile.azrinurvani.dnaproject.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = Ekspedisi.TABLE_NAME)
class Ekspedisi(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        var id :Int? = null,

        @ColumnInfo(name = "tipe_barang")
        var tipeBarang:Int? = null,
        //0 = Aksesoris/sparepart,
        // 1 = Motor < 150cc ,
        // 2 = Motor >=150 cc < 250cc,
        // 3 Motor >=250cc < 500cc,
        // 4 >=500cc(moge)

        @ColumnInfo(name = "nama_pengirim")
        var nama_pengirim:String? = null,

        @ColumnInfo(name = "nama_penerima")
        var nama_penerima:String? = null,

        @ColumnInfo(name = "telp_pengirim")
        var telpPengirim:String? = null,

        @ColumnInfo(name = "telp_penerima")
        var telpPenerima:String? = null,

        @ColumnInfo(name = "alamat_pengirim")
        var alamatPengirim:String? = null,

        @ColumnInfo(name = "alamat_penerima")
        var alamatPenerima:String? = null,

        @ColumnInfo(name = "tgl_pengiriman")
        var tglPengiriman:String? = null,

        @ColumnInfo(name = "tgl_diterima")
        var tglDiterima:String? = null,

        @ColumnInfo(name = "berat")
        var berat:Double? = null,

        @ColumnInfo(name = "biaya")
        var biaya:Double? = null,
        //biaya berbeda tergantung tipe barang yang dikirim

        @ColumnInfo(name = "total")
        var total:Double? = null,
        //hasil kalkulasi dari biaya*berat

        @ColumnInfo(name = "status")
        var status:Int? = null
        // 0 = Pengiriman sedang diproses
        // 1 = Sedang melakukan pengiriman ke alamat tujuan
        // 2 = Pengiriman diterima

): Parcelable {
    companion object{
        const val TABLE_NAME="t_ekspedisi"
    }
}