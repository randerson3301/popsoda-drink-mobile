
package com.example.caio.popsodadrink.activity.fragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.caio.popsodadrink.activity.EditarActivity
import com.example.caio.popsodadrink.R
import kotlinx.android.synthetic.main.fragment_perfil.view.*

class PerfilFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //Vincula essa class com o layout criado para a fragment
        val view: View = inflater.inflate(R.layout.fragment_perfil, container, false)

        view.editar.setOnClickListener {
            startActivity(Intent(this.context, EditarActivity::class.java))
        }

        return view
    }
}
