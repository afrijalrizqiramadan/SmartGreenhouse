package com.asyabab.smartgreenhouse.base

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.asyabab.endora.utils.getAppColor
import com.asyabab.endora.utils.lightStatusBar
import com.asyabab.smartgreenhouse.R


open class BaseActivity : AppCompatActivity() {

    private lateinit var progressBar: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lightStatusBar(getAppColor(R.color.dp_app_background))

    }

}
