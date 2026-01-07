package com.example.mytodoapp_mvvm.ui.add_edit_todo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytodoapp_mvvm.data.Todo
import com.example.mytodoapp_mvvm.data.TodoRepository
import com.example.mytodoapp_mvvm.ui.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AddEditTodoViewModel @Inject constructor(
    private val repository: TodoRepository,
    savedStateHandle: SavedStateHandle
) :ViewModel() {

        var todo by mutableStateOf< Todo?>(null)
    private set

    var title by mutableStateOf("")
        private set

    var description by mutableStateOf("")
        private set

    private val _uiEvent = Channel<UiEvent>()

    val uiEvent = _uiEvent.receiveAsFlow()

    init {
         val todoid = savedStateHandle.get<Int>("todoId")!!
        if (todoid != -1){
            viewModelScope.launch {
                repository.getTodoById(todoid)?.let {    tod->

                    title = tod.title

                    description = tod.description ?: ""
                    this@AddEditTodoViewModel.todo = tod
                }

            }
        }
    }


    fun onEvent(event: UiEvent)
}