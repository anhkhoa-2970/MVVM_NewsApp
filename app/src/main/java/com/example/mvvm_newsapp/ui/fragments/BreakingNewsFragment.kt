package com.example.mvvm_newsapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_newsapp.R
import com.example.mvvm_newsapp.adapters.NewsAdapter
import com.example.mvvm_newsapp.models.NewsResponce
import com.example.mvvm_newsapp.ui.NewsActivity
import com.example.mvvm_newsapp.ui.NewsViewModel
import com.example.mvvm_newsapp.util.Resource
import kotlinx.android.synthetic.main.fragment_breakingnews.*

class BreakingNewsFragment: Fragment(R.layout.fragment_breakingnews) {

    lateinit var viewModel : NewsViewModel
    lateinit var newsAdapter: NewsAdapter

    val TAG = "BreakingNewsFragment"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
        setUpRecycleView()

        viewModel.breakingNews.observe(viewLifecycleOwner, Observer { response ->
            when(response){
                is Resource.Success ->{
                    hideProgressBar()
                    response.data?.let { NewsResponce ->
                        newsAdapter.differ.submitList(NewsResponce.articles)
                    }
                }
                is Resource.Error ->{
                    hideProgressBar()
                    response.massage?.let { message ->
                        Log.d(TAG,"An occured: $message")
                    }
                }
                is Resource.Loading ->{
                    showProgressBar()
                }
            }
        })
    }

    private fun hideProgressBar(){
        paginationProgressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar(){
        paginationProgressBar.visibility = View.VISIBLE
    }

    private fun setUpRecycleView(){
        newsAdapter = NewsAdapter()
        rvBreakingNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}