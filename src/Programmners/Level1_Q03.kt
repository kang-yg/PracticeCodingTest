//K번째 수
fun main(args: Array<String>) {
    val kthNumber: KthNumber = KthNumber()
    kthNumber.solution(intArrayOf(1, 5, 2, 6, 3, 7, 4), arrayOf(intArrayOf(2, 5, 3), intArrayOf(4, 4, 1), intArrayOf(1, 7, 3))).forEach {
        print("$it ")
    }
}

class KthNumber {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = intArrayOf()
        val answerArrayList: ArrayList<Int> = arrayListOf()
        commands.forEach { row ->
            val tempArrayList: ArrayList<Int> = arrayListOf()
            for (i in row[0]..row[1]) {
                tempArrayList.add(array[i - 1])
            }
            tempArrayList.sort()
            answerArrayList.add(tempArrayList[row[2] - 1])
        }
        answer = answerArrayList.toIntArray()
        return answer
    }
}

fun solution03(array: IntArray, commands: Array<IntArray>): IntArray {
    var answer = intArrayOf()

    fun arrayCutter(arr: IntArray, st: Int, end: Int): IntArray {
        var resultArr: IntArray = intArrayOf()

        for (i in st - 1..end - 1) {
            resultArr += arr[i]
        }

        resultArr.sort()
        return resultArr
    }

    fun arrayPicker(arr: IntArray, pickNum: Int): Int {
        val result: Int = arr[pickNum - 1]

        return result
    }

    for (i in 0 until commands.size) {
        answer += arrayPicker(arrayCutter(array, commands[i][0], commands[i][1]), commands[i][2])

    }

    return answer
}