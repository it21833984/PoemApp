package com.example.poemapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstfragment = PoemListFragment()
        val fm : FragmentManager = supportFragmentManager
        fm.beginTransaction().add(R.id.mainlayout,firstfragment).commit()
    }
}