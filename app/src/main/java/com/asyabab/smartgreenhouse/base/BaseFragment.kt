package com.asyabab.endora.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.asyabab.endora.data.Repository
import com.asyabab.smartgreenhouse.App

open class BaseFragment : Fragment() {
    private lateinit var progressBar: AlertDialog

    protected val repository: Repository?
        get() = (requireActivity().application as App).repository

    protected val loadingDialog: AlertDialog?
        get() = progressBar


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}
