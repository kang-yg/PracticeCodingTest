//체육복
fun main(args: Array<String>) {
    val lost: IntArray = intArrayOf(3)
    val reserve: IntArray = intArrayOf(1)
    val result: Int = solution12(3, lost, reserve)

    println(result)
}

fun solution12(n: Int, lost: IntArray, reserve: IntArray): Int {
    var answer = 0
    var finalReserve: MutableList<Int> = mutableListOf()
    var finalLost: MutableList<Int> = mutableListOf()

    for (z in reserve) {
        finalReserve.add(z)
    }

    for (z in lost) {
        finalLost.add(z)
    }

    for (i in lost) {
        for (j in reserve) {
            if (i == j) {
                finalReserve.remove(j)
                finalLost.remove(i)
            }
        }
    }

    for (i in finalReserve) {
        if (i - 1 in finalLost) {
            finalLost.remove(i - 1)
        } else if (i + 1 in finalLost) {
            finalLost.remove(i + 1)
        }
    }

    answer = n - finalLost.size

    return answer
}