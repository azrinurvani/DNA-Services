package com.mobile.azrinurvani.dnaproject.view.home

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.mobile.azrinurvani.dnaproject.model.db.DnaDatabase
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val context: Application,
    private val database: DnaDatabase
): AndroidViewModel(context){


    companion object {
        private const val TAG = "HomeViewModel"
    }

    init {
        Log.d(TAG, "HomeViewModel is working...")
    }

}