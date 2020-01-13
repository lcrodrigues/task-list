package dominando.android.tasklist

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import java.util.*

fun dateToString(date: Date) : String {
    val calendar = Calendar.getInstance()
    calendar.time = date

    val day = calendar.get(Calendar.DAY_OF_MONTH)
    val month = calendar.get(Calendar.MONTH)
    return "$day/${calendarMonthToString(month)}"
}

fun calendarMonthToString(month: Int) : String {
    return when(month) {
        0 -> "01"
        1 -> "02"
        2 -> "03"
        3 -> "04"
        4 -> "05"
        5 -> "06"
        6 -> "07"
        7 -> "08"
        8 -> "09"
        9 -> "10"
        10 -> "11"
        11 -> "12"
        else -> "--"
    }
}

fun hideKeyboard(context: Context, view: View) {
    val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}