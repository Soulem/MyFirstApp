package com.dynamicdevs.myfirstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.dynamicdevs.myfirstapp.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.countButton.setOnClickListener{
            countMe(view)
        }

        binding.toastButton.setOnClickListener{
            val myToast = Toast.makeText(context, R.string.toast_button_message, Toast.LENGTH_SHORT)
            myToast.show()
        }

        binding.randomFirst.setOnClickListener {
            val currentCount = binding.textviewFirst.text.toString().toInt()
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount)
            findNavController().navigate(action)
        }
    }

    private fun countMe(view: View) {
        val countString = binding.textviewFirst.text.toString()
        var count = countString.toInt()
        binding.textviewFirst.text = (++count).toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}