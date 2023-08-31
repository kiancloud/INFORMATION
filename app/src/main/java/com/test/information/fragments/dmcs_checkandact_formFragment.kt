package com.test.information.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.test.information.R




class dmcs_checkandact_formFragment : Fragment() {


  private lateinit var button: Button
  private lateinit var spinner: Spinner
  private lateinit var datemonth: Spinner
  private lateinit var datedate: Spinner
  private lateinit var dateyear: Spinner
  private lateinit var spinlinemanagerposition: Spinner
  private lateinit var spinsalesmanposition: Spinner
  private lateinit var btn_dmcssubmit:Button



  var spinmonth = ""
  var spinday = ""
  var spinyear = ""
  var spinrank1 = ""
  var spinrank2 = ""

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    arguments?.let {

    }
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
    var v: View = inflater.inflate(R.layout.fragment_dmcs_checkandact_form, container, false)

    btn_dmcssubmit = v.findViewById(R.id.btn_dmcssubmit) as Button
    var dmcslinemanagername = v.findViewById(R.id.linemanagersname) as EditText
    var dmcssalesmanname = v.findViewById(R.id.salesmanname) as EditText
    var dmcscustomername = v.findViewById(R.id.dmcscustomersname) as EditText
    var dmcsbranch = v.findViewById(R.id.dmcsbranch) as EditText
    var dmcscallobjective = v.findViewById(R.id.dmcscallobjective) as EditText


//    var dmcscustomernametext = dmcscustomername.text.toString()
//    var dmcsbranchtext = dmcsbranch.text.toString()
//    var dmcscallobjectivetext = dmcscallobjective.text.toString()

    // ++++++ Spinner LINE MANAGER POSITION ++++++++
    //access string array
    val listrank1 = resources.getStringArray(R.array.rank1)
//         access the spinner and set ArrayAdaptor to control the list of items
    val spn_linemanager = v.findViewById(R.id.spn_linemanagerposition) as Spinner
    if (spn_linemanager != null) {
      val adapter = ArrayAdapter(this.requireActivity(),
          android.R.layout.simple_spinner_item, listrank1)
      spn_linemanager.adapter = adapter

      spn_linemanager.onItemSelectedListener = object :
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

//        END SPINNER LINEMANGER POSITIN

    // ++++++ Spinner SALESMAN POSITION ++++++++
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

//        END SPINNER SALESMAN POSITION

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





    btn_dmcssubmit.setOnClickListener(){


      var cdate = "$spinmonth $spinday $spinyear"

      val dmcslinemanagersnametext = dmcslinemanagername.text.toString()
      val dmcssalesmannametext = dmcssalesmanname.text.toString()
      val dmcscustomernametext = dmcscustomername.text.toString()
      val dmcsbranchtext = dmcsbranch.text.toString()
      val dmcscallobjectivetext = dmcscallobjective.text.toString()


      if (dmcslinemanagersnametext.length.toString() > 0.toString() &&
          spinrank1.length.toString() > 0.toString() &&
          dmcssalesmannametext.length.toString() > 0.toString() &&
          spinrank2.length.toString() > 0.toString() &&
          cdate.length.toString() > 0.toString() &&
          dmcscustomernametext.length.toString() > 0.toString() &&
          dmcsbranchtext.length.toString() > 0.toString() &&
          dmcscallobjectivetext.length.toString() > 0.toString()) {

        val nextFragDMCSformlist = dmcs_check_and_act_form_list()
        val bundle = Bundle()

        bundle.putString("linename", dmcslinemanagersnametext)
        bundle.putString("lineposition", spinrank1)
        bundle.putString("salesname", dmcssalesmannametext)
        bundle.putString("salesposition", spinrank2)
        bundle.putString("cdate", cdate)
        bundle.putString("dmcscustomernametext", dmcscustomernametext )
        bundle.putString("dmcsbranchtext", dmcsbranchtext)
        bundle.putString("dmcscallobjectivetext", dmcscallobjectivetext)
        nextFragDMCSformlist.arguments = bundle

        val commit = requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, nextFragDMCSformlist, "findThisFragment")
            .addToBackStack(null)
            .commit()

      }
      else{
        Toast.makeText(requireActivity(), "PLEASE DON'T LEAVE BLANK SPACES", Toast.LENGTH_SHORT).show()
      }

    }


    return v
  }


}