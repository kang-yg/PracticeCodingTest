//가운데 글자 가져오기
fun main(args: Array<String>) {
    val result01 = solution04("abcde")
    val result02 = solution04("qwer")

    println(result02)

}

fun solution04(s: String): String {
    var answer = ""

    var arr: CharArray = s.toCharArray()
    val arrSize: Int = arr.size
    val arrMid: Int = arrSize / 2

    if ((s.length % 2) == 0) {
        answer = arr[arrMid - 1].toString().plus(arr[arrMid])
    } else {
        answer = arr[arrMid].toString()
    }

    return answer
}