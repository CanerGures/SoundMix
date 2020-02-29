package com.example.mixsoundlib

import android.content.Context
import android.os.Build
import android.speech.tts.TextToSpeech
import android.widget.Toast

infix fun String.toast(context: Context?) = Toast.makeText(context, this, Toast.LENGTH_LONG).show()

@Suppress("DEPRECATION")
fun TextToSpeech.speak() = when {
    Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP -> {
        this.speak(MixSound.recordSound, TextToSpeech.QUEUE_FLUSH, null, null)
    }
    else -> this.speak(MixSound.recordSound, TextToSpeech.QUEUE_FLUSH, null)

}