package com.example.poemapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "poem_table")
data class poem(
    var Title : String,
    var poem : String,

) {
    @PrimaryKey(autoGenerate = true)
    var id : Int?= null
}
