package com.test.information.fragments

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.test.information.R
import com.test.information.fragments.*
import java.io.File
import java.time.Instant


class AddentryFragment : Fragment(){

    private lateinit var FragmentActivity: FragmentActivity
    private lateinit var evalFragmentMain: EvalFragmentMain
    private lateinit var button: Button
    private lateinit var dmcsbutton: Button
    private lateinit var bundle: Bundle
    private lateinit var editText: EditText
    private lateinit var spinner: Spinner
    private lateinit var datemonth: Spinner
    private lateinit var datedate: Spinner
    private lateinit var dateyear: Spinner
    private lateinit var spinlinemanagerposition: Spinner
    private lateinit var spinsalesmanposition: Spinner


    var spinmonth = ""
    var spinday = ""
    var spinyear = ""

    var spinrank1 = ""
    var spinrank2 = ""

    var detour1 = "GENERAL TRADE MANAGER"
    var detour2 = "DMCS"
    var detourbdo = "BDO"
//    var detourbooking = "BOOKING SALESMAN" (OLD POSITION NAME IN BOOKING)
//    NEW POSITION NAME IN BOOKING
var detourbooking = "SALES REPRESENTATIVE"
//    var detourextruck = "EXTRUCK SALESMAN" (OLD POSITION NAME IN EXTRUCK)
//    NEW EXTRUCK POSITION
    var detourextruck = "VAN SALESMAN"
    var detourdmcs = "DMCS"


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
         var  v: View = inflater.inflate(R.layout.fragment_addentry, container, false)
         var  button = v.findViewById(R.id.btn_addentrybutton) as Button
//         var dmcsbutton = v.findViewById(R.id.dmcs_check_and_act_form) as Button

//        ADD ENTRY TEXTBOX
         var linemanagername = v.findViewById(R.id.etfragment_linemanagername) as EditText
//         var date = v.findViewById(R.id.etfragment_addentrydate) as EditText
        var salesmanname = v.findViewById(R.id.etfragment_salesmanname) as EditText

//              permission
      ActivityCompat.requestPermissions(
          this.requireActivity(), arrayOf(
          Manifest.permission.WRITE_EXTERNAL_STORAGE,
          android.Manifest.permission.READ_EXTERNAL_STORAGE,
          android.Manifest.permission.MANAGE_EXTERNAL_STORAGE
      ), PackageManager.PERMISSION_GRANTED
      )

