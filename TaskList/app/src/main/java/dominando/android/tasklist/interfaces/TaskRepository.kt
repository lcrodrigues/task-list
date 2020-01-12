package dominando.android.tasklist.interfaces

import dominando.android.tasklist.model.Task

interface TaskRepository {
    fun saveTask(task: Task)
    fun addNewTask(task: Task, listener: AddTaskListener)
    fun fetchTasks(listener: SearchTaskListener)
}