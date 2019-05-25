package clarityapplications.nobelprize.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import clarityapplications.nobelprize.R
import kotlinx.android.synthetic.main.list_item_prize.view.*

class SimpleRecyclerAdapter(private val list: List<SimpleListItem>, private val clickListener: (Any) -> Unit) :
    RecyclerView.Adapter<SimpleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder {

        val inflater = LayoutInflater.from(parent.context)

        return SimpleViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {

        val item: SimpleListItem = list[position]

        holder.bind(item, clickListener)
    }

    override fun getItemCount(): Int = list.size
}

class SimpleViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item_prize, parent, false)) {

    fun bind(item: SimpleListItem, clickListener: (Any) -> Unit) {

        // Title
        itemView.list_title?.text = item.title

        // Subtitle is only visible if there is text
        if (item.subTitle == null || item.subTitle.isEmpty())
            itemView.list_description.visibility = View.GONE
        else
            itemView.list_description?.text = item.subTitle

        // Click listener
        itemView.setOnClickListener { clickListener(item.tag) }
    }
}

data class SimpleListItem(
    val title: String,
    val subTitle: String,
    val tag: Any
)