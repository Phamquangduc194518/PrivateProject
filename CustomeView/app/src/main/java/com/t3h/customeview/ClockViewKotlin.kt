package com.t3h.customeview

import android.content.Context
import android.content.res.TypedArray
import android.graphics.*
import android.os.Handler
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
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
        val paint: Paint = Paint()
        paint.setColor(Color.parseColor("#FFFF00"))
        paint.color = Color.parseColor("#FFFF00")
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 10f
        paint.isAntiAlias = true
//        canvas.rotate(10F,12F, 13F)
//        canvas.drawRect(12f,12f,12f,12f,paint)
        val radius = if (width < height) width/2 else height/2
        canvas.drawCircle(width.toFloat()/2,
            height.toFloat()/2, radius.toFloat()-6,
        paint)
//        drawTextTime(canvas)
        drawImage(canvas)
    }

//    private fun drawTextTime(canvas: Canvas){
//        val currentDate = Date()
//        val format = SimpleDateFormat("HH:mm:ss")
//        val strTime = format.format(currentDate)
//        val p = Paint()
//        p.textSize = 112f
//        val bold = Typeface.create(p.typeface,
//            Typeface.BOLD.xor(Typeface.ITALIC) )
//        p.typeface = bold
//
//        val rect = Rect()
//        p.getTextBounds(strTime,0, strTime.length, rect)
//
//        canvas.drawText(strTime,
//            (width-rect.width().toFloat())/2,
//            300f, p)
//
//    }

    fun setMargins(view: View, left: Int, top: Int, right: Int, bottom: Int) {
        val layoutParams = view.layoutParams as ViewGroup.MarginLayoutParams
        layoutParams.setMargins(left, top, right, bottom)
        view.layoutParams = layoutParams
    }


    private fun drawImage(canvas: Canvas){
        val bm:Bitmap = BitmapFactory.decodeResource(
            context.resources, R.drawable.clock
        )
        canvas.drawBitmap(bm, (width-bm.width.toFloat())/2,
            500f, null)
    }

    private fun getAttributeSet(attrs: AttributeSet){
         val type= context.obtainStyledAttributes(attrs, R.styleable.ClockViewKotlin)



    }
}