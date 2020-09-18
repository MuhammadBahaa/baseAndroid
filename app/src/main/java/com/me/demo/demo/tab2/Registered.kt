/*
 * *
 *  * Created by Abanoub Milad Nassief Hanna
 *  * on 8/13/20 4:06 PM
 *  * Last modified 8/13/20 4:06 PM
 *
 */

package com.me.demo.demo.tab2

import com.me.demo.R
import com.me.demo.demo.BaseFragment
import com.me.demo.demo.showSnackbar


/**
 * Shows "Done".
 */
class Registered : BaseFragment() {
    override val layoutId = R.layout.fragment_registered


    override fun onCreated() {


    }

    override fun onVisible() {

        showSnackbar("Registered")
    }
}
