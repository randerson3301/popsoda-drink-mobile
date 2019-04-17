package com.example.caio.popsodadrink.presenter

import android.util.JsonReader
import com.example.caio.popsodadrink.model.Brinde
import com.example.caio.popsodadrink.model.Login
import com.example.caio.popsodadrink.model.Usuario
import com.example.caio.popsodadrink.service.PopsService
import com.example.caio.popsodadrink.view.BrindeView
import com.example.caio.popsodadrink.view.LoginView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter(internal val service: PopsService, internal val loginView: LoginView) {


    fun doLogin( username: String, password: String){


        service.loginUsuario(username, password).enqueue(object : Callback<Login>{

            override fun onResponse(call: Call<Login>, response: Response<Login>) {
                val result = response?.body()
                loginView.getLoginResult(result!!.response)
                System.out.println(result?.response)
        }

            override fun onFailure(call: Call<Login>, t: Throwable) {
                System.out.println("Não Foi")
                t.localizedMessage
            }
        })
    }
}