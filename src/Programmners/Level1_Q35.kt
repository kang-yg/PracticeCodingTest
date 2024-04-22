// 약수의 개수와 덧셈
fun main(args: Array<String>) {
    val numberAndAdditionOfFactors: NumberAndAdditionOfFactors = NumberAndAdditionOfFactors()
    println(numberAndAdditionOfFactors.solution(24, 27))
}

class NumberAndAdditionOfFactors {
    fun solution(left: Int, right: Int): Int {
        var answer: Int = 0
        for (i in left..right) {
            if (isEvenOrOdd(getFactorsCount(i))) {
                // 짝수
                answer += i
            } else {
                // 홀수
                answer -= i
            }
        }
        return answer
    }

    private fun getFactorsCount(num: Int): Int {
        var count: Int = 0
        for (i in 1..num) {
            if (num % i == 0) count++
        }
        return count
    }

    private fun isEvenOrOdd(count: Int): Boolean {
        return count % 2 == 0
    }
}