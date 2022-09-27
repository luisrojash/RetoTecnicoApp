package com.app.lerp.retotecnicoapp

import android.content.Intent
import android.os.Bundle
import com.app.lerp.retotecnicoapp.base.BaseActivity
import com.app.lerp.retotecnicoapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {


    private lateinit var binding : ActivityMainBinding

    override fun startCreateViewBinding(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun getDataActivityForResult(data: Intent?) {

    }

    override fun initView() {
    }

    override fun initViewModel() {
    }

}