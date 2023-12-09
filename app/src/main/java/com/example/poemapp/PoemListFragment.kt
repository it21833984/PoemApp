package com.example.poemapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.poemapp.database.PoemRepository
import com.example.poemapp.database.Poemdb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.concurrent.fixedRateTimer


class PoemListFragment : Fragment() {
    private lateinit var adapter: PoemAdapter
    private lateinit var viewModel: MainActivityData

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_poem_list, container, false)
        val button: Button = view.findViewById(R.id.btnadd)

        button.setOnClickListener{
            val secondFragment = AddPoemFragment()
            val transaction : FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.mainlayout,secondFragment)
            transaction.commit()
        }
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerviewshow)
        val repository = PoemRepository(Poemdb.getDatabase(requireContext()))

        viewModel = ViewModelProvider(requireActivity())[MainActivityData::class.java]

        viewModel.data.observe(requireActivity()) {
            requireActivity().runOnUiThread {
                adapter = PoemAdapter(it, repository, viewModel)
                recyclerView.adapter = adapter
                recyclerView.layoutManager = LinearLayoutManager(context)
            }
        }
        CoroutineScope(Dispatchers.IO).launch {
            val data = repository.getAllTodoItems()
            requireActivity().runOnUiThread {
                viewModel.setData(data)

            }
        }
        return view
    }
}
