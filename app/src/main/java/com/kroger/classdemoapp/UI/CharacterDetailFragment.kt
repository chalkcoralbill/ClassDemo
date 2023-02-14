package com.kroger.classdemoapp.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kroger.classdemoapp.CharacterAdapter
import com.kroger.classdemoapp.R
import kotlin.random.Random


class CharacterDetailFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_character_detail, container, false)

        if(arguments != null){
            val name = requireArguments().getString("name")
            val age = requireArguments().getInt("age")
            val image = requireArguments().getString("image")
            val house = requireArguments().getString("house")
            val id = requireArguments().getInt("id")
            val description = requireArguments().getString("description")
            val dead = requireArguments().getBoolean("dead")
            val characterImage: ImageView = view.findViewById(R.id.character_image)
            Glide.with(view.context).load(image).into(characterImage)

           view.findViewById<TextView>(R.id.character_name).text = "\nName: "+name
           view.findViewById<TextView>(R.id.character_age).text = "Age: "+age.toString()
          // view.findViewById<ImageView>(R.id.character_image) = image
           view.findViewById<TextView>(R.id.character_house).text ="Member of the house of "+ house
            view.findViewById<TextView>(R.id.character_description).text=description
            if(dead.toString().equals("true")){
            view.findViewById<TextView>(R.id.character_dead).text="Character is currently Dead"
            }
            else
            {view.findViewById<TextView>(R.id.character_dead).text="Character is currently Alive"}
             }

        val characterImage: ImageView = view.findViewById(R.id.character_image)
        return view
    }
}
