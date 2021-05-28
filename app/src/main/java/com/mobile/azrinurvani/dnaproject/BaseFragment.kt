package com.mobile.azrinurvani.dnaproject

import androidx.appcompat.app.AlertDialog
import com.mobile.azrinurvani.dnaproject.view.MainActivity
import dagger.android.support.DaggerFragment

abstract class BaseFragment : DaggerFragment() {

    private var progressDialog: AlertDialog? = null

    fun showLoading() {
        progressDialog?.dismiss()
        activity?.let {
            progressDialog = AlertDialog.Builder(it.applicationContext, R.style.Theme_AppTheme_Dialog_Alert)
                    .setView(R.layout.layout_loading)
                    .setCancelable(false)
                    .show()
        }
    }

    fun hideLoading() {
        activity?.let {
            progressDialog?.dismiss()
//            if (activity is MainActivity)
//                (activity as MainActivity).onRefreshFinished()
        }
    }
}