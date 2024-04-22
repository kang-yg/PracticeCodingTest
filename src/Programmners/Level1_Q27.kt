//하샤드 수
fun main(args: Array<String>) {
    val result : Boolean = solution27(13)
    println(result)
}


fun solution27(x: Int): Boolean {
    var answer = true
    var sum : Int = 0

    for (i in 0 until x.toString().toCharArray().size){
        sum += x.toString().toCharArray()[i].toString().toInt()
    }

    answer = if ((x % sum) !=0) false else true

    return answer
}