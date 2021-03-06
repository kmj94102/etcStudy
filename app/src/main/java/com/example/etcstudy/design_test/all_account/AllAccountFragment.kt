package com.example.etcstudy.design_test.all_account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.etcstudy.databinding.FragmentAllAccountBinding
import com.example.etcstudy.design_test.draft2.Draft2Activity
import com.example.etcstudy.util.startActivity

class AllAccountFragment : Fragment() {

    private val binding : FragmentAllAccountBinding by lazy { FragmentAllAccountBinding.inflate(layoutInflater) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn1.setOnClickListener {
            requireActivity().startActivity<PlannerMainActivity>()
        }

        binding.btn2.setOnClickListener {
            requireActivity().startActivity<PlannerDetailActivity>()
        }

        binding.btn3.setOnClickListener {
            requireActivity().startActivity<Draft2Activity>()
        }

    }

}