package com.tasty.recipesapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.tasty.recipesapp.R


class SplashActivity : AppCompatActivity() {

    companion object{
        private  val TAG:String? = SplashActivity::class.java.canonicalName
    }

    private val SPLASH_DELAY: Long = 2000 // 2 seconds delay

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_DELAY)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"SplashActivity - onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"SplashActivity - onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"SplashActivity - onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"SplashActivity - onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"SplashActivity - onDestroy() called")

    }


}