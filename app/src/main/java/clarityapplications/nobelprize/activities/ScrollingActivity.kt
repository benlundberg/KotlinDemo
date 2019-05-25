package clarityapplications.nobelprize.activities

import android.os.Bundle
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

        val category = intent.getStringExtra("KeyCategory")
        val year = intent.getIntExtra("KeyYear", -1)

        val prize = PrizeManager.getPrizeByCategory(category, year)

        if (prize != null) {

            title = prize.category.toUpperCase() + " " + prize.year

            scrolling_description.text = prize.overallMotivation

            list_view_laureates.adapter = ArrayAdapter<Laureates>(this, android.R.layout.simple_list_item_1, prize.laureates)
        }
    }
}
