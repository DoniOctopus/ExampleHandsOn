package com.enigmacamp.examplehandon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.textview.MaterialTextView

class MainActivity : AppCompatActivity() {

    private lateinit var tvCounter: MaterialTextView
    private var startCounter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvCounter = findViewById(R.id.tv_counter)
    }

    fun notifyIncrease(view: View) {
        startCounter+=1
        tvCounter.text = startCounter.toString()
    }
    fun notifyDecrease(view: View) {
        startCounter-=1
        tvCounter.text = startCounter.toString()
    }

}