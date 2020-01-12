package dominando.android.tasklist.model

import java.util.*

data class Task(var id: Long,
                var date: Date,
                var description: String,
                var isDone: Boolean)