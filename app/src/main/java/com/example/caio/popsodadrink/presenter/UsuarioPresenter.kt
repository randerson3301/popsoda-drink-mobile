package com.example.caio.popsodadrink.presenter

import com.example.caio.popsodadrink.model.Login
import com.example.caio.popsodadrink.model.Usuario
import com.example.caio.popsodadrink.service.PopsService
import com.example.caio.popsodadrink.view.LoginView
import com.example.caio.popsodadrink.view.UsuarioView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsuarioPresenter(internal val service: PopsService, internal val userView: UsuarioView) {
    fun doLogin( userId: Int){


        service.getUserById(userId).enqueue(object : Callback<Usuario> {

            override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                val result = response?.body()
                userView.getUserById(result!!)
                System.out.println(result)
            }

            override fun onFailure(call: Call<Usuario>, t: Throwable) {
                System.out.println("Não Foi")
                t.localizedMessage
            }
        })
    }
}