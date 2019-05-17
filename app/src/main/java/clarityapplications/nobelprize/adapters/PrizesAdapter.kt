package clarityapplications.nobelprize.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import clarityapplications.nobelprize.models.Prizes
import clarityapplications.nobelprize.viewmodels.PrizesViewHolder

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