package com.example.task.presentation.list

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import task.R
import task.databinding.FragmentPeopleListBinding
import com.example.task.di.base.BaseFragment

class PeopleListFragment : BaseFragment<FragmentPeopleListBinding, PeopleListViewModel>() {

    private lateinit var binding: FragmentPeopleListBinding

    private lateinit var adapter: PeopleAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = getBinding()

        setLinearLayout()
        setOutputListeners()
        setInputListeners()
    }

    override fun getLayoutId() =
        R.layout.fragment_people_list

    override fun getViewModel() = ViewModelProvider(this, factory)[PeopleListViewModel::class.java]


    private fun setInputListeners() {
        fragmentViewModel.getPeople()

    }

    private fun setLinearLayout() {
        val linearLayoutManager =
            LinearLayoutManager(fragmentContext, LinearLayoutManager.VERTICAL, false)
        binding.peopleRecyclerView.layoutManager = linearLayoutManager
    }

    private fun setOutputListeners() {
        fragmentViewModel.peopleLiveData.observe(viewLifecycleOwner) {
            it?.let { peopleResponse ->
                adapter = PeopleAdapter(peopleResponse){
                    findNavController().navigate(R.id.person_detail_fragment, bundleOf("person" to it))
                }
                binding.peopleRecyclerView.adapter = adapter
            }
        }
    }

}