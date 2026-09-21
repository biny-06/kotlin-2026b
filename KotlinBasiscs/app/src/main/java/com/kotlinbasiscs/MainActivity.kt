package com.kotlinbasiscs

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kotlinbasiscs.ui.theme.KotlinBasiscsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinBasiscsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }

        // week03Variables()
        // week03Functions()
        week04Classes()
        // week04Collections()
    }

}

private fun week04Collections() {

    Log.d("KotlinWeek04", "== Kotlin Classes ==")

    val fruits = listOf("apple", "banana", "orange") //immutable
    val mutableFruits = mutableListOf("kiwi", "watermelon") // mutable

    // fruits.add("kiwi") // immutable
    println("Fruits: $fruits")
    mutableFruits.add("banana")
    println("Mutable fruits: $mutableFruits")

    var scores = mapOf("Kim" to 100, "Park" to 97, "Lee" to 99)

    println("Scores : $scores")

    for(fruit in mutableFruits){
        println("I like $fruit")
    }

        scores.forEach{(name, score) -> println("$name scored $score")}
        fruits.forEach{fruit -> println("$fruit")}

}

private fun week04Classes(){
    Log.d("KotlinWeek04", "== Kotlin Classes ==")

    class Person(val name: String, var age: Int){
        fun introduce(){
            Log.d("KotlinWeek04", "안녕하세요, $name ($age 세)입니다.")
        }
        fun birthday(){
            age++
            Log.d("KotlinWeek04", "$name 의 생일! 이제 $age 세...")
        }
    }
    val person1 = Person("홍길동", 27)
    person1.introduce()
    person1.birthday()

    open class Animal(var species: String){
        var weight: Double = 0.0
        constructor(species: String, weight: Double) : this(species){
            this.weight = weight
            Log.d("KotlinWeek04", "$species 의 무게 : $weight kg")
        }
        open fun makeSound(){
            Log.d("KotlinWeek04", "$species 가 소리를 냅니다.")
        }
    }
    val puppy = Animal("강아지", 10.5)
    puppy.makeSound()

    class Dog(species: String, weight: Double, val breed: String) : Animal(species, weight){
        override fun makeSound(){
            Log.d("KotlinWeek04", "$breed($species)가 멍멍 짖습니다!")
        }
    }

    val dog = Dog("개", 12.5, "골든 리트리버")
    dog.makeSound()

    data class Book(val title: String, val author: String, val pages: Int)

    val book1 = Book("코틀린 입문", "Kim", 400)
    val book2 = Book("코틀린 입문", "Kim", 400)

    Log.d("KotlinWeek04", "book1 == book2: ${book1 == book2}")
    Log.d("KotlinWeek04", "book1: $book1")
}

private fun week03Variables() {
    println("Week 03: Variables")

    val courseName = "Mobile Programming" // java final

    var week = 2
    week = 3
    println("Course : $courseName")
    println("Week : $week")

    println("========= Kotlin Variables =========")

    // val(immutable) vs var(mutable)
    val name = "Android"
    var version = 8

    println("Hi $name $version")

    val age: Int = 24
    val height: Double = 177.7
    val isStudent: Boolean = false

    println("Age : $age height : $height isStudent : $isStudent")

//    var nickname : String = null
    var nickname : String? = null
    nickname = "mirae"
    println("Nickname : $nickname ${nickname?.length}")


}

private fun week03Functions(){
//    println("Week 02: Functions")
//
//    fun greet(name: String) = "Hello, $name!"
//
//    println(greet("Android developer"))

    println("== Kotlin Functions ==")

    /*fun greet(name: String): String {
        return "Hello, $name!"
    }

    fun add(a: Int, b: Int) = a + b

    fun introduce(name: String, age: Int = 19){
        println("My name is $name and I'm $age years old")
    }

    println(greet("Kotlin"))
    println("Sum: ${add(5, -71)}")
    introduce("Kim", 7)
    introduce("Park")
    */

    fun printAll(vip: Boolean, name: String){
        println("$vip, $name")
    }

    fun printMany(vararg msg: String){ //variable arguments
        for(m in msg) println(m)
    }

    printAll(true, "dy")
    printAll(name = "mirae", vip = true) // named arguments

    printMany("A", "B", "C", "D")

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinBasiscsTheme {
        Greeting("Android")
    }
}

