//평균 구하기
fun main(args : Array<String>){
    val arr : IntArray = intArrayOf(5,5)
    val result : Double = solution26(arr)

    println(result)
}

fun solution26(arr: IntArray): Double {
    var answer : Double = 0.0

    answer = arr.average()

    return answer
}