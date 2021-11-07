package com.example.etcstudy.tenant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.etcstudy.databinding.ActivityRegisterTenantBinding

class RegisterTenantActivity : AppCompatActivity() {

    private val binding : ActivityRegisterTenantBinding by lazy { ActivityRegisterTenantBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.textPaymentDate.setOnClickListener {
            CalendarDialog(11) {

            }.show(supportFragmentManager, "")
        }

    }
}