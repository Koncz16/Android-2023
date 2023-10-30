package com.tasty.recipesapp

import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log

class TestActivity : AppCompatActivity() {

    companion object{
         private  val TAG:String? =TestActivity::class.java.canonicalName
    }

    private val SPLASH_DELAY: Long = 2000 // 2 seconds delay

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_DELAY)
    }


    override fun onStart() {
        super.onStart()
        Log.d(TAG,"TestActivity - onStart() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"TestActivity - onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"TestActivity - onDestroy() called")

    }



}