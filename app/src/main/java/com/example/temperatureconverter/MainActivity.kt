package com.example.temperatureconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var isCelciusToFahr = true
        this.modeInfo.text = "Converting Celsius degrees to Fahrenheit"

        fun celcToFahr(temp: Float): Float{
            val tempInFahr = temp * 9 / 5 + 32
            return tempInFahr
        }

        fun fahrToCelc(temp: Float): Float{
            val tempInCelc = (temp - 32) * 5 / 9
            return tempInCelc
        }

        btnconvert.setOnClickListener{
            var tempFromInput = textInputEditText.text
            if (tempFromInput!!.isNotEmpty() && tempFromInput.toString()!="-" && tempFromInput.toString()!="."){
                var newTemp: Float
                if (isCelciusToFahr == true) {
                    newTemp = celcToFahr(tempFromInput.toString().toFloat())
                } else {
                    newTemp = fahrToCelc(tempFromInput.toString().toFloat())
                }
                resultInfo.text = "Result: " + newTemp.toString()
            } else {
                Toast.makeText(applicationContext, "Please enter temperature! ", Toast.LENGTH_SHORT).show()
            }
        }

        btnmode.setOnClickListener{
            if (isCelciusToFahr == false){
                modeInfo.text = "Converting Celsius degrees to Fahrenheit"
                isCelciusToFahr = true
            } else {
                modeInfo.text = "Converting Fahrenheit to Celsius degrees"
                isCelciusToFahr = false
            }
        }

    }
}
