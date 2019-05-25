package clarityapplications.nobelprize.fragments

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import clarityapplications.nobelprize.R
import clarityapplications.nobelprize.activities.ScrollingActivity
import clarityapplications.nobelprize.adapters.PrizesAdapter
import clarityapplications.nobelprize.models.Prizes
import clarityapplications.nobelprize.utils.load
import clarityapplications.nobelprize.utils.then
import clarityapplications.nobelprize.viewmodels.PrizesViewModel
import kotlinx.android.synthetic.main.prizes_fragment.*

class PrizesFragment : Fragment() {

    companion object {
        fun newInstance() = PrizesFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.prizes_fragment, container, false)
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

    private fun displayPrizes(prizes: List<Prizes>) {
        list_recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = PrizesAdapter(prizes) { prize: Prizes -> prizeClicked(prize) }
        }
    }

    private fun prizeClicked(prize: Prizes) {
        val intent = Intent(activity, ScrollingActivity::class.java)
        intent.putExtra("KeyCategory", prize.category)
        intent.putExtra("KeyYear", prize.year)
        startActivity(intent)
    }
}
