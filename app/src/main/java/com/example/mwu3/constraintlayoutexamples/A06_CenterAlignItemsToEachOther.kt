package com.example.mwu3.constraintlayoutexamples

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class A06_CenterAlignItemsToEachOther : androidx.fragment.app.Fragment() {
    private var listener: OnFragmentInteractionListener? = null
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.a06_center_align_items_to_each_other, container, false)
    }
    
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
            listener?.onChildFragmentStart(resources.getString(R.string.a06))
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = A06_CenterAlignItemsToEachOther()
    }
}
