package dominando.android.tasklist.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import dominando.android.tasklist.MemoryRepository

import dominando.android.tasklist.R
import dominando.android.tasklist.adapters.TaskListAdapter
import dominando.android.tasklist.hideKeyboard
import dominando.android.tasklist.interfaces.TaskView
import dominando.android.tasklist.model.Task
import dominando.android.tasklist.presenter.TaskPresenter
import kotlinx.android.synthetic.main.fragment_task_list.*
import java.util.*

class TaskListFragment : Fragment(), TaskView {
    private val presenter = TaskPresenter(this, MemoryRepository)
    private lateinit var taskAdapter: TaskListAdapter

    override fun markAsDone() {}

    override fun onTaskAdded(position: Int) {
        recyclerTaskList.smoothScrollToPosition(position)
        taskAdapter.notifyItemInserted(position)
    }

    override fun showTasks(result: List<Task>) {
        taskAdapter = TaskListAdapter(result)
        initRecyclerView()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_task_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.fetch()
        setupButton()
        textNewTask.clearFocus()

        super.onViewCreated(view, savedInstanceState)
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(activity)

        recyclerTaskList.apply {
            this.adapter = taskAdapter
            this.layoutManager = layoutManager
        }
    }

    private fun setupButton() {
        fabAddTask.setOnClickListener {
            if (textNewTask.text.isNotEmpty() && textNewTask.text.isNotBlank()) {
                val taskDescription = textNewTask.text.toString()
                val task = Task(0L, Calendar.getInstance().time, taskDescription, false)

                presenter.add(task)
                textNewTask.text.clear()
                textNewTask.clearFocus()
                hideKeyboard(activity as MainActivity, textNewTask.rootView)
            }
        }
    }
}
