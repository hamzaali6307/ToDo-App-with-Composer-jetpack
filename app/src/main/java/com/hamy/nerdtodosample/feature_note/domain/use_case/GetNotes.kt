package com.hamy.nerdtodosample.feature_note.domain.use_case

import com.hamy.nerdtodosample.feature_note.domain.model.Note
import com.hamy.nerdtodosample.feature_note.domain.repositry.NoteRepositry
import com.hamy.nerdtodosample.feature_note.domain.util.NotesOrder
import com.hamy.nerdtodosample.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotes(private val noteRepositry: NoteRepositry) {

    operator fun invoke(
        notesOrder : NotesOrder = NotesOrder.Date(OrderType.Ascending)
    ):Flow<List<Note>>{
        return  noteRepositry.getNotes().map { notes ->
            when(notesOrder.orderType){
                is OrderType.Ascending ->{
                    when (notesOrder){
                        is NotesOrder.Date -> notes.sortedBy { it.timeStamp}
                        is NotesOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NotesOrder.Color -> notes.sortedBy { it.color }
                    }
                }
                is OrderType.Decending ->{
                    when (notesOrder){
                        is NotesOrder.Date -> notes.sortedByDescending { it.timeStamp}
                        is NotesOrder.Title -> notes.sortedByDescending { it.title }
                        is NotesOrder.Color -> notes.sortedByDescending { it.color }
                    }
                }
            }
        }
    }
}