package clarityapplications.nobelprize.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import clarityapplications.nobelprize.R
import clarityapplications.nobelprize.models.Prizes
import kotlinx.android.synthetic.main.list_item_prize.view.*

class PrizesAdapter(private val list: List<Prizes>, private val clickListener: (Prizes) -> Unit)
    : RecyclerView.Adapter<PrizesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : PrizesViewHolder {

        val inflater = LayoutInflater.from(parent.context)

        return PrizesViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: PrizesViewHolder, position: Int) {

        val prize: Prizes = list[position]
        holder.bind(prize, clickListener)
    }

    override fun getItemCount(): Int = list.size
}

class PrizesViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item_prize, parent, false)) {

    fun bind(prize: Prizes, clickListener: (Prizes) -> Unit) {
        itemView.list_title?.text = prize.category
        itemView.list_description?.text = prize.year.toString()
        itemView.setOnClickListener { clickListener(prize) }
    }
}