package com.enigmacamp.examplehandon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_board.*

class BoardActivity : AppCompatActivity() {

    private var activePlayer = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board)
        val playerOne = intent.getStringExtra("FIRST_NAME")
        textView3.text = "${playerOne}'s Turn"
    }

    private fun playGame(buttonSelected: Button) {
        val playerOne = intent.getStringExtra("FIRST_NAME")
        val playerTwo = intent.getStringExtra("LAST_NAME")
        if(activePlayer==1){
            textView3.text = "$playerTwo's Turn"
            buttonSelected.text = "X"
            activePlayer = 2
        }else{
            textView3.text = "$playerOne's Turn"
            buttonSelected.text = "O"
            activePlayer = 1
        }
        //disable button, after click
        buttonSelected.isEnabled = false;
    }

    fun buttonClick(view: View) {
        val buttonSelected = view as Button
        playGame(buttonSelected)
    }
}