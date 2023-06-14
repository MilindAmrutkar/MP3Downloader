package com.backtocoding.mp3downloader.screens.initial

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yausername.youtubedl_android.YoutubeDL
import com.yausername.youtubedl_android.mapper.VideoInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class InitialScreenViewModel: ViewModel() {

    val vidFormats: MutableLiveData<VideoInfo> = MutableLiveData()

    fun fetchInfo(url: String) {
        viewModelScope.launch {
            try {
                val vidInfo = withContext(Dispatchers.IO) {
                    YoutubeDL.getInstance().getInfo(url)
                }
                Log.d("InitialScreenVM", "GreetingPreview: $vidInfo")
                vidFormats.value = vidInfo
            } catch (e: Exception) {
                Log.d("InitialScreenVM", "Error: $e")
            }
        }
    }

}