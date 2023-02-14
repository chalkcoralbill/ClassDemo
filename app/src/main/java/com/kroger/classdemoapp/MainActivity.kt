/*
Alex Kuderer
CSC 415
Assignment 2: Recycler Views
Assignment of Game of thrones, the books ASOIF.
 */
package com.kroger.classdemoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kroger.classdemoapp.UI.GOTCharacterListFragment
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(R.id.fragment_container_view, GOTCharacterListFragment())
           // addToBackStack(null)
        }

   }

}
