//나누어 떨어지는 숫자 배열
fun main(args: Array<String>) {
    val arr: IntArray = intArrayOf(2, 36, 1, 3)
    val result: IntArray = solution05(arr, 1)

    for (i in result) {
        println(i)
    }
}

fun solution05(arr: IntArray, divisor: Int): IntArray {
    var answer = intArrayOf()

    for (i in 0 until arr.size) {
        if ((arr[i] % divisor) == 0) {
            answer += arr[i]
        }
    }

    if (answer.size == 0) {
        answer += -1
    }

    answer.sort()

    return answer
}