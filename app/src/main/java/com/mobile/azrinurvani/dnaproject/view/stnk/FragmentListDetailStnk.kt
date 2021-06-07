package com.mobile.azrinurvani.dnaproject.view.stnk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobile.azrinurvani.dnaproject.BaseFragment
import com.mobile.azrinurvani.dnaproject.databinding.FragmentListDetailStnkBinding
import com.mobile.azrinurvani.dnaproject.model.BiroJasa
import com.mobile.azrinurvani.dnaproject.viewmodel.ViewModelProviderFactory
import javax.inject.Inject


class FragmentListDetailStnk : BaseFragment() {

    private lateinit var binding : FragmentListDetailStnkBinding

    private lateinit var viewModel: StnkViewModel

    @Inject
    lateinit var vmFactory : ViewModelProviderFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListDetailStnkBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this,vmFactory).get(StnkViewModel::class.java)

        retrieveData()
        setRecyclerView()

    }

    private fun retrieveData(){
        viewModel?.biroJasaList.removeObservers(viewLifecycleOwner)
        viewModel?.biroJasaList?.observe(viewLifecycleOwner, Observer {
            if(!it.isNullOrEmpty()){
                viewModel.setRecyclerAdapter(it as ArrayList<BiroJasa>)
            }else{
                Toast.makeText(activity,"Data is NULL", Toast.LENGTH_LONG).show()
            }
        })
        viewModel.getBiroJasaData()
    }


    private fun setRecyclerView(){
        binding?.rvDetailStnk?.apply {
            setHasFixedSize(true)
            adapter = viewModel.getRecyclerAdapter()
            layoutManager = LinearLayoutManager(activity)
//            val decoration = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
//            addItemDecoration(decoration)
        }
    }

    companion object {
        private const val TAG = "FragmentDetailStnk"
    }
}