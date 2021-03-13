package com.example.android_study

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

open class Person(val name:String?){
    var age:Int? = null
    var address:String? = null
    init{
        println("Person의 Init 블록에서 실행됨")
    }
    constructor(name:String?, age:Int?, adress:String?):this(name){
        println("Person의 생성자에서 실행")
        this.age = age
        this.address = address
    }
}
class Student(val alias:String?): Person(alias){

    init {
        println("Student Init")
    }
    constructor(alias:String?,age:Int?,address:String?):this(alias){
        println("Constructor of Student")
        this.age = age
        this.address =address
    }
}

class MainActivity : AppCompatActivity() {
    /*num1,num2,num3,num4,num5, calcButton , resultView */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button4.setOnClickListener {
            val sum = fun(a: Int, b: Int): Int {
                var result = 0
                result = a + b
                return result
            }
            val output2 = sum(10, 20)
            resultView.setText("결과 : ${output2}")
            val student = Student("Name",10,"KOREA")
            println("${student.alias},${student.age},${student.address}")
        }
    }
}