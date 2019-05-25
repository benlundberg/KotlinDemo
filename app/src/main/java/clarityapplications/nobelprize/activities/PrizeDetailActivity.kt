package clarityapplications.nobelprize.activities

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import clarityapplications.nobelprize.R
import clarityapplications.nobelprize.adapters.SimpleListItem
import clarityapplications.nobelprize.adapters.SimpleRecyclerAdapter
import clarityapplications.nobelprize.models.Laureate
import clarityapplications.nobelprize.models.Prize
import clarityapplications.nobelprize.utils.load
import clarityapplications.nobelprize.utils.then
import clarityapplications.nobelprize.viewmodels.PrizeDetailViewModel
import kotlinx.android.synthetic.main.activity_prize_detail.*
import kotlinx.android.synthetic.main.activity_prize_detail.toolbar
import kotlinx.android.synthetic.main.content_prize_detail.*
import java.util.*

class PrizeDetailActivity : AppCompatActivity() {

    companion object {
        const val KEY_CATEGORY = "KeyCategory"
        const val KEY_YEAR = "KeyYear"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prize_detail)
        setSupportActionBar(toolbar)

        fab_fav_prize.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val category = intent.getStringExtra(KEY_CATEGORY)
        val year = intent.getIntExtra(KEY_YEAR, -1)

        val viewModel = ViewModelProviders.of(this).get(PrizeDetailViewModel::class.java)

        load {
            viewModel.getPrize(category, year)
        } then {
            displayPrize(it)
        }
    }

    private fun displayPrize(prize: Prize?) {
        if (prize != null) {

            title = prize.category.toUpperCase()

            if (prize.overallMotivation == null || prize.overallMotivation.isEmpty())
                scrolling_description.visibility = View.GONE
            else
                scrolling_description.text = prize.overallMotivation

            recycler_view_laureates.apply {

                layoutManager = LinearLayoutManager(context)

                val simpleListItems = prize.laureates?.map { SimpleListItem(it.toString(), "", it) }

                if (simpleListItems != null)
                    adapter = SimpleRecyclerAdapter(simpleListItems) { any: Any -> openLaureatesDetails(any as Laureate)}
            }
        }
    }

    private fun openLaureatesDetails(laureate: Laureate) {
        val intent = Intent(this, LaureateDetailActivity::class.java)
        intent.putExtra(LaureateDetailActivity.KEY_ID, laureate.id)
        startActivity(intent)
    }
}
