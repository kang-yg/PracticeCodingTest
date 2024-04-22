import java.util.*

// 기능 개발
fun main(args: Array<String>) {
    val functionDevelopment: FunctionDevelopment = FunctionDevelopment()
//    functionDevelopment.solution(intArrayOf(93, 30, 55), intArrayOf(1, 30, 5)).forEach {
//        println("$it ")
//    }
    functionDevelopment.solution(intArrayOf(95, 90, 99, 99, 80, 99), intArrayOf(1, 1, 1, 1, 1, 1)).forEach {
        println("$it ")
    }
}

class FunctionDevelopment {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = intArrayOf()
        val countArrayList: ArrayList<Int> = arrayListOf()
        val requiredTimeQueue: Queue<Int> = getRequiredTimeList(progresses, speeds)
        while (!requiredTimeQueue.isEmpty()) {
            var count: Int = 0
            var firstWorkRequireDay: Int = requiredTimeQueue.element()

            while (!requiredTimeQueue.isEmpty() && requiredTimeQueue.element() <= firstWorkRequireDay) {
                requiredTimeQueue.remove()
                count++
            }
            countArrayList.add(count)
        }
        answer = countArrayList.toIntArray()
        return answer
    }

    private fun getRequiredTimeList(progresses: IntArray, speeds: IntArray): Queue<Int> {
        val requiredTimeQueue: Queue<Int> = LinkedList()
        progresses.zip(speeds).map { pair ->
            var day = if ((100 - pair.first) % pair.second == 0) {
                (100 - pair.first) / pair.second
            } else {
                (100 - pair.first) / pair.second + 1
            }
            requiredTimeQueue.add(day)
        }
        return requiredTimeQueue
    }
}