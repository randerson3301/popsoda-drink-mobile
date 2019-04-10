package com.example.caio.popsodadrink.fragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.example.caio.popsodadrink.CadastroActivity
import com.example.caio.popsodadrink.R
import kotlinx.android.synthetic.main.activity_login.*



class LoginFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //Vincula essa class com o layout criado para a fragment
        return inflater.inflate(R.layout.activity_login, container, false)

        // Remove a barra de status
       /* getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        txtCadastro.setOnClickListener{
            startActivity(Intent(this, CadastroActivity::class.java))
        }*/

    }
}
