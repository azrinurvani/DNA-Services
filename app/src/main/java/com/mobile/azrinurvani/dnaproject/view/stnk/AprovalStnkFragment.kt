package com.mobile.azrinurvani.dnaproject.view.stnk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.mobile.azrinurvani.dnaproject.BaseFragment
import com.mobile.azrinurvani.dnaproject.R
import com.mobile.azrinurvani.dnaproject.databinding.FragmentAprovalStnkBinding


class AprovalStnkFragment : BaseFragment() {

    private lateinit var binding : FragmentAprovalStnkBinding

    private val dataDetailStnk : AprovalStnkFragmentArgs by navArgs()


    var jenisDoc = "-"
    var bpkbAvail = "-"
    var ktpAvail = "-"
    var stnkAvail = "-"
    var cpvAvail = "-"
    var status = "-"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAprovalStnkBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDataDetail()
    }


    private fun setDataDetail(){
        val data = dataDetailStnk.dataDetalStnk
        if (data != null){
            val nama = data.name
            val noKtp = data.noKtp
            val phone = data.phone
            val noPolisi = data.noPolisi
            val address = data.address

            if (data.jenisDoc==1){
                //langsung set text pada text view aja
                 jenisDoc = "STNK Tahunan"
            }else if (data.jenisDoc==2){
                 jenisDoc = "STNK 5 Tahunan"
            }else if (data.jenisDoc==3){
                 jenisDoc = "Penerbitan baru STNK hilang"
            }else if (data.jenisDoc==4){
                jenisDoc = "Mutasi"
            }else if (data.jenisDoc==5){
                jenisDoc = "Balik nama"
            }

            if (data.bpkbAvail==true){
                bpkbAvail = "Ada"
            }else{
                bpkbAvail = "Tidak Ada"
            }

            if (data.stnkAvail==true){
                stnkAvail = "Ada"
            }else{
                stnkAvail = "Tidak Ada"
            }

            if (data.ktpAvail==true){
                ktpAvail = "Ada"
            }else{
                ktpAvail = "Tidak Ada"
            }

            if (data.cpvAvail==true){
                cpvAvail = "Ada"
            }else{
                cpvAvail = "Tidak Ada"
            }

            if (data?.status==0){
              status = "Pengajuan ditolak"
            }else if (data?.status==1){
                status =  "Sedang diproses"
            }else if(data?.status==2){
                status =  "Pengajuan diterima"
            }else if (data?.status==3){
                status = "Dokumen akan dijemput"
            }else if (data?.status==4){
                status = "Menunggu pembayaran"
            }else if (data?.status==5){
                status = "Transaksi berhasil"
            }

            binding.txtName.setText(": $nama")
            binding.txtNoKtp.setText(": $noKtp")
            binding.txtNoPolisi.setText(": $noPolisi")
            binding.txtPhone.setText(": $phone")
            binding.txtAddress.setText(": $address")
            binding.txtJenisDoc.setText(jenisDoc)
            binding.txtKtpAsliAvail.setText(": $ktpAvail")
            binding.txtStnkAsliAvail.setText(": $stnkAvail")
            binding.txtBpkbAsliAvail.setText(": $bpkbAvail")
            binding.txtDocCekFisik.setText(": $cpvAvail")

        }
    }

    private fun aproveStnk(){
        binding.btnApprove.setOnClickListener {

        }
    }

    companion object {

        private const val TAG = "AprovalStnkFragment"
    }
}