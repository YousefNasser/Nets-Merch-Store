package com.example.netsmerch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.netsmerch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var navHostFragment: NavHostFragment
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        navHostFragment = binding.myNavHostFragment.getFragment()
        navController = navHostFragment.navController
        appBarConfiguration =
            AppBarConfiguration.Builder(R.id.listingsFragment, R.id.loginFragment).build()

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {

        navHostFragment = binding.myNavHostFragment.getFragment()
        navController = navHostFragment.navController
        appBarConfiguration =
            AppBarConfiguration.Builder(R.id.listingsFragment, R.id.loginFragment).build()

        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp()
    }
}