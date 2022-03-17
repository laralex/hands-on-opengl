package com.laralex.handson_opengl.android.fragment_gpu

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.laralex.handson_opengl.R

class GpuFragment : Fragment() {

    companion object {
        fun newInstance() = GpuFragment()
    }

    private lateinit var viewModel: GpuViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gpu, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GpuViewModel::class.java)
        // TODO: Use the ViewModel
    }

}