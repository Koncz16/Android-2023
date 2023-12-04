package com.tasty.recipesapp.ui.recipe.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tasty.recipesapp.repository.recipe.models.InstructionModel

class InstructionsAdapter(private val instructions: List<InstructionModel>) :
    RecyclerView.Adapter<InstructionsAdapter.InstructionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstructionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_2, parent, false)
        return InstructionViewHolder(view)
    }

    override fun onBindViewHolder(holder: InstructionViewHolder, position: Int) {
        val instruction = instructions[position]
        holder.bind(instruction, position + 1)
    }

    override fun getItemCount(): Int = instructions.size

    inner class InstructionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val numberTextView: TextView = itemView.findViewById(android.R.id.text1)
        private val instructionTextView: TextView = itemView.findViewById(android.R.id.text2)

        fun bind(instruction: InstructionModel, position: Int) {
            numberTextView.text = position.toString()
            instructionTextView.text = instruction.display_text
        }
    }
}

