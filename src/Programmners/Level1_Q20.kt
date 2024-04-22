//정수 내림차순으로 배치하기
fun main(args: Array<String>) {
    val result : Long = solution20(118372)
    println(result)
}

fun solution20(n: Long): Long {
    var answer: Long = 0
    var charArr : CharArray = charArrayOf()

    charArr = n.toString().toCharArray()
    charArr.sortDescending()

    answer = String(charArr).toLong()

    return answer
}