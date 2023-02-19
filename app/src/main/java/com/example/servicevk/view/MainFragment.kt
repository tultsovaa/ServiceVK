package com.example.servicevk.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.servicevk.R
import com.example.servicevk.ServiceAdapter
import com.example.servicevk.databinding.ServiceFragmentBinding
import com.example.servicevk.viewmodel.ServiceViewModel


class MainFragment: Fragment() {
    private lateinit var binding: ServiceFragmentBinding
    private lateinit var viewModel: ServiceViewModel
    private lateinit var movieAdapter: ServiceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.main_fragment, container, false);

        val rv: RecyclerView = root.findViewById(R.id.recycler)
        rv.setHasFixedSize(true)
        val lm: RecyclerView.LayoutManager = GridLayoutManager(requireActivity(), 2)
        rv.layoutManager = lm
        val adapterCards = ServiceAdapter()
        rv.adapter = adapterCards

        viewModel = ViewModelProvider(this)[ServiceViewModel::class.java]
        viewModel.getServiceInfo()
        viewModel.observeServiceLiveData().observe(requireActivity(), Observer { movieList ->
            movieAdapter.setServiceList(movieList)
        })
        return root
    }
}