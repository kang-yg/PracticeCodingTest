import kotlin.math.absoluteValue

// 부족한 금액 계산하기
fun main(args: Array<String>) {
    val calculateTheShortfall: CalculateTheShortfall = CalculateTheShortfall()
    calculateTheShortfall.solution(3, 20, 4)
}

class CalculateTheShortfall {
    fun solution(price: Int, money: Int, count: Int): Long {
        var answer: Long = 0
        var total: Long = 0
        for (i in 1..count) {
            total += price * i
        }
        answer = if (money > total) {
            0
        } else {
            (money - total).absoluteValue
        }
        return answer
    }
}