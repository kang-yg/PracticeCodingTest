//행렬의 덧셈
fun main(args: Array<String>) {
    val arr1: Array<IntArray> = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3))
    val arr2: Array<IntArray> = arrayOf(intArrayOf(3, 4), intArrayOf(5, 6))
    val result: Array<IntArray> = solution29(arr1, arr2)
}

fun solution29(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
    var answer: Array<IntArray> = Array<IntArray>(arr1.size, { IntArray(arr1[0].size, init = { i -> 0 }) })

    for (i in 0 until arr1.size) {
        for (j in 0 until arr1[i].size) {
            answer[i][j] = arr1[i][j] + arr2[i][j]
        }
    }

    return answer
}