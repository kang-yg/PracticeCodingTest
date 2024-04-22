// 실패율
fun main(args: Array<String>) {
    val failureRate: FailureRate = FailureRate()
//    failureRate.solution(5, intArrayOf(2, 1, 2, 6, 2, 4, 3, 3)).forEach {
//        print("$it ")
//    }
//    failureRate.solution(4, intArrayOf(4,4,4,4,4)).forEach {
//        print("$it ")
//    }
    failureRate.solution(5, intArrayOf(1, 2, 3, 4, 5)).forEach {
        print("$it ")
    }
}

// 실패율
class FailureRate {
    fun solution(N: Int, stages: IntArray): IntArray {
        var answer = IntArray(N)
        getFailureRate(N, stages)
        val failureRateHashMap: HashMap<Int, Double> = getFailureRate(N, stages)
        val sortedList: List<Pair<Int, Double>> = mapToSortedList(failureRateHashMap)
        for (i in 0 until N) {
            answer[i] = sortedList[i].first
        }
        return answer
    }

    /**
     * 스테이지별 실패율을 알 수 있는 Map
     */
    private fun getFailureRate(N: Int, stages: IntArray): HashMap<Int, Double> {
        val result: HashMap<Int, Double> = hashMapOf()
        for (i in 1..N) {
            var numberOfPeopleReached: Double = 0.0
            var numberOfPeopleBeingChallenged: Double = 0.0
            stages.forEach {
                if (i <= it) {
                    numberOfPeopleReached++
                }
                if (i == it) {
                    numberOfPeopleBeingChallenged++
                }
            }
            if (numberOfPeopleReached == 0.0) {
                result[i] = 0.0
            } else {
                result[i] = numberOfPeopleBeingChallenged / numberOfPeopleReached
            }
        }
        return result
    }

    /**
     * 정렬
     */
    private fun mapToSortedList(failureRateHashMap: HashMap<Int, Double>): List<Pair<Int, Double>> {
        return failureRateHashMap.toList().sortedByDescending { (_, value) ->
            value
        }
    }
}