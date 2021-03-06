package com.nico.counterapplicationwithlivedata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nico.counterapplicationwithlivedata.databinding.FragmentCounterBinding

class CounterFragment : Fragment() {

    private var _binding: FragmentCounterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCounterBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var counter: MutableLiveData<Int> = MutableLiveData(0)
        counter.observe(viewLifecycleOwner, Observer {
            binding.textviewCounter.text = counter.value.toString()
        })

        binding.buttonCounter.setOnClickListener{
            counter.value?.let {
                counter.value = it + 1
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}