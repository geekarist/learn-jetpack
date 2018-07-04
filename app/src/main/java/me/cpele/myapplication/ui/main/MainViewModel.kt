package me.cpele.myapplication.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var _name = MutableLiveData<String>()
    val name: LiveData<String>
        get() = _name
}
