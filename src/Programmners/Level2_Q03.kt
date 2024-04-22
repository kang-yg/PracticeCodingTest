//기능개발
fun main(args: Array<String>) {
    val pro: IntArray = intArrayOf(40, 93, 30, 55, 60, 65)
    val speed: IntArray = intArrayOf(60, 1, 30, 5, 10, 7)
    val result: IntArray = solution32(pro, speed)
}

fun solution32(progresses: IntArray, speeds: IntArray): IntArray {
    var answer = intArrayOf()
    var term: ArrayList<Int> = arrayListOf()
    var count: Int = 0
    var temp: ArrayList<Int> = arrayListOf()

    fun cutArray(arr: ArrayList<Int>, count: Int) {
        for (i in 0 until count) {
            arr.removeAt(0)
        }
    }

    for (i in 0 until progresses.size) {
        term.add(if (((100 - progresses[i]) % speeds[i]) == 0) (100 - progresses[i]) / speeds[i] else ((100 - progresses[i]) / speeds[i]) + 1)
    }

    temp = term

    for (i in 0 until term.size) {
        for (j in 1 until term.size) {
            if (term[i] < term[j]) {
                count++
                cutArray(temp, count)
                break
            } else {
                count++
            }
        }
        count = 0
    }

    return answer
}