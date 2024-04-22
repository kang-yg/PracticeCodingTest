// 가장 큰 수
fun maim(args: Array<String>) {
    val biggestNumber: BiggestNumber = BiggestNumber()
//    biggestNumber.solution(intArrayOf(6, 10, 2))
    biggestNumber.solution(intArrayOf(3, 30, 34, 5, 9))
}

class BiggestNumber {
    fun solution(numbers: IntArray): String {
        numbers.forEachIndexed { forEachIndex, forEachValue ->
            makeNumbers(forEachValue.toString(), numbers.filterIndexed { filterIndex, filterValue ->
                forEachIndex != filterIndex
            }.toIntArray())
        }
        return strArrayList.maxOrNull()!!
    }

    private fun makeNumbers(number: String, numbers: IntArray) {
        strArrayList.add(number)
        if (numbers.isEmpty()) return
        numbers.forEachIndexed { forEachIndex, forEachValue ->
            makeNumbers(number.plus(forEachValue), numbers.filterIndexed { filterIndex, filterValue ->
                forEachIndex != filterIndex
            }.toIntArray())
        }
    }

    companion object {
        val strArrayList: ArrayList<String> = arrayListOf()
    }
}