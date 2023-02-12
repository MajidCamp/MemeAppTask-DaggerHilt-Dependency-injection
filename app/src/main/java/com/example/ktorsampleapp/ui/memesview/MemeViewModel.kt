package com.example.ktorsampleapp.ui.memesview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ktorsampleapp.model.MemeApi
import com.example.ktorsampleapp.model.meme.MemeItem
import com.example.ktorsampleapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MemeViewModel @Inject constructor(private val memeApi: MemeApi)  : ViewModel() {

    //    private val postApi = PostApiImpl(Provider.client)
    private val _memes: MutableLiveData<Resource<MemeItem>> =
        MutableLiveData(Resource.Loading())
    val memes: LiveData<Resource<MemeItem>> get() = _memes
    var address : String = "d"



    fun getMemes() {
        viewModelScope.launch {
            _memes.value = Resource.Loading()
            _memes.value = memeApi.getMeme(address)
        }
    }

}