package com.example.caio.popsodadrink.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import com.example.caio.popsodadrink.R
import com.example.caio.popsodadrink.model.Usuario
import com.example.caio.popsodadrink.presenter.UsuarioPresenter
import com.example.caio.popsodadrink.service.ServiceFactory
import com.example.caio.popsodadrink.view.UsuarioView
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), UsuarioView {
    override fun showMessage(titulo: String, mensagem: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun login(mensagem: String) {

    }

    var service = ServiceFactory().create()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        var presenter = UsuarioPresenter(this, service)

        btn_cadastro.setOnClickListener {

            var usuario = Usuario(
                    //preciso arrumar os parametros que serão passados
                    txt_usuario.text.toString(),
                    txt_senha.text.toString()
            )

            presenter.loginUsuario(usuario)

        }


        // Remove a barra de status
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

         txtCadastro.setOnClickListener{
             startActivity(Intent(this, CadastroActivity::class.java))
         }

    }
}
