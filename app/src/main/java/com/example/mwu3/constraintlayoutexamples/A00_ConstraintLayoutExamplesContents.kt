package com.example.mwu3.constraintlayoutexamples

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.a00_contents_fragment.*

class A00_ConstraintLayoutExamplesContents : androidx.fragment.app.Fragment() {
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.a00_contents_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // Navigation with Rx
        val navHostFragment = NavHostFragment.findNavController(this)
        compositeDisposable.add(RxView.clicks(tv_a01)
                .map {
                    navHostFragment.navigate(R.id.a01_RelativePositioning) // target fragment name goes in navigate()
                }.subscribe())
        
        // Navigation with built-in tools
        tv_a02.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.a02_MarginGone))
        tv_a03.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.a03_Centering))
        tv_a04.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.a04_HorizontalVerticalBias))
        tv_a05.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.a05_AlignBaselineText))
        tv_a07.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.a07_CircularPositioning))
        tv_a08.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.a08_DimensionConstraints))
        tv_a09.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.a09_HorizontalVerticalGuidelines))
        tv_a10.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.a10_MatchConstraints))
        tv_a11.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.a11_PercentDimensions))
        tv_a12.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.a12_Ratio))
        tv_a13.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.a13_Chains))
        tv_a14.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.a14_Groups))
        tv_a15.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.a15_Barriers))
        tv_a16.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.a16_ConstraintSetAnimation))
    }

    override fun onDetach() {
        super.onDetach()
        compositeDisposable.clear()
    }

    companion object {
        val TAG = "ConstraintLayoutExamplesHome"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         */
        @JvmStatic
        fun newInstance() = A00_ConstraintLayoutExamplesContents()
    }
}
