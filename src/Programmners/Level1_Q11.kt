//자연수 뒤집어 배열로 만들기
fun main(args: Array<String>) {
    val result: IntArray = solution11(12345)

    println(result[0])

}

fun solution11(n: Long): IntArray {
    var answer = intArrayOf()

    var charArray: CharArray = n.toString().toCharArray()

    charArray.reverse()

    for (i in 0 until charArray.size) {
        answer += charArray[i].toString().toInt()
    }

    return answer
}