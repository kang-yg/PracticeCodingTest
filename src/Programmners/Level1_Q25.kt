//콜라츠 추측
fun main(args: Array<String>) {
    val result: Int = solution25(626331)

    println(result)
}

fun solution25(num: Int): Int {
    var answer = 0
    var temp: Double = num.toDouble()

    while (true) {
        if (temp == 1.0){
            break
        }

        if ((temp % 2) == 0.0) {
            temp /= 2
            answer++
        } else {
            temp = (temp * 3) + 1
            answer++
        }

        if (temp == 1.0) {
            break
        } else if (answer > 500) {
            answer = -1
            break
        }
    }

    return answer
}