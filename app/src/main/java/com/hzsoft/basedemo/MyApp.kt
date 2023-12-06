package com.hzsoft.basedemo

import com.hzsoft.lib.base.manager.ActivityManager
import com.hzsoft.lib.base.module.ModuleApp

/**
 * Describe:
 * App
 *
 * @author zhouhuan
 * @Date 2020/12/1
 */
class MyApp : ModuleApp(){
    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(ActivityManager.instance)
    }
}
