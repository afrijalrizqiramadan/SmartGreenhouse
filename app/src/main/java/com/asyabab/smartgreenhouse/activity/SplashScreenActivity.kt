package com.asyabab.smartgreenhouse.activity

import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import com.asyabab.smartgreenhouse.base.BaseActivity
import com.asyabab.endora.utils.getAppColor
import com.asyabab.endora.utils.launchActivity
import com.asyabab.endora.utils.lightStatusBar
import com.asyabab.smartgreenhouse.ActivityHome
import com.asyabab.smartgreenhouse.R

class SplashScreenActivity : BaseActivity() {
    lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)
        lightStatusBar(getAppColor(R.color.white))

        handler = Handler()
        handler.postDelayed({

                launchActivity<ActivityHome>()

                finish()


        }, 2000)
    }


}