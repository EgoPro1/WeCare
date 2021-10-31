package com.example.wecareapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.wecareapp.databinding.ActivitySelectorBinding

import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarItemView

class SelectorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Instancia del view binding
        val binding = ActivitySelectorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView = binding.buttonNav
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment



        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.homeFragment, R.id.stadisticsFragment, R.id.feelingFragment2,R.id.statsFragment)
        )
        val navController = navHostFragment.navController

        setupActionBarWithNavController(navController,appBarConfiguration)
        // Sincronizacion del navController con nuesto bottom navigation
        bottomNavigationView.setupWithNavController(navController)

    }
}