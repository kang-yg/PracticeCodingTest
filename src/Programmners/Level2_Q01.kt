// 타겟 넘버
fun main(args: Array<String>) {
    val targetNumber: TargetNumber = TargetNumber()
    println(targetNumber.solution(intArrayOf(4, 1, 2, 1), 4))
}

class TargetNumber {
    fun solution(_numbers: IntArray, _target: Int): Int {
        target = _target
        numbers = _numbers
        dfs(numbers[0], 0)
        dfs(numbers[0] * -1, 0)
        return answer
    }

    private fun dfs(num: Int, count: Int) {
        if (count == numbersSize - 1) {
            if (num == target) {
                answer++
            }
        } else {
            dfs(num + numbers[count + 1], count + 1)
            dfs(num + numbers[count + 1] * -1, count + 1)
        }
    }

    companion object {
        private var target: Int = 0
        private var numbers: IntArray = intArrayOf()
            set(value) {
                field = value
                numbersSize = value.size
            }
        private var numbersSize: Int = 0
        private var answer = 0
    }
}