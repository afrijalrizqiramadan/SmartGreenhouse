package com.asyabab.endora.data


import android.content.Context
import com.asyabab.endora.data.local.SharedPrefHelper
import com.asyabab.endora.data.network.APIRequest
import java.io.File
import java.util.*

class Repository(private val mContext: Context) {

    private val apiRequest: APIRequest = APIRequest()

    private val prefs: SharedPrefHelper = SharedPrefHelper(mContext)

    private var city = ArrayList<String>()
    private var spesialis = ArrayList<String>()

}