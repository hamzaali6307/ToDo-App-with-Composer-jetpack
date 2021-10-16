package com.hamy.nerdtodosample.feature_note.data_source.Repositry

import com.hamy.nerdtodosample.feature_note.data_source.NotesDao
import com.hamy.nerdtodosample.feature_note.domain.model.Note
import com.hamy.nerdtodosample.feature_note.domain.repositry.NoteRepositry
import kotlinx.coroutines.flow.Flow

class NoteRepositryImp(private val dao: NotesDao) : NoteRepositry {
    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun insetNote(note: Note) {
        dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note)
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)
    }
}