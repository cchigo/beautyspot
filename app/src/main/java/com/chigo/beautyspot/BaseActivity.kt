package com.chigo.beautyspot

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ProgressBar
import androidx.constraintlayout.widget.ConstraintLayout

class BaseActivity : AppCompatActivity() {

   lateinit var mProgressBar: ProgressBar

    override fun setContentView(layoutResID: Int) {
        var constraintLayout = layoutInflater.inflate(R.layout.activity_base, null)
        var frameLayout: FrameLayout = constraintLayout.findViewById(R.id.activity_content)
        mProgressBar = constraintLayout.findViewById(R.id.progress_bar)

        layoutInflater.inflate(layoutResID, frameLayout, false)
        super.setContentView(layoutResID)
    }

    fun showProgressBar(visibility: Boolean){
        //mProgressBar.visibility(visibility ? View.VISIBLE : View.INVISIBLE)
        if(visibility){
            mProgressBar.visibility = View.VISIBLE
        }else{
            mProgressBar.visibility = View.INVISIBLE
        }
    }
}
