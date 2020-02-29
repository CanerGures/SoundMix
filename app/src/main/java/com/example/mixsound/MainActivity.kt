package com.example.mixsound

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mixsoundlib.MixSound
import com.example.mixsoundlib.SoundType


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // val button: Button= findViewById(R.id.button2)
        // button2.text= "Enter"
        // button2.gravity = Gravity.BOTTOM
        //button2.isClickable = false

        val imgMic = findViewById<ImageButton>(R.id.imgb_mic)
        val imgbFast = findViewById<ImageButton>(R.id.imgb_pikachu)
        val imgbSlow = findViewById<ImageButton>(R.id.imgb_charmender)
        val imgbDarthVader = findViewById<ImageButton>(R.id.imgb_abra)
        val imgbChimpmonk = findViewById<ImageButton>(R.id.imgb_snorlax)

        imgMic.setOnClickListener {
            MixSound.getInstance(this).recordSound()
            "ImgMic Clicked" extShowToast this

        }
        imgbFast.setOnClickListener {
            MixSound.getInstance(this).changeSound(SoundType.Chipmunk)
            "imgbFast Clicked" extShowToast this
        }
        imgbSlow.setOnClickListener {
            MixSound.getInstance(this).changeSound(SoundType.Fast)
            "imgbSlow Clicked" extShowToast this
        }
        imgbDarthVader.setOnClickListener {
            MixSound.getInstance(this).changeSound(SoundType.DarthVader)
            "imgbDarthVader Clicked" extShowToast this
        }
        imgbChimpmonk.setOnClickListener {
            MixSound.getInstance(this).changeSound(SoundType.Slow)
            "imgbChimpmonk Clicked" extShowToast this
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            MixSound.CODE_SPEECH_RECOGNIZER -> {
                data?.let {
                    val result = it.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                    MixSound.recordSound = result.first()
                }
            }
        }
    }


}

infix fun String.extShowToast(context: Context) {
    Toast.makeText(context, this, Toast.LENGTH_SHORT).show()
}
