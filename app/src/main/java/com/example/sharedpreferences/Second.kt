package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Second : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var textView: TextView
    private lateinit var textView2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)

        textView= findViewById(R.id.textView)
        textView2= findViewById(R.id.textView2)
        sharedPreferences = this.getSharedPreferences(
            getString(R.string.preference_file_key), Context.MODE_PRIVATE
        )
        textView.text = intent.extras?.getString("x1").toString()
        textView2.text= intent.extras?.getString("x2").toString()
    }

    fun callData(view: View) {
        textView.text = sharedPreferences.getString("xx1","")
        textView2.text= sharedPreferences.getString("xx2","")
    }
}