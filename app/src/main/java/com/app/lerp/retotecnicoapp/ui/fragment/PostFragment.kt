package com.app.lerp.retotecnicoapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.lerp.entity.PostEntity
import com.app.lerp.retotecnicoapp.MainViewModel
import com.app.lerp.retotecnicoapp.base.BaseFragment
import com.app.lerp.retotecnicoapp.databinding.FragmentListPostBinding
import com.app.lerp.retotecnicoapp.ui.fragment.adapter.PostAdapter
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.fragment.findNavController

@AndroidEntryPoint
class PostFragment : BaseFragment() {

    private lateinit var binding: FragmentListPostBinding
    private val parentViewModel: MainViewModel by activityViewModels()
    private lateinit var adapter: PostAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentListPostBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parentViewModel.getListPost()
        initView()
        initObserver()
    }

    private fun initView() {
        val linearLayoutManager = LinearLayoutManager(requireContext())
        binding.recycler.setHasFixedSize(true)
        binding.recycler.layoutManager = linearLayoutManager

    }

    private fun initObserver() {
        showProgressDialog()
        parentViewModel.postLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is PostEventResult.ShowListPost -> {
                    hideProgressDialog()
                    initAdapter(it)
                }
                is PostEventResult.Error -> {
                    hideProgressDialog()

                }
                else -> {
                    hideProgressDialog()
                }
            }
        }

    }

    private fun initAdapter(it: PostEventResult.ShowListPost) {
        adapter = PostAdapter({ itEntity ->
            initStartCommentFragment(itEntity)
        }, it.data)
        binding.recycler.adapter = adapter
    }

    private fun initStartCommentFragment(itEntity: PostEntity) {
       // findNavController().navigate(PlaceListFragmentDirections.actionPlaceListFragmentToPlaceDetailFragment())
    }


}