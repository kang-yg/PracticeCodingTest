//문자열 다루기 기본
fun main(args: Array<String>) {
    val result: Boolean = solution07("12345")

    print(result)
}

fun solution07(s: String): Boolean {
    var answer = true

    if (s.length == 4 || s.length == 6){
        if (s.toIntOrNull() == null) {
            answer = false
        }
    } else {
        answer = false
    }

    return answer

/*    try {
        s.toInt()
    } catch (e: Exception) {
        answer = false
    }*/


}