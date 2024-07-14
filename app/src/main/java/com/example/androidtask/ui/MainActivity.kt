package com.example.androidtask.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtask.databinding.ActivityMainBinding
import com.example.routetask.ui.ProductAdapter
import com.example.routetask.ui.ProductViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ProductAdapter
    private val viewModel: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = ProductAdapter()
        viewModel.getProduct()
        viewModel.productLiveData.observe(
            this
        ) {
            adapter.setData(it)
        }
        binding.rv.adapter = adapter

    }
}