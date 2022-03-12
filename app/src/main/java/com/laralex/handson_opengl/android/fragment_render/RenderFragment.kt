package com.laralex.handson_opengl.android.fragment_render

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.laralex.handson_opengl.R

class RenderFragment : Fragment() {

    companion object {
        fun newInstance() = RenderFragment()
    }

    private lateinit var viewModel: RenderViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_render, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RenderViewModel::class.java)
        // TODO: Use the ViewModel
    }

}