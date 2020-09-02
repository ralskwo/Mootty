package com.humo.mootty.ui.auth

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.humo.mootty.R
import com.humo.mootty.databinding.ActivityLoginBinding
import com.humo.mootty.utils.startHomeActivity
import com.marozzi.roundbutton.RoundButton
import kotlinx.android.synthetic.main.activity_login.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance


class LoginActivity() : AppCompatActivity(), AuthListener, KodeinAware {

    override val kodein by kodein()
    private val factory: AuthViewModelFactory by instance()
    private lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProvider(this, factory).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.authListener = this

//        setContentView(R.layout.activity_login)

//        button_sign_in.setOnClickListener {
//            if (button_sign_in.isAnimating) {
//                button_sign_in.setResultState(RoundButton.ResultState.FAILURE)
//            } else {
//                button_sign_in.startAnimation()
//                button_sign_in.postDelayed({ btn_sign_in.revertAnimation() }, 3000)
//            }
//
//            val intent = Intent(this@LoginActivity, SignUpActivity::class.java)
//            startActivity(intent)
//
//        }

    }

    override fun onStarted() {
        if (button_sign_in.isAnimating) {
            button_sign_in.setResultState(RoundButton.ResultState.FAILURE)
        } else {
            button_sign_in.startAnimation()
            button_sign_in.postDelayed({ button_sign_in.revertAnimation() }, 3000)
        }
    }

    override fun onSuccess() {
        startHomeActivity()
    }

    override fun onFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        viewModel.user?.let {
            startHomeActivity()
        }
    }

}