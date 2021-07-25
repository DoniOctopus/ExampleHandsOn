package com.enigmacamp.examplehandon

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TransactionViewModel : ViewModel(){
    var balance : MutableLiveData<Int>   = MutableLiveData(0)

    fun handleIncrement(increment : Int){
        balance.value = balance.value?.plus(increment)
    }
    fun handleDecrement(decrement : Int){
        balance.value = balance.value?.minus(decrement)

    }

}