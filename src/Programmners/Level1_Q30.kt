//x만큼 간격이 있는 n개의 숫자
fun main(args : Array<String>){
    val result : LongArray = solution30(-4,2)
}

fun solution30(x: Int, n: Int): LongArray {
    var answer = longArrayOf()
    var temp : Long = x.toLong()

    for (i in 0 until n){
        answer += temp
        temp = temp + x
    }

    return answer
}