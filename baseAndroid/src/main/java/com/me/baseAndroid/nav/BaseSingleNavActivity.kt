package com.me.baseAndroid.nav

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.me.baseAndroid.R
import com.me.baseAndroid.base.AlertDisconnectionActivity

open class BaseSingleNavActivity : AlertDisconnectionActivity(), INav {

    override val layoutId = R.layout.base_arch_module_single_nav_activity


    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1) {
            dismiss()
        } else {
            finish()
        }

    }

    override fun dismiss(clearAllTop: Boolean) {
        if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStack()
        }
    }

    override fun dismissThenNavigate(fragment: Fragment, bundle: Bundle?) {
        dismiss()
        navigate(fragment, bundle)
    }


    override fun navigate(fragment: Fragment, bundle: Bundle?) {
        fragment.arguments = bundle
        supportFragmentManager
            .beginTransaction().addToBackStack(null)
            .replace(R.id.nav_host_container, fragment).commitAllowingStateLoss()
    }

    override fun navigate(tabIndex: Int, fragment: Fragment, bundle: Bundle?) {
    }

    override fun navigate(tabIndex: Int, clearAllTop: Boolean) {
    }
}