//모의고사
fun main(args: Array<String>) {
    val answers: IntArray = intArrayOf(1, 3, 2, 4, 2)
    var result: IntArray = solution02(answers)

    for (i in result) {
        print(i)
    }

}

fun solution02(answers: IntArray): IntArray {
    var answer: IntArray = intArrayOf()

    val person01: IntArray = IntArray(answers.size)
    val person02: IntArray = IntArray(answers.size)
    val person03: IntArray = IntArray(answers.size)

    var count: MutableList<Int> = arrayListOf(0, 0, 0)

    var num01: Int = 1

    //person01 패턴
    for (i in 0 until answers.size) {
        if (num01 < 6) {
            person01[i] = num01
            num01++
        } else {
            num01 = 1
            person01.set(i, num01)
            num01++
        }
    }

    //person02 패턴
    num01 = 1
    for (i in 0 until answers.size) {
        if (num01 == 2) {
            num01 = 3
        }

        if ((i % 2) == 0) {
            person02[i] = 2
        } else {
            if (num01 < 6) {
                person02[i] = num01
                num01++
            } else {
                num01 = 1
                person02[i] = num01
                num01++
            }
        }
    }

    for (i in 0 until answers.size) {
        when (i % 10) {
            0, 1 -> {
                person03[i] = 3
            }

            2, 3 -> {
                person03[i] = 1
            }

            4, 5 -> {
                person03[i] = 2
            }

            6, 7 -> {
                person03[i] = 4
            }

            8, 9 -> {
                person03[i] = 5
            }
        }
    }

    for (i in 0 until answers.size) {
        if (answers[i] == person01[i]) {
            count[0]++
        }

        if (answers[i] == person02[i]) {
            count[1]++
        }

        if (answers[i] == person03[i]) {
            count[2]++
        }
    }

    val maxNum: Int = count.maxOrNull()!!

    for (i in 0 until count.size) {
        if (count[i] == maxNum) {
            answer += i + 1
        }
    }

    return answer
}