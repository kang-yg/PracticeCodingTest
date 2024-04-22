//시저 암호
fun main(args: Array<String>) {
    val result: String = solution09("a B z", 4)

    print(result)
}


//대문자 ASCII : 65~90
//소문자 ASCII : 97~122
fun solution09(s: String, n: Int): String {
    var answer = ""
    var charArr: CharArray = s.toCharArray()

    for (i in 0 until charArr.size) {
        if (65 <= charArr[i].toInt() && charArr[i].toInt() <= 90) {
            if ((charArr[i].toInt() + n) > 90) {
                charArr[i] = ((charArr[i].toInt() + n) - 26).toChar()
            } else {
                charArr[i] = (charArr[i].toInt() + n).toChar()
            }
        } else if (97 <= charArr[i].toInt() && charArr[i].toInt() <= 122) {
            if ((charArr[i].toInt() + n) > 122) {
                charArr[i] = ((charArr[i].toInt() + n) - 26).toChar()
            } else {
                charArr[i] = (charArr[i].toInt() + n).toChar()
            }
        }
    }

    answer = String(charArr)

    return answer
}