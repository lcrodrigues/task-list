package dominando.android.tasklist.interfaces

import dominando.android.tasklist.model.Task

interface SearchTaskListener {
    fun onTasksFetched(result: List<Task>)
}