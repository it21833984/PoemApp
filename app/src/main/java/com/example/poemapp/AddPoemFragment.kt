package com.example.poemapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.example.poemapp.database.PoemRepository
import com.example.poemapp.database.Poemdb
import com.example.poemapp.database.poem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class AddPoemFragment : Fragment() {


    private lateinit var viewModel:MainActivityData

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_add_poem, container, false)
        val submitbtn:Button = view.findViewById(R.id.submitbtn)
        val backbtn: Button = view.findViewById(R.id.backbtn)
        val addTitle : EditText = view.findViewById(R.id.addtitle)
        val addPoem : EditText = view.findViewById(R.id.addpoem)

    val repository = PoemRepository(Poemdb.getDatabase(requireContext()))

    submitbtn.setOnClickListener{

        val addtitles = addTitle.text.toString()
        val addpoems = addPoem.text.toString()

        if (!areFieldsNullOrEmpty(addtitles,addpoems)){
            CoroutineScope(Dispatchers.IO).launch {
                repository.insert(
                    poem(addtitles,addpoems)
                )
                val data = repository.getAllTodoItems()
                requireActivity().runOnUiThread{
                    viewModel.setData(data)

                    val addtitles = addTitle.text.clear()
                    val addpoems = addPoem.text.clear()

                    Toast.makeText(context,"Data Inserted successfully",Toast.LENGTH_LONG).show()

                }
            }

        }


    }
        backbtn.setOnClickListener{

            val firstFragment = PoemListFragment()
            val transaction : FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.mainlayout,firstFragment)
            transaction.commit()
        }


   return view


    }
    private  fun areFieldsNullOrEmpty(
        addtitles:String?,addpoems:String?
    ):Boolean{
        return addtitles.isNullOrBlank()||
                addpoems.isNullOrBlank()
    }



    }

