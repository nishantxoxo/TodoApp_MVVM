package com.example.mytodoapp_mvvm.ui.todo_list

import com.example.mytodoapp_mvvm.data.Todo

sealed class TodoListEvent {
        data class DeleteTodo(val todo: Todo): TodoListEvent()

        data class onDoneChange(val todo: Todo, val isDone: Boolean): TodoListEvent()

        object OnUndoDeleteClick: TodoListEvent()

    data class onTodoClick(val todo: Todo): TodoListEvent()

    object onAddTodoClick: TodoListEvent()


}