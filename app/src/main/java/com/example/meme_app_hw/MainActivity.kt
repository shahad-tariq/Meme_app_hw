package com.example.meme_app_hw

import android.view.LayoutInflater
import com.bumptech.glide.Glide
import com.example.meme_app_hw.databinding.ActivityMainBinding
import okhttp3.*

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val LOG_TAG: String = "Activity_Main"
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding = ActivityMainBinding::inflate

    var BASE_URL = "http://apimeme.com/meme"

    override fun setup() {  }

    override fun addCallbacks() {
        binding!!.apply {
            submit.setOnClickListener {
                val nameMeme = spinnerMeme.selectedItem.toString().replace(" ", "-")
                val topText = topText.text
                val bottomText = bottomText.text

                val url = "$BASE_URL?meme=$nameMeme&top=$topText&bottom=$bottomText"
                loadImg(url)
            }
        }
    }

    fun loadImg(url: String) {

        Glide.with(this)
            .load(url)
            .into(binding!!.imageMeme)

    }


}