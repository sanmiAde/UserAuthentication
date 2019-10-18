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
import com.sanmiaderibigbe.userauthentication.data.remote.GetDataResult
import com.sanmiaderibigbe.userauthentication.data.sharedPref.UserCredentialsData
import com.sanmiaderibigbe.userauthentication.di.ViewModelFactory

import com.sanmiaderibigbe.userauthentication.ui.login.LoginViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.home_fragment.*
import timber.log.Timber
import javax.inject.Inject

class HomeFragment : DaggerFragment() {
    @Inject
    lateinit var loginViewModelFactory: ViewModelFactory<LoginViewModel>

    @Inject
    lateinit var homeViewModelFactory: ViewModelFactory<HomeViewModel>

    private lateinit var userData: UserCredentialsData

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

        initClickListners()
        initloginLiveData()


    }

    private fun initClickListners() {
        btn_get_data.setOnClickListener {
            initGetDataLiveData()
        }
    }

    private fun initGetDataLiveData() {
        homeViewModel.getUserId(
            "Bearer ${userData.signInModel.tokenPair.accessToken}",
            userData.email
        )
        homeViewModel.userDataLiveData.observe(viewLifecycleOwner, Observer {
            when (it) {
                GetDataResult.Loading -> {
                }
                is GetDataResult.Success -> {
                    Timber.d(it.result.userId)
                    Toast.makeText(
                        requireContext(),
                        "${it.result.userId} ${it.result.email}",
                        Toast.LENGTH_LONG
                    ).show()
                }
                is GetDataResult.Error -> {
                    txt_data.text = it.errorMessage
                }
            }
        })
    }

    private fun initloginLiveData() {
        loginViewModel.getLoginStatus().observe(viewLifecycleOwner, Observer {
            when (it) {
                true -> {
                    Toast.makeText(requireContext(), "IUser  logged in ", Toast.LENGTH_LONG).show()
                    userData = homeViewModel.getUserData()
                }
                false -> {
                    findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
                }
            }
        })
    }
}
