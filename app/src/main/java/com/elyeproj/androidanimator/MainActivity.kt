package com.elyeproj.androidanimator

import android.animation.ValueAnimator.*
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_press_me.setOnClickListener {
            animateThis()
        }
    }

    private fun animateThis() {
        ofFloat(0f, 3600f).apply {
            repeatMode = REVERSE
            repeatCount = INFINITE
            interpolator = AccelerateDecelerateInterpolator()
            duration = 10000
            addUpdateListener { animation ->
                val progress = animation.animatedValue as Float
                text_happy.rotationX = progress
                text_arrow.rotationY = progress
                view_fan.rotation = progress
                view_cloud.alpha = (3600  - progress)/3600
                view_sun.scaleX = progress/3600 + 1
                view_sun.scaleY = progress/3600 + 1
                view_hotair.translationY = - progress/10
                view_yatch.translationX = progress/10
                btn_press_me.translationZ = progress/50
            }
        }.start()
    }
}
