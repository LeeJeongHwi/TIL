# Lambda 식

코틀린의 함수는 **First-Class Object** 이다.

* 변수에 할당
* 함수 파라미터로 전달
* 함수에서 반환

즉, **함수는 변수에 할당될 수 있다.**

함수를 변수에 할당할 때는 **Anonymous Function**이나 **Lambda식 (lambda Expression)**의 형태로 사용한다.



### 변수 할당

> activity_main.xml

```xml
	<TextView
        android:id="@+id/resultView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="결과 :"
        android:textColor="#0027FF"
        android:textSize="24sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.461"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.14" />

    <Button
        android:id="@+id/button1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="72dp"
        android:text="runFunction"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.455"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/resultView" />
```

> MainActivity.kt

```kotlin
button1.setOnClickListener {
    val addFunc = {a:Int, b:Int -> a+b}
    val result= addFunc(10,10)

    resultView.setText("결과 : ${result}")
}
```

`addFunc` 는 `a,b`를 인자로 받고 `a+b`를 리턴하는 람다식이다.



### 파라미터로 전달

> activity_main.xml

```xml
    <Button
        android:id="@+id/button2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="68dp"
        android:text="parameter Button"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.445"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/button1" />
```

> MainActivity.kt

```kotlin
...// 중략
	button2.setOnClickListener {
        val addFunc = {a:Int, b:Int -> a+b}
        val result = calc(10,11,addFunc)
        resultView.setText("결과 : ${result}")
    }
}
fun calc(first:Int, second:Int, oper:(Int,Int)->Int):Int {
        return oper(first,second)
    }
```

함수로 `calc` 를 만들고 `result` 에 `calc`의 결과값을 저장하는데, `oper` 에 `addFunc` 를 넘겨주었다.



### 람다식으로 함수의 결과 값으로 반환

> MainActivity.kt

```kotlin
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
```

`getOperator`로 함수에 대한 리턴 결과를 받는다.

리턴 결과는 `name`에 따라 `lambda expression` 을 리턴한다.

해당 코드는 subtract 라는 name을 주었을 때, oper에는 `{a,b->a-b}` 람다식을 리턴한다.

`oper`의 변수는 `((Int,Int) -> Int)?` 로 인자 파라미터의 타입을 결정한다.

> Kotlin 의 void 함수는 `Unit` 자료형으로 사용한다.



### 익명함수와 인라인 함수

람다식에서는 `return, break, continue` 와 같은 제어문을 처리하기 쉽지 않음

따라서 제어문 처리를 위한 익명함수를 사용함

```kotlin
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

            doAction(fun(): Int {
                println("액션 수행")
                return 10
            })
            doAction{
                println("액션 수행2")
                10
            }
            doAction{
                println("액션 수행3")
                return@doAction 10
            }
        }
    }
    fun doAction(action:() -> Int){
        println("do Action 수행")
        val result = action()
        println("do Action 호출 종료 : ${result}")
    }
```

* 익명함수

  ```kotlin
  val sum = fun(a: Int, b:Int): Int{
      ...
  }
  ```

  * 다음과 같이 사용된다.

`doAction` 코드를 살펴보면, 람다식은 `return`키워드를 그냥 사용할 수 없어서 반환 값을 `return `키워드 없이 사용이 가능하다. 

>  액션수행 2이 예와 같다.

`return` 키워드를 사용하고 싶다면 **액션수행3** 과 같이 `return@[Label]` 로 쓴다.

이와 같이 사용하면 람다식만 종료 가능



**인라인 함수**

* 함수를 정의한 후 그 함수를 반복적으로 호출하면 코드를 구성하는 효율성은 높아지지만 성능은 떨어짐, 해당 함수를 호출할 때 그 함수의 코드가 호출하는 쪽에 복사되어 실행되는 것이 `inline` 함수 --> 성능개선 

```kotlin
inline fun ~~~
```







