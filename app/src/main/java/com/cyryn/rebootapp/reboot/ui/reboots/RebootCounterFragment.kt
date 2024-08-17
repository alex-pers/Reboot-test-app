package com.cyryn.rebootapp.reboot.ui.reboots

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.cyryn.rebootapp.databinding.RebootsFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RebootCounterFragment : Fragment() {


    private val viewModel: RebootsFragmentViewModel by viewModels()

    private var _binding: RebootsFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = RebootsFragmentBinding.inflate(inflater, container, false)

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.uiState.collect { state ->

                if (state.list.isNullOrEmpty()) {
                    binding.reboots.text = "No Events"
                } else {
                    binding.reboots.text = state.list.joinToString {
                        "${it.date} - ${it.count}\n"
                    }
                }
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}