import java.lang.StringBuilder

// 이상한 문자 만들기
fun main(args: Array<String>) {
    val createWeirdCharacters: CreateWeirdCharacters = CreateWeirdCharacters()
    val str: String = createWeirdCharacters.solution("try hello world")
    println(str)
}

class CreateWeirdCharacters {
    fun solution(s: String): String {
        val strList: List<String> = s.split(" ")
        val resultList: ArrayList<String> = arrayListOf()
        strList.forEach {
            val builder: StringBuilder = StringBuilder()
            it.mapIndexed { index, s ->
                if (index % 2 == 0) {
                    builder.append(s.uppercase())
                } else {
                    builder.append(s.lowercase())
                }
            }
            resultList.add(builder.toString())
        }
        return resultList.joinToString(separator = " ")
    }
}