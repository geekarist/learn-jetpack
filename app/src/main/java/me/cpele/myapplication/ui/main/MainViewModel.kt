package me.cpele.myapplication.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val name: MutableLiveData<String> = MutableLiveData()
}
