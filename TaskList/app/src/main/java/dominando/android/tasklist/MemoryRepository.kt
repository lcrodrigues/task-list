package dominando.android.tasklist

import dominando.android.tasklist.interfaces.AddTaskListener
import dominando.android.tasklist.interfaces.SearchTaskListener
import dominando.android.tasklist.interfaces.TaskRepository
import dominando.android.tasklist.model.Task
import java.util.*

object MemoryRepository : TaskRepository {

    private var nextId = 1L
    private var taskList = mutableListOf<Task>()

    init {
        saveTask(Task(0L, Calendar.getInstance().time, "Caminhar na costa.", false))
        saveTask(Task(0L, Calendar.getInstance().time, "Banho de mar.", false))
        saveTask(Task(0L, Calendar.getInstance().time, "Jogar futebol.", false))
    }

    override fun saveTask(task: Task) {
        if(task.id == 0L) {
            task.id = nextId++
            taskList.add(task)
        } else {
            val index = taskList.indexOfFirst { it.id == task.id }

            if(index > -1) {
                taskList[index] = task
            } else {
                taskList.add(task)
            }

        }
    }

    override fun addNewTask(task: Task, listener: AddTaskListener) {
        saveTask(task)
        listener.onAddTask(taskList.lastIndex)
    }

    override fun fetchTasks(listener: SearchTaskListener) {
        listener.onTasksFetched(taskList)
    }

}