package com.example.test_kotlindevelop_xml

import android.media.AudioManager
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //Блок инициализации переменных
    var switch = 0
    var replic_counter = -1
    var epifan_pos = mutableListOf<Float>(
        0.9F,
        0.1F
    )

    val replics = mutableListOf<String>(
        "Идейные соображения высшего порядка, а также укрепление и развитие структуры играет важную роль в формировании модели развития. Идейные соображения высшего порядка, а также постоянное информационно-пропагандистское обеспечение нашей деятельности играет важную роль в формировании форм развития.",
        "Ты че, поехавший? Ты че несешь?!",
        "Ты просто не в состоянии этого понять, ведь на самом деле поехавший - это ты!",
        "А может ты поехавший?",
        "Ну вот, я же говорил тебе не есть сладкий хлеб, а ты...",
        "Уааааа-ааааааааааа!",
        "Ты че больной?",
        "А ты че меня лечишь падла?",
        "Да я еще и не начинал, ахахахахах",
        "Ты что сдурел?",
    )
    private var soundPool: SoundPool? = null
    private var soundId1 = 0
    private var soundId2 = 0
    private var soundId3 = 0
    private var soundId4 = 0
    private var soundId5 = 0
    private var soundId6 = 0
    private var leftVolume = 1F
    private var rightVolume = 1F
    private var soundPriorityGlobal = 1


    fun playSound(sound: Int) {
        var soundIdBuffer = 0
        when (sound) {
            1 -> soundIdBuffer = soundId1
            2 -> soundIdBuffer = soundId2
            3 -> soundIdBuffer = soundId3
            4 -> soundIdBuffer = soundId4
            5 -> soundIdBuffer = soundId5
            6 -> soundIdBuffer = soundId6

        }
        soundPool?.play(soundIdBuffer, leftVolume, rightVolume, soundPriorityGlobal, 0, 1F)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        soundPool = SoundPool(25, AudioManager.STREAM_MUSIC, 0)
        soundId1 = soundPool!!.load(baseContext, R.raw.epifan_rage_scream, soundPriorityGlobal)
        soundId2 = soundPool!!.load(baseContext, R.raw.epifan_mudr_1, soundPriorityGlobal)
        soundId3 = soundPool!!.load(baseContext, R.raw.epifan_mudr_2, soundPriorityGlobal)
        soundId4 = soundPool!!.load(baseContext, R.raw.epifan_mudr_3, soundPriorityGlobal)
        soundId5 = soundPool!!.load(baseContext, R.raw.epifan_mudr_4, soundPriorityGlobal)
        soundId6 = soundPool!!.load(baseContext, R.raw.epifan_mudr_5, soundPriorityGlobal)



        findViewById<ImageView>(R.id.epifan).setOnClickListener {
            if(replic_counter>10)
            {replic_counter=0}
            switch()
        }
    }
    fun switch() {
        replic_counter++
        switch++

        epifan_text.text = replics[replic_counter]

        when (switch) {
            1 -> {
                epifan.setImageResource(R.drawable.epifan_mudr)
                ConstraintMain.setHorizontalBias(R.id.epifan, epifan_pos[1])
                playSound(2)
            }
            2 -> {
                epifan.setImageResource(R.drawable.epifan_rage)
                ConstraintMain.setHorizontalBias(R.id.epifan, epifan_pos[0])
                playSound(1)
            }
            3 -> {
                epifan.setImageResource(R.drawable.epifan_mudr)
                ConstraintMain.setHorizontalBias(R.id.epifan, epifan_pos[1])
                playSound(3)
            }
            4 -> {
                epifan.setImageResource(R.drawable.epifan_rage)
                ConstraintMain.setHorizontalBias(R.id.epifan, epifan_pos[0])
                playSound(1)
            }
            5 -> {
                epifan.setImageResource(R.drawable.epifan_mudr)
                ConstraintMain.setHorizontalBias(R.id.epifan, epifan_pos[1])
                playSound(4)
            }
            6 -> {
                epifan.setImageResource(R.drawable.epifan_rage)
                ConstraintMain.setHorizontalBias(R.id.epifan, epifan_pos[0])
                playSound(1)
            }
            7 -> {
                epifan.setImageResource(R.drawable.epifan_mudr)
                ConstraintMain.setHorizontalBias(R.id.epifan, epifan_pos[1])
                playSound(5)
            }
            8 -> {
                epifan.setImageResource(R.drawable.epifan_rage)
                ConstraintMain.setHorizontalBias(R.id.epifan, epifan_pos[0])
                playSound(1)
            }
            9 -> {
                epifan.setImageResource(R.drawable.epifan_mudr)
                ConstraintMain.setHorizontalBias(R.id.epifan, epifan_pos[1])
            }
            10 -> {
                epifan.setImageResource(R.drawable.epifan_rage)
                ConstraintMain.setHorizontalBias(R.id.epifan, epifan_pos[0])
                playSound(1)
            }
            else -> {
                switch = 0
                replic_counter = 0
            }
        }
    }

    fun ConstraintLayout.setHorizontalBias(
        targetViewId: Int,
        bias: Float
    ) {
        val constraintSet = ConstraintSet()
        constraintSet.clone(this)
        constraintSet.setHorizontalBias(targetViewId, bias)
        constraintSet.applyTo(this)
    }
}