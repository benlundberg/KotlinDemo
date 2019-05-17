package clarityapplications.nobelprize.activities

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import clarityapplications.nobelprize.R
import clarityapplications.nobelprize.managers.PrizeManager
import clarityapplications.nobelprize.models.Laureates
import kotlinx.android.synthetic.main.activity_scrolling.*
import kotlinx.android.synthetic.main.content_scrolling.*

class ScrollingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val category = intent.getStringExtra("KeyCategory")
        val year = intent.getIntExtra("KeyYear", -1)

        val prize = PrizeManager.getPrizeByCategory(category, year)

        if (prize != null) {

            title = prize.category.toUpperCase() + " " + prize.year

            scrolling_description.text = prize.overallMotivation

            var list = ArrayList<String>()

            for (i in 1 until 100) {
                list.add("Hello World")
            }

            val laureates = prize.laureates.map { it.firstname }

            list_view_laureates.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list)
        }
    }
}
