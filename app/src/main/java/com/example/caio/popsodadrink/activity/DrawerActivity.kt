package com.example.caio.popsodadrink.activity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.WindowManager
import com.example.caio.popsodadrink.R
import com.example.caio.popsodadrink.activity.fragments.BrindesFragment
import com.example.caio.popsodadrink.activity.fragments.EstabelecimentosFragments
import com.example.caio.popsodadrink.activity.fragments.PerfilFragment
import com.example.caio.popsodadrink.activity.fragments.PromocoesFragment
import com.example.caio.popsodadrink.model.LoginResult
import com.example.caio.popsodadrink.model.Usuario
import com.example.caio.popsodadrink.presenter.UsuarioPresenter
import com.example.caio.popsodadrink.service.ServiceFactory
import com.example.caio.popsodadrink.view.LoginView
import com.example.caio.popsodadrink.view.UsuarioView
import kotlinx.android.synthetic.main.activity_drawer.*
import kotlinx.android.synthetic.main.nav_header.*


class DrawerActivity : AppCompatActivity(), UsuarioView {


    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)

        // Remove a barra de status
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        //setando o toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val actionbar: ActionBar? = supportActionBar
        actionbar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.menu)
        }
        drawerLayout = findViewById(R.id.drawer_layout)
        val navigationView: NavigationView = findViewById(R.id.nav_view)

        setupDrawerContent(navigationView)

        val id: Int = intent.getIntExtra("userId",0)
        if(id > 0)
            requestOnAPI(id)
        else
           println("awiwa")



    }


    fun requestOnAPI(id:Int){

        println(id)

       val service = ServiceFactory().create()

        val presenter =  UsuarioPresenter(service, this)

        presenter.getUserById(id)
    }

    //permite que o menu drawer possa abrir quando o icon do canto for tocado
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    //função para fazer o setup do conteúdo do drawer
    private fun setupDrawerContent(navigationView: NavigationView){
        navigationView.setNavigationItemSelectedListener { menuItem ->
            selectDrawerItem(menuItem)

            true
        }
    }

    //função para realizar a navegação entre fragments
    fun selectDrawerItem(menuItem: MenuItem){
        // Create a new fragment and specify the fragment to show based on nav item clicked

        var fragment: Fragment

        var fragmentClass: Class<*>? = null

        when (menuItem.itemId) {

            R.id.nav_brindes ->

                fragmentClass = BrindesFragment::class.java

            R.id.nav_promo ->

                fragmentClass = PromocoesFragment::class.java

            R.id.nav_places ->

                fragmentClass = EstabelecimentosFragments::class.java

            R.id.nav_perfil ->

                fragmentClass = PerfilFragment::class.java

            R.id.nav_login ->

                startActivity(Intent(this, LoginActivity::class.java))
            else ->

                fragmentClass = BrindesFragment::class.java
        }

        if (fragmentClass != null){
            fragment = fragmentClass?.newInstance() as Fragment

            val fragmentManager = supportFragmentManager

            fragmentManager.beginTransaction().replace(R.id.content, fragment).commit()
        }

        menuItem.isChecked = true
        drawerLayout.closeDrawers()
        //title = menuItem.title

    }

    override fun getUser(list: List<LoginResult>) {

           txt_login.text = list[0].nome
           txt_teste.text = list[0].email

           println(list[0].cpf)
           println(list[0].email)
           println(list[0].nome)

           println("Ainda não")

    }

}
