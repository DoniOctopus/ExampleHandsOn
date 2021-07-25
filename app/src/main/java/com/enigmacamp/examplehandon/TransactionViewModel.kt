package com.enigmacamp.examplehandon

import androidx.lifecycle.ViewModel

class TransactionViewModel : ViewModel(){
    var balance = 0

    fun handleIncrement(increment : Int){
        balance += increment
    }
    fun handleDecrement(decrement : Int){
        balance -= decrement
    }

}