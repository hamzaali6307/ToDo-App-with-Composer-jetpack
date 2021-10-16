package com.hamy.nerdtodosample.di

import android.app.Application
import androidx.room.Dao
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hamy.nerdtodosample.feature_note.data_source.NoteDatabase
import com.hamy.nerdtodosample.feature_note.data_source.Repositry.NoteRepositryImp
import com.hamy.nerdtodosample.feature_note.domain.repositry.NoteRepositry
import com.hamy.nerdtodosample.feature_note.domain.use_case.DeleteNote
import com.hamy.nerdtodosample.feature_note.domain.use_case.GetNotes
import com.hamy.nerdtodosample.feature_note.domain.use_case.NoteUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppModule {

    @Provides
    @Singleton
    fun provideNotDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepositry(noteDatabase: NoteDatabase): NoteRepositry {
        return NoteRepositryImp(noteDatabase.dao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCase(noteRepositry: NoteRepositry): NoteUseCase {
        return NoteUseCase(
            getNotes = GetNotes(noteRepositry),
            deleteNote = DeleteNote(noteRepositry)
        )
    }
}