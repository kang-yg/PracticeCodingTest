//정수 제곱근 판별
fun main(args: Array<String>) {
    val result: Long = solution21(121)
    println(result)
}

fun solution21(n: Long): Long {
    var answer: Long = 0
    var temp: Long = Math.sqrt(n.toDouble()).toLong()

    answer = if ((temp * temp) == n) (temp + 1) * (temp + 1) else -1


//    answer = if (Math.pow(Math.sqrt(n.toDouble()), 2.toDouble()) == n.toDouble()) Math.pow(Math.sqrt(n.toDouble()) + 1, 2.toDouble()).toLong() else -1

    return answer
}
