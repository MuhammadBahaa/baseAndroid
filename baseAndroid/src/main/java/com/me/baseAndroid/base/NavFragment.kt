package com.me.baseAndroid.base

import android.content.Context
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.CallSuper
import com.me.baseAndroid.R
import com.me.baseAndroid.view.observe
import org.abanoubmilad.router.listenToRouter

/*
 * *
 *  * Created by Abanoub Milad Nassief Hanna
 *  * on 5/1/20 11:05 PM
 *  * Last modified 5/1/20 11:05 PM
 *
 */
abstract class NavFragment : org.abanoubmilad.labyrinth.NavFragment(), ITextWatcher {
    override val watchMap: HashMap<EditText, TextWatcher> by lazy {
        hashMapOf<EditText, TextWatcher>()
    }

    override fun buildRootView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): View {
        return inflater.inflate(layoutId, container, false)
    }

    abstract val layoutId: Int

    fun showToast(msg: String) {
        activity?.let {
            Toast.makeText(it, msg, Toast.LENGTH_SHORT).show()
        }
    }

    fun showToast(resource: Int) {
        activity?.let {
            Toast.makeText(it, resource, Toast.LENGTH_SHORT).show()
        }
    }

    fun hideCookieBar() {
        (activity as? BaseActivity)?.let {
            it.hideCookieBar()
        }
    }

    fun showCookieBar(resource: Int) {
        (activity as? BaseActivity)?.let {
            it.showCookieBar(resource)
        }
    }

    fun showCookieBar(msg: String) {
        (activity as? BaseActivity)?.let {
            it.showCookieBar(msg)
        }
    }

    fun showCookieBar(
        highLightFunction: (TextView) -> Unit,
        bgResId: Int = R.color.base_arch_module_cookiebar_error_red,
        duration: Long = 3000
    ) {
        (activity as? BaseActivity)?.let {
            it.showCookieBar(highLightFunction, bgResId, duration)
        }
    }

    fun hideKeyboard() {
        activity?.let { parent ->
            parent.currentFocus?.let {
                (parent.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
                    .hideSoftInputFromWindow(it.windowToken, 0)
            }

        }
    }

    fun showKeyboard(view: View?) {
        activity?.let { parent ->
            (parent.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
                .showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }
    }

    fun getStringArgumentDefaultEmpty(tag: String) = arguments?.getString(tag) ?: ""

    fun getBooleanArgumentDefault(tag: String, default: Boolean) =
        arguments?.getBoolean(tag, default) ?: default

    fun getIntArgumentDefault(tag: String, default: Int) =
        arguments?.getInt(tag, default) ?: default

    open fun listenToMessagesOf(viewModel: BaseViewModel) {
        observe(viewModel.info) {
            showCookieBar(it)
        }
    }

    open fun listenToRouterOf(viewModel: BaseViewModel) {
        listenToRouter(viewModel.router)
    }

    @CallSuper
    override fun onDestroyView() {
        disposeITextWatcher()
        super.onDestroyView()
    }


}