package com.example.caio.popsodadrink.activity

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import com.example.caio.popsodadrink.R
import com.example.caio.popsodadrink.presenter.LoginPresenter
import com.example.caio.popsodadrink.service.ServiceFactory
import com.example.caio.popsodadrink.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginView {

    val service = ServiceFactory().create()

    override fun showMessage(msg: String, result: String) {
        val alert = AlertDialog.Builder(this)
        alert.setTitle(msg)
        alert.setMessage(result)
        alert.setPositiveButton("Ok", DialogInterface.OnClickListener { dialog, which -> finish() })

        alert.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginPresenter = LoginPresenter(service, this )

        // Remove a barra de status
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        txtCadastro.setOnClickListener{
            startActivity(Intent(this, CadastroActivity::class.java))
        }

    }
}
