package com.example.navigationandfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.Navigator
import com.example.navigationandfragment.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    /*--------------------*/
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    /*--------------------*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*--------------------*/
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
        /*--------------------*/
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.txtName.setText("Değişim Sağlandı")
        binding.btnNext.setOnClickListener {
           Test(it) }

    }
    /*--------------------*/
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    /*--------------------*/

    fun Test(v : View){
        val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(binding.txtName.text.toString())
        Navigation.findNavController(v).navigate(action)
    }
}