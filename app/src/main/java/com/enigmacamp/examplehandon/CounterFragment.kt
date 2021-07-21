package com.enigmacamp.examplehandon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_counter.*


class CounterFragment : Fragment() {
    private lateinit var counterHandler: CounterInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    //Proses set view
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_counter, container, false)
    }

    //Setelah semua berjalan, logic coding taruh di sini
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        increaseButton.setOnClickListener {
            println("INCREASE BUTTON DIPANGGIL")
            counterHandler.notifyIncrease()
        }
        decreaseButton.setOnClickListener {
            println("DECREASE BUTTON DIPANGGIL")
            counterHandler.notifyDecrease()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(counterInterface: CounterInterface) =
                CounterFragment().apply {
                    counterHandler = counterInterface
                }
    }

}