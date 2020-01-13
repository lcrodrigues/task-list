package dominando.android.tasklist.interfaces

import dominando.android.tasklist.model.Task

interface TaskRepository {
    fun saveTask(task: Task)
    fun addNewTask(task: Task, listener: AddTaskListener)
    fun markTask(position: Int, isDone: Boolean, listener: MarkTaskListener)
    fun fetchTasks(listener: SearchTaskListener)
}