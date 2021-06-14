package com.mobile.azrinurvani.dnaproject.view.ekspedisi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.mobile.azrinurvani.dnaproject.BaseFragment
import com.mobile.azrinurvani.dnaproject.databinding.FragmentDetailPengirimanBarangBinding
import com.mobile.azrinurvani.dnaproject.model.Ekspedisi
import com.mobile.azrinurvani.dnaproject.viewmodel.ViewModelProviderFactory
import javax.inject.Inject

class DetailPengirimanBarangFragment : BaseFragment() {

    private lateinit var binding : FragmentDetailPengirimanBarangBinding

    private val dataDetailOrder : DetailPengirimanBarangFragmentArgs by navArgs()

    private lateinit var viewModel: EkspedisiViewModel

    @Inject
    lateinit var vmFactory: ViewModelProviderFactory

    lateinit var dataEkspedisi : Ekspedisi


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailPengirimanBarangBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataEkspedisi = dataDetailOrder.dataDetailEkspedisi

        viewModel = ViewModelProviders.of(this,vmFactory).get(EkspedisiViewModel::class.java)

        setDataDetail()

        binding.btnSubmit.setOnClickListener {
            if (dataEkspedisi!=null){
                submitPesanan(dataEkspedisi)
            }else{
                Toast.makeText(activity,"Data ekspedisi is NULL", Toast.LENGTH_LONG).show()
            }
        }
        binding.btnCancel.setOnClickListener {
            moveToHome()
        }

    }


    private fun setDataDetail() {

        if (dataEkspedisi!=null) {
            val namaPengirim = dataEkspedisi.nama_pengirim
            val namaPenerima = dataEkspedisi.nama_penerima
            val telpPengirim = dataEkspedisi.telpPengirim
            val telpPenerima = dataEkspedisi.telpPenerima
            val tglPengiriman = dataEkspedisi.tglPengiriman
            val tglDiterima = dataEkspedisi.tglDiterima
            val alamatPengirim = dataEkspedisi.alamatPengirim
            val alamatPenerima = dataEkspedisi.alamatPenerima

            val namaBarang = dataEkspedisi.namaBarang
            val descBarang = dataEkspedisi.descBarang
            val berat = dataEkspedisi.berat
            val total = dataEkspedisi.total


            binding.txtNamaPengirim.text = namaPengirim
            binding.txtNamaPenerima.text = namaPenerima
            binding.txtPhonePengirim.text = telpPengirim
            binding.txtPhonePenerima.text = telpPenerima
            binding.txtTglPengiriman.text = tglPengiriman
//            binding.txtTglDiterima.text = tglDiterima
            binding.txtAlamatPengirim.text = alamatPengirim
            binding.txtAlamatDiterima.text = alamatPenerima
            binding.txtNamaBarang.text = namaBarang
            binding.txtDeskripsi.text = descBarang
            binding.txtBerat.text = berat.toString()
            binding.txtTotalBiaya.text = total.toString()
        }else{
            Toast.makeText(activity,"Data is NULL",Toast.LENGTH_LONG).show()
        }
    }


    private fun submitPesanan(data: Ekspedisi) {
        viewModel.saveDataIntoDb(data)
        Toast.makeText(activity,"Submit successful", Toast.LENGTH_LONG).show()
        moveToHome()
    }

    private fun moveToHome() {
        val directions = DetailPengirimanBarangFragmentDirections.actionDetailPengirimanBarangFragmentToFragmentHome()
        view?.findNavController()?.navigate(directions)
    }

    companion object {
        private const val TAG = "DetailPengirimanBarang"
    }
}