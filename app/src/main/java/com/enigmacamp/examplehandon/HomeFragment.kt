package com.enigmacamp.examplehandon

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.fragment_balance.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_transaction.*

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

        dataResult()
        bottomItem()
    }

    fun dataResult(){
        //get Name From Login with bundle
        val hasil ="Welcome " + arguments?.getString("username")
        Log.d("Masuk", "onViewCreated:")
        user_name.text = hasil.toString()
    }

    fun bottomItem(){
        NavigationUI.setupWithNavController(bottomNavigationView,navController)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.btn_homeFragment -> {
                    navController.navigate(R.id.action_loginFragment_to_homeFragment)
                    true
                }
                R.id.btn_transactionFragment -> {
                    navController.navigate(R.id.action_homeFragment_to_transactionFragment)
                    true
                }
                R.id.btn_balanceFragment -> {
                    navController.navigate(R.id.action_homeFragment_to_balanceFragment)
                    true
                }
                else ->{
                    println("Else")
                    false
                }
            }
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