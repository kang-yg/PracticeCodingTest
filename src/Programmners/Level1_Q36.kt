// 신고 결과 받기
fun main(args: Array<String>) {
    val receiveReportResults: ReceiveReportResults = ReceiveReportResults()
    receiveReportResults.solution(
        arrayOf("muzi", "frodo", "apeach", "neo"),
        arrayOf("muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"),
        2
    ).forEach { print("$it ") }

//    receiveReportResults.solution(
//        arrayOf("con", "ryan"),
//        arrayOf("ryan con", "ryan con", "ryan con", "ryan con"),
//        2
//    ).forEach { print("$it ") }
}

class ReceiveReportResults {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        var answer: IntArray = intArrayOf()
        val reportMap: HashMap<String, HashSet<String>> = hashMapOf()
        val respondentCountMap: HashMap<String, Int> = hashMapOf()
        val notifyCountMap: HashMap<String, Int> = hashMapOf()
        setReportMap(id_list, report, reportMap)
        setRespondentCountMap(id_list, reportMap, respondentCountMap)
        setNotifyCountMap(reportMap, respondentCountMap, notifyCountMap, k)
        answer = makeAnswer(id_list, notifyCountMap)
        return answer
    }

    /**
     * 누가 누구를 신고했는지 알 수 있는 Map
     */
    private fun setReportMap(
        id_list: Array<String>,
        report: Array<String>,
        reportMap: HashMap<String, HashSet<String>>
    ) {
        id_list.forEach { reporter ->
            reportMap[reporter] = hashSetOf()
        }
        report.forEach {
            val reporter: String = it.split(" ")[0]
            val respondent: String = it.split(" ")[1]
            reportMap[reporter]?.add(respondent)
        }
    }

    /**
     * 사용자별 신고당한 횟수를 알 수 있는 Map
     */
    private fun setRespondentCountMap(
        id_list: Array<String>,
        reportMap: HashMap<String, HashSet<String>>,
        respondentCountMap: HashMap<String, Int>
    ) {
        id_list.forEach { id ->
            respondentCountMap[id] = 0
            reportMap.forEach {
                for (i in it.value) {
                    if (i == id) {
                        respondentCountMap[id] = respondentCountMap[id]!!.plus(1)
                    }
                }
            }
        }
    }

    /**
     * 사용자별 안내를 받을 메일의 수를 알 수 있는 Map
     */
    private fun setNotifyCountMap(
        reportMap: HashMap<String, HashSet<String>>,
        respondentCountMap: HashMap<String, Int>,
        notifyCountMap: HashMap<String, Int>,
        k: Int
    ) {
        for (i in reportMap.entries) {
            notifyCountMap[i.key] = 0
        }
        val suspendedUsers: ArrayList<String> = arrayListOf()
        for (i in respondentCountMap.entries) {
            if (i.value >= k) {
                suspendedUsers.add(i.key)
            }
        }
        for (i in reportMap.entries) {
            for (j in suspendedUsers) {
                if (i.value.contains(j)) {
                    notifyCountMap[i.key] = notifyCountMap[i.key]!!.plus(1)
                }
            }
        }
    }

    /**
     * 전달받은 아이디 순서대로 결과 만들기
     */
    private fun makeAnswer(id_list: Array<String>, notifyCountMap: HashMap<String, Int>): IntArray {
        val intArray: IntArray = IntArray(id_list.size)
        id_list.forEachIndexed { index, id ->
            intArray[index] = notifyCountMap[id]!!
        }
        return intArray
    }
}
