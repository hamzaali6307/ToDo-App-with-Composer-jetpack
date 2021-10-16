package com.hamy.nerdtodosample.feature_note.domain.use_case

import com.hamy.nerdtodosample.feature_note.domain.model.Note
import com.hamy.nerdtodosample.feature_note.domain.repositry.NoteRepositry

 class DeleteNote(private val repositry: NoteRepositry) {

     operator suspend fun invoke(note: Note){
         repositry.deleteNote(note)

     }
}