package com.backtocoding.mp3downloader

import android.app.Application
import android.util.Log
import com.yausername.ffmpeg.FFmpeg
import com.yausername.youtubedl_android.YoutubeDL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.lang.Exception
class MP3DownloaderApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        try {
            runBlocking {
                YoutubeDL.getInstance().init(this@MP3DownloaderApplication)
                FFmpeg.getInstance().init(this@MP3DownloaderApplication)
            }
        } catch (e: Exception) {
            Log.e("Application Class Exception", "failed to initialize youtubedl-android", e)
        }
    }
}
