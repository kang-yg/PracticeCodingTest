//수박수박수박수박수박수?
fun main(args: Array<String>) {
    val result : String = solution17(4)
    println(result)
}

fun solution17(n: Int): String {
    var answer = ""

    for (i in 0 until n){
        when(i % 2){
            0 -> {
                answer += "수"
            }

            1-> {
                answer += "박"
            }
        }
    }

    return answer
}