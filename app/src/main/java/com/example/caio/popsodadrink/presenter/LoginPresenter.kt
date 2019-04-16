package com.example.caio.popsodadrink.presenter

import com.example.caio.popsodadrink.model.Brinde
import com.example.caio.popsodadrink.model.Usuario
import com.example.caio.popsodadrink.service.PopsService
import com.example.caio.popsodadrink.view.BrindeView
import com.example.caio.popsodadrink.view.LoginView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter(internal val service: PopsService, internal val loginView: LoginView) {


    fun doLogin( username: String, password: String){


        service.loginUsuario(username, password).enqueue(object : Callback<Usuario>{

            override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                val result = response?.body()

                loginView.showMessage("Sucesso", "Você está logado")
            }

            override fun onFailure(call: Call<Usuario>, t: Throwable) {
                t.localizedMessage
            }
        })
    }
}