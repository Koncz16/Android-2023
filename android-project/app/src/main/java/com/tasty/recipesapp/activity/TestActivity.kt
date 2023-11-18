package com.tasty.recipesapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.tasty.recipesapp.R

class TestActivity : AppCompatActivity() {

    companion object{
         private  val TAG:String? = TestActivity::class.java.canonicalName
    }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_test)
            val editTextUserInput = findViewById<EditText>(R.id.editTextUserInput)
            val buttonStart = findViewById<Button>(R.id.startButton)
            Log.d(TAG, "TestActivity - onCreate() called")

            buttonStart.setOnClickListener {
                val inputText = editTextUserInput.text.toString()

                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("message", inputText)
                startActivity(intent)
                Log.d(TAG, "TestActivity - startButton() clicked")
            }
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