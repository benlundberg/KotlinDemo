package clarityapplications.nobelprize.managers

import clarityapplications.nobelprize.models.Prize
import clarityapplications.nobelprize.services.PrizeService

class PrizeManager {

    companion object {
        private var prizes: List<Prize>? = null

        fun getPrizes(): List<Prize>? {

            if (prizes == null) {
                prizes = PrizeService().getPrizes()
            }

            return this.prizes
        }

        fun getPrizeByCategoryAndYear(category: String, year: Int): Prize? {
            return getPrizes()?.first { it.category == category && it.year == year }
        }
    }
}