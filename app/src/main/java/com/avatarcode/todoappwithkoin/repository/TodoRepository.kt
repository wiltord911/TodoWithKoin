package com.avatarcode.todoappwithkoin.repository

import com.avatarcode.todoappwithkoin.database.TodoDao
import com.avatarcode.todoappwithkoin.database.TodoEntity
import kotlinx.coroutines.flow.Flow

interface TodoRepository {

    suspend fun getTodos():Flow<List<TodoEntity>>
    suspend fun addTodo(todo:TodoEntity)
    suspend fun updateTodo(todo:TodoEntity)
    suspend fun deleteTode(todo:TodoEntity)

}