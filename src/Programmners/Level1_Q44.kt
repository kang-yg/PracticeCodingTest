// 음양 더하기
fun main(args: Array<String>) {
    val addYinAndYang: AddYinAndYang = AddYinAndYang()
    println(addYinAndYang.solution(intArrayOf(4,7,12), booleanArrayOf(true,false,true)))
    println(addYinAndYang.solution(intArrayOf(1,2,3), booleanArrayOf(false,false,true)))
}

class AddYinAndYang {
    fun solution(absolutes: IntArray, signs: BooleanArray): Int {
        return absolutes.zip(signs.map { if (it) 1 else -1 }).sumOf { it.first * it.second }
    }
}