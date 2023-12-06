package com.hzsoft.module.me.fragment

import android.view.View
import com.hzsoft.lib.base.view.BaseMvvmViewBindingFragment
import com.hzsoft.module.me.R
import com.hzsoft.module.me.databinding.FragmentMeMainBinding
import com.hzsoft.module.me.viewmodel.MainMeViewModel

/**
 * Describe:
 * 首页，使用了ViewBinding示例
 *
 * @author zhouhuan
 * @Date 2020/12/3
 */
class MainMeFragment : BaseMvvmViewBindingFragment<FragmentMeMainBinding, MainMeViewModel>() {

    companion object {
        fun newsInstance(): MainMeFragment {
            return MainMeFragment()
        }
    }

    override fun onBindLayout(): Int = R.layout.fragment_me_main

    override fun initView(mView: View) {

    }

    override fun initData() {

    }

    override fun enableToolbar(): Boolean = true

    override fun initViewObservable() {

    }

    override fun getTootBarTitle(): String = getString(R.string.title_mine)
}
