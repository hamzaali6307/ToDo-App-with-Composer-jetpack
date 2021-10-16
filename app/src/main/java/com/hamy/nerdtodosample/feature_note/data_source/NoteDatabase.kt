package com.hamy.nerdtodosample.feature_note.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hamy.nerdtodosample.feature_note.domain.model.Note

@Database(
    entities = [Note::class],
    version = 1
  )

abstract class NoteDatabase: RoomDatabase() {
    abstract val dao : NotesDao

   companion object{
       const val DATABASE_NAME = "notes_db"
   }
}