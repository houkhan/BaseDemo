package com.task.data.remote

/**
 *
 * @author zhouhuan
 * @time 2020/12/1 0:06
 */
internal interface RemoteDataSource {
    suspend fun requestRecipes(): String
}
