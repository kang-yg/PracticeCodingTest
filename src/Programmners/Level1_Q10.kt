//자릿수 더하기
fun main(args: Array<String>) {
    val result: Int = solution10(987)

    println(result)
}

fun solution10(n: Int): Int {
    var answer = 0

    val charArr: CharArray = n.toString().toCharArray()

    for (i in 0 until charArr.size) {
        answer += charArr[i].toString().toInt()
    }

    return answer
}