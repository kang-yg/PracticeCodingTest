//문자열 내림차순으로 배치하기
fun main(args: Array<String>) {
    val str: String = solution06("Zbcdefg")

    println(str)
}

fun solution06(s: String): String {
    var answer = ""
    var chaArr: CharArray = s.toCharArray()

    chaArr.sortDescending()
    answer = String(chaArr)

    return answer
}