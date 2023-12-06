package debug

import com.blankj.utilcode.util.LogUtils
import com.hzsoft.lib.base.utils.ThreadUtils
import com.hzsoft.lib.base.view.BaseFragment
import com.hzsoft.lib.base.view.BaseMvvmRefreshViewBindingActivity
import com.hzsoft.lib.common.utils.EnvironmentUtil
import com.hzsoft.lib.domain.entity.Demo
import com.hzsoft.lib.base.BaseApp
import com.hzsoft.lib.net.dto.Resource
import com.hzsoft.lib.net.utils.ext.launch
import com.hzsoft.lib.net.utils.ext.observe
import com.hzsoft.module.home.R
import com.hzsoft.module.home.adapter.MainHomeAdapter
import com.hzsoft.module.home.databinding.FragmentHomeMainBinding
import com.hzsoft.module.home.viewmodel.MainHomeViewModel

/**
 *
 *
 * @author <a href="mailto:zhouhuandev@gmail.com" rel="nofollow">zhouhuan</a>
 * @since 2022/7/7 23:00
 */
class MainHomeActivity : BaseMvvmRefreshViewBindingActivity<FragmentHomeMainBinding, MainHomeViewModel>() {

    private lateinit var mAdapter: MainHomeAdapter


    override fun initViewObservable() {
        observe(mViewModel.recipesLiveData, ::handleRecipesList)
    }

    override fun onBindLayout(): Int = R.layout.fragment_home_main
    override fun initView() {
        mAdapter = MainHomeAdapter()
        mAdapter.bindSkeletonScreen(
            requireBinding().mRecyclerView,
            R.layout.skeleton_default_service_item,
            8
        )
    }

    override fun initData() {
        onRefreshEvent()
        LogUtils.dTag(BaseFragment.TAG, EnvironmentUtil.Storage.getCachePath(mContext))
    }

    var firstLoad = true

    override fun onRefreshEvent() {
        // 为了展示骨架屏
        if (firstLoad) {
            firstLoad = false
            ThreadUtils.runOnUiThread({ mViewModel.refreshData() }, 1000)
        } else {
            mViewModel.refreshData()
        }
    }

    override fun onLoadMoreEvent() {
        mViewModel.loadMore()
    }

    override fun onBindRefreshLayout(): Int = R.id.mRefreshLayout

    override fun enableRefresh(): Boolean = true

    override fun enableLoadMore(): Boolean = false

    override fun enableToolbar(): Boolean = true

    override fun getTootBarTitle(): String = "首页"

    private fun handleRecipesList(resource: Resource<List<Demo>>) {
        resource.launch {
            it?.apply {
                bindListData(recipes = ArrayList(this))
            }
        }
    }

    private fun bindListData(recipes: ArrayList<Demo>) {
        mAdapter.setNewInstance(recipes)
    }
}