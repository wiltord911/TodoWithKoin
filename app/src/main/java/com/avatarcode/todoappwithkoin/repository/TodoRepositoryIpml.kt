package com.avatarcode.todoappwithkoin.repository

import com.avatarcode.todoappwithkoin.database.TodoDao
import com.avatarcode.todoappwithkoin.database.TodoDatabase
import com.avatarcode.todoappwithkoin.database.TodoEntity
import kotlinx.coroutines.flow.Flow

class TodoRepositoryIpml(private val db:TodoDatabase) : TodoRepository {

    private  val dao : TodoDao = db.todoDao()

    override suspend fun getTodos(): Flow<List<TodoEntity>> =dao.getTodos()

    override suspend fun addTodo(todo: TodoEntity) = dao.addTodo(todo)

    override suspend fun updateTodo(todo: TodoEntity) = dao.updateTodo(todo)

    override suspend fun deleteTode(todo: TodoEntity) =  dao.deleteTodo(todo)
}