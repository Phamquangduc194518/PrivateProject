package com.example.customview

import android.content.Context
import android.graphics.*
import android.os.Handler
import android.util.AttributeSet
import android.view.View
import java.text.SimpleDateFormat
import java.util.*

class ClockViewKotlin :View, Runnable{
    val hn = Handler()
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs){
        hn.postDelayed(this, 1000)

    }
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ){
        hn.postDelayed(this, 1000)
    }

    constructor(
        context: Context,
        attrs: AttributeSet,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes){
        hn.postDelayed(this, 1000)
    }

    override fun run() {
        invalidate()
        hn.postDelayed(this, 100    )
    }

    override protected fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val paint = Paint()
        paint.color = Color.parseColor("#FFFF00")
        paint.style = Paint.Style.STROKE
        canvas.rotate(30F, 10F, 10F)
        paint.strokeWidth = 12f
        paint.isAntiAlias = true
        val radius = if (width < height) width/2 else height/2
        canvas.drawCircle(width.toFloat()/2,
            height.toFloat()/2, radius.toFloat()-6,
            paint)
        drawTextTime(canvas)
//        drawImage(canvas)
    }

    private fun drawTextTime(canvas: Canvas){
        val currentDate = Date()
        val format = SimpleDateFormat("HH:mm:ss")
        val strTime = format.format(currentDate)
        val p = Paint()
        p.textSize = 112f
        val bold = Typeface.create(p.typeface,
            Typeface.BOLD.xor(Typeface.ITALIC) )
        p.typeface = bold

        val rect = Rect()
        p.getTextBounds(strTime,0, strTime.length, rect)

        canvas.drawText(strTime,
            (width-rect.width().toFloat())/2,
            300f, p)

    }


}
