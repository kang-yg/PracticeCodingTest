//서울에서 김서방 찾기
fun main(args: Array<String>) {
    val arr: Array<String> = arrayOf("Jane", "Kim")
    val result: String = solution16(arr)

    println(result)
}

fun solution16(seoul: Array<String>): String {
    var answer = ""
    val text01: String = "김서방은 "
    val text02: String = "에 있다"

    for (i in 0 until seoul.size) {
        if (seoul[i].equals("Kim")) {
            answer = text01.plus(i).plus(text02)
        }
    }

    return answer
}