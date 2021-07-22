package com.enigmacamp.examplehandon

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("hancur_login", "onCreate: ")


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btn_login.setOnClickListener {
            val name = username.text
            Log.d("name", "onViewCreated: ${name.toString()}")
            var bundle = bundleOf("username" to name.toString())
            navController.navigate(R.id.action_loginFragment_to_homeFragment,bundle)
        }

    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("hancur_login", "onDestroy: ")
    }

    companion object {

        @JvmStatic
        fun newInstance() = LoginFragment()
    }
}