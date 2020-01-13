package dominando.android.tasklist.presenter

import dominando.android.tasklist.interfaces.*
import dominando.android.tasklist.model.Task

class TaskPresenter(
    val view: TaskView,
    private val repository: TaskRepository
) {

    fun add(task: Task) {
        repository.addNewTask(task, object : AddTaskListener {
            override fun onAddTask(position: Int) {
                view.onTaskAdded(position)
            }
        })
    }

    fun mark(position: Int, isDone: Boolean) {
        repository.markTask(position, isDone, object : MarkTaskListener {
            override fun onMarkedTask() {
                view.markAsDone(position)
            }
        })
    }

    fun remove(position: Int) {
       repository.removeTask(position, object : RemoveTaskListener {
           override fun onRemovedTask() {
                view.onTaskRemoved(position)
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