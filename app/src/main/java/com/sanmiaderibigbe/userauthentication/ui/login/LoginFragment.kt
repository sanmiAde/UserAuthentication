package com.sanmiaderibigbe.userauthentication.ui.login

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.sanmiaderibigbe.userauthentication.R
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.login_fragment.*

class LoginFragment : DaggerFragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txt_register.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_navigation)
        }
    }
}
