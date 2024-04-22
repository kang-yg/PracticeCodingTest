// 내적
fun main(args: Array<String>) {
    val dotProduct: DotProduct = DotProduct()
    println(dotProduct.solution(intArrayOf(1, 2, 3, 4), intArrayOf(-3, -1, 0, 2)))
    println(dotProduct.solution(intArrayOf(-1, 0, 1), intArrayOf(1, 0, -1)))
}

class DotProduct {
    fun solution(a: IntArray, b: IntArray): Int {
        var answer: Int = 0
        for (i in a.indices) {
            answer += a[i] * b[i]
        }
        return answer
//        return a.zip(b).map { it.first * it.second }.sum()
    }
}