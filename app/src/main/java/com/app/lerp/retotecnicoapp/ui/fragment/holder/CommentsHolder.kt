package com.app.lerp.retotecnicoapp.ui.fragment.holder

import android.text.Html
import android.text.Spannable
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.app.lerp.entity.CommentsEntity
import com.app.lerp.retotecnicoapp.databinding.ItemListCommentsBinding


class CommentsHolder constructor(val binding: ItemListCommentsBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        commentsEntity: CommentsEntity,
        onClickComments: (onClickPost: CommentsEntity) -> Unit
    ) {
        val idMessage = "<b>Id : </b> ${commentsEntity.id} "
        binding.textViewId.text = Html.fromHtml(idMessage, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        val titleEmail = "<b>Email : </b> ${commentsEntity.email} "
        binding.textViewTitle.text = Html.fromHtml(titleEmail, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        val bodyMessage = "<b>Body : </b> ${commentsEntity.body} "
        binding.textViewBody.text = Html.fromHtml(bodyMessage, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.itemCardView.setOnClickListener {
            Toast.makeText(binding.root.context, " Data : " + commentsEntity.postId, Toast.LENGTH_SHORT)
                .show()
        }
    }

}

