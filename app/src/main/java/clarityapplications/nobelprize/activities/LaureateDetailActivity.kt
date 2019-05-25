package clarityapplications.nobelprize.activities

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import clarityapplications.nobelprize.R
import clarityapplications.nobelprize.models.Laureate
import clarityapplications.nobelprize.utils.load
import clarityapplications.nobelprize.utils.then
import clarityapplications.nobelprize.viewmodels.LaureateDetailViewModel
import kotlinx.android.synthetic.main.activity_laureate_detail.*

class LaureateDetailActivity : AppCompatActivity() {

    companion object {
        const val KEY_ID = "KeyId"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laureate_detail)
        setSupportActionBar(toolbar)

        fab_fav_laureate.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val viewModel = ViewModelProviders.of(this).get(LaureateDetailViewModel::class.java)

        val id = intent.getIntExtra(KEY_ID, -1)

        load {
            viewModel.getLaureateById(id)
        } then {
            displayLaureate(it)
        }
    }

    private fun displayLaureate(laureate: Laureate?) {

        if (laureate != null) {
            title = laureate.toString().toUpperCase()

        }
    }
}
