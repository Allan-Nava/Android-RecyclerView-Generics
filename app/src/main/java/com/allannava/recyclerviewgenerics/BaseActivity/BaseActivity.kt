package com.allannava.recyclerviewgenerics.BaseActivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by Allan Nava on 17/02/2023.
 * Updated by Allan Nava on 17/02/2023.
 */

interface BaseOnActivityResult {
    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
}
abstract class BaseActivity : AppCompatActivity(), BaseContracts.View {

    override fun getActivityContext(): Context? {
        return this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //FoottersApplication.
    }

    override fun onResume() {
        super.onResume()
        MyApplication.activityResumed()
    }

    override fun onPause() {
        //spotDialog?.dismiss()
        super.onPause()
        MyApplication.activityPaused()
    }

    val mScreenWidth: Int
        get() {
            return getWindowManager()?.getDefaultDisplay()?.getWidth()!!
        }

    val mScreenHeight: Int
        get() {
            return getWindowManager()?.getDefaultDisplay()?.getHeight()!!
        }


    override fun attachBaseContext(newBase: Context?) {
        //super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
        try {
            super.attachBaseContext(newBase!!)
        }catch(e: Exception){
            e.printStackTrace()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }

    fun setTopMarginForLayout(layout: View, topMargin: Int?) {
        val layoutParams = layout.layoutParams as ViewGroup.MarginLayoutParams
        layoutParams.topMargin = topMargin!!
        layout.layoutParams = layoutParams
    }

    fun setLateralMarginsForLayout(layout: View, topMargin: Int?) {
        val layoutParams = layout.layoutParams as ViewGroup.MarginLayoutParams
        layoutParams.leftMargin = topMargin!!
        layoutParams.rightMargin = topMargin

        layout.layoutParams = layoutParams
    }

    fun setHeight(layout: FrameLayout, height: Int?) {
        val layoutParams = layout.layoutParams as ViewGroup.MarginLayoutParams
        layoutParams.height = height!!
        layout.layoutParams = layoutParams
    }

    fun dpToPixel(dp: Int): Int {
        val r = resources
        val sizePx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), r.displayMetrics)
        return sizePx.toInt()
    }

}
