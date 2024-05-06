package com.example.mycolabapplication.ui.rooms

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.mycolabapplication.R
import com.example.mycolabapplication.data.model.rooms_package.RoomsItemModel
import com.example.mycolabapplication.databinding.RoomItemBinding

class RoomsAdapter(
    val roomsList: List<RoomsItemModel>
) : RecyclerView.Adapter<RoomsAdapter.RoomsViewHolder>() {

    inner class RoomsViewHolder(itemView: View) : ViewHolder(itemView) {
        val binding = RoomItemBinding.bind(itemView)
        fun updateUI(roomItemModel: RoomsItemModel) {
            binding.apply{
                tvRoomId.text = "Room ID: ${roomItemModel.id}"
                tvStatus.text = "Availablility: ${roomItemModel.isOccupied.toString()}"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomsViewHolder {
        return RoomsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.room_item, parent, false)
        )
    }

    override fun getItemCount() = roomsList.size

    override fun onBindViewHolder(holder: RoomsViewHolder, position: Int) {
        holder.updateUI(roomsList[position])
    }
}