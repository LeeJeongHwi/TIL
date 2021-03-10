package com.example.android_study

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    /*num1,num2,num3,num4,num5, calcButton , resultView */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1.setOnClickListener {
            val addFunc = {a:Int, b:Int -> a+b}
            val result= addFunc(10,10)
            resultView.setText("결과 : ${result}")
        }
        button2.setOnClickListener {
            val addFunc = {a:Int, b:Int -> a+b}
            val result = calc(10,11,addFunc)
            resultView.setText("결과 : ${result}")
        }
        button3.setOnClickListener {
            val oper = getOperator("subtract")
            if (oper!=null){
                val result = calc(30,19,oper)
                resultView.setText("결과 : ${result}")
            }
        }
    }
    fun getOperator(name:String) : ((Int, Int)-> Int)? {
        var oper:((Int, Int)-> Int)?= null
        if (name == "add"){
            oper = {a,b-> a+b}
        }
        else if (name == "subtract"){
            oper = {a,b -> a-b}
        }
        return oper
    }
    fun calc(first:Int, second:Int, oper:(Int,Int)->Int):Int {
        return oper(first,second)
    }  
}