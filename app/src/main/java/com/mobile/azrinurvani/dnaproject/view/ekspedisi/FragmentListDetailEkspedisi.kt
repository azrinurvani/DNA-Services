package com.mobile.azrinurvani.dnaproject.view.ekspedisi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobile.azrinurvani.dnaproject.BaseFragment
import com.mobile.azrinurvani.dnaproject.databinding.FragmentListDetailEkspedisiBinding
import com.mobile.azrinurvani.dnaproject.model.Ekspedisi
import com.mobile.azrinurvani.dnaproject.viewmodel.ViewModelProviderFactory
import javax.inject.Inject


class FragmentListDetailEkspedisi : BaseFragment() {


    private lateinit var binding : FragmentListDetailEkspedisiBinding
    private lateinit var viewModel: EkspedisiViewModel

    @Inject
    lateinit var vmFactory : ViewModelProviderFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListDetailEkspedisiBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this,vmFactory).get(EkspedisiViewModel::class.java)

        retrieveData()
        setRecyclerView()

    }

    private fun retrieveData(){
        viewModel?.ekspedisiList.removeObservers(viewLifecycleOwner)
        viewModel?.ekspedisiList?.observe(viewLifecycleOwner, Observer {
            if(!it.isNullOrEmpty()){
                viewModel.setRecyclerAdapter(it as ArrayList<Ekspedisi>)
            }else{
                Toast.makeText(activity,"Data is NULL", Toast.LENGTH_LONG).show()
            }
        })
        viewModel.getAllEkspedisiData()
    }


    private fun setRecyclerView(){
        binding?.rvEkspedisi?.apply {
            setHasFixedSize(true)
            adapter = viewModel.getRecyclerAdapter()
            layoutManager = LinearLayoutManager(activity)
//            val decoration = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
//            addItemDecoration(decoration)
        }
    }

    companion object {
        private const val TAG = "FragmentListDetailEkspe"
    }
}