 package com.test.information.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.test.information.DatabaseHandler
import com.test.information.R


 class ListentryFragment : Fragment() {


    override fun onCreateView(


            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v: View = inflater.inflate(R.layout.fragment_listentry, container, false)
        val db = DatabaseHandler(this.requireActivity())


        return v
    }


}