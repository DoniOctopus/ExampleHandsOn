package com.enigmacamp.examplehandon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val FIRST_NAME = "FIRST_NAME"
        const val LAST_NAME = "LAST_NAME"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_tekan.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v) {
            button_tekan -> toBoardActivity()
        }
    }

    private fun toBoardActivity() {
        val intent = Intent(this, BoardActivity::class.java)
        intent.putExtra(FIRST_NAME, input_name.text.toString())
        intent.putExtra(LAST_NAME, input_name2.text.toString())
        startActivity(intent)
    }

}