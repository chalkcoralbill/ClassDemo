/*
Alex Kuderer
CSC 415
Assignment 2: Recycler Views
Assignment of Game of thrones, the books ASOIF.
 */
package com.kroger.classdemoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.character_recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val characters = mutableListOf<Character>()

        characters.add(John())
        characters.add(Stannis())
        characters.add(Tryion())
        characters.add(Joffery())
        characters.add(Daenerys())
        characters.add(Eddard())
        characters.add(Sansa())

        for (i in 0..30) {
            characters.add(createCharacterWW())
        }

        val adapter = CharacterAdapter(characters)
        recyclerView.adapter = adapter
    }

    private fun createCharacterWW() = Character(        //randomly generated zombies
        name = "White Walker #"+ Random.nextInt(1, 1000),
        age = Random.nextInt(10, 1500),
        image = R.mipmap.zombies,
        //image = R.drawable.baseline_10k_24,
        dead= true,
        house = "white walker",
        id = 0,
        relation = listOf("no know family")
    )
    private fun John() = Character(
        name = "John Snow",
        age = 24,
        image = R.mipmap.john,
        dead= true,
        house = "Snow, Stark and Targaryen",
        id = 1,
        relation = listOf(Eddard().name, Sansa().name, Daenerys().name)
    )
    private fun Eddard() = Character(
        name = "Eddard Stark",
        age = 52,
        image = R.mipmap.eddard,
        dead= true,
        house = "Stark",
        id = 2,
        relation = listOf(Sansa().name, "John Snow")
    )
    private fun Sansa() = Character(
        name = "Sansa Stark",
        age = 20,
        image = R.mipmap.sansa,
        dead= false,
        house = "Stark",
        id = 3,
        relation = listOf("Eddard Stark", "John Snow")
    )
    private fun Daenerys() = Character(
        name = "Daenerys Targaryen",
        age = 26,
        image = R.mipmap.daenerys,
        dead= false,
        house = "Targaryen",
        id = 4,
        relation = listOf("John Snow")
    )
    private fun Tryion() = Character(
        name = "Tyrion Lannister",
        age = 26,
        image = R.mipmap.tryion,
        dead= false,
        house = "Lannister",
        id = 5,
        relation = listOf(Joffery().name)
    )
    private fun Stannis() = Character(
        name = "Stannis Baratheon",
        age = 49,
        image = R.mipmap.stannis,
        dead= true,
        house = "Baratheon",
        id = 6,
        relation = listOf(Joffery().name)
    )
    private fun Joffery() = Character(
        name = "Joffery Baratheon",
        age = 16,
        image = R.mipmap.joffery,
        dead= true,
        house = "Lannister",
        id = 7,
        relation = listOf("Stannis Baratheon","Tryion Lannister" )
    )
}
