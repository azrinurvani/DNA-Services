package com.mobile.azrinurvani.dnaproject.view.ekspedisi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.mobile.azrinurvani.dnaproject.databinding.LayoutListEkspedisiBinding
import com.mobile.azrinurvani.dnaproject.model.Ekspedisi
import com.mobile.azrinurvani.dnaproject.view.ekspedisi.FragmentListDetailEkspedisi
import com.mobile.azrinurvani.dnaproject.view.ekspedisi.FragmentListDetailEkspedisiDirections
import com.mobile.azrinurvani.dnaproject.view.stnk.FragmentListDetailStnkDirections

class EkspedisiRecyclerAdapter : RecyclerView.Adapter<EkspedisiRecyclerAdapter.EkspedisiViewHolder>() {

    private lateinit var bindingLayout : LayoutListEkspedisiBinding
    var listEkspedisi = ArrayList<Ekspedisi>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EkspedisiViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        bindingLayout =  LayoutListEkspedisiBinding.inflate(inflater,parent,false)
        return EkspedisiViewHolder(bindingLayout)
    }

    override fun getItemCount(): Int {
        return if (listEkspedisi.size>0){
            listEkspedisi.size
        }else{
            0
        }
    }

    override fun onBindViewHolder(holder: EkspedisiViewHolder, position: Int) {
        holder.bind(listEkspedisi[position])



        holder.itemView.setOnClickListener {view->
            listEkspedisi[position].let {data->
                val directions = FragmentListDetailEkspedisiDirections.actionFragmentListEkspedisiToAprovalEkspedisiFragment(data)
                view.findNavController().navigate(directions)
            }
        }

    }

    fun setEkspedisiRecyler(data : ArrayList<Ekspedisi>){
        this.listEkspedisi = data
        notifyDataSetChanged()
    }


    inner class EkspedisiViewHolder(binding: LayoutListEkspedisiBinding): RecyclerView.ViewHolder(binding.root) {
        private  val binding = binding
        fun bind(data:Ekspedisi?){
            binding.txtNamaPengirim.text = data?.nama_pengirim
            binding.txtNamaPenerima.text = data?.nama_penerima
            binding.txtNamaBarang.text = data?.namaBarang
            binding.txtTglPengiriman.text = data?.tglPengiriman
//            binding.txtTujuanPengiriman.text = data?.alamatPenerima
//            binding.txtAsalPengiriman.text = data?.alamatPengirim
            binding.txtNoHpPengirim.text = data?.telpPengirim
            binding.txtNoHpPenerima.text = data?.telpPenerima

            if (data?.status==0){
                binding.txtStatus.text = "Sedang diproses"
            }else if(data?.status==1){
                binding.txtStatus.text = "Dalam pengiriman"
            }else if (data?.status==2){
                binding.txtStatus.text = "Barang sudah diterima"
            }

            if (data?.tipeBarang==0){
                binding.txtJenisBarang.text = "Aksesoris/Spare Part"
            }else if (data?.tipeBarang==1){
                binding.txtJenisBarang.text = "Motor kelas < 125 cc"
            }else if (data?.tipeBarang==2){
                binding.txtJenisBarang.text = "Motor kelas 125 - 150 cc"
            }else if (data?.tipeBarang==3){
                binding.txtJenisBarang.text = "Motor kelas 150 - 250 cc"
            }else if (data?.tipeBarang==4){
                binding.txtJenisBarang.text = "Motor kelas 250 - 300 cc"
            }else if (data?.tipeBarang==5){
                binding.txtJenisBarang.text = "Motor kelas 300 - 500 cc"
            }else if (data?.tipeBarang==6){
                binding.txtJenisBarang.text = "Motor kelas > 500 cc"
            }
        }
    }
}