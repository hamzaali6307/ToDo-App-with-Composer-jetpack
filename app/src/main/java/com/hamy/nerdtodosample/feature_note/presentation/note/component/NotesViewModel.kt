package com.hamy.nerdtodosample.feature_note.presentation.note.component

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamy.nerdtodosample.feature_note.domain.model.Note
import com.hamy.nerdtodosample.feature_note.domain.use_case.NoteUseCase
import com.hamy.nerdtodosample.feature_note.presentation.note.NoteEvent
import com.hamy.nerdtodosample.feature_note.presentation.note.NoteState
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import javax.inject.Inject

@ViewModelScoped
class NotesViewModel @Inject constructor(private val useCase: NoteUseCase) : ViewModel() {
   private  val _state =  mutableStateOf(NoteState())
    val state: State<NoteState> = _state
    private var recentlyDeletedNote : Note? = null
    fun onEvent(noteEvent: NoteEvent) {
        when (noteEvent) {
            is NoteEvent.Order -> {

            }
            is NoteEvent.DeleteNote -> {
                viewModelScope.launch {
                    useCase.deleteNote(noteEvent.note)
                    recentlyDeletedNote = noteEvent.note
                }
            }
            is NoteEvent.RestoreNote ->{

            }
            is NoteEvent.ToggleSectionOrder ->{
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }

        }
    }
}