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



### 다양한 형태





