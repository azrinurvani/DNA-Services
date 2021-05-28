package com.mobile.azrinurvani.dnaproject.view.stnk

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.database.Cursor
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.mobile.azrinurvani.dnaproject.BaseFragment
import com.mobile.azrinurvani.dnaproject.BuildConfig
import com.mobile.azrinurvani.dnaproject.databinding.FragmentFormStnkTahunanBinding
import com.mobile.azrinurvani.dnaproject.helper.FileCompressor
import com.mobile.azrinurvani.dnaproject.helper.FunctionGlobalDir
import com.mobile.azrinurvani.dnaproject.model.BiroJasa
import com.mobile.azrinurvani.dnaproject.view.home.FragmentHomeDirections
import com.mobile.azrinurvani.dnaproject.viewmodel.ViewModelProviderFactory
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import kotlin.jvm.Throws

class FormStnkTahunanFragment : BaseFragment() {


    private lateinit var binding: FragmentFormStnkTahunanBinding
    private lateinit var viewModel: StnkTahunanViewModel

    @Inject
    lateinit var vmFactory : ViewModelProviderFactory

    private var bitmapImage :Bitmap? = null

    var mPhotoFile: File? = null
    var mCompressor: FileCompressor? = null

    private var jenisDoc = 1
    private var ktpAvail = false
    private var stnkAvail = false
    private var bpkbAvail = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentFormStnkTahunanBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this,vmFactory).get(StnkTahunanViewModel::class.java)


        moveToCamera()
        binding.btnSubmit.setOnClickListener {
            saveData()
        }
    }

    private fun saveData(){
        //showLoading()
        checkDocumentAvailable()
        var name = binding.edtName.text.toString()
        var no_ktp = binding.edtNoKtp.text.toString()
        var address = binding.edtAddress.text.toString()
        var phone = binding.edtPhone.text.toString()
        var noPolisi = binding.edtNoPolisi.text.toString()


        //pindahkan ke ViewModel
        val data = BiroJasa(
                jenisDoc = 1,
                name = name,
                noKtp = no_ktp,
                phone = phone,
                address = address,
                noPolisi = noPolisi,
                bpkbAvail = bpkbAvail,
                stnkAvail = stnkAvail,
                ktpAvail = ktpAvail,
                cpvAvail = false,
                ktpImagePath = "-",
                status = 1)
        viewModel.saveDataIntoDb(data)
        Toast.makeText(activity,"Submit successful",Toast.LENGTH_LONG).show()
        moveToHome()
    }

    private fun moveToHome(){
        val directions= FormStnkTahunanFragmentDirections.actionFormStnkTahunanFragmentToFragmentHome()
        view?.findNavController()?.navigate(directions)

    }

    private fun checkDocumentAvailable(){
        if(binding?.cboKtp.isChecked){
            ktpAvail = true
        }
        if(binding?.cboBpkb.isChecked){
            bpkbAvail = true
        }
        if(binding?.cboStnkAsli.isChecked){
            stnkAvail = true
        }

    }



    private fun moveToCamera(){
        binding.btnTakeKtpPict.setOnClickListener {

        requestStoragePermission(true)

//            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//            if (activity?.packageManager?.let { it1 -> intent.resolveActivity(it1) } != null) {
//                startActivityForResult(intent, CAMERA_INTENT)
//            }
        }
    }

    private fun requestStoragePermission(isCamera: Boolean) {
        Dexter.withActivity(activity).withPermissions(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
        )
            .withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(report: MultiplePermissionsReport) {
                    if (FunctionGlobalDir.initFolder()) {
                        if (FunctionGlobalDir.isFileExists(FunctionGlobalDir.appFolder)) {
                            mCompressor?.setDestinationDirectoryPath(FunctionGlobalDir.getStorageCard + FunctionGlobalDir.appFolder)
                        } else {
                            //dir tidak ditemukan
                            Toast.makeText(activity,"Directory not found",Toast.LENGTH_LONG).show()
                        }
                    }

                    // check if all permissions are granted
                    if (report.areAllPermissionsGranted()) {
                        if (isCamera) {
                            dispatchTakePictureIntent()
                        } else {
                           // dispatchGalleryIntent()
                        }
                    }
                }

                override fun onPermissionRationaleShouldBeShown(
                    permissions: List<PermissionRequest>,
                    token: PermissionToken
                ) {
                    token.continuePermissionRequest()
                }
            }).withErrorListener {
                Toast.makeText(activity, "Error permission occurred! ", Toast.LENGTH_SHORT)
                    .show()
            }.onSameThread().check()
    }

    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (activity?.packageManager?.let { takePictureIntent.resolveActivity(it) } != null) {
            // Create the File where the photo should go
            var photoFile: File? = null
            try {
                photoFile = createImageFile()
            } catch (ex: IOException) {
                ex.printStackTrace()
                // Error occurred while creating the File
            }
            if (photoFile != null) {
                val photoURI = FileProvider.getUriForFile(
                    requireActivity(), BuildConfig.APPLICATION_ID.toString() + ".provider",
                    photoFile
                )
                mPhotoFile = photoFile
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO)
            }
        }
    }

    @Throws(IOException::class)
    private fun createImageFile(): File? {
        val timeStamp =
            SimpleDateFormat("yyyyMMddHHmmss").format(Date())
        val mFileName = "DNA_KTP_IMG_" + timeStamp + "_"
        val storageDir: File? = activity?.getExternalFilesDir(Environment.DIRECTORY_DCIM)
        return File.createTempFile(mFileName, ".jpg", storageDir)
    }

    fun getRealPathFromUri(contentUri: Uri?): String? {
        var cursor: Cursor? = null
        return try {
            val proj =
                arrayOf(MediaStore.Images.Media.DATA)
            cursor =
                contentUri?.let { activity?.contentResolver?.query(it, proj, null, null, null) }
            assert(cursor != null)
            val column_index = cursor?.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
            cursor?.moveToFirst()
            column_index?.let { cursor?.getString(it) }
        } finally {
            cursor?.close()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

//        when (requestCode) {
//            REQUEST_TAKE_PHOTO -> {
//                bitmapImage = data!!.extras!!["data"] as Bitmap?
//                if (bitmapImage != null) {
//                    binding.imgTakePictKtp.setImageBitmap(bitmapImage)
//                } else {
//                    Toast.makeText(activity, "Bitmap Image is NULL", Toast.LENGTH_LONG).show()
//                }
//            }
//        }
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_TAKE_PHOTO) {
                try {
                    mPhotoFile = mPhotoFile?.let { mCompressor?.compressToFile(it) }
                } catch (e: IOException) {
                    e.printStackTrace()
                }
                activity?.let { Glide.with(it).load(mPhotoFile).into(binding.imgTakePictKtp) }
                Log.d(TAG, "onActivityResult: $mPhotoFile")
                Toast.makeText(activity, "Image Path : $mPhotoFile", Toast.LENGTH_SHORT).show()
            }
        }

    }

    companion object {
        private const val TAG = "FormStnkTahunanFragment"
        private const val REQUEST_TAKE_PHOTO = 101
    }
}