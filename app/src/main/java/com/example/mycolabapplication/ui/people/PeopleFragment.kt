package com.example.mycolabapplication.ui.people

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycolabapplication.R
import com.example.mycolabapplication.databinding.FragmentPeopleBinding
import com.example.mycolabapplication.ui.details.DetailsFragment


class PeopleFragment : Fragment() {
    private var _binding: FragmentPeopleBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val peopleViewModel = ViewModelProvider(this).get(PeopleViewModel::class.java)

        _binding = FragmentPeopleBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.apply {
            peopleViewModel.productList.observe(viewLifecycleOwner) {
                rcPeople.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = PeopleAdapter(it) {peopleItemModel ->
                        findNavController().navigate(
                            R.id.action_peopleFragment_to_detailsFragment,
                            bundleOf(
                                Pair("image", peopleItemModel.avatar),
                                Pair("firstName",peopleItemModel.firstName),
                                Pair("lastName", peopleItemModel.lastName),
                                Pair("email", peopleItemModel.email),
                                Pair("jobTitle", peopleItemModel.jobtitle)
                            )
                        )
                    }
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