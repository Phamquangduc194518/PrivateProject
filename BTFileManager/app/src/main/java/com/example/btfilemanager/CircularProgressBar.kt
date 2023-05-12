package com.example.btfilemanager

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.duypdu007.filemanagerandroids.R
import kotlin.math.min

class CircularProgressBar(context: Context, attrs: AttributeSet) : View(context, attrs) {
    // Khai báo các thuộc tính và biến cần thiết
    private var progress = 0f // Giá trị progress (0-100)
    private var strokeWidth = 20f // Độ dày của vòng tròn
    private var progressColor = Color.BLUE // Màu sắc của vòng tròn
    private var bgColor = Color.GRAY // Màu sắc nền của vòng tròn

    private var layoutWidth = 0
    private var layoutHeight = 0

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircularProgressBar)

        progress = typedArray.getFloat(R.styleable.CircularProgressBar_progress, 0f)
        strokeWidth = typedArray.getDimension(R.styleable.CircularProgressBar_strokeWidth, 5f)
        progressColor = typedArray.getColor(R.styleable.CircularProgressBar_progressColor, Color.BLUE)
        bgColor = typedArray.getColor(R.styleable.CircularProgressBar_bgColor, Color.GRAY)
        typedArray.recycle()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        layoutWidth = MeasureSpec.getSize(widthMeasureSpec)
        layoutHeight = MeasureSpec.getSize(heightMeasureSpec)

        val diameter = min(layoutWidth, layoutHeight)
        setMeasuredDimension(diameter, diameter)
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val cx = layoutWidth / 2f
        val cy = layoutHeight / 2f
        val radius = min(cx,cy) - strokeWidth/2f

        // Vẽ đường tròn ProgressBar
        val bgPaint = Paint()
        bgPaint.style = Paint.Style.STROKE
        bgPaint.strokeWidth = strokeWidth
        bgPaint.color = Color.GRAY
        bgPaint.isAntiAlias = true
        canvas?.drawCircle(cx, cy, radius, bgPaint)

        // Vẽ nút trên đường tròn ProgressBar
        val progressAngle = progress / 100f * 360f
        val progressPaint = Paint()
        progressPaint.style = Paint.Style.STROKE
        progressPaint.strokeWidth = strokeWidth
        progressPaint.color = progressColor
        progressPaint.strokeCap = Paint.Cap.ROUND
        progressPaint.isAntiAlias = true

        canvas?.drawArc(
            cx - radius,
            cy - radius,
            cx + radius,
            cy + radius,
            -90f,
            progressAngle,
            false,
            progressPaint
        )
    }

    fun setProgress(value: Float) {
        progress = value
        invalidate()
    }
}