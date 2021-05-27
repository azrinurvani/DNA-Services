package com.mobile.azrinurvani.dnaproject.view.stnk

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.mobile.azrinurvani.dnaproject.model.BiroJasa
import com.mobile.azrinurvani.dnaproject.model.db.DnaDatabase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class StnkTahunanViewModel @Inject constructor(
    private val context : Application,
    private val database: DnaDatabase
) : AndroidViewModel(context){


    protected val compositeDisposable = CompositeDisposable()
    //val biroJasaList = MutableLiveData<List<BiroJasa>>()

    init {
        Log.d(TAG, "STNKTahunanViewModel is working...." )
    }

    fun saveDataIntoDb(data: BiroJasa){

        database?.biroJasaDao()?.insertBiroJasa(data)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(
                {
                    Log.d(TAG, "saveDataIntoDb: Insert Success")

                },{
                    Log.e(TAG, "saveDataIntoDb: errror ${it.localizedMessage}" )
                }
            )?.let {
                compositeDisposable.add(it)
            }
    }

    companion object {
        private const val TAG = "StnkTahunanViewModel"
    }
}