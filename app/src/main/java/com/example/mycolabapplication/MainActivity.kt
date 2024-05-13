package com.example.mycolabapplication

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.mycolabapplication.databinding.ActivityMainBinding
import com.example.mycolabapplication.ui.people.PeopleFragment

class MainActivity : AppCompatActivity() {

     lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //replaceFragment(PeopleFragment())
        val navHostFragment = supportFragmentManager
            .findFragmentById(binding.flLaunch.id) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId) {
                R.id.itemPeople -> {
                    navController.navigate(R.id.itemPeople)
                    //replaceFragment(PeopleFragment())
                }
                R.id.itemRooms -> {
                    navController.navigate(R.id.itemRooms)
                    //replaceFragment(RoomsFragment())
                }
                else -> {}
            }
            true
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.detailsFragment) {
                binding.bottomNavigationView.visibility = View.GONE
            }
            else {
                binding.bottomNavigationView.visibility = View.VISIBLE
            }
        }

//        enableEdgeToEdge()
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }

//    private fun replaceFragment(fragment: Fragment) {
//
//        val fragmentManager = supportFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.flLaunch, fragment)
//        fragmentTransaction.commit()
//    }
}