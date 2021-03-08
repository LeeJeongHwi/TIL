package com.example.android_study

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSay.setOnClickListener {
            Toast.makeText(applicationContext,"Button Clicked",Toast.LENGTH_LONG).show()
        }
        button4.setOnClickListener {
            val inputText = input1.text.toString() // edit Text에 입력한 글자가 있다면 가져오거라!
            output1.text = "Result : $inputText"
        }
    }
}