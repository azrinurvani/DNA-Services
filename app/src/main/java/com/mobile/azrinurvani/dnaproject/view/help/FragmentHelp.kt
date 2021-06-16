package com.mobile.azrinurvani.dnaproject.view.help

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobile.azrinurvani.dnaproject.BaseFragment
import com.mobile.azrinurvani.dnaproject.R
import com.mobile.azrinurvani.dnaproject.databinding.FragmentHelpBinding


class FragmentHelp : BaseFragment() {

    lateinit var binding : FragmentHelpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHelpBinding.inflate(inflater,container,false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.txtTelp.setOnClickListener {
            val phoneNumber = binding.txtTelp.text.toString()
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$phoneNumber")
            startActivity(intent)
        }

        binding.txtSms.setOnClickListener {
            val phoneNumber = binding.txtSms.text.toString()
            val textSms = "Hai, saya ingin bertanya mengenai layanan DNA Motor :)"

            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("sms:$phoneNumber")
            intent.putExtra("sms_body",textSms)
            startActivity(intent)
        }
    }

    companion object {
        private const val TAG = "FragmentHelp"
    }
}