package com.enigmacamp.examplehandon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView

class MainActivity : AppCompatActivity() {

    private lateinit var inputPanjang: TextInputEditText
    private lateinit var inputLebar: TextInputEditText
    private lateinit var inputTinggi: TextInputEditText
    private lateinit var buttonHitung: MaterialButton
    private lateinit var txtResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputPanjang = findViewById(R.id.input_panjang)
        inputLebar = findViewById(R.id.input_lebar)
        inputTinggi = findViewById(R.id.input_tinggi)
        buttonHitung = findViewById(R.id.btn_hitung)
        txtResult = findViewById(R.id.txt_hasil)

        buttonHitung.setOnClickListener {
            if(it?.id == R.id.btn_hitung) {
                val panjang = inputPanjang.text.toString().trim()
                val lebar = inputLebar.text.toString().trim()
                val tinggi = inputTinggi.text.toString().trim()

                var isEmptyFields = false


                when {
                    panjang.isEmpty() -> {
                        isEmptyFields = true
                        inputPanjang.error = "Field ini tidak boleh kosong"
                    }
                    lebar.isEmpty() -> {
                        isEmptyFields = true
                        inputLebar.error =  "Field ini tidak boleh kosong"
                    }
                    tinggi.isEmpty() -> {
                        isEmptyFields = true
                        inputTinggi.error = "Field ini tidak boleh kosong"
                    }
                }

                if (!isEmptyFields) {
                    val volume = panjang.toDouble() * lebar.toDouble() * tinggi.toDouble()
                    txtResult.text = volume.toString()
                }
            }
        }
    }
}