package com.sanmiaderibigbe.userauthentication.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.sanmiaderibigbe.userauthentication.R
import com.sanmiaderibigbe.userauthentication.data.remote.SignInResult
import com.sanmiaderibigbe.userauthentication.di.ViewModelFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.login_fragment.*
import javax.inject.Inject

class LoginFragment : DaggerFragment(){

    @Inject
    lateinit var loginViewModelFactory: ViewModelFactory<LoginViewModel>

    private val loginViewModel by lazy {
        //let passes it object and run passes this object. find out the difference
        requireActivity().run {
            ViewModelProviders.of(this, loginViewModelFactory)[LoginViewModel::class.java]
        }
    }

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

        btn_login.setOnClickListener {
            loginViewModel.logInUser(
                tl_email.editText?.text.toString(),
                tl_password.editText?.text.toString()
            )

            loginViewModel.loginResponseLiveData.observe(viewLifecycleOwner, Observer {
                when (it) {
                    SignInResult.Loading -> {
                    }
                    is SignInResult.Success -> {
                        findNavController().navigate(
                            R.id.homeFragment,
                            null,
                            NavOptions.Builder().setPopUpTo(R.id.loginFragment, true).build()
                        )
                    }
                    is SignInResult.Error -> {
                        Toast.makeText(requireContext(), "${it.errorMessage}", Toast.LENGTH_LONG)
                            .show()
                    }
                }
            })
        }
    }
}
