    package com.enigmacamp.examplehandon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val languageViewModel by viewModels<LanguageViewModel>()
    private lateinit var languageRecyclerAdapter: LanguageRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        language_recycle_view.layoutManager = LinearLayoutManager(this)
        languageRecyclerAdapter = LanguageRecyclerAdapter()
        language_recycle_view.adapter = languageRecyclerAdapter
        refreshData()
    }

    fun addLanguage(view: View) {
        val languageName = language_name_input.text.toString()
        languageViewModel.addLanguage(languageName)
        refreshData()
    }

    private fun refreshData() {
        languageRecyclerAdapter.setData(languageViewModel.languageLiveData)
    }
}