package com.example.caio.popsodadrink.activity.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.caio.popsodadrink.R


class BrindesFragment: Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //Vincula essa class com o layout criado para a fragment de brindes
        return inflater.inflate(R.layout.fragment_brindes, container, false)
    }
}