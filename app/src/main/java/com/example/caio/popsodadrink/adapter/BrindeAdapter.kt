package com.example.caio.popsodadrink.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.caio.popsodadrink.R
import com.example.caio.popsodadrink.model.Brinde
import kotlinx.android.synthetic.main.fragment_brindes.view.*
import org.w3c.dom.Text


class BrindeAdapter(context: Context, resource: Int, list: ArrayList<Brinde>)
    : ArrayAdapter<Brinde>( context,  resource,  list) {

    var resource: Int
    var list: ArrayList<Brinde>
    var vi: LayoutInflater

    init {
        this.resource = resource
        this.list = list
        this.vi = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var v: View?
        v = convertView

        if(v == null){
            v = LayoutInflater.from(context).inflate(R.layout.cardview_brinde, parent, false)
        }

        val brinde: Brinde = getItem(position)

        //!! converte qualquer valor para um non-null, e retorna ua exception se o valor já vier nulo
        val imgBrinde: ImageView = v!!.findViewById(R.id.img_brinde)
        val txtNameBrinde: TextView = v!!.findViewById(R.id.brinde_name)
        val txtPriceBrinde: TextView = v!!.findViewById(R.id.brinde_price)

        txtNameBrinde.text = brinde.nome
        txtPriceBrinde.text = brinde.valorUnitario.toString()

        return v;
    }

}

