import kotlin.math.sqrt

// 소수 만들기
fun main(args: Array<String>) {
    val makePrimNumber: MakePrimNumber = MakePrimNumber()
    println(makePrimNumber.solution(intArrayOf(1, 2, 3, 4)))
    println(makePrimNumber.solution(intArrayOf(1, 2, 7, 6, 4)))
}

class MakePrimNumber {
    fun solution(nums: IntArray): Int {
        return pickThreeNumAndSum(nums)
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

    private fun pickThreeNumAndSum(nums: IntArray): Int {
        var primeCount: Int = 0
        for (i in 0..nums.size - 3) {
            for (j in i + 1..nums.size - 2) {
                for (z in j + 1 until nums.size) {
                    if (isPrimeNumber(nums[i] + nums[j] + nums[z])) primeCount++
                }
            }
        }
        return primeCount
    }
}