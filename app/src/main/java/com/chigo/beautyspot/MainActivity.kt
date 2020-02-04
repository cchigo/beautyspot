package com.chigo.beautyspot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(){

    lateinit var homeFragment: HomeFragment
    lateinit var categoryFragment: CategoryFragment
    lateinit var favouritesFragment: FavouritesFragment
    lateinit var profileFragment: ProfileFragment

 override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     val bottomNavigation: BottomNavigationView = findViewById(R.id.btn_nav)

     //setting home fragment as default
     homeFragment = HomeFragment()
     supportFragmentManager
         .beginTransaction()
         .replace(R.id.frame_layout, homeFragment)
         .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
         .commit()

     bottomNavigation.setOnNavigationItemSelectedListener { item ->
         when (item.itemId) {

             R.id.homeFragment ->{
                 homeFragment = HomeFragment()
                 supportFragmentManager
                     .beginTransaction()
                     .replace(R.id.frame_layout, homeFragment)
                     .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                     .commit()

             }
             R.id.category ->{
                 categoryFragment = CategoryFragment()
                 supportFragmentManager
                     .beginTransaction()
                     .replace(R.id.frame_layout, categoryFragment)
                     .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                     .commit()

             }
             R.id.favourite ->{
                 favouritesFragment = FavouritesFragment()
                 supportFragmentManager
                     .beginTransaction()
                     .replace(R.id.frame_layout, favouritesFragment)
                     .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                     .commit()

             }
             R.id.profile ->{
                 profileFragment = ProfileFragment()
                 supportFragmentManager
                     .beginTransaction()
                     .replace(R.id.frame_layout, profileFragment)
                     .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                     .commit()

             }
         }
         true
     }

    }

    //toolbar menu on the right



}