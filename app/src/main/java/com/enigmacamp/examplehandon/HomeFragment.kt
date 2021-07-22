package com.enigmacamp.examplehandon

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_login.*

class HomeFragment : Fragment() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("hancur_home", "onCreate: ")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        //get Name From Login with bundle
        val hasil ="Welcome " + arguments?.getString("username")
        Log.d("Masuk", "onViewCreated:")
        user_name.text = hasil.toString()


        btn_transaction.setOnClickListener {
//            var bundle = bundleOf("angka" to 100)
//            navController.navigate(R.id.action_homeFragment_to_transactionFragment,bundle)
            navController.navigate(R.id.action_homeFragment_to_transactionFragment)
        }

        btn_blance.setOnClickListener {
           navController.navigate(R.id.action_homeFragment_to_balanceFragment)
        }

        btn_history.setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_historyFragment)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("hancur_home", "onDestroy: ")
    }
    companion object {

        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}