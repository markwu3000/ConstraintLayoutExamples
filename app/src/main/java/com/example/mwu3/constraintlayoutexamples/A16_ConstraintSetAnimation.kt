package com.example.mwu3.constraintlayoutexamples

import android.content.Context
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.a16a_animation_circular_before.*

class A16_ConstraintSetAnimation : androidx.fragment.app.Fragment() {
    private var listener: OnFragmentInteractionListener? = null
    private var currentIndex: Int = 0
    private lateinit var listConstraintLayouts: MutableList<Int>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.a16a_animation_circular_before, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listConstraintLayouts = ArrayList()
        listConstraintLayouts.add(R.layout.a16a_animation_circular_before)
        listConstraintLayouts.add(R.layout.a16b_animation_circular_after)
        center_button.setOnClickListener({ addAnimationOperations() })
    }

    private fun addAnimationOperations() {
        val constraintAfter = ConstraintSet()
        currentIndex++
        if (currentIndex >= listConstraintLayouts.size) {
            currentIndex = 0
        }
        constraintAfter.load(activity, listConstraintLayouts.get(currentIndex))
        TransitionManager.beginDelayedTransition(root_level)
        constraintAfter.applyTo(root_level)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
            listener?.onChildFragmentStart(resources.getString(R.string.a16))
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
        fun newInstance() = A16_ConstraintSetAnimation()
    }
}
