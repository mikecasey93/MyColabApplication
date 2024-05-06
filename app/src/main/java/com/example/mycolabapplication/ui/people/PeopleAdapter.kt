package com.example.mycolabapplication.ui.people

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
//import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.mycolabapplication.R
import com.example.mycolabapplication.data.model.people_package.PeopleItemModel
import com.example.mycolabapplication.databinding.PeopleItemBinding

class PeopleAdapter(
    val peoplelist: List<PeopleItemModel>,
    val function: (PeopleItemModel) -> Unit
): RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>(){

    inner class PeopleViewHolder(itemView: View): ViewHolder(itemView) {
        val binding = PeopleItemBinding.bind(itemView)
        fun updateUI(peopleItemModel: PeopleItemModel) {
            binding.apply {
                Glide.with(itemView.context)
                    .load(peopleItemModel.avatar)
                    .placeholder(R.drawable.baseline_person_24)
                    .into(ivProfile)
                tvFirstName.text = "First Name: ${peopleItemModel.firstName}"
                tvLastName.text = "Last Name: ${peopleItemModel.lastName}"
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        return PeopleViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.people_item, parent, false)
        )
    }

    override fun getItemCount() = peoplelist.size

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        holder.updateUI(peoplelist[position])

        holder.binding.root.setOnClickListener {
            function.invoke(peoplelist[position])
        }
    }
}