package br.com.ztx.beagle_1.components

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import br.com.ztx.beagle_1.R
import kotlinx.android.synthetic.main.widget_beagle.view.*

class TitleIncreaseComponent(context: Context): LinearLayout(context) {
    init {
        View.inflate(context, R.layout.widget_beagle, this)
        changeTitleSize()
    }

    fun setTitleText(title: String) {
        tvExampleTitle.text = title
    }

    fun setTitleButton1(titleButton:String){
        btIncrease.text = titleButton
    }
    fun setTitleButton2(titleButton:String){
        btDecrease.text = titleButton
    }

    private fun changeTitleSize(){

        var size = tvExampleTitle.textSize
        tvExampleTitle.textSize = size
        Toast.makeText(context, size.toString(), Toast.LENGTH_SHORT).show()

        val textView = findViewById<TextView>(R.id.tvExampleTitle)
        val b1 = findViewById<Button>(R.id.btIncrease)
        val b2 = findViewById<Button>(R.id.btDecrease)

        b1.setOnClickListener {
            if(size < 50){
                size += 5f
                tvExampleTitle.textSize = size
            }
            Toast.makeText(context, size.toString(), Toast.LENGTH_SHORT).show()
        }

        b2.setOnClickListener {
            if(size > 5){
                size -= 5f
                tvExampleTitle.textSize = size
            }
            Toast.makeText(context, size.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}