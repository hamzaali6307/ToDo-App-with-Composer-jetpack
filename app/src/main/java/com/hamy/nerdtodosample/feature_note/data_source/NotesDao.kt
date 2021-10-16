package com.hamy.nerdtodosample.feature_note.data_source

import androidx.room.*
import com.hamy.nerdtodosample.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {

    @Query("SELECT * FROM note")
    fun getNotes(): Flow<List<Note>>

    @Query("SELECT * FROM note WHERE id = :id")
    suspend fun getNoteById(id: Int): Note?

    @Delete
    suspend fun deleteNote(note: Note)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)


}