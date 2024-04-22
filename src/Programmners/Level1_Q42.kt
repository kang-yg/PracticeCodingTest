// 없는 숫자 더하기
fun main(args: Array<String>) {
    val addMissingNumbers: AddMissingNumbers = AddMissingNumbers()
    println(addMissingNumbers.solution(intArrayOf(1, 2, 3, 4, 6, 7, 8, 0)))
    println(addMissingNumbers.solution(intArrayOf(5, 8, 4, 0, 6, 7, 9)))
}

class AddMissingNumbers {
    fun solution(numbers: IntArray): Int {
        return getMissingNumberIntArray(numbers)
//        return (0..9).filterNot(numbers::contains).sum()
    }

    private fun getMissingNumberIntArray(numbers: IntArray): Int {
        var result: Int = 0
        val resultIntArray: ArrayList<Int> = arrayListOf()
        for (i in 0..9) {
            resultIntArray.add(i)
        }

        numbers.forEach {
            if (resultIntArray.contains(it)) resultIntArray.remove(it)
        }

        resultIntArray.forEach {
            result += it
        }
        return result
    }
}