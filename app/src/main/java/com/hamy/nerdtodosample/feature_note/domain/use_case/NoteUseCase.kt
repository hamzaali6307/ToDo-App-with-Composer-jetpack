package com.hamy.nerdtodosample.feature_note.domain.use_case

data class NoteUseCase(
    val getNotes: GetNotes,
    val deleteNote: DeleteNote
)
