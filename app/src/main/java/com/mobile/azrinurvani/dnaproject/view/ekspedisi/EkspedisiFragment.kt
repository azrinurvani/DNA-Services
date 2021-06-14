package com.mobile.azrinurvani.dnaproject.view.ekspedisi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.mobile.azrinurvani.dnaproject.BaseFragment
import com.mobile.azrinurvani.dnaproject.databinding.FragmentEkspedisiBinding


class EkspedisiFragment : BaseFragment() {

    private lateinit var binding : FragmentEkspedisiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentEkspedisiBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        moveToFormPengirimanMotor()
        moveToFormPengirimanAkesoris()
    }

    private fun moveToFormPengirimanMotor(){
        binding.cardPengirimanMotor.setOnClickListener {
            val directions= EkspedisiFragmentDirections.actionEkspedisiFragmentToFormPengirimanMotorFragment()
            it.findNavController().navigate(directions)
        }
    }


    private fun moveToFormPengirimanAkesoris(){
        binding.cardPengirimanAksesoris.setOnClickListener {
            val directions= EkspedisiFragmentDirections.actionEkspedisiFragmentToFormPengirimanAksesorisFragment()
            it.findNavController().navigate(directions)
        }
    }



    companion object {
        private const val TAG = "EkspedisiFragment"
    }
}