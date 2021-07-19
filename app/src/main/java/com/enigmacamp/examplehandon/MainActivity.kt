package com.enigmacamp.examplehandon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_show.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counter.setOnClickListener {
            switchFragment(CounterFragment())
        }

        counterShow.setOnClickListener {
            switchFragment(ShowFragment())
        }
        //view yang pertama kali dipanggil
        showFirstFragment()
    }

    private fun switchFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }

    private fun showFirstFragment(){
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, CounterFragment()).commit()
    }


    fun controllerData(value: Int) {
        //ini id dari fragment 2 yang text_view
//       Hasil.hasil = value
        (application as BaseApplication).hasil = value
    }
}