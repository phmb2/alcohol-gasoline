package com.phmb.alcohol_gasoline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_calculate.setOnClickListener {

            val alcoholPrice = edit_alcohol_price.text.toString()
            val gasolinePrice = edit_gasoline_price.text.toString()

            val validateInputs = validatePrices(alcoholPrice, gasolinePrice)

            if (validateInputs) {
                calculateBestPrice(alcoholPrice, gasolinePrice)
            } else {
                text_result.setText("Preencha os preços!")
            }
        }

    }

    fun validatePrices(alcoholPrice: String, gasolinePrice: String) : Boolean {

        var validateFields = true

        if(alcoholPrice.isNullOrEmpty()) {
            validateFields = false
        } else if(gasolinePrice.isNullOrEmpty()) {
            validateFields = false
        }

        return validateFields
    }

    fun calculateBestPrice(alcoholPrice: String, gasolinePrice: String) {

        val alcoholValue = alcoholPrice.toDouble()
        val gasolineValue = gasolinePrice.toDouble()

        val result = (alcoholValue / gasolineValue)

        if (result >= 0.7) {
            text_result.setText("Utilize gasolina!")
        } else {
            text_result.setText("Utilize álcool!")
        }
    }


}