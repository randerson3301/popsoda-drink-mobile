package com.example.caio.popsodadrink.presenter

import com.example.caio.popsodadrink.model.Login
import com.example.caio.popsodadrink.model.LoginResult
import com.example.caio.popsodadrink.model.Usuario
import com.example.caio.popsodadrink.service.PopsService
import com.example.caio.popsodadrink.view.LoginView
import com.example.caio.popsodadrink.view.UsuarioView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsuarioPresenter(internal val service: PopsService, internal val userView: UsuarioView) {
    fun getUserById(userId: Int){
        service.getUserById(userId).enqueue(object : Callback<LoginResult> {
            override fun onResponse(call: Call<LoginResult>, response: Response<LoginResult>) {
                val result = response.body()

               // userView.getUser(result)

                println("foi")

            }

            override fun onFailure(call: Call<LoginResult>, t: Throwable) {
                println("Não Foi")
                t.localizedMessage
            }
        })
    }
}