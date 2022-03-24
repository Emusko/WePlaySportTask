package com.example.task.presentation.detail

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import task.R
import task.databinding.ItemListViewBinding
import com.bumptech.glide.Glide
import com.example.task.di.base.BaseFragment

class PersonDetailFragment : BaseFragment<ItemListViewBinding, PersonDetailViewModel>() {

    private lateinit var binding: ItemListViewBinding

    private val arguments by navArgs<PersonDetailFragmentArgs>()

    private val person by lazy { arguments.person }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = getBinding()

        Glide.with(binding.root.context)
            .load("https://people.epfl.ch/private/common/photos/links/268072.jpg")
            .into(binding.profileImage)
        binding.name.text = person.name
        binding.email.text = person.email
        binding.position.text = person.position
        binding.office.text = person.office
        binding.phoneNumber.text = person.phoneNumber
    }

    override fun getLayoutId() = R.layout.item_list_view

    override fun getViewModel() = ViewModelProvider(this, factory)[PersonDetailViewModel::class.java]
}