import java.util.*

// 프린터
fun main(args: Array<String>) {
    val printer: Printer = Printer()
    printer.solution(intArrayOf(2, 1, 3, 2), 2)
//    printer.solution(intArrayOf(1, 1, 9, 1, 1, 1), 0)*/
}

class Printer {
    fun solution(priorities: IntArray, location: Int): Int {
        return sortPriorities(priorities, location)
    }

    private fun sortPriorities(priorities: IntArray, location: Int): Int {
        var result: Int = 0
        val docs: List<Pair<Int, Int>> = (priorities.indices).zip(priorities.map { it })
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        docs.forEach {
            queue.add(it)
        }

        while (queue.isNotEmpty()) {
            val queueFront = queue.poll()
            if (queue.any { queueFront.second < it.second }) {
                queue.add(queueFront)
            } else {
                result++
                if (queueFront.first == location) {
                    break
                }
            }
        }
        return result
    }
}