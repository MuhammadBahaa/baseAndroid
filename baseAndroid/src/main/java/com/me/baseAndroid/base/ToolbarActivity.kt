/*
 * *
 *  * Created by Abanoub Milad Nassief Hanna
 *  * on 9/18/20 2:40 AM
 *  * Last modified 9/18/20 2:26 AM
 *
 */

package com.me.baseAndroid.base

import android.os.Bundle
import androidx.annotation.CallSuper
import kotlinx.android.synthetic.main.base_arch_module_layout_toolbar.*

/*
 * *
 *  * Created by Abanoub Milad Nassief Hanna
 *  * on 5/1/20 11:05 PM
 *  * Last modified 5/1/20 11:05 PM
 *
 */
abstract class ToolbarActivity : BaseActivity() {

    open fun onToolbarLeftButtonClick() {
        onBackPressed()
    }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        iv_left.setOnClickListener {
            onToolbarLeftButtonClick()
        }
    }
}