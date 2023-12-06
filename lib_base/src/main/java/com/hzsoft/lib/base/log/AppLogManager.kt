package com.hzsoft.lib.base.log

import com.blankj.utilcode.util.CrashUtils
import com.blankj.utilcode.util.LogUtils
import com.hzsoft.lib.base.BaseApp
import com.hzsoft.lib.base.BuildConfig

/**
 * @Author : hss
 * @Date :2023/8/22 - 10:22
 * @Description : 日志初始化相关
 */
object AppLogManager {
    /**
     * 日志中是否打印线程信息 && 是否控制台打印
     */
    var IS_DEBUG_LOG = BuildConfig.IS_DEBUG

    var APP_LOGS_DEBUG_DIR = BaseApp.getContext().getExternalFilesDir("app_logs")?.absolutePath

    var APP_LOGS_RELEASE_DIR = BaseApp.getContext().filesDir.absolutePath + "/app_logs"

    // 所有的日志的根目录
    var APP_ALL_LOGS_DIR = if (IS_DEBUG_LOG) APP_LOGS_DEBUG_DIR else APP_LOGS_RELEASE_DIR

    // LogUtils 保存的日志目录
    var APP_LOGS_DIR = (if (IS_DEBUG_LOG) APP_LOGS_DEBUG_DIR else APP_LOGS_RELEASE_DIR) + "/appLogs/"

    // 三方工具类 CrashUtils 捕获到的错误日志
    var APP_CRASH_LOGS_DIR = (if (IS_DEBUG_LOG) APP_LOGS_DEBUG_DIR else APP_LOGS_RELEASE_DIR) + "/crashLogs/"

    // 导出日志zip的目录地址
    var APP_LOGS_ZIP_DIR = BaseApp.getContext().getExternalFilesDir("app_log_zip")?.absolutePath + "/"

    fun init() {
        LogUtils.getConfig()
            // 设置 log 总开关
            .setLogSwitch(true)
            // 设置 log 全局 tag
            .setGlobalTag(BaseApp.TAG)
            // 设置 log 文件开关
            .setLog2FileSwitch(true)
            // 设置 log 控制台开关
            .setConsoleSwitch(IS_DEBUG_LOG)
            // 设置 log 文件存储目录
            .setDir(APP_LOGS_DIR)
            // 设置 log 文件前缀
            .setFilePrefix("app_log")
            // 设置 log 可保留天数
            .setSaveDays(1)
        // 崩溃日志保存
        CrashUtils.init(APP_CRASH_LOGS_DIR)
    }
}
