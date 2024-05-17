package com.asyabab.endora.data.network

import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import org.json.JSONObject
import java.io.File


/**
 * Created by Silva on 05/26/2020.
 */

class APIRequest {
    companion object {
        val BASE_URL_WEBVIEW = "https://webview.ruangpraktek.id"
        //        val BASE_URL_WEBVIEW = "https://webview.ruangpraktek.id"
    }

    private val BASE_URL = " http://endoracare.com/api/"

    private val TAG = "hasil"
    private val gson = GsonBuilder().create()
    private var requestUrl = ""

   
}

