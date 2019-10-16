package com.sanmiaderibigbe.userauthentication.ui.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

import com.sanmiaderibigbe.userauthentication.R
import com.sanmiaderibigbe.userauthentication.di.ViewModelFactory

import com.sanmiaderibigbe.userauthentication.ui.login.LoginViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.home_fragment.*
import javax.inject.Inject

class HomeFragment : DaggerFragment() {
    @Inject
    lateinit var loginViewModelFactory: ViewModelFactory<LoginViewModel>

    @Inject
    lateinit var homeViewModelFactory: ViewModelFactory<HomeViewModel>

    private val loginViewModel by lazy {
        //let passes it object and run passes this object. find out the difference
        requireActivity().run {
            ViewModelProviders.of(this, loginViewModelFactory)[LoginViewModel::class.java]
        }
    }

    private val homeViewModel by lazy {
        ViewModelProviders.of(this, homeViewModelFactory)[HomeViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginViewModel.getLoginStatus().observe(viewLifecycleOwner, Observer {
            when(it){
                true -> {
                    Toast.makeText(requireContext(), "IUser  logged in ", Toast.LENGTH_LONG).show()
                    txt.text =
                        " ${homeViewModel.getUserData().signInModel.tokenPair.accessToken} ${homeViewModel.getUserData().email}"
                }
                false -> {
                    findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
                }
            }
        })


    }
}
