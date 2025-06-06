package com.example.animation

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.BounceInterpolator
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.broadcastreceiverapplication.R

class PropertyAnimationDemo @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private lateinit var imageView: ImageView
    private lateinit var btnMove: Button
    private lateinit var btnColorChange: Button
    private lateinit var btnScale: Button
    private lateinit var btnCombo: Button
    private lateinit var btnValueAnimator: Button

    init {
        orientation = VERTICAL
        inflate(context, R.layout.property_animation_demo, this)

        imageView = findViewById(R.id.animation_image)
        btnMove = findViewById(R.id.btn_move)
        btnColorChange = findViewById(R.id.btn_color_change)
        btnScale = findViewById(R.id.btn_scale)
        btnCombo = findViewById(R.id.btn_combo)
        btnValueAnimator = findViewById(R.id.btn_value_animator)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        btnMove.setOnClickListener {
            val animator = ObjectAnimator.ofFloat(
                imageView,
                View.TRANSLATION_X,
                0f,
                300f
            ).apply {
                duration = 1000
                interpolator = AccelerateDecelerateInterpolator()
                repeatCount = 1
                repeatMode = ObjectAnimator.REVERSE
            }
            animator.start()
        }

        btnColorChange.setOnClickListener {
            val animator = ObjectAnimator.ofArgb(
                imageView,
                "backgroundColor",
                Color.RED,
                Color.BLUE,
                Color.GREEN,
                Color.RED
            ).apply {
                duration = 2000
                interpolator = LinearInterpolator()
            }
            animator.start()
        }

        btnScale.setOnClickListener {
            val scaleX = ObjectAnimator.ofFloat(
                imageView,
                View.SCALE_X,
                1f,
                2f
            )
            val scaleY = ObjectAnimator.ofFloat(
                imageView,
                View.SCALE_Y,
                1f,
                2f
            )
            AnimatorSet().apply {
                playTogether(scaleX, scaleY)
                duration = 800
                interpolator = BounceInterpolator()
                start()
            }
        }

        btnCombo.setOnClickListener {
            val moveX = ObjectAnimator.ofFloat(
                imageView,
                View.TRANSLATION_X,
                0f,
                300f
            )
            val moveY = ObjectAnimator.ofFloat(
                imageView,
                View.TRANSLATION_Y,
                0f,
                300f
            )
            val rotate = ObjectAnimator.ofFloat(
                imageView,
                View.ROTATION,
                0f,
                360f
            )
            AnimatorSet().apply {
                playTogether(moveX, moveY, rotate)
                duration = 1500
                start()
            }
        }

        btnValueAnimator.setOnClickListener {
            ValueAnimator.ofFloat(0f, 1f).apply {
                duration = 1000
                addUpdateListener { animation ->
                    val value = animation.animatedValue as Float
                    imageView.alpha = value
                    imageView.scaleX = 1 + value
                    imageView.scaleY = 1 + value
                }
                start()
            }
        }
    }
}