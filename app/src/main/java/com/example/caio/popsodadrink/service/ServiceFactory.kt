package com.example.caio.popsodadrink.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ServiceFactory {

    fun create(): PopsService {
        val retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.0.27:3100/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        return retrofit.create(PopsService::class.java)
    }

}