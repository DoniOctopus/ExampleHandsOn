package com.enigmacamp.examplehandon

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_transaction.*
import kotlin.math.log

class TransactionFragment : Fragment() {

    private lateinit var navController: NavController
    private lateinit var viewModel: TransactionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("hancur_transaction", "onCreate: ")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(this).get(TransactionViewModel::class.java)
        return inflater.inflate(R.layout.fragment_transaction, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscriber()
        navController = Navigation.findNavController(view)
//        val angka = arguments?.getInt("angka")
//        Log.d("Masuk", "onViewCreated : $angka")

        btn_back.setOnClickListener {
            navController.popBackStack()
        }

        btn_buy.setOnClickListener {
            viewModel.handleIncrement(textInputTransaction.text.toString().toInt())
        }
        btn_sell.setOnClickListener {
            viewModel.handleDecrement(textInputTransaction.text.toString().toInt())
        }

    }

    private fun subscriber(){
        var balanceObserver : Observer<Int> = Observer {
            it -> result.text = it.toString()
        }
        viewModel.balance.observe(viewLifecycleOwner,balanceObserver)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("hancur_Transaction", "onDestroy: ")
    }

    companion object {

        @JvmStatic
        fun newInstance() = TransactionFragment()
    }
}