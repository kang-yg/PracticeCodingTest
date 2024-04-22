//제일 작은 수 제거하기
fun main(args: Array<String>) {
    val arr: IntArray = intArrayOf(4)
    val result: IntArray = solution22(arr)

    for (i in result){
        println(i)
    }
}

fun solution22(arr: IntArray): IntArray {
    var answer = intArrayOf()
    var myArr: ArrayList<Int> = arr.toCollection(ArrayList())

    myArr.remove(arr.minOrNull()!!)

    if (myArr.size != 0) {
        answer = myArr.toIntArray()
    } else {
        myArr.add(-1)
        answer = myArr.toIntArray()
    }

    return answer
}