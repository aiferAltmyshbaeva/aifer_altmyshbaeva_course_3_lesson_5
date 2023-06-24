package com.example.c3lesson5hw5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.c3lesson5hw5.databinding.FragmentStartBinding

private const val MAX = 10
private const val MIN = 0

class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding
    private var isReversed: Boolean = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCalc.setOnClickListener {
            val currentResult = binding.tvResult.text.toString().toInt()
            if (currentResult == MAX) {
                isReversed = true
            }
            val newResult = if (!isReversed) {
                currentResult + 1
            } else {
                currentResult - 1
            }
            if (isReversed && currentResult == MIN) {
                val fragment = ResultFragment()
                val args = Bundle()
                args.putString("result", currentResult.toString())
                fragment.arguments = args
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.container, fragment).addToBackStack(null).commit()
            } else {
                binding.tvResult.text = newResult.toString()
            }
            if (newResult == MIN) {
                binding.btnCalc.text = "NEXT"
            }
            if (newResult == MAX) {
                binding.btnCalc.text = "-1"
            }
        }
    }


}


//supportFragmentManager.beginTransaction()
//.add(com.google.android.material.R.id.container, StartFragment()).addToBackStack(null).commit()