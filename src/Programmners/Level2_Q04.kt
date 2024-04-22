import kotlin.math.sqrt

// 소수 찾기
fun main(args: Array<String>) {
    val findPrimeNumber: FindPrimeNumber = FindPrimeNumber()
    findPrimeNumber.solution("123")
}

class FindPrimeNumber {
    fun solution(numbers: String): Int {
        var answer = 0
        val cards: List<Char> = numbers.map { it }
        cards.forEachIndexed { index, c -> makeNumber(c.toString(), cards.filterIndexed { i, _ -> index != i }) }
        numberSet.forEach {
            if (isPrimeNumber(it)) {
                answer++
            }
        }
        return answer
    }

    private fun makeNumber(number: String, cards: List<Char>) {
        numberSet.add(number.toInt())
        if (cards.isEmpty()) return
        cards.forEachIndexed { index, c ->
            makeNumber(number.plus(c), cards.filterIndexed { i, _ -> index != i })
        }
    }

    private fun isPrimeNumber(num: Int): Boolean {
        var isPrimeResult: Boolean = true
        for (i in 2..sqrt(num.toDouble()).toInt()) {
            if ((num % i) == 0) {
                isPrimeResult = false
                break
            }
        }
        return isPrimeResult
    }

    companion object {
        val numberSet: HashSet<Int> = hashSetOf();
    }
}