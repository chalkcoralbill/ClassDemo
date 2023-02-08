package com.kroger.classdemoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CharacterAdapter(private val characters: List<Character>) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CharacterViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.character_card_view, parent, false)
    )

    override fun getItemCount() = characters.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.characterImage.setImageResource(character.image)
        holder.characterName.text = character.name
        holder.characterAge.text = "Age:" + character.age.toString()
        holder.characterHouse.text = "Member of the house of "+character.house
        if(character.relation.isEmpty()){
            holder.characterRelations.text= character.relation.toString().drop(1).dropLast(1)
        }
        else{
            holder.characterRelations.text= "Family member of " + character.relation.toString().drop(1).dropLast(1)
        }
        if (character.dead.equals(true))
        {
        holder.characterDead.text= "Dead"
        }
        else
            holder.characterDead.text="Alive"
    }

    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val characterImage: ImageView = itemView.findViewById(R.id.character_image)
        val characterName: TextView = itemView.findViewById(R.id.character_name)
        val characterAge: TextView = itemView.findViewById(R.id.character_age)
        val characterHouse: TextView = itemView.findViewById(R.id.character_house)
        val characterDead: TextView = itemView.findViewById(R.id.character_dead)
        val characterRelations: TextView = itemView.findViewById(R.id.character_relations)
    }
}
