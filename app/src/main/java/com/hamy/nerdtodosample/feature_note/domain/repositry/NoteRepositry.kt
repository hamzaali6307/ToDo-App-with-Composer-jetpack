package com.hamy.nerdtodosample.feature_note.domain.repositry

import com.hamy.nerdtodosample.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepositry {

    fun getNotes() : Flow<List<Note>>

    suspend fun insetNote(note: Note)

    suspend fun deleteNote(note: Note)

    suspend fun getNoteById(id:Int):Note?



}