package com.mobile.azrinurvani.dnaproject.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.mobile.azrinurvani.dnaproject.BaseFragment
import com.mobile.azrinurvani.dnaproject.R
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
        Toast.makeText(activity,"Home Fragment", Toast.LENGTH_SHORT).show()
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel = ViewModelProviders.of(this,providerFactory).get(HomeViewModel::class.java)

        moveToFragmentStnkTahunan()

    }

    private fun moveToFragmentStnkTahunan(){
        binding.cardPajakTahunan.setOnClickListener {
            val directions= FragmentHomeDirections.actionFragmentHomeToFormStnkTahunanFragment()
            it.findNavController().navigate(directions)
        }
    }

}