/*
 * *
 *  * Created by Abanoub Milad Nassief Hanna
 *  * on 8/13/20 4:06 PM
 *  * Last modified 8/13/20 4:06 PM
 *
 */

package com.me.demo.demo.tab0

import com.me.demo.R
import com.me.demo.demo.BaseFragment
import com.me.demo.demo.showSnackbar
import kotlinx.android.synthetic.main.fragment_welcome.*

/**
 * Shows the main title screen with a button that navigates to [About1].
 */
class Welcome : BaseFragment() {
    override val layoutId = R.layout.fragment_welcome

    override fun onCreated() {
        about_btn.setOnClickListener {
            iNav?.navigate(About1())
        }

    }


    override fun onVisible() {

        showSnackbar("welcome")
    }
}
