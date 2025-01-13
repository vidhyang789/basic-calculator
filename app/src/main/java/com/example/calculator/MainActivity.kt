package com.example.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    
    var curr : String = ""
    var operation : String = ""
    var is_operation : Boolean = false
    lateinit var result : String
    lateinit var Result : TextView
    lateinit var Textbox : TextView

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Textbox = findViewById<TextView>(R.id.Toshowtext)
        Result = findViewById<TextView>(R.id.Resulttext)
        val btn1 = findViewById<MaterialButton>(R.id.btn1)
        btn1.setOnClickListener{
            setnumeric("1")
            if(is_operation){
                setwhileinput(operation)
            }
        }
        val btn2 = findViewById<MaterialButton>(R.id.btn2)
        btn2.setOnClickListener{
            setnumeric("2")
            if(is_operation){
                setwhileinput(operation)
            }
        }
        val btn3 = findViewById<MaterialButton>(R.id.btn3)
        btn3.setOnClickListener{
            setnumeric("3")
            if(is_operation){
                setwhileinput(operation)
            }
        }
        val btn4 = findViewById<MaterialButton>(R.id.btn4)
        btn4.setOnClickListener{
            setnumeric("4")
            if(is_operation){
                setwhileinput(operation)
            }
        }
        val btn5 = findViewById<MaterialButton>(R.id.btn5)
        btn5.setOnClickListener{
            setnumeric("5")
            if(is_operation){
                setwhileinput(operation)
            }
        }
        val btn6 = findViewById<MaterialButton>(R.id.btn6)
        btn6.setOnClickListener{
            setnumeric("6")
            if(is_operation){
                setwhileinput(operation)
            }
        }
        val btn7 = findViewById<MaterialButton>(R.id.btn7)
        btn7.setOnClickListener{
            setnumeric("7")
            if(is_operation){
                setwhileinput(operation)
            }
        }
        val btn8 = findViewById<MaterialButton>(R.id.btn8)
        btn8.setOnClickListener{
            setnumeric("8")
            if(is_operation){
                setwhileinput(operation)
            }
        }
        val btn9 = findViewById<MaterialButton>(R.id.btn9)
        btn9.setOnClickListener{
            setnumeric("9")
            if(is_operation){
                setwhileinput(operation)
            }

        }
        val btn0 = findViewById<MaterialButton>(R.id.btn0)
        btn0.setOnClickListener{
            setnumeric("0")
            if(is_operation){
                setwhileinput(operation)
            }
        }
        val btndot = findViewById<MaterialButton>(R.id.btndot)
        btndot.setOnClickListener{
            setnumeric(".")
        }
        val btn00 = findViewById<MaterialButton>(R.id.btn00)
        btn00.setOnClickListener{
            setnumeric("00")
            if(is_operation){
                setwhileinput(operation)
            }
        }
        val btnper = findViewById<MaterialButton>(R.id.btnper)
        btnper.setOnClickListener{
            Textbox.text = Textbox.text.toString() + "%"
            operation = "%"
            if(!is_operation){
                result = curr
                Result.text = curr
                is_operation = true
            }
            else{
                result = Result.text.toString()
            }
            curr = ""
        }
        val btnadd = findViewById<MaterialButton>(R.id.btnadd)
        btnadd.setOnClickListener{
            Textbox.text = Textbox.text.toString() + "+"
            operation = "+"
            if(!is_operation){
                result = curr
                Result.text = curr
                is_operation = true
            }
            else{
                result = Result.text.toString()
            }
            curr = ""
        }
        val btnmul = findViewById<MaterialButton>(R.id.btnmul)
        btnmul.setOnClickListener{
            Textbox.text = Textbox.text.toString() + "*"
            operation = "*"
            if(!is_operation){
                result = curr
                Result.text = curr
                is_operation = true
            }
            else{
                result = Result.text.toString()
            }
            curr = ""
        }
        val btndiv = findViewById<MaterialButton>(R.id.btndiv)
        btndiv.setOnClickListener{
            Textbox.text = Textbox.text.toString() + "/"
            operation = "/"
            if(!is_operation){
                result = curr
                Result.text = curr
                is_operation = true
            }
            else{
                result = Result.text.toString()
            }
            curr = ""
        }
        val btnmin = findViewById<MaterialButton>(R.id.btnmin)
        btnmin.setOnClickListener{
            Textbox.text = Textbox.text.toString() + "-"
            operation = "-"
            if(!is_operation){
                result = curr
                Result.text = curr
                is_operation = true
            }
            else{
                result = Result.text.toString()
            }
            curr = ""
        }
        val btnequ = findViewById<MaterialButton>(R.id.btnequ)
        btnequ.setOnClickListener{
            Textbox.text = Result.text
        }

        val btnAC = findViewById<MaterialButton>(R.id.btnAC)
        btnAC.setOnClickListener{
            curr = ""
            Textbox.text = ""
            Result.text = ""
            result = ""
            is_operation = false
        }

        val btnC = findViewById<MaterialButton>(R.id.btnC)
        btnC.setOnClickListener{
            Textbox.text = Textbox.text.toString().substring(0, Textbox.text.toString().length - 1)
            is_operation = false
            for (i in Textbox.text.toString()){
                if(i < '0' || i > '9'){
                    is_operation = true
                }
            }

            if(is_operation){
                setwhileinput(operation)
            }
            else{
                Result.text = Textbox.text
            }
        }
    }
    
    @SuppressLint("SetTextI18n")
    fun setnumeric (num : String){
        curr += num
        Textbox.text = Textbox.text.toString() + num
    }
    fun setwhileinput(op:String){
        if(curr.isNotEmpty()){
            if(result.isNotEmpty()){
                var temp = result.toDouble()
                when(op){
                    "+" -> temp += curr.toDouble()
                    "*" -> temp *= curr.toDouble()
                    "/" -> temp /= curr.toDouble()
                    "%" -> temp %= curr.toDouble()
                    "-" -> temp -= curr.toDouble()
                }
                Result.text = temp.toString()
            }
            else{
                Result.text = curr
            }
        }
        else{
            Result.text = result
        }
    }
}