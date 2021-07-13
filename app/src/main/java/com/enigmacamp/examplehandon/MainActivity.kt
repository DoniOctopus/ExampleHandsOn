package com.enigmacamp.examplehandon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.enigmacamp.examplehandon.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        viewBinding.apply {
            btnShowName.setOnClickListener {
                val name = textInputName.text
                tvName.text = name
            }
        }

    }
}