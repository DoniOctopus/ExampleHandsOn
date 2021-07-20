package com.enigmacamp.examplehandon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_show.*

class MainActivity : AppCompatActivity() ,CounterInterface {

    private lateinit var counterFragment: CounterFragment
    private lateinit var counterShowFragment: ShowFragment
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counterFragment = CounterFragment.newInstance(this)
        counterShowFragment = ShowFragment()

        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, counterFragment).commit()

        counterFragmentButton.setOnClickListener {
            switchFragment(counterFragment)
        }

        counterShowFragmentButton.setOnClickListener {
            switchFragment(counterShowFragment)
        }
    }
    override fun notifyIncrease() {
        counter+=1
    }

    override fun notifyDecrease() {
        counter-=1
    }

    private fun switchFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }
}