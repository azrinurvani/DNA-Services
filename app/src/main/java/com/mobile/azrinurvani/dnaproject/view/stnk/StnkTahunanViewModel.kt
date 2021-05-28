package com.mobile.azrinurvani.dnaproject.view.stnk

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.mobile.azrinurvani.dnaproject.model.BiroJasa
import com.mobile.azrinurvani.dnaproject.model.db.DnaDatabase
import com.mobile.azrinurvani.dnaproject.view.adapter.StnkDetailRecyclerAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class StnkTahunanViewModel @Inject constructor(
    private val context : Application,
    private val database: DnaDatabase
) : AndroidViewModel(context){


    protected val compositeDisposable = CompositeDisposable()
    val biroJasaList = MutableLiveData<List<BiroJasa>>()

    @Inject
    lateinit var stnkDetailRecyclerAdapter: StnkDetailRecyclerAdapter

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

    fun getBiroJasaData(){
        database?.biroJasaDao()?.getAllBiroJasa()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe({
                    if(!it.isNullOrEmpty()){
                        biroJasaList.postValue(it)
                    }else{
                        biroJasaList.postValue(listOf())
                    }
                    it?.forEach{biroJasa->
                        biroJasa.name?.let { it1 -> Log.v("Person Name ", it1) }
                    }

                },{
                    Log.e(TAG, "getPersonData: RxError: ${it.localizedMessage}" )

                })?.let {
                    compositeDisposable.add(it)
                }
    }



    //Adapter
    fun getRecyclerAdapter(): StnkDetailRecyclerAdapter{
        return stnkDetailRecyclerAdapter
    }
    fun setRecyclerAdapter(data : ArrayList<BiroJasa>){
        stnkDetailRecyclerAdapter.setStnkRecyclerAdapter(data)
    }


    companion object {
        private const val TAG = "StnkTahunanViewModel"
    }
}