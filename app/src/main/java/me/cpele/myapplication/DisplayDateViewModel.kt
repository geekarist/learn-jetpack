package me.cpele.myapplication

import android.app.Application
import android.text.format.DateUtils
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*

class DisplayDateViewModel(private val app: Application) : AndroidViewModel(app) {

    private val _greeting: MutableLiveData<String> = MutableLiveData()
    val greeting: LiveData<String>
        get() = _greeting

    private val _clock: MutableLiveData<String> = MutableLiveData()
    val clock: LiveData<String>
        get() = _clock

    fun init(name: String?) {
        _greeting.postValue(app.getString(R.string.hello, name))
        _clock.postValue(
                app.getString(
                        R.string.disp_date_current,
                        DateUtils.formatDateTime(
                                app,
                                Date().time,
                                DateUtils.FORMAT_SHOW_TIME
                        )
                )
        )
    }
}
