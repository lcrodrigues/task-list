package dominando.android.tasklist

import dominando.android.tasklist.interfaces.*
import dominando.android.tasklist.model.Task
import java.util.*

object MemoryRepository : TaskRepository {

    private var nextId = 1L
    private var taskList = mutableListOf<Task>()

    init {
        saveTask(Task(0L, Calendar.getInstance().time, "Tarefa 1.", false))
        saveTask(Task(0L, Calendar.getInstance().time, "Tarefa 2.", false))
        saveTask(Task(0L, Calendar.getInstance().time, "Tarefa 3.", false))
    }

    override fun saveTask(task: Task) {
        if (task.id == 0L) {
            task.id = nextId++
            taskList.add(task)
        } else {
            val index = taskList.indexOfFirst { it.id == task.id }

            if (index > -1) {
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

    override fun markTask(position: Int, isDone: Boolean, listener: MarkTaskListener) {
        val markedTask = taskList[position]
        markedTask.isDone = isDone
        saveTask(markedTask)

        listener.onMarkedTask()
    }

    override fun removeTask(position: Int, listener: RemoveTaskListener) {
        taskList.removeAt(position)
        listener.onRemovedTask()
    }

    override fun fetchTasks(listener: SearchTaskListener) {
        listener.onTasksFetched(taskList)
    }
}