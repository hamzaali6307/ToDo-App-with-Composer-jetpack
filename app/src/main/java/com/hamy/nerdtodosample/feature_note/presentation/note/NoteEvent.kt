package com.hamy.nerdtodosample.feature_note.presentation.note

import com.hamy.nerdtodosample.feature_note.domain.model.Note
import com.hamy.nerdtodosample.feature_note.domain.util.NotesOrder

sealed class NoteEvent {
    data class Order(val order: NotesOrder) : NoteEvent()
    data class DeleteNote(val note: Note) : NoteEvent()
    object RestoreNote : NoteEvent()
    object ToggleSectionOrder: NoteEvent()



}

