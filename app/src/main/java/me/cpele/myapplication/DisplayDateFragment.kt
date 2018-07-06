package me.cpele.myapplication

import android.os.Bundle
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_display_date.*
import java.util.*


class DisplayDateFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_display_date, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dispDateName.text = String.format("Hello %s!", arguments?.getString("name"))
        dispDateClock.text = getString(
                R.string.disp_date_current,
                DateUtils.formatDateTime(
                        context,
                        Date().time,
                        DateUtils.FORMAT_SHOW_TIME
                )
        )
    }
}
