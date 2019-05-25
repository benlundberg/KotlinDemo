package clarityapplications.nobelprize.viewmodels

import android.arch.lifecycle.ViewModel
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import clarityapplications.nobelprize.R
import clarityapplications.nobelprize.managers.PrizeManager
import clarityapplications.nobelprize.models.Prizes
import clarityapplications.nobelprize.services.PrizeService
import kotlinx.android.synthetic.main.list_item_prize.view.*

class PrizesViewModel : ViewModel() {

    fun loadPrizes() : List<Prizes>? {
        return PrizeManager.getPrizes()
    }
}


