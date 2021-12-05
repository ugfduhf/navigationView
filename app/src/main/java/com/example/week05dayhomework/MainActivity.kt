package com.example.week05dayhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private var drawerLayout:DrawerLayout?=null
    private var toolview:Toolbar?=null
    private var navView:NavigationView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectView()
        setSupportActionBar(toolview)
       supportActionBar?.setDisplayHomeAsUpEnabled(true)// يعطيني زر الهبرقر
        setupDrawer()
        drawerClicks()
    }
    private fun connectView(){
        drawerLayout=findViewById(R.id.drawer)
        toolview=findViewById(R.id.toolbar)
        navView=findViewById(R.id.navView)
    }
    private fun setupDrawer(){

        val actionBarDrawerToggle= ActionBarDrawerToggle(this,drawerLayout!!,R.string.open,R.string.close)
        drawerLayout?.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home ->{
                drawerLayout?.openDrawer(GravityCompat.START)
                true
            }else -> true
        }

    }
    private fun drawerClicks(){
        navView?.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.camera -> {
                    Toast.makeText(this,"this is camera",Toast.LENGTH_LONG).show()
                    drawerLayout?.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.send ->{
                    Toast.makeText(this,"this is send",Toast.LENGTH_LONG).show()
                    drawerLayout?.closeDrawer(GravityCompat.START)
                    true
                }
                else -> true
            }
        }
    }

}