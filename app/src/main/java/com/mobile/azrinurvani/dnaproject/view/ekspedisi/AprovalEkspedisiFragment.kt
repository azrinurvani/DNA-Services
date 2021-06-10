package com.mobile.azrinurvani.dnaproject.view.ekspedisi

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.mobile.azrinurvani.dnaproject.BaseFragment
import com.mobile.azrinurvani.dnaproject.R
import com.mobile.azrinurvani.dnaproject.databinding.FragmentAprovalEkspedisiBinding
import com.mobile.azrinurvani.dnaproject.model.Ekspedisi
import com.mobile.azrinurvani.dnaproject.view.stnk.AprovalStnkFragmentDirections
import com.mobile.azrinurvani.dnaproject.viewmodel.ViewModelProviderFactory
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@SuppressLint("NewApi")
class AprovalEkspedisiFragment : BaseFragment() {

    private lateinit var binding : FragmentAprovalEkspedisiBinding
    private lateinit var viewModel: EkspedisiViewModel

    private val dataDetailEkspedisi : AprovalEkspedisiFragmentArgs by navArgs()

    @Inject
    lateinit var vmFactory : ViewModelProviderFactory

    var id_ekspedisi = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentAprovalEkspedisiBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this,vmFactory).get(EkspedisiViewModel::class.java)

        id_ekspedisi = dataDetailEkspedisi.dataDetailEkspedisi.id?.toInt() ?: 0

        setDataDetail()
        terimaPaket()
        moveToCallByPhone()

    }


    private fun setDataDetail(){
        val dataEkspedisi = dataDetailEkspedisi.dataDetailEkspedisi
        if (dataEkspedisi!=null){
            val namaPengirim = dataEkspedisi.nama_pengirim
            val namaPenerima = dataEkspedisi.nama_penerima
            val telpPengirim = dataEkspedisi.telpPengirim
            val telpPenerima = dataEkspedisi.telpPenerima
            val alamatPengirim = dataEkspedisi.alamatPengirim
            val alamatPenerima = dataEkspedisi.alamatPenerima
            val tglDikirim = dataEkspedisi.tglPengiriman
            val tglDiterima = dataEkspedisi.tglDiterima

            val namaBarang  = dataEkspedisi.namaBarang
            val berat = dataEkspedisi.berat
            val total = dataEkspedisi.total

            if (dataEkspedisi.stnkAvail == true){
                binding.txtStnkAsliAvail.text = "Ada"
            }else if (dataEkspedisi.stnkAvail == false){
                binding.txtTitleStnk.visibility = View.GONE
                binding.txtStnkAsliAvail.visibility = View.GONE
            }

            if(dataEkspedisi.tipeBarang==0){
                binding.txtJenisBarang.text = "Akesoris/Sparepart"
            } else if (dataEkspedisi.tipeBarang==1){
                binding.txtJenisBarang.text = "Motor < 125 cc"
            }else if (dataEkspedisi.tipeBarang==2){
                binding.txtJenisBarang.text = "Motor 125 - 150 cc"
            }else if (dataEkspedisi.tipeBarang==3){
                binding.txtJenisBarang.text = "Motor 150 - 250 cc"
            }else if (dataEkspedisi.tipeBarang==4){
                binding.txtJenisBarang.text = "Motor 250 - 300 cc"
            }else if (dataEkspedisi.tipeBarang==5){
                binding.txtJenisBarang.text = "Motor 300 - 500 cc"
            }else if (dataEkspedisi.tipeBarang==6){
                binding.txtJenisBarang.text = "Motor > 500 cc"
            }

            binding.txtNamaPengirim.text = namaPengirim
            binding.txtNamaPenerima.text = namaPenerima
            binding.txtPhonePengirim.text = telpPengirim
            binding.txtPhonePenerima.text = telpPenerima
            binding.txtTglPengiriman.text = tglDikirim
            binding.txtTglDiterima.text = tglDiterima
            binding.txtAlamatPengirim.text = alamatPengirim
            binding.txtAlamatDiterima.text = alamatPenerima
            binding.txtMerkMotor.text = namaBarang
            binding.txtBerat.text = berat.toString()
            binding.txtTotalBiaya.text = total.toString()

        }
    }


    private fun terimaPaket(){
        val currentDateTime = LocalDateTime.now()
        val tglDiterima = currentDateTime.format(DateTimeFormatter.ofPattern("dd/MMMM/yyyy HH:mm:ss"))
        binding.btnSubmit.setOnClickListener {
            viewModel.updateStatusDiterima(tglDiterima,2,id_ekspedisi)
            Toast.makeText(activity,"Approve Success", Toast.LENGTH_LONG).show()
            moveToHome()
        }
    }



    private fun moveToCallByPhone(){

        binding.txtPhonePengirim.setOnClickListener {
            val phoneNumber = binding.txtPhonePengirim.text.toString().split(":")[1]
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$phoneNumber")
            startActivity(intent)
        }

        binding.txtPhonePenerima.setOnClickListener {
            val phoneNumber = binding.txtPhonePenerima.text.toString().split(":")[1]
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$phoneNumber")
            startActivity(intent)
        }

    }

    private fun moveToHome(){
        val directions = AprovalEkspedisiFragmentDirections.actionAprovalEkspedisiFragmentToFragmentHome()
        view?.findNavController()?.navigate(directions)
    }

    companion object {
        private const val TAG = "AprovalEkspedisiFragmen"
    }
}