package com.example.mycolabapplication.ui.people

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycolabapplication.R
import com.example.mycolabapplication.databinding.FragmentPeopleBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PeopleFragment : Fragment() {
    lateinit var binding: FragmentPeopleBinding
    private val peopleViewModel: PeopleViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val peopleViewModel = ViewModelProvider(this).get(PeopleViewModel::class.java)

        lifecycleScope.launch {
            peopleViewModel.dataShareState.collect{

            }
        }

        binding = FragmentPeopleBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        binding = null
//    }
}