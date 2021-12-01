package com.example.travelplannerandcityguide.ui.fragments

import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.travelplannerandcityguide.R
import com.example.travelplannerandcityguide.model.Profile
import com.example.travelplannerandcityguide.model.TokenResponce
import com.example.travelplannerandcityguide.ui.Login
import com.example.travelplannerandcityguide.utils.Resource
import com.example.travelplannerandcityguide.viewModel.LoginViewModel
import kotlinx.android.synthetic.main.sign_up_data_insert.*


class SignUpDataInsert : Fragment() {

    lateinit var viewModel: LoginViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up_data_insert, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=(activity as Login).viewModel

        viewModel.tokenResponse.observe(viewLifecycleOwner, Observer { response->

            when(response)
            {
                is Resource.Success->{
                    response.data?.let { tokenResponce ->
                    val tR=tokenResponce
                        Log.d("testing","success")
                        Toast.makeText(context,"submmitted",Toast.LENGTH_LONG).show()
                        requireActivity().finish()

                    }
                }
                is Resource.Error->{
                    response.message?.let { message->
                        Log.d("testi","An error occured: "+ message)

                    }
                }
                is Resource.Loading->{
                    Log.d("testing","loading")
                }
            }

        })

        signUpBtn.setOnClickListener{
            val fnameT=firstName.text.toString().trim()
            val lNameT=lastName.text.toString().trim()
            val emailT=email.text.toString().trim()
            val passwordT=password.text.toString().trim()

            Log.d("testing",fnameT)

         val   profile= Profile(emailT,fnameT,lNameT,passwordT)

            viewModel.postProfile(profile)
        }
    }


}