package com.example.animation

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class SimpleDrawingView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint().apply {
        color = Color.BLACK
        style = Paint.Style.STROKE
        strokeWidth = 5f
        isAntiAlias = true
    }

    private val rect = RectF(100f, 100f, 500f, 300f)
    private val path = Path()

    init {
        // Create a simple path (a triangle)
        path.moveTo(200f, 400f)
        path.lineTo(400f, 400f)
        path.lineTo(300f, 600f)
        path.close()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Set background color
        canvas.drawColor(Color.LTGRAY)

        // Draw a rectangle
        paint.color = Color.RED
        canvas.drawRect(rect, paint)

        // Draw a circle
        paint.color = Color.BLUE
        canvas.drawCircle(300f, 200f, 50f, paint)

        // Draw the path (triangle)
        paint.color = Color.GREEN
        canvas.drawPath(path, paint)

        // Draw some text
        paint.color = Color.BLACK
        paint.textSize = 60f
        paint.style = Paint.Style.FILL
        canvas.drawText("Canvas Demo", 100f, 700f, paint)
    }
}