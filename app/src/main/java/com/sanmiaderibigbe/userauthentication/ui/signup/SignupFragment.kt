package com.sanmiaderibigbe.userauthentication.ui.signup


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.sanmiaderibigbe.userauthentication.R
import com.sanmiaderibigbe.userauthentication.data.remote.SignUpResult
import com.sanmiaderibigbe.userauthentication.di.ViewModelFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_signup.*
import timber.log.Timber
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class SignupFragment : DaggerFragment() {

    @Inject
    lateinit var loginViewModelFactory: ViewModelFactory<SignUpViewModel>

//    @Inject
//    lateinit var  homeViewModelFactory: ViewModelFactory<HomeViewModel>

    private val signUpViewModel by lazy {
        //let passes it object and run passes this object. find out the difference
        ViewModelProviders.of(this, loginViewModelFactory)[SignUpViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_register.setOnClickListener {
            Timber.d("${tl_email.editText?.text.toString()} ${tl_password.editText?.text.toString()}")
            observeSignUpLivedata()
        }
    }

    private fun observeSignUpLivedata() {
        signUpViewModel.signUp(
            tl_email.editText?.text.toString(),
            tl_password.editText?.text.toString()
        )
        signUpViewModel.signUpSuccessful.observe(this, Observer {
            when (it) {
                is SignUpResult.Success -> {
                    findNavController().navigate(
                        R.id.homeFragment,
                        null,
                        NavOptions.Builder().setPopUpTo(R.id.signupFragment, true).build()
                    )
                }
                is SignUpResult.Error -> {
                    Toast.makeText(requireContext(), "${it.errorMessage}", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        })
    }
}
