//문자열을 정수로 바꾸기
fun main(args: Array<String>) {
    val result: Int = solution08("-1324")

    print(result)
}

fun solution08(s: String): Int {
    var answer = 0

    answer = s.toInt()

    return answer
}