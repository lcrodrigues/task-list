package dominando.android.tasklist.presenter

import android.util.Log
import dominando.android.tasklist.interfaces.AddTaskListener
import dominando.android.tasklist.interfaces.SearchTaskListener
import dominando.android.tasklist.interfaces.TaskRepository
import dominando.android.tasklist.interfaces.TaskView
import dominando.android.tasklist.model.Task

class TaskPresenter(
    val view: TaskView,
    val repository: TaskRepository
) {

    fun add(task: Task) {
        repository.addNewTask(task, object : AddTaskListener {
            override fun onAddTask(position: Int) {
                view.onTaskAdded(position)
            }
        })
    }

    fun fetch() {
        repository.fetchTasks(object : SearchTaskListener {
            override fun onTasksFetched(result: List<Task>) {
                view.showTasks(result)
            }
        })
    }
}