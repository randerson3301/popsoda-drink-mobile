package com.example.caio.popsodadrink.view

import com.example.caio.popsodadrink.model.Login
import com.example.caio.popsodadrink.model.Usuario

interface LoginView {

    fun getLoginResult(list: List<Usuario>)
}