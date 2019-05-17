package clarityapplications.nobelprize.managers

import clarityapplications.nobelprize.models.Prizes
import clarityapplications.nobelprize.services.PrizeService

class PrizeManager {

    companion object {
        private var prizes: List<Prizes>? = null

        fun getPrizes() : List<Prizes>? {

            if (prizes == null) {
                prizes = PrizeService().getPrizes()
            }

            return this.prizes
        }

        fun getPrizeByCategory(category: String, year: Int) : Prizes? {
            return getPrizes()?.first { it.category == category && it.year == year }
        }
    }
}