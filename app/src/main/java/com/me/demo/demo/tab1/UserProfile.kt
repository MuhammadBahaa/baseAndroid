/*
 * *
 *  * Created by Abanoub Milad Nassief Hanna
 *  * on 8/13/20 4:06 PM
 *  * Last modified 8/13/20 4:06 PM
 *
 */

package com.me.demo.demo.tab1

import com.me.demo.R
import com.me.demo.demo.BaseFragment
import com.me.demo.demo.showSnackbar
import com.me.demo.demo.tab1.MyAdapter.Companion.USERNAME_KEY
import kotlinx.android.synthetic.main.fragment_user_profile.*


/**
 * Shows a profile screen for a user, taking the name from the arguments.
 */
class UserProfile : BaseFragment() {
    override val layoutId = R.layout.fragment_user_profile

    override fun onCreated() {

        val name = arguments?.getString(USERNAME_KEY) ?: "Ali Connors"
        profile_user_name.text = name
    }


    override fun onVisible() {

        showSnackbar("profile")
    }
}
