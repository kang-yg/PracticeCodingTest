import kotlin.math.pow

// 3진법 뒤집기
fun main(args: Array<String>) {
    val ternaryBaseThreeFlip: TernaryBaseThreeFlip = TernaryBaseThreeFlip()
    println(ternaryBaseThreeFlip.solution(125))
}

class TernaryBaseThreeFlip {
    fun solution(n: Int): Int {
        val ternaryBaseTreeReversed = numToTernaryBaseTreeReversed(n)
        return ternaryBaseTreeToNum(ternaryBaseTreeReversed)
    }

    private fun numToTernaryBaseTreeReversed(n: Int): List<Int> {
        val ternaryBaseTreeArrayList: ArrayList<Int> = arrayListOf()
        var quotient: Int = n
        do {
            if (quotient / 3 != 0) {
                ternaryBaseTreeArrayList.add(quotient % 3)
            } else {
                ternaryBaseTreeArrayList.add(quotient)
            }
            quotient /= 3

        } while (quotient != 0)
        return ternaryBaseTreeArrayList
    }

    private fun ternaryBaseTreeToNum(list: List<Int>): Int {
        var result: Int = 0
        val listSize: Int = list.size
        list.forEachIndexed { index, i ->
            result += ((3).toDouble().pow(listSize - index - 1) * i).toInt()
        }
        return result
    }
}