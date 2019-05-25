package clarityapplications.nobelprize.viewmodels

import android.arch.lifecycle.ViewModel
import clarityapplications.nobelprize.managers.PrizeManager
import clarityapplications.nobelprize.models.Prize

class PrizeDetailViewModel : ViewModel() {

    fun getPrize( category: String, year: Int) : Prize? {
        return PrizeManager.getPrizeByCategoryAndYear(category, year)
    }
}