package com.example.task.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import task.R
import task.databinding.ItemListViewBinding
import com.bumptech.glide.Glide
import com.example.task.data.service.model.Person

class PeopleAdapter(
    private var people: ArrayList<Person>,
    private val onClick: (person: Person) -> Unit
) : RecyclerView.Adapter<PeopleAdapter.FormAListViewHolder>() {

    class FormAListViewHolder(private val itemListViewBinding: ItemListViewBinding) :
        RecyclerView.ViewHolder(itemListViewBinding.root) {
        fun bind(
            person: Person,
            onClick: (Person) -> Unit
        ) {
            Glide.with(itemListViewBinding.root.context)
                .load("https://people.epfl.ch/private/common/photos/links/268072.jpg")
                .into(itemListViewBinding.profileImage)
            itemListViewBinding.name.text = person.name
            itemListViewBinding.email.text = person.email
            itemListViewBinding.position.text = person.position
            itemListViewBinding.office.text = person.office
            itemListViewBinding.phoneNumber.text = person.phoneNumber

            itemListViewBinding.root.setOnClickListener {
                onClick.invoke(person)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FormAListViewHolder(
            ItemListViewBinding.bind(
                LayoutInflater.from(parent.context).inflate(R.layout.item_list_view, parent, false)
            )
        )

    override fun onBindViewHolder(holder: FormAListViewHolder, position: Int) {
        holder.bind(people[position], onClick)
    }

    override fun getItemCount() = people.size
}