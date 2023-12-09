package com.example.poemapp.database

class PoemRepository(private val db : Poemdb){


    suspend fun insert(poem: poem) = db.getPoemDao().insert(poem)
    suspend fun delete(poem: poem) = db.getPoemDao().delete(poem)
    fun getAllTodoItems():List<poem> = db.getPoemDao().getAllPoems()



}