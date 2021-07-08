package com.enigmacamp.examplehandon

import androidx.lifecycle.ViewModel

class LanguageViewModel: ViewModel() {

    val languageLiveData =  mutableListOf("Java", "Golang")

    fun addLanguage(name: String) {
        languageLiveData.add(name)
    }
}