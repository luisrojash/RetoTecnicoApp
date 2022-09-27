package com.app.lerp.retotecnicoapp.ui.fragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.lerp.entity.PostEntity
import com.app.lerp.retotecnicoapp.databinding.ItemListPostBinding
import com.app.lerp.retotecnicoapp.ui.fragment.holder.ListPostHolder

class ListPostAdapter(
    private var items: List<PostEntity>,
) : RecyclerView.Adapter<ListPostHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListPostHolder {

        return ListPostHolder(
            ItemListPostBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ListPostHolder, position: Int) {
        val postList = items[position]
        holder.bind(postList)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

