package dominando.android.tasklist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dominando.android.tasklist.R
import dominando.android.tasklist.dateToString
import dominando.android.tasklist.model.Task
import kotlinx.android.synthetic.main.task_list_item.view.*

class TaskListAdapter(
    private var taskList: List<Task>,
    private val callback: (Int, Boolean) -> Unit): RecyclerView.Adapter<TaskListAdapter.TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.task_list_item, parent, false)
        val viewHolder = TaskViewHolder(v)

        viewHolder.itemView.checkIsDone.setOnClickListener {
            val position = viewHolder.adapterPosition
            val isMarked = viewHolder.itemView.checkIsDone.isChecked

            callback(position, isMarked)
        }

        return viewHolder
    }

    override fun getItemCount(): Int = taskList.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val item = taskList[position]

        holder.description.text = item.description
        holder.stringDate.text = dateToString(item.date)
        holder.checkIsDone.isChecked = item.isDone

        holder.disableCell.visibility = if(item.isDone) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val description: TextView = view.textDescription
        val stringDate: TextView = view.textDate
        val checkIsDone: CheckBox = view.checkIsDone
        val disableCell: View = view.viewDisable
    }

}