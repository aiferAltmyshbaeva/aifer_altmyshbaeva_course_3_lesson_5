package com.example.c3lesson5hw5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.c3lesson5hw5.databinding.FragmentResultBinding
import com.example.c3lesson5hw5.databinding.FragmentStartBinding

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = arguments
        if (args != null && args.containsKey("result")) {
            val result = args.getString("result")
            binding.tvFinalResult.text = result.toString()
        }
    }

}