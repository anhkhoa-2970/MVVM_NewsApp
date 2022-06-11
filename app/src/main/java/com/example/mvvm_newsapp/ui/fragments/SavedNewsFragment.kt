package com.example.mvvm_newsapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.mvvm_newsapp.R
import com.example.mvvm_newsapp.ui.NewsActivity
import com.example.mvvm_newsapp.ui.NewsViewModel

class SavedNewsFragment: Fragment(R.layout.fragment_breakingnews) {

    lateinit var viewModel : NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
    }
}