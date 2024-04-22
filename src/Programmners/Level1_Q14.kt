//두 정수 사이의 합

fun main(args: Array<String>) {
    val result: Long = solution14(3, 5)
    println(result)
}

fun solution14(a: Int, b: Int): Long {
    var answer: Long = 0

    if (a < b) {
        for (i in a..b) {
            answer += i
        }
    } else {
        for (j in a downTo b) {
            answer += j
        }
    }

    return answer
}