// 두 개 뽑아서 더하기
fun main(args: Array<String>) {
    val takeTwoAndAdd: TakeTwoAndAdd = TakeTwoAndAdd()
//    takeTwoAndAdd.solution(intArrayOf(2, 1, 3, 4, 1)).forEach {
//        print("$it ")
//    }
//    takeTwoAndAdd.solution(intArrayOf(5,0,2,7)).forEach {
//        print("$it ")
//    }
    takeTwoAndAdd.solution(intArrayOf(9, 8, 1, 54, 21, 78, 1, 0, 4, 2, 4, 7, 3, 8, 4, 3, 1, 84, 3, 87, 6, 1)).forEach {
        print("$it ")
    }
}

class TakeTwoAndAdd {
    fun solution(numbers: IntArray): IntArray {
        val answerSet: HashSet<Int> = hashSetOf()
        numbers.forEachIndexed { index1, num1 ->
            numbers.forEachIndexed { index2, num2 ->
                if (index1 != index2)
                    answerSet.add(num1 + num2)
            }
        }

        var answer: IntArray = IntArray(answerSet.size)
        answerSet.toSortedSet(Comparator { o1, o2 -> o1.compareTo(o2) }).forEachIndexed { index, i ->
            answer[index] = i
        }
        return answer
    }
}