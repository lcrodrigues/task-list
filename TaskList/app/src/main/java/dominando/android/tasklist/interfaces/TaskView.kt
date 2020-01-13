package dominando.android.tasklist.interfaces

import dominando.android.tasklist.model.Task

interface TaskView {
    fun markAsDone(position: Int)
    fun onTaskAdded(position: Int)
    fun onTaskRemoved(position: Int)
    fun showTasks(result: List<Task>)
}