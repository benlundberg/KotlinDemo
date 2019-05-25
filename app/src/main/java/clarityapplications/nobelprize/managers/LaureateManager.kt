package clarityapplications.nobelprize.managers

import clarityapplications.nobelprize.models.Laureate
import clarityapplications.nobelprize.services.LaureateService

class LaureateManager {
    companion object {

        private var laureates: List<Laureate>? = null

        fun getLaureates(): List<Laureate>? {

            if (laureates == null) {
                laureates = LaureateService().getLaureates()
            }

            return this.laureates
        }

        fun getLaureateById(id: Int): Laureate? {
            return getLaureates()?.first { it.id == id }
        }
    }
}