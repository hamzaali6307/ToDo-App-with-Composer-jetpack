package com.hamy.nerdtodosample.feature_note.presentation.note

import com.hamy.nerdtodosample.feature_note.domain.model.Note
import com.hamy.nerdtodosample.feature_note.domain.util.NotesOrder
import com.hamy.nerdtodosample.feature_note.domain.util.OrderType

data class NoteState(
    val notes : List<Note> = emptyList(),
    val notesOrder: NotesOrder = NotesOrder.Date(OrderType.Decending),
    val isOrderSectionVisible: Boolean = false,
)
