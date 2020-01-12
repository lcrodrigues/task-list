package dominando.android.tasklist.interfaces

import dominando.android.tasklist.model.Task

interface TaskView {
    fun markAsDone()
    fun onTaskAdded(position: Int)
    fun showTasks(result: List<Task>)
}