package com.mobile.azrinurvani.dnaproject.view.ekspedisi

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.mobile.azrinurvani.dnaproject.BaseFragment
import com.mobile.azrinurvani.dnaproject.databinding.FragmentFormPengirimanMotorBinding
import com.mobile.azrinurvani.dnaproject.model.Ekspedisi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@SuppressLint("NewApi")
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

        //val currentDate = LocalDate.now()
        val currentDateTime = LocalDateTime.now()

       // val formatter = currentDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM))
        val formatter = currentDateTime.format(DateTimeFormatter.ofPattern("dd/MMMM/yyyy HH:mm:ss"))
//        val formatter = currentDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)).toString()

        binding.edtTglPengiriman.setText(formatter.toString())

        binding.btnOrder.setOnClickListener {
            if(checkValidityForm()){
                setFormData()
            }else{
                Toast.makeText(activity,"Mohon Lengkapi Form",Toast.LENGTH_LONG).show()
            }

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
        //val tglDiterima = binding.edtTglDiterima.text.toString()
        val alamatDiterima = binding.edtAlamatPenerima.text.toString()

        //paket
        val merkMotor = binding.edtMerkMotor.text.toString()
        val descMotor = binding.edtDescBarang.text.toString()
        //val berat = binding.edtBerat.text.toString().toDouble()
        var total = /*berat **/ biaya

        if (TextUtils.isEmpty(namaPengirim) ||
            TextUtils.isEmpty(namaPenerima) ||
            TextUtils.isEmpty(telpPengirim) ||
            TextUtils.isEmpty(telpPenerima) ||
            TextUtils.isEmpty(tglDikirim) ||
//            TextUtils.isEmpty(tglDiterima) ||
            TextUtils.isEmpty(alamatPengiriman) ||
            TextUtils.isEmpty(alamatDiterima) ||
            TextUtils.isEmpty(merkMotor) ||
            TextUtils.isEmpty(descMotor)){

            Toast.makeText(activity,"Mohon Lengkapi Form",Toast.LENGTH_LONG).show()

        }else{
            val data = Ekspedisi(
                tipeBarang = kelasMotor,
                nama_pengirim = namaPengirim,
                nama_penerima = namaPenerima,
                telpPengirim = telpPengirim,
                telpPenerima = telpPenerima,
                tglPengiriman = tglDikirim,
                alamatPengirim = alamatPengiriman,
                alamatPenerima = alamatDiterima,
                namaBarang = merkMotor,
                biaya = biaya,
                stnkAvail = stnkAvail,
                descBarang = descMotor,
                total = total,
                status = 0)

            moveToDetail(data)

        }

    }

    private fun checkValidityForm(): Boolean{
        val namaPengirim =  binding.edtNamaPengirim.text.toString()
        val namaPenerima =  binding.edtNamaPenerima.text.toString()
        val telpPengirim =  binding.edtPhonePengirim.text.toString()
        val telpPenerima =  binding.edtPhonePenerima.text.toString()
        val tglPengiriman =  binding.edtTglPengiriman.text.toString()
        val alamatPengirim =  binding.edtAlamatPengirim.text.toString()
        val alamatDiterima = binding.edtAlamatPenerima.text.toString()
        val merkMotor = binding.edtMerkMotor.text.toString()
       // val berat = binding.edtBerat.text.toString()

        return !(TextUtils.isEmpty(namaPengirim)||
                TextUtils.isEmpty(namaPenerima)||
                TextUtils.isEmpty(telpPengirim)||
                TextUtils.isEmpty(telpPenerima)||
                TextUtils.isEmpty(tglPengiriman)||
                TextUtils.isEmpty(alamatPengirim)||
                TextUtils.isEmpty(alamatDiterima)||
                TextUtils.isEmpty(merkMotor))

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
            biaya = 500000.0
        }else if (binding.rbKelas2.isChecked){
            // 125 - 150
            kelasMotor = 2
            biaya = 800000.0
        }else if (binding.rbKelas3.isChecked){
            // 150 - 250
            kelasMotor = 3
            biaya = 1500000.0
        }else if (binding.rbKelas4.isChecked){
            //250 - 300
            kelasMotor = 4
            biaya = 2000000.0
        }else if (binding.rbKelas5.isChecked){
            //300 - 500
            kelasMotor = 5
            biaya = 2500000.0
        }else if (binding.rbKelas6.isChecked){
            // > 500
            kelasMotor = 6
            biaya = 5000000.0
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