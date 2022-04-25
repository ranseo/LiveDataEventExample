package com.example.mediatorlivedataexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mediatorlivedataexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel : MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.viewModel = viewModel
        binding.lifecycleOwner = this


        val adapter = Adapter()

        binding.rec.adapter = adapter

        binding.firstSave.setOnClickListener {
            viewModel.firList.add(binding.firstEt.text.toString())
            viewModel.setFirValue()
            binding.firstEt.text.clear()
        }

        binding.secondSave.setOnClickListener {
            viewModel.secList.add(binding.secondEt.text.toString())
            viewModel.setSecValue()
            binding.secondEt.text.clear()
        }

        viewModel.convert.observe(this, Observer{ event ->
            event.getContentIfNotHandled()?.let{
                Log.i("메인뷰모델","${it}")
                adapter.items = it
                adapter.notifyDataSetChanged()
                Log.i("메인뷰모델","adapter items : ${adapter.items}")
            }
        })


    }
}