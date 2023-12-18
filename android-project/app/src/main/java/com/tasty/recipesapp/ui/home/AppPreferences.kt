package com.tasty.recipesapp.ui.home

import android.content.Context
import android.content.SharedPreferences

class AppPreferences(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE)

    var userId: Long?
        get() = prefs.getLong(USER_ID_KEY, 0)
        set(value) = value?.let { prefs.edit().putLong(USER_ID_KEY, it).apply() }!!

    companion object {
        private const val PREFS_FILENAME = "app_prefs"
        private const val USER_ID_KEY = "user_id"
    }
}
