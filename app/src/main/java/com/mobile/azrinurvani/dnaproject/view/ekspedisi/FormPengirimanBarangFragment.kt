package com.mobile.azrinurvani.dnaproject.view.ekspedisi

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.mobile.azrinurvani.dnaproject.BaseFragment

import com.mobile.azrinurvani.dnaproject.databinding.FragmentFormPengirimanBarangBinding
import com.mobile.azrinurvani.dnaproject.model.Ekspedisi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@SuppressLint("NewApi")
class FormPengirimanBarangFragment : BaseFragment() {

    private lateinit var binding : FragmentFormPengirimanBarangBinding

    private var biaya = 80000.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFormPengirimanBarangBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val currentDateTime = LocalDateTime.now()

        val formatter = currentDateTime.format(DateTimeFormatter.ofPattern("dd/MMMM/yyyy HH:mm:ss"))
        binding.edtTglPengiriman.setText(formatter.toString())

        binding.btnOrder.setOnClickListener {
            setFormData()
        }

    }

    private fun setFormData(){
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
        val namaBarang = binding.edtNamaBarang.text.toString()
        val berat = binding.edtBerat.text.toString().toDouble()
        var total = berat * biaya

        if (TextUtils.isEmpty(namaPengirim) ||
            TextUtils.isEmpty(namaPenerima) ||
            TextUtils.isEmpty(telpPengirim) ||
            TextUtils.isEmpty(telpPenerima) ||
            TextUtils.isEmpty(tglDikirim) ||
//            TextUtils.isEmpty(tglDiterima) ||
            TextUtils.isEmpty(alamatPengiriman) ||
            TextUtils.isEmpty(alamatDiterima) ||
            TextUtils.isEmpty(namaBarang) ||
            TextUtils.isEmpty(berat.toString())){

            Toast.makeText(activity,"Mohon Lengkapi Form", Toast.LENGTH_LONG).show()

        }else{
            val data = Ekspedisi(
                tipeBarang = 0,
                nama_pengirim = namaPengirim,
                nama_penerima = namaPenerima,
                telpPengirim = telpPengirim,
                telpPenerima = telpPenerima,
                tglPengiriman = tglDikirim,
                alamatPengirim = alamatPengiriman,
                alamatPenerima = alamatDiterima,
                namaBarang = namaBarang,
                biaya = biaya,
                berat = berat,
                stnkAvail = false,
                total = total,
                status = 0)

            moveToDetail(data)

        }

    }
    private fun moveToDetail(data: Ekspedisi){
        val directions = FormPengirimanBarangFragmentDirections.actionFormPengirimanAksesorisFragmentToDetailPengirimanBarangFragment(data)
        view?.findNavController()?.navigate(directions)
    }

    companion object {
        private const val TAG = "FormPengirimanAksesoris"
    }
}