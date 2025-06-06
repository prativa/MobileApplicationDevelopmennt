package com.example.animation

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.withStyledAttributes
import com.example.broadcastreceiverapplication.R

class ViewAnimationDemo @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private lateinit var imageView: ImageView
    private lateinit var btnFadeIn: Button
    private lateinit var btnSlideUp: Button
    private lateinit var btnRotate: Button
    private lateinit var btnBounce: Button
    private lateinit var btnSequence: Button

    init {
        orientation = VERTICAL
        inflate(context, R.layout.view_animation_demo, this)

        imageView = findViewById(R.id.animation_image)
        btnFadeIn = findViewById(R.id.btn_fade_in)
        btnSlideUp = findViewById(R.id.btn_slide_up)
        btnRotate = findViewById(R.id.btn_rotate)
        btnBounce = findViewById(R.id.btn_bounce)
        btnSequence = findViewById(R.id.btn_sequence)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        btnFadeIn.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(context, R.anim.fade_in)
            imageView.startAnimation(animation)
        }

        btnSlideUp.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(context, R.anim.slide_up)
            imageView.startAnimation(animation)
        }

        btnRotate.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(context, R.anim.rotate)
            imageView.startAnimation(animation)
        }

        btnBounce.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(context, R.anim.bounce)
            imageView.startAnimation(animation)
        }

        btnSequence.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(context, R.anim.sequential)
            imageView.startAnimation(animation)
        }
    }
}