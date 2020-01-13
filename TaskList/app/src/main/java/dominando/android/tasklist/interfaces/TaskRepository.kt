package dominando.android.tasklist.interfaces

import dominando.android.tasklist.model.Task

interface TaskRepository {
    fun saveTask(task: Task)
    fun addNewTask(task: Task, listener: AddTaskListener)
    fun markTask(position: Int, isDone: Boolean, listener: MarkTaskListener)
    fun removeTask(position: Int, listener: RemoveTaskListener)
    fun fetchTasks(listener: SearchTaskListener)
}