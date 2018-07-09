package me.cpele.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_display_date.*


class DisplayDateFragment : Fragment() {

    private val viewModel: DisplayDateViewModel
        get() = ViewModelProviders.of(this).get(DisplayDateViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.init(name = DisplayDateFragmentArgs.fromBundle(arguments).name)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_display_date, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.greeting.observe(this, Observer { dispDateName.text = it })
        viewModel.clock.observe(this, Observer { dispDateClock.text = it })
    }
}
