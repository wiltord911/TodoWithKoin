package com.avatarcode.todoappwithkoin

import android.app.Application
import androidx.room.Room
import com.avatarcode.todoappwithkoin.database.TodoDatabase
import com.avatarcode.todoappwithkoin.repository.TodoRepository
import com.avatarcode.todoappwithkoin.repository.TodoRepositoryIpml
import org.koin.core.context.startKoin
import org.koin.dsl.bind
import org.koin.dsl.module

class KoinApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                module {
                    single {
                        Room.databaseBuilder(this@KoinApp, TodoDatabase::class.java, "dbTodoKoin").build()
                    }
                    single {
                        TodoRepositoryIpml(db = get())
                    } bind TodoRepository::class
                }
            )
        }
    }

}