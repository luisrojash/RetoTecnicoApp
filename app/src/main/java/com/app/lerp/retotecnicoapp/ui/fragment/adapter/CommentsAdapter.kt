package com.app.lerp.retotecnicoapp.ui.fragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.lerp.entity.CommentsEntity
import com.app.lerp.entity.PostEntity
import com.app.lerp.retotecnicoapp.databinding.ItemListCommentsBinding
import com.app.lerp.retotecnicoapp.databinding.ItemListPostBinding
import com.app.lerp.retotecnicoapp.ui.fragment.holder.CommentsHolder
import com.app.lerp.retotecnicoapp.ui.fragment.holder.PostHolder

class CommentsAdapter(
    private var onClickComments: (route: CommentsEntity) -> Unit,
    private var items: List<CommentsEntity>,
) : RecyclerView.Adapter<CommentsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsHolder {

        return CommentsHolder(
            ItemListCommentsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CommentsHolder, position: Int) {
        val coments = items[position]
        holder.bind(coments,onClickComments)
    }
}

