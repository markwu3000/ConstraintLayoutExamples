package com.example.mwu3.constraintlayoutexamples

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import androidx.navigation.Navigation

class MainActivity : AppCompatActivity(), OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    
    override fun onChildFragmentStart(title: String) {
        setTitle(title)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navigation = Navigation.findNavController(this, R.id.my_nav_host_fragment)
        navigation.navigateUp()
        Log.e( "MSW", "Compare: " + A00_ConstraintLayoutExamplesContents.TAG + " // " + navigation.currentDestination.label)
        if (A00_ConstraintLayoutExamplesContents.TAG.equals(navigation.currentDestination.label)) {
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
            setTitle(resources.getString(R.string.app_name))
        }
        return true
    }

}
