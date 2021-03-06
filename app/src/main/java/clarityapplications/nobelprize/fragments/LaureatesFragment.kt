package clarityapplications.nobelprize.fragments

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import clarityapplications.nobelprize.R
import clarityapplications.nobelprize.viewmodels.LaureatesViewModel

class LaureatesFragment : Fragment() {

    companion object {
        fun newInstance() = LaureatesFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_laureates, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val viewModel = ViewModelProviders.of(this).get(LaureatesViewModel::class.java)


    }
}
