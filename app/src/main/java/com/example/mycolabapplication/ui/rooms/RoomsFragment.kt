package com.example.mycolabapplication.ui.rooms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycolabapplication.R
import com.example.mycolabapplication.databinding.FragmentPeopleBinding
import com.example.mycolabapplication.databinding.FragmentRoomsBinding


class RoomsFragment : Fragment() {
    private var _binding: FragmentRoomsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val roomsViewModel = ViewModelProvider(this).get(RoomsViewModel::class.java)

        _binding = FragmentRoomsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.apply {
            roomsViewModel.roomsList.observe(viewLifecycleOwner) {
                rcRooms.apply{
                    layoutManager = LinearLayoutManager(context)
                    adapter = RoomsAdapter(it)
                }
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}