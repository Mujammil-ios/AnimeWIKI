package com.example.animewiki

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.animewiki.databinding.ActivityMainBinding
import com.example.animewiki.ui.ExploreFragment
import com.example.animewiki.ui.RandomFragment
import com.example.animewiki.ui.TopFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    private val exploreFragment = ExploreFragment()
    private val topFragment = TopFragment()
    private val randomFragment = RandomFragment()




    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(exploreFragment)

//        bottomNavigationView.setOnItemSelectedListener {
//            // do stuff
//
//            return@setOnItemSelectedListener true
//        }

        binding.bnv.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.explore_id ->
                    replaceFragment(exploreFragment)
                R.id.top_id ->
                replaceFragment(topFragment)
                R.id.random_id ->
                    replaceFragment(randomFragment)

            }
            return@setOnItemSelectedListener true


        }


//        bnv.setOnItem
//
//
//
//
//        BottomNavigationView()?.OnNavigationItemSelectedListener{
//
//            when(it.itemId) {
//                R.id.explore_id ->
//
//
//                R.id.top_id ->
//                    replaceFragment(topFragment)
//                R.id.random_id ->
//                    replaceFragment(randomFragment)
//
//            }
//            true
//        }


    }
    private fun replaceFragment(fragment: Fragment){

        if (fragment !== null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()

        }
    }






}














