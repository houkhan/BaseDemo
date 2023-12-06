package debug

import android.view.View
import com.blankj.utilcode.util.LogUtils
import com.google.gson.Gson
import com.hzsoft.lib.base.utils.ToastUtil
import com.hzsoft.lib.base.utils.ext.view.showToast
import com.hzsoft.lib.base.view.BaseFragment
import com.hzsoft.lib.base.view.BaseMvvmViewBindingActivity
import com.hzsoft.module.me.R
import com.hzsoft.module.me.activity.RoomTestActivity
import com.hzsoft.module.me.activity.SaveStateTestActivity
import com.hzsoft.module.me.databinding.FragmentMeMainBinding
import com.hzsoft.module.me.viewmodel.MainMeViewModel

/**
 *
 *
 * @author <a href="mailto:zhouhuandev@gmail.com" rel="nofollow">zhouhuan</a>
 * @since 2022/7/7 22:56
 */
class MainMeActivity : BaseMvvmViewBindingActivity<FragmentMeMainBinding, MainMeViewModel>() {

    override fun onBindLayout(): Int = R.layout.fragment_me_main

    override fun initView() {

    }

    override fun initData() {

    }

    override fun initListener() {
        requireBinding().button1.setOnClickListener(this::onClick)
        requireBinding().button2.setOnClickListener(this::onClick)
        requireBinding().button3.setOnClickListener(this::onClick)
        requireBinding().button4.setOnClickListener(this::onClick)
    }

    override fun enableToolbar(): Boolean = true

    override fun getTootBarTitle(): String = "Me"

    override fun onClick(v: View?) {

    }

    override fun initViewObservable() {

    }

}