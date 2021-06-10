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
import com.mobile.azrinurvani.dnaproject.databinding.FragmentDetailPengirimanMotorBinding
import com.mobile.azrinurvani.dnaproject.model.Ekspedisi
import com.mobile.azrinurvani.dnaproject.viewmodel.ViewModelProviderFactory
import javax.inject.Inject


class DetailPengirimanMotorFragment : BaseFragment() {

    lateinit var binding : FragmentDetailPengirimanMotorBinding

    private val dataDetailOrder : DetailPengirimanMotorFragmentArgs by navArgs()

    private lateinit var viewModel: EkspedisiViewModel

    @Inject
    lateinit var vmFactory: ViewModelProviderFactory

    lateinit var dataEkspedisi : Ekspedisi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
       binding = FragmentDetailPengirimanMotorBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataEkspedisi = dataDetailOrder.dataDetailPengirimanMotor
        viewModel = ViewModelProviders.of(this,vmFactory).get(EkspedisiViewModel::class.java)

        setDataDetail()

        binding.btnSubmit.setOnClickListener {
            if (dataEkspedisi!=null){
                submitPesanan(dataEkspedisi)
            }else{
                Toast.makeText(activity,"Data ekspedisi is NULL",Toast.LENGTH_LONG).show()
            }
        }
        binding.btnCancel.setOnClickListener {
            moveToHome()
        }
    }

    private fun setDataDetail(){

        if (dataEkspedisi!=null){
            val namaPengirim    = dataEkspedisi.nama_pengirim
            val namaPenerima    = dataEkspedisi.nama_penerima
            val telpPengirim    = dataEkspedisi.telpPengirim
            val telpPenerima    = dataEkspedisi.telpPenerima
            val tglPengiriman   = dataEkspedisi.tglPengiriman
            val tglDiterima     = dataEkspedisi.tglDiterima
            val alamatPengirim  = dataEkspedisi.alamatPengirim
            val alamatPenerima  = dataEkspedisi.alamatPenerima

            val namaBarang  = dataEkspedisi.namaBarang
            val berat = dataEkspedisi.berat
            val total = dataEkspedisi.total

            if (dataEkspedisi.stnkAvail == true){
                binding.txtStnkAsliAvail.text = "Ada"
            }else if (dataEkspedisi.stnkAvail == false){
                binding.txtStnkAsliAvail.text = "Tidak Ada"
            }

            if (dataEkspedisi.tipeBarang==1){
                binding.txtKelasMotor.text = "< 125 cc"
            }else if (dataEkspedisi.tipeBarang==2){
                binding.txtKelasMotor.text = "125 - 150 cc"
            }else if (dataEkspedisi.tipeBarang==3){
                binding.txtKelasMotor.text = "150 - 250 cc"
            }else if (dataEkspedisi.tipeBarang==4){
                binding.txtKelasMotor.text = "250 - 300 cc"
            }else if (dataEkspedisi.tipeBarang==5){
                binding.txtKelasMotor.text = "300 - 500 cc"
            }else if (dataEkspedisi.tipeBarang==6){
                binding.txtKelasMotor.text = "> 500 cc"
            }

            binding.txtNamaPengirim.text = namaPengirim
            binding.txtNamaPenerima.text = namaPenerima
            binding.txtPhonePengirim.text = telpPengirim
            binding.txtPhonePenerima.text = telpPenerima
            binding.txtTglPengiriman.text = tglPengiriman
//            binding.txtTglDiterima.text = tglDiterima
            binding.txtAlamatPengirim.text = alamatPengirim
            binding.txtAlamatDiterima.text = alamatPenerima
            binding.txtMerkMotor.text = namaBarang
            binding.txtBerat.text = berat.toString()
            binding.txtTotalBiaya.text = total.toString()

        }
    }

    private fun submitPesanan(data:Ekspedisi){
        viewModel.saveDataIntoDb(data)
        Toast.makeText(activity,"Submit successful", Toast.LENGTH_LONG).show()
        moveToHome()
    }

    private fun moveToHome(){
        val directions = DetailPengirimanMotorFragmentDirections.actionDetailPengirimanMotorFragmentToFragmentHome()
        view?.findNavController()?.navigate(directions)
    }

    companion object {
        private const val TAG = "DetailPengirimanMotorFr"
    }
}