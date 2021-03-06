package com.me.baseAndroid.nav

import androidx.annotation.CallSuper
import kotlinx.android.synthetic.main.base_arch_module_layout_toolbar.*

/*
 * *
 *  * Created by Abanoub Milad Nassief Hanna
 *  * on 5/1/20 11:05 PM
 *  * Last modified 5/1/20 11:05 PM
 *
 */
abstract class ToolbarNavFragment : NavFragment() {

    open fun onToolbarLeftButtonClick() {
        activity?.onBackPressed()
    }

    @CallSuper
    override fun onCreated() {

        iv_left.setOnClickListener {
            onToolbarLeftButtonClick()
        }
    }
}