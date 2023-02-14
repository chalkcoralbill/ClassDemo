package com.kroger.classdemoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kroger.classdemoapp.UI.CharacterDetailFragment

class CharacterAdapter(private val characters: List<Character>) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder{
        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.character_card_view, parent, false)
        return CharacterViewHolder(view){position ->
            val character = characters[position]

            val bundle = bundleOf(
                "name" to character.name,
                "age" to character.age,
                "house" to character.house,
                "image" to character.image,
                "dead" to character.dead,
                "id" to character.id,
                "relation" to character.relation,
                "description" to character.description
            )
            val detailFragment = CharacterDetailFragment()
            detailFragment.arguments = bundle

            val activity = view.context as AppCompatActivity

            activity.supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view, detailFragment)
                addToBackStack(null)
            }
        }

    }

    override fun getItemCount() = characters.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        //holder.characterImage.setImageResource(character.image)

        Glide.with(holder.itemView.context).load(character.image).into(holder.characterImage)

        holder.characterName.text = character.name
        holder.characterAge.text = "Age:" + character.age.toString()
        holder.characterHouse.text = "Member of the house of "+character.house
        if(character.relation.isEmpty()){
            holder.characterRelations.text= "No known family members"//character.relation.toString().drop(1).dropLast(1)
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

    inner class CharacterViewHolder(
        itemView: View,
        private val onItemClick: (adaptorPosition: Int) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        val characterImage: ImageView = itemView.findViewById(R.id.character_image)
        val characterName: TextView = itemView.findViewById(R.id.character_name)
        val characterAge: TextView = itemView.findViewById(R.id.character_age)
        val characterHouse: TextView = itemView.findViewById(R.id.character_house)
        val characterDead: TextView = itemView.findViewById(R.id.character_dead)
        val characterRelations: TextView = itemView.findViewById(R.id.character_relations)

        init {
            itemView.setOnClickListener{
                onItemClick(adapterPosition)
            }
        }
    }
}
