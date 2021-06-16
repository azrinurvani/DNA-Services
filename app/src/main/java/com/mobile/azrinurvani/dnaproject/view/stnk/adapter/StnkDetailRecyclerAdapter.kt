package com.mobile.azrinurvani.dnaproject.view.stnk.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.mobile.azrinurvani.dnaproject.databinding.LayoutListStnkDetailBinding
import com.mobile.azrinurvani.dnaproject.model.BiroJasa
import com.mobile.azrinurvani.dnaproject.view.stnk.FragmentListDetailStnkDirections

class StnkDetailRecyclerAdapter : RecyclerView.Adapter<StnkDetailRecyclerAdapter.StnkDetailViewHolder>()/*, Filterable*/ {
    private lateinit var bindingLayout : LayoutListStnkDetailBinding
    var listBiroJasa = ArrayList<BiroJasa>()

//    var filterData = ArrayList<BiroJasa>()

//    init {
//        filterData = ArrayList(listBiroJasa)
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StnkDetailViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        bindingLayout = LayoutListStnkDetailBinding.inflate(inflater,parent,false)
        return StnkDetailViewHolder(bindingLayout)
    }

    override fun getItemCount(): Int {
        return if (listBiroJasa.size>0){
            listBiroJasa.size
        }else{
            0
        }
    }

    override fun onBindViewHolder(holder: StnkDetailViewHolder, position: Int) {
        holder.bind(listBiroJasa[position])

        holder.itemView.setOnClickListener {view->
            //navigate to AprovalStnkFragment
            listBiroJasa[position].let {data->
                val directions = FragmentListDetailStnkDirections.actionFragmentStnkToAprovalStnkFragment(data)
                view.findNavController().navigate(directions)
            }
        }
    }

    fun setStnkRecyclerAdapter(data : ArrayList<BiroJasa>){
        this.listBiroJasa = data
        notifyDataSetChanged()
    }


    class StnkDetailViewHolder(binding:LayoutListStnkDetailBinding): RecyclerView.ViewHolder(binding.root) {
        private val binding = binding

        fun bind(data: BiroJasa?){
            binding.txtName.text = data?.name
            binding.txtNoKtp.text = data?.noKtp
            binding.txtNoPolisi.text = data?.noPolisi
            binding.txtPhone.text = data?.phone
            binding.txtAddress.text = data?.address

            if (data?.jenisDoc==1){
                binding.txtJenisDoc.text = "Perpanjangan STNK Tahunan"
            }else  if (data?.jenisDoc==2){
                binding.txtJenisDoc.text = "Perpanjangan STNK 5 Tahunan"
            }else  if (data?.jenisDoc==3){
                binding.txtJenisDoc.text = "Penerbitan baru STNK Hilang"
            }else  if (data?.jenisDoc==4){
                binding.txtJenisDoc.text = "Mutasi Kendaraan"
            }else  if (data?.jenisDoc==5){
                binding.txtJenisDoc.text = "Balik Nama Kendaraan"
            }

            if (data?.status==0){
                binding.txtStatus.text = "Pengajuan ditolak"
            }else if (data?.status==1){
                binding.txtStatus.text = "Sedang diproses"
            }else if(data?.status==2){
                binding.txtStatus.text = "Pengajuan diterima"
            }else if (data?.status==3){
                binding.txtStatus.text = "Dokumen akan dijemput"
            }else if (data?.status==4){
                binding.txtStatus.text = "Menunggu pembayaran"
            }else if (data?.status==5){
                binding.txtStatus.text = "Transaksi berhasil"
            }

        }

    }

    fun filterList(filteredList: ArrayList<BiroJasa>) {
        listBiroJasa = filteredList
        notifyDataSetChanged()
    }

//    override fun getFilter(): Filter {
//        return stnkFilter
//    }
//    private val stnkFilter: Filter = object : Filter() {
//        override fun performFiltering(constraint: CharSequence): FilterResults {
//            val filter: MutableList<BiroJasa> = java.util.ArrayList<BiroJasa>()
//            if (constraint == null || constraint.length == 0) {
//                Collections.sort(filterData, Comparator { o1, o2 -> o2.name?.toLowerCase()?.let { o1.name?.toLowerCase()?.compareTo(it) }!! })
//                filter.addAll(filterData)
//            } else {
//                val filteredPattern = constraint.toString().toLowerCase().trim { it <= ' ' }
//                for (data in filterData) {
//                    if (data.name?.toLowerCase()?.contains(filteredPattern)!!) {
//                        filter.add(data)
//                    }
//                }
//            }
//            val result = FilterResults()
//            result.values = filter
//            return result
//        }
//
//        override fun publishResults(constraint: CharSequence, results: FilterResults) {
//            listBiroJasa.clear()
//            listBiroJasa.addAll(results.values as List<BiroJasa>)
//            notifyDataSetChanged()
//        }
//    }
}