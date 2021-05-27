package com.mobile.azrinurvani.dnaproject.view.ekspedisi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobile.azrinurvani.dnaproject.BaseFragment
import com.mobile.azrinurvani.dnaproject.R
import dagger.android.support.DaggerFragment


class FragmentDetailEkspedisi : BaseFragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_ekspedisi, container, false)
    }

    companion object {

    }
}