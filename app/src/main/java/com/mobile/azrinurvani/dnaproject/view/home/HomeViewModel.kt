package com.mobile.azrinurvani.dnaproject.view.home

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val context: Application
): AndroidViewModel(context){


    companion object {
        private const val TAG = "HomeViewModel"
    }

    init {
        Log.d(TAG, "HomeViewModel is working...")
    }

}