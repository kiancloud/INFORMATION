package com.test.information

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Environment
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import com.test.information.fragments.*
import java.io.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{


    lateinit var bundle: Bundle
    //    fragment
    lateinit var evalMainFragment: EvalFragmentMain
    lateinit var homeFragment: HomeFragment
    lateinit var addentryFragment: AddentryFragment
    lateinit var listentryFragment: ListentryFragment
    lateinit var mcpFragment: McpFragment
    lateinit var salesFragment: SalesFragment
    lateinit var settingsFragment: SettingsFragment
    lateinit var addentry_select_form: addentry_select_form


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



//        Navigation
        val nav_view:NavigationView = findViewById(R.id.nav_view)
//        val toolBar:Toolbar = findViewById(R.id.toolBar)
        val drawerLayout: (DrawerLayout) = findViewById(R.id.drawerLayout)
//        setSupportActionBar(toolBar) //No Problerm
        val  actionBar = supportActionBar
//       Navigation title or name
        actionBar?.title = " "
        val drawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(
                this,
                drawerLayout,
//                toolBar,
                (R.string.open),
                (R.string.close)
        ) {
        }
        drawerToggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        //default page is HomeFragment

        homeFragment = HomeFragment()
        supportFragmentManager.beginTransaction()
                .replace(R.id.frame_layout, homeFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()
//        ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//        ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//        Permission Granted
        ActivityCompat.requestPermissions(
                this, arrayOf(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.MANAGE_EXTERNAL_STORAGE
        ), PackageManager.PERMISSION_GRANTED
        )

//        Creating Folder Evaluation
        val extStorageDirectory = Environment.getExternalStorageDirectory().toString()
            val folder = File(extStorageDirectory, "Evaluation Folder")
            if (folder.exists()) {
//                Toast.makeText(this, "Already Created", Toast.LENGTH_SHORT).show()
            } else {
//                Toast.makeText(this, "Successfull Creating a Folder", Toast.LENGTH_SHORT).show()
                folder.mkdir()
            }



//        onCreate end tag
    }




    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        val drawerLayout: (DrawerLayout) = findViewById(R.id.drawerLayout)
        when(menuItem.itemId) {
            R.id.home -> {
                homeFragment = HomeFragment()
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, homeFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
            }
            R.id.addentry -> {
                addentry_select_form = addentry_select_form()
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, addentry_select_form)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
            }
            R.id.listentry -> {
                listentryFragment = ListentryFragment()
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, listentryFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
            }
            R.id.mcp -> {
                mcpFragment = McpFragment()
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, mcpFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
            }
            R.id.sales -> {
                salesFragment = SalesFragment()
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, salesFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
            }
            R.id.settings -> {
                settingsFragment = SettingsFragment()
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, settingsFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
            }
            R.id.logout -> {
                homeFragment = HomeFragment()
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, homeFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
            }
        }
     drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        val drawerLayout: (DrawerLayout) = findViewById(R.id.drawerLayout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        }
        else {
            super.onBackPressed()
        }
    }

}

