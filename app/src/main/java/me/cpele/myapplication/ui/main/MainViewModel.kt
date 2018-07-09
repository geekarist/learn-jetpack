package me.cpele.myapplication.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import me.cpele.myapplication.R

class MainViewModel : ViewModel() {

    val name: MutableLiveData<String> = MutableLiveData()
    var checkedId: Int? = null

    fun nextDirection(): NavDirections = when (checkedId) {
        R.id.mainRadioButtonDate -> MainFragmentDirections.MainActionNextDate().setName(name.value)
        else -> MainFragmentDirections.MainActionNextOne()
    }
}
