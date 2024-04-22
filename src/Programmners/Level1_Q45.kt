import java.util.*

// 크레인 인형뽑기 게임
fun main(args: Array<String>) {
    val cranePuppetGame: CranePuppetGame = CranePuppetGame()
    cranePuppetGame.solution(
        arrayOf(
            intArrayOf(0, 0, 0, 0, 0),
            intArrayOf(0, 0, 1, 0, 3),
            intArrayOf(0, 2, 5, 0, 1),
            intArrayOf(0, 2, 5, 0, 1),
            intArrayOf(4, 2, 4, 4, 2),
            intArrayOf(3, 5, 1, 3, 1)
        ), intArrayOf(1, 5, 3, 5, 1, 2, 1, 4)
    )
}

class CranePuppetGame {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        val myStack: Stack<Int> = Stack()
        moves.forEach moves@{ move ->
            board.forEach board@{ row ->
                val doll = row[move - 1]
                if (doll != 0) {
                    row[move - 1] = 0
                    if (checkStack(doll, myStack)) {
                        answer += 2
                    }
                    return@moves
                }
            }
        }
        return answer
    }

    private fun checkStack(num: Int, stack: Stack<Int>): Boolean {
        if (!stack.isEmpty()) {
            if (stack.peek() == num) {
                stack.pop()
                return true
            }
        }
        stack.add(num)
        return false
    }
}