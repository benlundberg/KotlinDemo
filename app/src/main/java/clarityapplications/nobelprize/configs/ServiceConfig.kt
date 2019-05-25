package clarityapplications.nobelprize.configs

class ServiceConfig {
    companion object {
        private val BASE = "http://api.nobelprize.org/v1/"

        val GET_PRIZES = BASE + "prize.json"
        val GET_LAUREATES = BASE + "laureate.json"
    }
}