package clarityapplications.nobelprize.viewmodels

import android.arch.lifecycle.ViewModel
import clarityapplications.nobelprize.managers.PrizeManager
import clarityapplications.nobelprize.models.Prize

class PrizesViewModel : ViewModel() {

    fun loadPrizes() : List<Prize>? {
        return PrizeManager.getPrizes()
    }
}


