package com.enigmacamp.examplehandon

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TransactionViewModel : ViewModel(){
    var balanceLiveData : MutableLiveData<Int>   = MutableLiveData(0)
    private var balance = 0
    fun handleIncrement(increment : Int){
        balance += increment
        balanceLiveData.value = balance
    }
    fun handleDecrement(decrement : Int){
        balance -= decrement
        balanceLiveData.value = balance
    }

}