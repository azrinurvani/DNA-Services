package com.mobile.azrinurvani.dnaproject.view.stnk

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
import com.mobile.azrinurvani.dnaproject.databinding.FragmentAprovalStnkBinding
import com.mobile.azrinurvani.dnaproject.viewmodel.ViewModelProviderFactory
import javax.inject.Inject


class AprovalStnkFragment : BaseFragment() {

    private lateinit var binding : FragmentAprovalStnkBinding

    private val dataDetailStnk : AprovalStnkFragmentArgs by navArgs()

    @Inject
    lateinit var vmFactory : ViewModelProviderFactory

    private lateinit var viewModel: StnkViewModel

    var jenisDoc = "-"
    var bpkbAvail = "-"
    var ktpAvail = "-"
    var stnkAvail = "-"
    var cpvAvail = "-"
    var status = "-"
    var receipt = "-"

    var id_stnk = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAprovalStnkBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this,vmFactory).get(StnkViewModel::class.java)
        id_stnk = dataDetailStnk.dataDetalStnk.id?.toInt() ?: 0


        setDataDetail()
        approveStnk()
        rejectStnk()
        moveToCallByPhone()
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
                 jenisDoc = "Penerbitan Baru STNK Hilang"
            }else if (data.jenisDoc==4){
                jenisDoc = "Mutasi"
            }else if (data.jenisDoc==5){
                jenisDoc = "Balik Nama"
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

            if (data.receiptAvail==true){
                 receipt= "Ada"
            }else{
                receipt = "Tidak Ada"
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
            binding.txtReceiptAvail.setText(": $receipt")
            binding.txtDocCekFisik.setText(": $cpvAvail")

        }
    }

    private fun approveStnk(){
        binding.btnApprove.setOnClickListener {
            viewModel.updateStatus(2,id_stnk)
            Toast.makeText(activity,"Approve Success",Toast.LENGTH_LONG).show()
            moveToHome()
        }
    }

    private fun rejectStnk(){
        binding.btnReject.setOnClickListener {
            viewModel.updateStatus(0,id_stnk)
            Toast.makeText(activity,"Reject Success",Toast.LENGTH_LONG).show()
            moveToHome()
        }
    }

    private fun moveToCallByPhone(){

        binding.txtPhone.setOnClickListener {
            val phoneNumber = binding.txtPhone.text.toString().split(":")[1]
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$phoneNumber")
            startActivity(intent)
        }

    }

    private fun moveToHome(){
        val directions = AprovalStnkFragmentDirections.actionAprovalStnkFragmentToFragmentHome()
        view?.findNavController()?.navigate(directions)
    }

    companion object {
        private const val TAG = "AprovalStnkFragment"
    }
}