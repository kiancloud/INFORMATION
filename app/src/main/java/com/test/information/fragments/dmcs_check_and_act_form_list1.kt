package com.test.information.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.test.information.R




class dmcs_check_and_act_form_list1 : Fragment() {




  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    arguments?.let {

    }
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
    var v: View = inflater.inflate(R.layout.fragment_dmcs_check_and_act_form_list1, container, false)



    return v
  }


}