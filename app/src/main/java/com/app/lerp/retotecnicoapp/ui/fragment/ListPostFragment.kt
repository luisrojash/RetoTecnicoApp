package com.app.lerp.retotecnicoapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.app.lerp.retotecnicoapp.R
import com.app.lerp.retotecnicoapp.base.BaseFragment
import com.app.lerp.retotecnicoapp.databinding.FragmentListPostBinding

class ListPostFragment : BaseFragment() {

    private lateinit var binding: FragmentListPostBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentListPostBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}