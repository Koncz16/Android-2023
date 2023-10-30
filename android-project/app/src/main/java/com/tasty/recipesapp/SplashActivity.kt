package com.tasty.recipesapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText


class SplashActivity : AppCompatActivity() {

    companion object{
        private  val TAG:String? =SplashActivity::class.java.canonicalName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val editTextUserInput = findViewById<EditText>(R.id.editTextUserInput)
        val buttonStart = findViewById<Button>(R.id.startButton)
        Log.d(TAG, "SplashActivity - onCreate() called")

        buttonStart.setOnClickListener {
            val inputText = editTextUserInput.text.toString()

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("message", inputText)
            startActivity(intent)
            Log.d(TAG, "SplashActivity - startButton() clicked")
        }
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