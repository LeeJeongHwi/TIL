package com.example.android_study

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /*num1,num2,num3,num4,num5, calcButton , resultView */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        calcButton.setOnClickListener {

            val num_1 = if (num1.text.toString() == "") 0 else num1.text.toString().toInt()
            val num_2 = if (num2.text.toString() == "") 0 else num2.text.toString().toInt()
            val num_3 = if (num3.text.toString() == "") 0 else num3.text.toString().toInt()
            val num_4 = if (num4.text.toString() == "") 0 else num4.text.toString().toInt()
            val num_5 = if (num5.text.toString() == "") 0 else num5.text.toString().toInt()
            val result:Int = num_1+num_2+num_3+num_4+num_5
            resultView.setText("결과 : "+result.toString())
        }
    }
}