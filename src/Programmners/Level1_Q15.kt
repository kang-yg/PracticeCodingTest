//문자열 내 마음대로 정렬하기
fun main(args: Array<String>) {
//    val arr: Array<String> = arrayOf("sun", "bed", "car")
    val arr: Array<String> = arrayOf("abce", "abcd", "cdx")
    val result: Array<String> = solution15(arr, 2)

    for (i in result){
        println(i)
    }
}

fun solution15(strings: Array<String>, n: Int): Array<String> {
    var answer = arrayOf<String>()
    var temp : String

    for (i in 0 until strings.size){
        for (j in 0 until strings.size){
            if (strings[i][n] < strings[j][n]){
                temp = strings[i]
                strings[i] = strings[j]
                strings[j] = temp
            }
            if (strings[i][n] == strings[j][n]){
                if (strings[i] < strings[j]){
                    temp = strings[i]
                    strings[i] = strings[j]
                    strings[j] = temp
                }
            }
        }
    }

    for (i in strings){
        answer += i
    }

    return answer
}