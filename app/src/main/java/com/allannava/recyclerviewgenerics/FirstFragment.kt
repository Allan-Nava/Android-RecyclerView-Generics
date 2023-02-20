package com.allannava.recyclerviewgenerics

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.allannava.recyclerviewgenerics.Models.Widget
import com.allannava.recyclerviewgenerics.Models.WidgetViewModel
import com.allannava.recyclerviewgenerics.UXClasses.JsonUtils
import com.allannava.recyclerviewgenerics.UXClasses.LayoutAdapter
import com.allannava.recyclerviewgenerics.databinding.FragmentFirstBinding
import com.google.gson.Gson
import com.google.gson.JsonObject

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val TAG = "FirstFragment"
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
        //
        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        val jsonFileString = JsonUtils.getJsonDataFromAsset(this.requireContext(), "data.json")
        if (jsonFileString != null) {
            //Log.i(TAG, "data: $jsonFileString")
            val convertedObject  = Gson().fromJson(jsonFileString, Widget::class.java)
            Log.i(TAG, " v: $convertedObject")
            //Log.i(TAG, convertedObject.data.toString())
            val widgetViewModel = WidgetViewModel()
            widgetViewModel.widgets.add(convertedObject)
            //
            val adapter = LayoutAdapter(widgetViewModel)
            binding.recyclerView?.let{
                it.layoutManager = LinearLayoutManager(this.activity,  LinearLayoutManager.VERTICAL, false)
                it.adapter = adapter
            }
        }
        //
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}