package com.app.lerp.retotecnicoapp.ui.fragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.lerp.entity.PostEntity
import com.app.lerp.retotecnicoapp.databinding.ItemListPostBinding
import com.app.lerp.retotecnicoapp.ui.fragment.holder.PostHolder

class PostAdapter(
    private var onClickPost: (route: PostEntity) -> Unit,
    private var items: List<PostEntity>,
) : RecyclerView.Adapter<PostHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {

        return PostHolder(
            ItemListPostBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        val postList = items[position]
        holder.bind(postList,onClickPost)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

