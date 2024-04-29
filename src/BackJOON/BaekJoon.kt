import java.time.LocalTime
import java.util.*

private fun main() {
    
}

fun 예산(request: List<Int>, budget: Int): Int {
    var result = 0
    for (i in 1..request.size) {
        if (request.sorted().take(i).sum() <= budget) {
            result++
        }
    }
    return result
}

fun 백준2480(num1: Int, num2: Int, num3: Int): Int {
    val diceValues = listOf<Int>(num1, num2, num3)
    val uniqueValues = diceValues.toSet()

    return when (uniqueValues.size) {
        1 -> {
            10_000 + uniqueValues.first() * 1_000
        }

        2 -> {
            val mostCommonValue = diceValues.first { value ->
                diceValues.count { it == value } == 2
            }
            1_000 + mostCommonValue * 100
        }

        else -> {
            uniqueValues.maxOrNull()!! * 100
        }
    }
}

fun 백준2525(hour: Int, minute: Int, requiredTime: Int): String {
    val currentTime = hour * 60 + minute
    val finishTime = currentTime + requiredTime

    val finishHour = if ((finishTime / 60) > 23) {
        (finishTime / 60) - 24
    } else {
        finishTime / 60
    }
    val finishMinute = finishTime % 60

    return "$finishHour $finishMinute"
}

fun 백준14681(x: Int, y: Int): Int {
    return if (x > 0) {
        if (y > 0) {
            1
        } else {
            4
        }
    } else {
        if (y > 0) {
            2
        } else {
            3
        }
    }
}

fun 백준10951(num1: Int, num2: Int): Int = num1 + num2

fun 백준1546(subjectCount: Int, scoreList: List<Int>): Float {
    val maxScore = scoreList.maxOrNull()
    val newScoreList = scoreList.map {
        it / maxScore!!.toFloat() * 100
    }
    return (newScoreList.sum() / subjectCount)
}

fun 백준1152(str: String): Int {
    val words = str.trim()
    return if (words.isBlank()) {
        0
    } else {
        words.split(" ").count()
    }
}

fun 백준1157(word: String): Char {
    val charCount = word.uppercase().filter { it.isLetter() }.groupingBy { it }.eachCount()
    val maxCount = charCount.values.maxOrNull()
    val maxChars = charCount.filter { it.value == maxCount }.keys

    return if (maxCount == null || maxChars.size > 1) '?' else maxChars.first()
}

fun 백준3003(foundPieces: List<Int>): String {
    val correctPieces = listOf(1, 1, 2, 2, 2, 8) // King, Queen, Rook, Bishop, Knight, Pawn
    val differences = correctPieces.zip(foundPieces).map { (correct, found) -> correct - found }
    return differences.joinToString(" ")
}

fun 백준10988(word: String): Int = if (word == word.reversed()) 1 else 0

fun 백준2738(array: List<Int>): Int {
    val rowSize = array[0]
    val columnSize = array[1]

    val data = Arrays.copyOfRange(array.toIntArray(), 2, array.size - 1)
    val firstArray = Arrays.copyOfRange(data, 0, (rowSize * columnSize) - 1)
    val secondArray = Arrays.copyOfRange(data, (rowSize * columnSize), data.size - 1)
    firstArray.zip(secondArray).forEach {
        for (i in 0 until rowSize) {
            for (j in 0 until columnSize) {
                print(it.first + it.second)
            }
            println()
        }
    }
    return 0
}

fun 백준1436(naturalNumber: Int): Int {
    var number = 666
    val array666 = arrayListOf<Int>().apply {
        add(number)
    }
    do {
        number += 1
        if (number.toString().contains("666")) {
            array666.add(number)
        }
    } while (array666.size != naturalNumber)
    return array666[naturalNumber - 1]
}

// TODO
fun 백준2798() {
    val userInput = Scanner(System.`in`)
    val (n, m) = userInput.nextLine().split(" ").map { it.toInt() }
    val numberList = userInput.nextLine().split(" ").map { it.toInt() }

    val sumList = arrayListOf<Int>()
    for (i in 0 until n - 2) {
        for (j in i + 1 until n - 1) {
            for (k in j + 1 until n) {
                sumList.add(numberList[i] + numberList[j] + numberList[k])
            }
        }
    }
    println(sumList.filter { it <= m }.maxOrNull()!!)
}

fun 백준2750(count: Int, numbers: Array<Int>) {
    val userInput = Scanner(System.`in`)
    val count = userInput.nextInt()
    val numbers = Array<Int>(count) { _ -> 0 }
    for (i in 0 until count) {
        numbers[i] = userInput.nextInt()
    }

    numbers.sorted().forEach {
        println(it)
    }
}

fun 백준2231() {
    val userInput = Scanner(System.`in`)
    val 분해합 = userInput.nextInt()
    var result = 0

    for (i in 0 until 분해합) {
        val sum = i + i.toString().sumOf { it - '0' }
        if (sum == 분해합) {
            result = i
            break
        }
    }
    println(result)
}

fun 백준25206() {
    val userInput = Scanner(System.`in`)
    val score: ArrayList<String> = arrayListOf()
    while (userInput.hasNextLine()) {
        score.add(userInput.nextLine())
    }
    val 평점목록: List<Pair<String, Float>> = listOf(
        Pair("A+", 4.5f),
        Pair("A0", 4.0f),
        Pair("B+", 3.5f),
        Pair("B0", 3.0f),
        Pair("C+", 2.5f),
        Pair("C0", 2.0f),
        Pair("D+", 1.5f),
        Pair("D0", 1.0f),
        Pair("F", 0.0f)
    )
    var sum = 0f
    var 총학점 = 0f
    score.map {
        val (과목, 학점, 등급) = it.split(" ")
        if (등급 != "P") {
            val 평점 = 평점목록.first { it.first == 등급 }.second
            sum += 학점.toFloat() * 평점
            총학점 += 학점.toFloat()
        }
    }
    println("${sum / 총학점}")
}

