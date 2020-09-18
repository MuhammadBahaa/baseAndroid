/*
 * *
 *  * Created by Abanoub Milad Nassief Hanna
 *  * on 9/18/20 2:25 AM
 *  * Last modified 9/11/20 8:56 PM
 *
 */

package com.me.baseAndroid.base

import android.os.Bundle
import androidx.annotation.CallSuper
import com.me.baseAndroid.R
import org.abanoubmilad.labyrinth.INavHolder
import org.abanoubmilad.labyrinth.LabyrinthSingle

open class BaseSingleNavActivity : AlertDisconnectionActivity(), INavHolder {
    override val layoutId = R.layout.base_arch_module_single_nav_activity

    lateinit var labyrinth: LabyrinthSingle
    override fun getINav() = labyrinth

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        labyrinth = LabyrinthSingle.Builder(
            fragmentManager = supportFragmentManager,

            fragmentContainerId = R.id.nav_host_container
        ).build()
    }


    override fun onBackPressed() {
        if (labyrinth.shouldCallSuperOnBackPressed())
            super.onBackPressed()
    }
}
