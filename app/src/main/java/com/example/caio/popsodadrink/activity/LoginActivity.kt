package com.example.caio.popsodadrink.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import com.example.caio.popsodadrink.R
import com.example.caio.popsodadrink.model.LoginResult
import com.example.caio.popsodadrink.model.Usuario
import com.example.caio.popsodadrink.presenter.LoginPresenter
import com.example.caio.popsodadrink.service.ServiceFactory
import com.example.caio.popsodadrink.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginView {

    val service = ServiceFactory().create()

    override fun getLoginResult(list: List<LoginResult>) {
        val alert = AlertDialog.Builder(this)
        alert.setTitle("Ok")
        alert.setMessage("Autenticado com sucesso!")
        alert.setPositiveButton("Ok", null)
        putExtra(list[0].userId)
        alert.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.caio.popsodadrink.R.layout.activity_login)

        val loginPresenter = LoginPresenter(service, this )

        btn_login.setOnClickListener{
            try {
                loginPresenter.doLogin(txt_user.text.toString(), txt_password.text.toString())

                val intent = Intent(this, DrawerActivity::class.java)



            } catch (erro: Exception){
                erro.localizedMessage
            }
        }

        // Remove a barra de status
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        txtCadastro.setOnClickListener{
            startActivity(Intent(this, CadastroActivity::class.java))
        }

    }

    fun putExtra(userId: Int){
        val intent = Intent(this, DrawerActivity::class.java)
        intent.putExtra("userId", userId)
        startActivity(intent)
    }
}
