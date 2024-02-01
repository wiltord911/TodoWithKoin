package com.avatarcode.todoappwithkoin.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.avatarcode.todoappwithkoin.database.TodoEntity
import com.avatarcode.todoappwithkoin.repository.TodoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModel: ViewModel(),KoinComponent {

    private  val repo:TodoRepository by inject()

    private val _todos:MutableStateFlow<List<TodoEntity>> = MutableStateFlow(emptyList())
    val todos = _todos.asStateFlow()

    init {
        getTodos()
    }

    private fun getTodos(){
        viewModelScope.launch(Dispatchers.IO) {
            repo.getTodos().collect{data ->
                _todos.update { data }
            }
        }
    }

    fun updateTodo(todo : TodoEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repo.updateTodo(todo)
        }
    }

    fun deleteTodo(todo : TodoEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repo.deleteTode(todo)
        }
    }

    fun addTodo(todo : TodoEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repo.addTodo(todo)
        }
    }

}