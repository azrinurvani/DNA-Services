package com.mobile.azrinurvani.dnaproject.view.ekspedisi

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.mobile.azrinurvani.dnaproject.BaseFragment
import com.mobile.azrinurvani.dnaproject.R
import com.mobile.azrinurvani.dnaproject.databinding.FragmentFormPengirimanMotorBinding
import com.mobile.azrinurvani.dnaproject.model.Ekspedisi


class FormPengirimanMotorFragment : BaseFragment() {

    private lateinit var binding : FragmentFormPengirimanMotorBinding

    private var stnkAvail = false
    private var kelasMotor = 1
    private var biaya = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFormPengirimanMotorBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnOrder.setOnClickListener {
            setFormData()
        }

    }


    private fun setFormData() {
        kelasMotor()
        cekStnkAvail()


        //pengirim
        val namaPengirim = binding.edtNamaPengirim.text.toString()
        val telpPengirim = binding.edtPhonePengirim.text.toString()
        val tglDikirim = binding.edtTglPengiriman.text.toString()
        val alamatPengiriman = binding.edtAlamatPengirim.text.toString()

        //penerima
        val namaPenerima = binding.edtNamaPenerima.text.toString()
        val telpPenerima = binding.edtPhonePenerima.text.toString()
        val tglDiterima = binding.edtTglDiterima.text.toString()
        val alamatDiterima = binding.edtAlamatPenerima.text.toString()

        //paket
        val merkMotor = binding.edtMerkMotor.text.toString()
        val berat = binding.edtBerat.text.toString().toDouble()
        var total = berat * biaya

        if (TextUtils.isEmpty(namaPengirim) ||
            TextUtils.isEmpty(namaPenerima) ||
            TextUtils.isEmpty(telpPengirim) ||
            TextUtils.isEmpty(telpPenerima) ||
            TextUtils.isEmpty(tglDikirim) ||
            TextUtils.isEmpty(tglDiterima) ||
            TextUtils.isEmpty(alamatPengiriman) ||
            TextUtils.isEmpty(alamatDiterima) ||
            TextUtils.isEmpty(merkMotor) ||
            TextUtils.isEmpty(berat.toString())){

            Toast.makeText(activity,"Mohon Lengkapi Form",Toast.LENGTH_LONG).show()

        }else{
            val data = Ekspedisi(
                tipeBarang = kelasMotor,
                nama_pengirim = namaPengirim,
                nama_penerima = namaPenerima,
                telpPengirim = telpPengirim,
                telpPenerima = telpPenerima,
                tglPengiriman = tglDikirim,
                tglDiterima = tglDiterima,
                alamatPengirim = alamatPengiriman,
                alamatPenerima = alamatDiterima,
                namaBarang = merkMotor,
                biaya = biaya,
                berat = berat,
                stnkAvail = stnkAvail,
                total = total,
                status = 0)

            moveToDetail(data)

        }

    }

    private fun moveToDetail(data: Ekspedisi){
        val directions = FormPengirimanMotorFragmentDirections
            .actionFormPengirimanMotorFragmentToDetailPengirimanMotorFragment(data)
        view?.findNavController()?.navigate(directions)
    }



    private fun kelasMotor(){
        if (binding.rbKelas1.isChecked){
            // 0 - 125
            kelasMotor = 1
            biaya = 10000.0
        }else if (binding.rbKelas2.isChecked){
            // 125 - 150
            kelasMotor = 2
            biaya = 12500.0
        }else if (binding.rbKelas3.isChecked){
            // 150 - 250
            kelasMotor = 3
            biaya = 14000.0
        }else if (binding.rbKelas4.isChecked){
            //250 - 300
            kelasMotor = 4
            biaya = 20000.0
        }else if (binding.rbKelas5.isChecked){
            //300 - 500
            kelasMotor = 5
            biaya = 25000.0
        }else if (binding.rbKelas6.isChecked){
            // > 500
            kelasMotor = 6
            biaya = 40000.0
        }
    }

    private fun cekStnkAvail(){
        if (binding.rbStnkAvail.isChecked)
        {
            stnkAvail = true
        }else if (binding.rbStnkUnavail.isChecked){
            stnkAvail = false
        }
    }

    companion object {
        private const val TAG = "FormPengirimanMotorFrag"
    }
}