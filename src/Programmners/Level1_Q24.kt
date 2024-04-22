// 최대공약수와 최소공배수
fun main(args: Array<String>) {
    val result: IntArray = solution24(3, 12)
}

fun solution24(n: Int, m: Int): IntArray {
    var answer = intArrayOf()

    answer += n.toBigInteger().gcd(m.toBigInteger()).toInt()
    answer += (n * m) / n.toBigInteger().gcd(m.toBigInteger()).toInt()

    return answer
}