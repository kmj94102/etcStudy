package com.example.etcstudy.design_test.draft2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.etcstudy.databinding.ActivityDraft2Binding

class Draft2Activity : AppCompatActivity() {

    private val binding : ActivityDraft2Binding by lazy { ActivityDraft2Binding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



    }
}