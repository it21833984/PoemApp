package com.example.poemapp


import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.poemapp.database.PoemRepository
import com.example.poemapp.database.poem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PoemAdapter(items:List<poem>,repository: PoemRepository,viewModel: MainActivityData) : RecyclerView.Adapter<PoemViewHolder>(){

    var context : Context? = null
    val items = items
    val repository = repository
    val viewModel = viewModel

    private val colors = arrayOf("#FBCEB1","#FFD580", "#FFD580", "#FFDEAD", "#FFF5EE")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PoemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.a_poem_record,parent,false)
        context = parent.context
        return PoemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  items.size
    }

    override fun onBindViewHolder(holder: PoemViewHolder, position: Int) {

        val record = items[position]
        val color = colors[position % colors.size]

        holder.showtitle.text = "${record.Title}"
        holder.showPoem.text = "${record.poem}"
        holder.layout.setBackgroundColor(Color.parseColor(color))
        holder.DeleteBtn.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                repository.delete(items.get(position))
                val data = repository.getAllTodoItems()
                withContext(Dispatchers.Main){
                    viewModel.setData(data)
                }
            }
        }


    }


}