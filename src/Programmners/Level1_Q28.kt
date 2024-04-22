//핸드폰 번호 가리기
fun main(args: Array<String>){
    val str : String = "027778888"
    val result : String = solution28(str)
}

fun solution28(phone_number: String): String {
    var answer = ""

    for (i in 0 until phone_number.length - 4){
        answer += "*"
    }

    answer += phone_number.substring(phone_number.length - 4, phone_number.length)

    return answer
}