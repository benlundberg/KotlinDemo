package clarityapplications.nobelprize.fragments

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import clarityapplications.nobelprize.R
import clarityapplications.nobelprize.activities.PrizeDetailActivity
import clarityapplications.nobelprize.adapters.SimpleListItem
import clarityapplications.nobelprize.adapters.SimpleRecyclerAdapter
import clarityapplications.nobelprize.models.Prize
import clarityapplications.nobelprize.utils.load
import clarityapplications.nobelprize.utils.then
import clarityapplications.nobelprize.viewmodels.PrizesViewModel
import kotlinx.android.synthetic.main.fragment_prizes.*

class PrizesFragment : Fragment() {

    companion object {
        fun newInstance() = PrizesFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_prizes, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val viewModel = ViewModelProviders.of(this).get(PrizesViewModel::class.java)

        progress_circular.visibility = View.VISIBLE

        load {

            // Background thread
            viewModel.loadPrizes()

        } then {

            // UI thread
            progress_circular.visibility = View.GONE
            if (it != null) {
                displayPrizes(it)
            }
        }
    }

    private fun displayPrizes(prizes: List<Prize>) {
        list_recycler_view.apply {

            layoutManager = LinearLayoutManager(activity)

            val simpleListItems = prizes.map { SimpleListItem(it.category, it.year.toString(), it) }

            adapter = SimpleRecyclerAdapter(simpleListItems) { any: Any -> openPrizeDetails(any as Prize) }
        }
    }

    private fun openPrizeDetails(prize: Prize) {
        val intent = Intent(activity, PrizeDetailActivity::class.java)
        intent.putExtra(PrizeDetailActivity.KEY_CATEGORY, prize.category)
        intent.putExtra(PrizeDetailActivity.KEY_YEAR, prize.year)
        startActivity(intent)
    }
}
