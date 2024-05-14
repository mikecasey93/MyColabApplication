package com.example.mycolabapplication.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.mycolabapplication.R
import com.example.mycolabapplication.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {

    lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)

        val image = arguments?.getString("image")
        val firstName = arguments?.getString("firstName")
        val lastName = arguments?.getString("lastname")
        val email = arguments?.getString("email")
        val jobTitle = arguments?.getString("jobTitle")

        binding.apply {
            tvFName.text = firstName
            tvLName.text = lastName
            tvEmail.text = email
            tvJobTitle.text = jobTitle
            Glide.with(requireContext()).load(image).into(ivdDetailProfile)
            btBack.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.action_detailsFragment_to_itemPeople)
            }
        }

        return binding.root
    }
}