package com.example.meme_app_hw

import android.Manifest
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.meme_app_hw.databinding.ActivityMainBinding
import okhttp3.*
import android.provider.MediaStore.Images

import android.content.ContentValues
import android.content.Context
import android.os.Environment
import androidx.core.app.ActivityCompat
import com.google.common.net.MediaType.PNG
import java.io.File
import java.io.FileOutputStream
import java.lang.Exception
import java.security.cert.Extension
import android.os.Build

import android.content.DialogInterface

import android.widget.Toast





class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val LOG_TAG: String = "Activity_Main"
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding = ActivityMainBinding::inflate

    var BASE_URL = "http://apimeme.com/meme"


    var nameMeme:String = "Bah-Humbug"
    var topTextMeme:String = "input top text"
    var bottomTextMeme:String =  "input bottom text"
    var url:String = "$BASE_URL?meme=$nameMeme&top=$topTextMeme&bottom=$bottomTextMeme"

    var PERMISSION_REQUEST_CODE = 1


    override fun setup() {

        loadImg(url)
    }

    override fun addCallbacks() {

        binding!!.apply {
            submitGenerator.setOnClickListener {
                getInfo()
            }
//            submitDownload.setOnClickListener {
//                getAndSaveImage()
//            }
        }

    }

    fun getInfo(){
        binding!!.apply {
            nameMeme = spinnerMeme.selectedItem.toString().replace(" ", "-")
            topTextMeme = topText.text.toString()
            bottomTextMeme = bottomText.text.toString()

            url = "$BASE_URL?meme=$nameMeme&top=$topTextMeme&bottom=$bottomTextMeme"
            loadImg(url)
        }
    }

    fun loadImg(url: String) {

        Glide.with(this)
            .load(url)
            .into(binding!!.imageMeme)
    }

//    fun getAndSaveImage(){
//
//        val bitmapDrawable = binding?.imageMeme?.drawable as BitmapDrawable
//        val bitmap = bitmapDrawable.bitmap
//
//        var outputStream: FileOutputStream? = null
//        val file: File = Environment.getExternalStorageDirectory()
//        val dir = File(file.absolutePath.toString() + "/MyPics")
//        dir.mkdirs()
//
//        val filename = String.format("%d.jpeg", System.currentTimeMillis())
//        val outFile = File(dir, filename)
//        try {
//            outputStream = FileOutputStream(outFile)
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//
//        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
//
//        try {
//            outputStream?.flush()
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//        try {
//            outputStream?.close()
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//    }

}