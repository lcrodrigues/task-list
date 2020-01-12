package dominando.android.tasklist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dominando.android.tasklist.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showTaskListFragment()
    }

    private fun showTaskListFragment() {
        val fragment = TaskListFragment()
        supportFragmentManager.
            beginTransaction().
            replace(R.id.frameParent, fragment, "TAG").
            commit()
    }
}
