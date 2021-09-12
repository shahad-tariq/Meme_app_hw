package com.example.meme_app_hw

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import okhttp3.OkHttpClient
import okhttp3.Request

abstract class BaseActivity <VB : ViewBinding> : AppCompatActivity() {
    //initial variable for log fun
    abstract val LOG_TAG: String

    //initial binding inflater
    abstract val bindingInflater: (LayoutInflater) -> VB
    private var _binding: ViewBinding? = null
    protected val binding
        get() = _binding as VB?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater(layoutInflater)
        setContentView(requireNotNull(_binding).root)
        setup()
        addCallbacks()
    }
    //basic function in this project
    protected abstract fun setup()
    protected abstract fun addCallbacks()
    protected fun log(value: Any) {
        Log.v(LOG_TAG, value.toString())
    }

}


//override fun addCallbacks() {
////        binding!!.submit.setOnClickListener {
////            log(binding!!.spinner.selectedItem.toString().replace(" ","-"))
////        }
//}

//fun loadImg(){
//
//    val client = OkHttpClient()
//
//    val request = Request.Builder()
//        .url("https://ronreiter-meme-generator.p.rapidapi.com/meme?meme=Condescending-Wonka&bottom=Bottom%20Text&top=Top%20Text&font=Impact&font_size=50")
//        .get()
//        .addHeader("x-rapidapi-host", "ronreiter-meme-generator.p.rapidapi.com")
//        .addHeader("x-rapidapi-key", "be62e4fa27msh9c40c5fad40746bp1b8d7fjsnac812cea5a2e")
//        .build()
//
//    val response = client.newCall(request).execute()
//
//    Glide.with(this)
//        .load("http://apimeme.com/meme?meme=Bah-Humbug&top=Top+text&bottom=Bottom+text")
//        .into(binding!!.imageMeme)
//
//}