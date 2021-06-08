package com.mobile.azrinurvani.dnaproject.view.ekspedisi

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.mobile.azrinurvani.dnaproject.model.BiroJasa
import com.mobile.azrinurvani.dnaproject.model.Ekspedisi
import com.mobile.azrinurvani.dnaproject.model.db.DnaDatabase
import com.mobile.azrinurvani.dnaproject.view.stnk.StnkViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class EkspedisiViewModel @Inject constructor(
    private val context : Application,
    private val database: DnaDatabase
) : AndroidViewModel(context){


    protected val compositeDisposable = CompositeDisposable()
    val ekspedisiList = MutableLiveData<List<Ekspedisi>>()

    init {
        Log.d(TAG, "EkspedisiViewModel is working...." )
    }

    fun saveDataIntoDb(
        tipeBarang : Int, namaPengirim :String, namaPenerima: String, telpPengirim:String,telpPenerima:String,
        tglDikirim:String,tglDiterima:String, alamatPengiriman:String,alamatDiterima:String,
        namaBarang:String,biaya:Double,berat:Double,stnkAvail:Boolean,total:Double,status:Int
    ){
        val data = Ekspedisi(
            tipeBarang = tipeBarang,
            nama_pengirim = namaPengirim,
            nama_penerima = namaPenerima,
            telpPengirim = telpPengirim,
            telpPenerima = telpPenerima,
            tglPengiriman = tglDikirim,
            tglDiterima = tglDiterima,
            alamatPengirim = alamatPengiriman,
            alamatPenerima = alamatDiterima,
            namaBarang = namaBarang,
            biaya = biaya,
            berat = berat,
            stnkAvail = stnkAvail,
            total = total,
            status = status)

        database?.ekspedisiDao()?.insertEkspedisi(data)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(
                {
                    Log.d(TAG, "saveDataIntoDb: Insert Success")

                },{
                    Log.e(TAG, "saveDataIntoDb: errror ${it.localizedMessage}" )
                    errorMsg = it.localizedMessage.toString()
                }
            )?.let {
                compositeDisposable.add(it)
            }

    }

    fun saveDataIntoDb(data:Ekspedisi){

        database?.ekspedisiDao()?.insertEkspedisi(data)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(
                {
                    Log.d(TAG, "saveDataIntoDb: Insert Success")

                },{
                    Log.e(TAG, "saveDataIntoDb: errror ${it.localizedMessage}" )
                    errorMsg = it.localizedMessage.toString()
                }
            )?.let {
                compositeDisposable.add(it)
            }

    }

    companion object{
        private const val TAG = "EkspedisiViewModel"
        var errorMsg = ""
    }
}