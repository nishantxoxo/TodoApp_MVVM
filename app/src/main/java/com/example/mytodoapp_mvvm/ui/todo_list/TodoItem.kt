package com.example.mytodoapp_mvvm.ui.todo_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mytodoapp_mvvm.data.Todo


@Composable
fun TodoItem(todo: Todo, onEvent: (TodoListEvent)-> Unit,
             modifier: Modifier = Modifier
             ) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Column(modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
            ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text( text = todo.title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                    )

                Spacer(modifier = Modifier.width(8.dp))
                IconButton(onClick = {
                    onEvent(TodoListEvent.DeleteTodo(todo))

                }) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")

                }
            }
            todo.description?.let {

                Spacer(Modifier.height(8.dp))
                Text(text = it)
            }

        }
        Checkbox(checked = todo.isDone, onCheckedChange = {
            x-> onEvent(TodoListEvent.onDoneChange(todo  , x))
        })
    }


}