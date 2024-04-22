// 나머지가 1이 되는 수 찾기
fun main(args: Array<String>) {
    val findNumberRemainderOne: FindNumberRemainderOne = FindNumberRemainderOne()
    for (i in 3..100) {
        println("$i : ${findNumberRemainderOne.solution(i)}")
    }
}

class FindNumberRemainderOne {
    fun solution(n: Int): Int {
        var answer: Int = 0
        for (i in 2..n) {
            if (n % i == 1) {
                answer = i
                break
            }
        }
        return answer
    }
}