fun 백준1316() {
    fun isGroupWord(word: String): Boolean {
        val seen = mutableSetOf<Char>()
        var prevChar = ' '
        for (char in word) {
            if (char != prevChar && seen.contains(char)) {
                return false
            }
            seen.add(char)
            prevChar = char
        }
        return true
    }

    val userInput = Scanner(System.`in`)
    val wordCount = userInput.nextInt()
    userInput.nextLine()

    var result = 0
    for (i in 1..wordCount) {
        val word = userInput.nextLine()
        if (isGroupWord(word)) {
            result++
        }
    }
    println(result)
}

fun 백준2738() {
    val userInput = Scanner(System.`in`)
    val row = userInput.nextInt()
    val column = userInput.nextInt()
    val values = arrayListOf<Int>()
    for (i in 0 until row * column * 2) {
        values.add(userInput.nextInt())
    }
    val (arrayA, arrayB) = values.chunked(row * column)
    val result = arrayA.indices.map { arrayA[it] + arrayB[it] }
    result.forEachIndexed { index, i ->
        if (index % column == column - 1) {
            print(i)
            println()
        } else print("$i ")
    }
}

fun 백준2563() {
    val userInput = Scanner(System.`in`)
    val pagerCount = userInput.nextInt()
    userInput.nextLine()
    val 도화지 = Array(100) { BooleanArray(100) { false } }
    repeat(pagerCount) {
        val line = userInput.nextLine()
        val (x, y) = line.split(" ").map { it.toInt() }
        (x until x + 10).forEach { i ->
            (y until y + 10).forEach { j ->
                도화지[i][j] = true
            }
        }
    }
    println(도화지.flatMap { it.filter { it } }.count())
}

fun 백준10798() {
    val userInput = Scanner(System.`in`)
    val lines = arrayListOf<String>()
    repeat(5) {
        lines.add(userInput.nextLine())
    }
    val strBuilder = StringBuilder()
    val rowCharArray = lines.map { it.toCharArray() }
    (0..14).map { columnIndex ->
        for (rowIndex in 0..4) {
            try {
                strBuilder.append(rowCharArray[rowIndex][columnIndex])
            } catch (e: IndexOutOfBoundsException) {
                strBuilder.append("")
            }
        }
    }
    println(strBuilder.toString())
}

fun 백준2566() {
    val userInput = Scanner(System.`in`)
    val table = Array(9) { IntArray(9) }
    repeat(9) { rowIndex ->
        repeat(9) { columnIndex ->
            table[rowIndex][columnIndex] = userInput.nextInt()
        }
    }

    val maxValue = table.flatMap { it.toList() }.maxOrNull()
    table.forEachIndexed { rowIndex, row ->
        row.forEachIndexed { columnIndex, column ->
            if (table[rowIndex][columnIndex] == maxValue) {
                println(maxValue)
                print("${rowIndex + 1} ${columnIndex + 1}")
                return
            }
        }
    }
}

fun 백준2869() {
    val userInput = Scanner(System.`in`)
    val upDistance = userInput.nextInt()
    val downDistance = userInput.nextInt()
    val distance = userInput.nextInt()

    // 마지막 날에는 미끄러지지 않으므로, distance - upDistance를 해서 마지막 날을 제외한 높이를 계산
    // 그리고 나서 (upDistance - downDistance)로 나누어 몇 번 더 올라가야 하는지 계산
    val beforeLastDistance = distance - upDistance
    val oneDayDistance = upDistance - downDistance

    // if (beforeLastDistance % oneDayDistance > 0)
    // 0보다 크다면 달팽이가 마지막 추가 일자를 필요로 한다는 것을 의미. 이는 달팽이가 마지막 날에 조금 더 올라가야 하는 거리가 남아있다는 것을 의미
    // 마지막 날을 포함하기 위해 최종적으로 +1
    val result = (beforeLastDistance / oneDayDistance) + (if (beforeLastDistance % oneDayDistance > 0) 1 else 0) + 1

    println(result)
}

fun 백준2720() {
    val userInput = Scanner(System.`in`)
    val testCaseCount = userInput.nextInt()
    val firstChange = userInput.nextInt()
    val secondChange = userInput.nextInt()
    val thirdChange = userInput.nextInt()

    fun counter(charge: Int): IntArray {
        var remainCharge = charge
        val 쿼터 = 25
        val 다임 = 10
        val 니켈 = 5
        val 페니 = 1

        val 쿼터카운트 = remainCharge / 쿼터
        remainCharge -= (쿼터 * 쿼터카운트)
        val 다임카운트 = remainCharge / 다임
        remainCharge -= (다임 * 다임카운트)
        val 니켈카운트 = remainCharge / 니켈
        remainCharge -= (니켈 * 니켈카운트)
        val 페니카운트 = remainCharge

        return intArrayOf(쿼터카운트, 다임카운트, 니켈카운트, 페니카운트)
    }

    counter(firstChange)
}

fun 백준2884() {
    val userInput = Scanner(System.`in`)
    val hour = userInput.nextInt()
    val minute = userInput.nextInt()

    val time = LocalTime.of(hour, minute).minusMinutes(45)
    println("${time.hour} ${time.minute}")
}