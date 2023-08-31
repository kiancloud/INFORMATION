package com.test.information.fragments

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.test.information.R
import android.widget.*
import androidx.core.app.ActivityCompat
import androidx.core.view.isGone
import androidx.core.view.isVisible
import java.io.File

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class addentry_select_form : Fragment() {

  lateinit var radiogroup: RadioGroup
  lateinit var radiogetvalue: Button


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    arguments?.let {

    }
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
    var  v: View = inflater.inflate(R.layout.fragment_addentry_select_form, container, false)

    radiogroup = v.findViewById<RadioGroup>(R.id.radiogroup)
    radiogetvalue = v.findViewById<Button>(R.id.radiogetvalue)

    var radiotext = ""

// Get radio group selected item using on checked change listener
    radiogroup.setOnCheckedChangeListener(
        RadioGroup.OnCheckedChangeListener { group, checkedId ->
          val radio: RadioButton = v.findViewById(checkedId)
          Toast.makeText(requireActivity(),
              " ${radio.text}" + " SELECTED" ,
              Toast.LENGTH_SHORT).show()


      radiotext = radio.text.toString()

        })


      // STORAGE PERMISSION
      ActivityCompat.requestPermissions(
          this.requireActivity(), arrayOf(
              Manifest.permission.WRITE_EXTERNAL_STORAGE,
              Manifest.permission.READ_EXTERNAL_STORAGE,
              Manifest.permission.MANAGE_EXTERNAL_STORAGE
          ), PackageManager.PERMISSION_GRANTED
      )

      //             CREATING EVALUATION FOLDER IF ACCIDENTALLY DELETED
      val extStorageDirectory = Environment.getExternalStorageDirectory().toString()
      val folder = File(extStorageDirectory, "CHECK AND ACT FOLDER")
      if (folder.exists()) {
      } else {
          folder.mkdir()
      }

    radiogetvalue.setOnClickListener() {

      val option1 = "COACHING FORM"
      val option2 = "CHECK AND ACT FORM FORM"

      if (radiotext == option1)
      {
        val nextFragAddEntry = AddentryFragment()
        val commit = requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, nextFragAddEntry, "findThisFragment")
            .addToBackStack(null)
            .commit()
      }

      if (radiotext == option2)
      {
        val nextFragDmcsCheckandAct = dmcs_checkandact_formFragment()
        val commit = requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, nextFragDmcsCheckandAct, "findThisFragment")
            .addToBackStack(null)
            .commit()
      }


    }



  return v
  }




}

