package com.hamy.nerdtodosample.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hamy.nerdtodosample.ui.theme.*

@Entity
data class Note(
    var title :String ,
    var content: String,
    var timeStamp : Long,
    var color : Int,
    @PrimaryKey val id : Int? = null
){
    companion object{
        val noteColors = listOf( Red100, Green100, Teal200, Yellow100, Purple800)
    }
}
