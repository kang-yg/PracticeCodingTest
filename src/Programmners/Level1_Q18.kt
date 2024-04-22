//약수의 합
fun main(args: Array<String>) {
    val result: Int = solution18(12)
    println(result)
}

fun solution18(n: Int): Int {
    var answer = 0

    for (i in 1..n) {
        if ((n % i) == 0) {
            answer += i
        }
    }

    return answer
}