      //             CREATING EVALUATION FOLDER IF ACCIDENTALLY DELETED
      if(ActivityCompat.checkSelfPermission(requireActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
        val extStorageDirectory = Environment.getExternalStorageDirectory().toString()
        val folder = File(extStorageDirectory, "Evaluation Folder")
        if (folder.exists()) {
     //     Toast.makeText(requireActivity(), folder.toString(), Toast.LENGTH_SHORT).show()
        } else {
          folder.mkdir()
     //     Toast.makeText(requireActivity(), "FOLDER CREATED", Toast.LENGTH_SHORT).show()
        }
      }

//      CREATING C AND A FOLDER IF ACCIDENTALLY DELETED
          if(ActivityCompat.checkSelfPermission(requireActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            val extStorageDirectory = Environment.getExternalStorageDirectory().toString()
            val folder = File(extStorageDirectory, "C AND A Folder")
            if (folder.exists()) {
              //     Toast.makeText(requireActivity(), folder.toString(), Toast.LENGTH_SHORT).show()
            } else {
              folder.mkdir()
              //     Toast.makeText(requireActivity(), "FOLDER CREATED", Toast.LENGTH_SHORT).show()
            }
          }

//
//      if(ActivityCompat.checkSelfPermission(requireActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
//        val f = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "Evaluation Folder")
//        f.appendText("test ${Instant.now().toEpochMilli()}\n")
//
//        f.readLines().forEach { line -> Log.e("LOG", line)}}

        // ++++++ Spinner LINE MANAGER NAME ++++++++
        //access string array
        val listrank1 = resources.getStringArray(R.array.rank1)
//         access the spinner and set ArrayAdaptor to control the list of items
       val spn_coacherposition = v.findViewById(R.id.spn_coacherposition) as Spinner
        if (spn_coacherposition != null) {
            val adapter = ArrayAdapter(this.requireActivity(),
                android.R.layout.simple_spinner_item, listrank1)
            spn_coacherposition.adapter = adapter

            spn_coacherposition.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    val spinrankp: String = parent?.getItemAtPosition(position).toString()
                    spinrank1 = spinrankp
//             Toast.makeText(activity, survey1ListItem[position], Toast.LENGTH_SHORT).show()

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
        }

//        END SPINNER SALESMAN POSITION

        // ++++++ Spinner LINE MANAGER NAME ++++++++
        //access string array
        val listrank2 = resources.getStringArray(R.array.rank2)
//         access the spinner and set ArrayAdaptor to control the list of items
        val spn_salesmanposition = v.findViewById(R.id.spn_salesmanposition) as Spinner
        if (spn_salesmanposition != null) {
            val adapter = ArrayAdapter(this.requireActivity(),
                android.R.layout.simple_spinner_item, listrank2)
            spn_salesmanposition.adapter = adapter

            spn_salesmanposition.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    val spinranks: String = parent?.getItemAtPosition(position).toString()
                    spinrank2 = spinranks
//             Toast.makeText(activity, survey1ListItem[position], Toast.LENGTH_SHORT).show()

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
        }

//        END SPINNER LINEMANAGER POSITION

        // ++++++ Spinner MOnth ++++++++
        //access string array
        val survey1ListItem = resources.getStringArray(R.array.month)
//         access the spinner and set ArrayAdaptor to control the list of items
        datemonth = v.findViewById(R.id.datemonth) as Spinner
        if (datemonth != null) {
            val adapter = ArrayAdapter(this.requireActivity(),
                    android.R.layout.simple_spinner_item, survey1ListItem)
            datemonth.adapter = adapter

            datemonth.onItemSelectedListener = object :
                    AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    val spin8: String = parent?.getItemAtPosition(position).toString()
                    spinmonth = spin8
//             Toast.makeText(activity, survey1ListItem[position], Toast.LENGTH_SHORT).show()

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
        }
// +++++ End Spinner Month ++++++

        // ++++++ Spinner Day ++++++++
        //access string array
        val survey1ListItem1 = resources.getStringArray(R.array.day)
//         access the spinner and set ArrayAdaptor to control the list of items
        datedate = v.findViewById(R.id.dateday) as Spinner
        if (datedate != null) {
            val adapter = ArrayAdapter(this.requireActivity(),
                    android.R.layout.simple_spinner_item, survey1ListItem1)
            datedate.adapter = adapter

            datedate.onItemSelectedListener = object :
                    AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    val spin9: String = parent?.getItemAtPosition(position).toString()
                    spinday = spin9
//             Toast.makeText(activity, survey1ListItem[position], Toast.LENGTH_SHORT).show()

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
        }
// +++++ End Spinner Year ++++++

        // ++++++ Spinner Day ++++++++
        //access string array
        val survey1ListItem3 = resources.getStringArray(R.array.year)
//         access the spinner and set ArrayAdaptor to control the list of items
        dateyear = v.findViewById(R.id.dateyear) as Spinner
        if (dateyear != null) {
            val adapter = ArrayAdapter(this.requireActivity(),
                    android.R.layout.simple_spinner_item, survey1ListItem3)
            dateyear.adapter = adapter

            dateyear.onItemSelectedListener = object :
                    AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    val spin10: String = parent?.getItemAtPosition(position).toString()
                    spinyear = spin10
//             Toast.makeText(activity, survey1ListItem[position], Toast.LENGTH_SHORT).show()

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
        }
// +++++ End Spinner Year ++++++


        button.setOnClickListener(View.OnClickListener() {

          if (linemanagername.text.length.toString() > 0.toString() &&
              spinrank1.length.toString() > 0.toString() &&
              salesmanname.text.length.toString() > 0.toString() &&
              spinrank2.length.toString() > 0.toString()) {

            if (spinrank2 == detour1) {
              var date = "$spinmonth $spinday $spinyear"
              val nextFrag1 = EvalformManager()
              val bundle = Bundle()
              bundle.putString("linemanagername", linemanagername.text.toString())
              bundle.putString("linemanagerposition", spinrank1)
              bundle.putString("salesmanname", salesmanname.text.toString())
              bundle.putString("salesmanposition", spinrank2)
              bundle.putString("date", date)
              nextFrag1.arguments = bundle

              val commit = requireActivity().supportFragmentManager.beginTransaction()
                  .replace(R.id.frame_layout, nextFrag1, "findThisFragment")
                  .addToBackStack(null)
                  .commit()

            } else {
//            Toast.makeText(activity, "spinrank1 error", Toast.LENGTH_SHORT).show()
            }

            if (spinrank2 == detourextruck || spinrank2 == detourbooking || spinrank2 == detourbdo) {
              var date = "$spinmonth $spinday $spinyear"
              val nextFrag2 = EvalFragmentMain()
              val bundle = Bundle()
              bundle.putString("linemanagername", linemanagername.text.toString())
              bundle.putString("linemanagerposition", spinrank1)
              bundle.putString("salesmanname", salesmanname.text.toString())
              bundle.putString("salesmanposition", spinrank2)
              bundle.putString("date", date)
              nextFrag2.arguments = bundle

              val commit = requireActivity().supportFragmentManager.beginTransaction()
                  .replace(R.id.frame_layout, nextFrag2, "findThisFragment")
                  .addToBackStack(null)
                  .commit()
            } else {
//            Toast.makeText(activity, "NexFrag2 Error", Toast.LENGTH_SHORT).show()
            }
          } else {
            Toast.makeText(activity, "Please dont leave blank spaces", Toast.LENGTH_SHORT).show()
          }

            if (spinrank2 == detourdmcs) {
                var date = "$spinmonth $spinday $spinyear"
                val nextFrag3 = evalfragment_dmcs()
                val bundle = Bundle()
                bundle.putString("linemanagername", linemanagername.text.toString())
                bundle.putString("linemanagerposition", spinrank1)
                bundle.putString("salesmanname", salesmanname.text.toString())
                bundle.putString("salesmanposition", spinrank2)
                bundle.putString("date", date)
                nextFrag3.arguments = bundle

                val commit = requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_layout, nextFrag3, "findThisFragment")
                    .addToBackStack(null)
                    .commit()

            } else {
//            Toast.makeText(activity, "spinrank1 error", Toast.LENGTH_SHORT).show()
            }

        })

//      dmcsbutton.setOnClickListener(View.OnClickListener() {
//        val dmcsFrag = dmcs_checkandact_formFragment()
//        var date = "$spinmonth $spinday $spinyear"
//        val bundle = Bundle()
//
//        if (linemanagername.text.length.toString() > 0.toString() &&
//            spinrank1.length.toString() > 0.toString() &&
//            salesmanname.text.length.toString() > 0.toString() &&
//            spinrank2.length.toString() > 0.toString()) {
//
//          bundle.putString("linemanagername", linemanagername.text.toString())
//          bundle.putString("linemanagerposition", spinrank1)
//          bundle.putString("salesmanname", salesmanname.text.toString())
//          bundle.putString("salesmanposition", spinrank2)
//          bundle.putString("date", date)
//          dmcsFrag.arguments = bundle
//
//          val commit = requireActivity().supportFragmentManager.beginTransaction()
//              .replace(R.id.frame_layout, dmcsFrag, "findThisFragment")
//              .addToBackStack(null)
//              .commit()
//
//        } else {
//          Toast.makeText(requireActivity(), "DONT LEAVE BLANK SPACES", Toast.LENGTH_SHORT).show()
//        }
//
//
//
//      })
return v
        }




}




