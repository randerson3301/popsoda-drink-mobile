package com.example.caio.popsodadrink.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import com.example.caio.popsodadrink.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Remove a barra de status
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }
}