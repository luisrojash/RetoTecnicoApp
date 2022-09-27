package com.app.lerp.retotecnicoapp.ui.fragment.holder

import android.text.Html
import android.text.Spannable
import androidx.recyclerview.widget.RecyclerView
import com.app.lerp.entity.PostEntity
import com.app.lerp.retotecnicoapp.databinding.ItemListPostBinding


class PostHolder constructor(val binding: ItemListPostBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(postList: PostEntity, onClickdPost: (onClickPost: PostEntity) -> Unit) {
        val idMessage = "<b>Id : </b> ${postList.id} "
        binding.textViewId.text = Html.fromHtml(idMessage, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        val titleMessage = "<b>Title : </b> ${postList.title} "
        binding.textViewTitle.text = Html.fromHtml(titleMessage, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        val bodyMessage = "<b>Body : </b> ${postList.body} "
        binding.textViewBody.text =  Html.fromHtml(bodyMessage, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.itemCardView.setOnClickListener {
            onClickdPost.invoke(postList)
        }
    }

}

