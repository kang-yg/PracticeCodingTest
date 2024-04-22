// 최소직사각형
fun main(args: Array<String>) {
    val minimumRectangle: MinimumRectangle = MinimumRectangle()
    val arrayInt: Array<IntArray> =
        arrayOf(intArrayOf(14, 4), intArrayOf(19, 6), intArrayOf(6, 16), intArrayOf(18, 7), intArrayOf(7, 11))
    println("${minimumRectangle.solution(arrayInt)}")
}

class MinimumRectangle {
    fun solution(sizes: Array<IntArray>): Int {
        var width: Int = 0
        var height: Int = 0
        sizes.forEach {
            var longSide: Int = 0
            var shortSide: Int = 0
            if (it[0] > it[1]) {
                longSide = it[0]
                shortSide = it[1]
            } else {
                longSide = it[1]
                shortSide = it[0]
            }
            width = if (width >= longSide) width else longSide
            height = if (height >= shortSide) height else shortSide
        }
        return height * width
    }
}