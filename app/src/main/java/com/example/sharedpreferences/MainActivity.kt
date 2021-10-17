package com.example.sharedpreferences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var entry1: EditText
    private lateinit var entry2: EditText
    private lateinit var intentX: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        entry1= findViewById(R.id.entry1)
        entry2= findViewById(R.id.entry2)
        sharedPreferences = this.getSharedPreferences(
            getString(R.string.preference_file_key), Context.MODE_PRIVATE
        )

        intentX= Intent(this,Second::class.java)
    }

    fun saveData(view: View) {
        if (entry1.text.isNotBlank()&&entry2.text.isNotBlank()){
            with(sharedPreferences.edit()) {
                putString("xx1", entry1.text.toString())
                putString("xx2", entry2.text.toString())
                apply()
            }
        }
        startActivity(intentX)
    }
    fun sendData(view: View) {
        if (entry1.text.isNotBlank()&&entry2.text.isNotBlank()){
            intentX.putExtra("x1",entry1.text.toString())
            intentX.putExtra("x2",entry2.text.toString())
        }
    }
}