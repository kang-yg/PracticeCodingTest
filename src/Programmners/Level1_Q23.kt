//짝수와 홀수
fun main(args:Array<String>){
    val result : String = solution23(3)
    println(result)
}

fun solution23(num: Int): String {
    var answer = ""

    answer = if (num % 2 == 0) "Even" else "Odd"

    return answer
}