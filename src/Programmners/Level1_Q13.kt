//2016년

import java.text.SimpleDateFormat
import java.util.*

fun main(args: Array<String>) {
    val result: String = solution13(10, 24)

    println(result)
}

fun solution13(a: Int, b: Int): String {
    var answer = ""

    val dateFormat: SimpleDateFormat = SimpleDateFormat("yyyyMMdd")
    val date: Date = if (a < 10) dateFormat.parse("2016".plus(0).plus(a).plus(b)) else dateFormat.parse("2016".plus(a).plus(b))

    val calendar: Calendar = Calendar.getInstance()
    calendar.time = date

    val flag: Int = calendar.get(Calendar.DAY_OF_WEEK)

    when (flag) {
        1 -> {
            answer = "SUN"
        }

        2 -> {
            answer = "MON"
        }

        3 -> {
            answer = "TUE"
        }

        4 -> {
            answer = "WED"
        }

        5 -> {
            answer = "THU"
        }

        6 -> {
            answer = "FRI"
        }

        7 -> {
            answer = "SAT"
        }
    }

    return answer
}