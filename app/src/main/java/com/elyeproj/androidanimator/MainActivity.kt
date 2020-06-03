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
        View.ALPHA
        val valueAnimator = ofFloat(0f, 3600f)
        valueAnimator.repeatMode = REVERSE
        valueAnimator.repeatCount = INFINITE
        valueAnimator.interpolator = AccelerateDecelerateInterpolator()
        valueAnimator.duration = 10000
        valueAnimator.addUpdateListener { animation ->
            val progress = animation.animatedValue as Float
            text_me_5.rotationX = progress - 100
            text_me_4.rotationX = progress - 80
            text_me_3.rotationX = progress - 60
            text_me_2.rotationX = progress - 40
            text_me_1.rotationX = progress - 20
            text_me.rotationX = progress
            text_me2.rotationX = progress + 20
            text_me3.rotationX = progress + 40
            text_me4.rotationX = progress + 60
            text_me5.rotationX = progress + 80
            text_me6.rotationX = progress + 100

            text_arrow.rotationY = progress

            view_ball.rotation = progress
            view_ball.scaleX = progress / 3600 + 1
            view_ball.scaleY = progress / 3600 + 1
            view_ball.z = progress
            view_fan.rotation = progress
            view_cloud.alpha = (3600  - progress)/3600
            view_sun.scaleX = progress/3600 + 1
            view_sun.scaleY = progress/3600 + 1

            view_hotair.translationY = - progress/10
            view_yatch.translationX = progress/10
            btn_press_me.translationZ = progress/50


        }
        valueAnimator.start()
    }
}
