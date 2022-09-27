package com.app.lerp.retotecnicoapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.lerp.entity.PostEntity
import com.app.lerp.retotecnicoapp.MainViewModel
import com.app.lerp.retotecnicoapp.base.BaseFragment
import com.app.lerp.retotecnicoapp.databinding.FragmentCommentsBinding
import com.app.lerp.retotecnicoapp.ui.fragment.adapter.CommentsAdapter
import com.app.lerp.retotecnicoapp.ui.fragment.event.CommentsEventResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CommentsFragment : BaseFragment() {

    private lateinit var binding: FragmentCommentsBinding
    private val args: CommentsFragmentArgs by navArgs()
    private val parentViewModel: MainViewModel by activityViewModels()
    private lateinit var adapter: CommentsAdapter
    private var postEntity: PostEntity? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentCommentsBinding.inflate(inflater, container, false)
        return binding.root.apply {
            val postParcel = args.postEntity
            postEntity = postParcel
            parentViewModel.getPostAndComents(postParcel)
            initView()
            initObserver()
        }
    }


    private fun initObserver() {
        showProgressDialog()
        parentViewModel.postComentLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is CommentsEventResult.ShowListComments -> {
                    hideProgressDialog()
                    initAdapter(it)
                }
                is CommentsEventResult.Error -> {
                    hideProgressDialog()

                }
                else -> {
                    hideProgressDialog()
                }
            }
        }
    }

    private fun initAdapter(it: CommentsEventResult.ShowListComments) {
        adapter = CommentsAdapter({ itEntity ->
        }, it.data)
        binding.recycler.adapter = adapter
    }


    private fun initView() {
        binding.textViewTitle.text = postEntity?.title
        binding.textViewName.text = postEntity?.body
        val linearLayoutManager = LinearLayoutManager(requireContext())
        binding.recycler.setHasFixedSize(true)
        binding.recycler.layoutManager = linearLayoutManager
    }

    private fun showDataView(postParcel: PostEntity) {
        parentViewModel.getPostAndComents(postParcel)
    }


}