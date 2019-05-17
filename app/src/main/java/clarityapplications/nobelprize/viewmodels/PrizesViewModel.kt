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

class PrizesViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item_prize, parent, false)) {

    fun bind(prize: Prizes, clickListener: (Prizes) -> Unit) {
        itemView.list_title?.text = prize.category
        itemView.list_description?.text = prize.overallMotivation
        itemView.setOnClickListener { clickListener(prize) }
    }
}
