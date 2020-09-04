package com.humo.mootty.ui.home

import android.view.View
import androidx.lifecycle.ViewModel
import com.humo.mootty.data.repositories.UserRepository
import com.humo.mootty.utils.startLoginActivity

class HomeViewModel(
    private val repository: UserRepository
) : ViewModel() {

    val user by lazy {
        repository.currentUser()
    }

    fun logout(view: View) {
        repository.logout()
        view.context.startLoginActivity()
    }
}