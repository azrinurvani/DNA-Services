package com.mobile.azrinurvani.dnaproject.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.mobile.azrinurvani.dnaproject.BaseFragment
import com.mobile.azrinurvani.dnaproject.databinding.FragmentHomeBinding
import com.mobile.azrinurvani.dnaproject.viewmodel.ViewModelProviderFactory
import javax.inject.Inject

class FragmentHome : BaseFragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)

        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel = ViewModelProviders.of(this,providerFactory).get(HomeViewModel::class.java)

        moveToFragmentStnkTahunan()
        moveToFragmentStnk5Tahunan()
        moveToFragmentStnkHilang()
        moveToFragmentBalikNama()
        moveToFragmentMutasi()
        moveToEkspedisi()

    }

    private fun moveToFragmentStnkTahunan(){
        binding.cardPajakTahunan.setOnClickListener {
            val directions= FragmentHomeDirections.actionFragmentHomeToFormStnkTahunanFragment()
            it.findNavController().navigate(directions)
        }
    }

    private fun moveToFragmentStnk5Tahunan(){
        binding.cardPajak5Tahunan.setOnClickListener {
            val directions= FragmentHomeDirections.actionFragmentHomeToFormStnkLimaTahunanFragment()
            it.findNavController().navigate(directions)
        }
    }

    private fun moveToFragmentStnkHilang(){
        binding.cardStnkHilang.setOnClickListener {
            val directions= FragmentHomeDirections.actionFragmentHomeToFormStnkHilangFragment()
            it.findNavController().navigate(directions)
        }
    }

    private fun moveToFragmentBalikNama(){
        binding.cardBalikNama.setOnClickListener {
            val directions= FragmentHomeDirections.actionFragmentHomeToFormBalikNamaFragment()
            it.findNavController().navigate(directions)
        }
    }

    private fun moveToFragmentMutasi(){
        binding.cardMutasi.setOnClickListener {
            val directions= FragmentHomeDirections.actionFragmentHomeToFormMutasiFragment()
            it.findNavController().navigate(directions)
        }
    }

    private fun moveToEkspedisi(){
        binding.cardEkspedisi.setOnClickListener {
            val directions= FragmentHomeDirections.actionFragmentHomeToPerkiraanHargaEkspedisiFragment()
            it.findNavController().navigate(directions)
        }
    }



}