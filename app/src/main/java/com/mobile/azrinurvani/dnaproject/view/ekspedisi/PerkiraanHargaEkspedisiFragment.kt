package com.mobile.azrinurvani.dnaproject.view.ekspedisi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.mobile.azrinurvani.dnaproject.BaseFragment
import com.mobile.azrinurvani.dnaproject.R
import com.mobile.azrinurvani.dnaproject.databinding.FragmentPerkiraanHargaEkspedisiBinding


class PerkiraanHargaEkspedisiFragment : BaseFragment() {

    private lateinit var binding : FragmentPerkiraanHargaEkspedisiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentPerkiraanHargaEkspedisiBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnContinue.setOnClickListener {
            moveToEkspedisi()
        }

    }

    private fun moveToEkspedisi(){
        val directions = PerkiraanHargaEkspedisiFragmentDirections.actionPerkiraanHargaEkspedisiFragmentToEkspedisiFragment()
        view?.findNavController()?.navigate(directions)
    }

    companion object {
        private const val TAG = "PerkiraanHargaEkspedisi"
    }
}