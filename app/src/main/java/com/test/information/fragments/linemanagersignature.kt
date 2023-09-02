package com.test.information.fragments

import android.content.pm.ActivityInfo
import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.github.gcacace.signaturepad.views.SignaturePad
import com.itextpdf.io.image.ImageData
import com.test.information.R
import java.io.ByteArrayOutputStream

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [linemanagersignature.newInstance] factory method to
 * create an instance of this fragment.
 */
class linemanagersignature : Fragment() {
  // TODO: Rename and change types of parameters
  private var param1: String? = null
  private var param2: String? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    arguments?.let {
      param1 = it.getString(ARG_PARAM1)
      param2 = it.getString(ARG_PARAM2)
    }
  }

  lateinit var bitmapsignature: Bitmap
  lateinit var streamsignature: ByteArrayOutputStream
  lateinit var imagesignature: ImageData

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
    val v: View = inflater.inflate(R.layout.fragment_linemanagersignature, container, false)

    val signaturePad = v.findViewById<SignaturePad>(R.id.signaturePad_manager)
    val btnclear = v.findViewById<Button>(R.id.btnclear_manager)
    val btnSave = v.findViewById<Button>(R.id.btnSave_manager)

//
    var getlinename = ""
    var getlineposition = ""
    var getsalesname = ""
    var getsalesposition = ""
    var getdate = ""
    var getrating1 = ""
    var getremarks1 = ""
    var getrating2 = ""
    var getremarks2 = ""
    var getrating3 = ""
    var getremarks3 = ""
    var getrating4 = ""
    var getremarks4 = ""
    var getrating5 = ""
    var getremarks5 = ""
    var getrating6 = ""
    var getremarks6 = ""
    var getrating7 = ""
    var getremarks7 = ""
    var getrating8 = ""
    var getremarks8 = ""
    var getrating9 = ""
    var getremarks9 = ""
    var getrating10 = ""
    var getremarks10 = ""
    var getrating11 = ""
    var getremarks11 = ""
    var getrating12 = ""
    var getremarks12 = ""
    var getrating13 = ""
    var getremarks13 = ""
    var getrating14 = ""
    var getremarks14 = ""
    var getrating15 = ""
    var getremarks15 = ""
//    var getrating16 = ""
//    var getremarks16 = ""

    btnSave.isEnabled = false
    btnclear.isEnabled = false

//    RECEIVE DATA FROM EVALFRAGMENTMANAGER FRAGMENT

    if (requireArguments().getString("linename") !=null ||
        requireArguments().getString("lineposition") != null ||
        requireArguments().getString("salesname") != null ||
        requireArguments().getString("salesposition") != null ||
        requireArguments().getString("date") != null ||
        requireArguments().getString("name") != null ||
        requireArguments().getString("rating1") != null ||
        requireArguments().getString("remarks1") != null ||
        requireArguments().getString("rating2") != null ||
        requireArguments().getString("remarks2") != null ||
        requireArguments().getString("rating3") != null ||
        requireArguments().getString("remarks3") != null ||
        requireArguments().getString("rating4") != null ||
        requireArguments().getString("remarks4") != null ||
        requireArguments().getString("rating5") != null ||
        requireArguments().getString("remarks5") != null ||
        requireArguments().getString("rating6") != null ||
        requireArguments().getString("remarks6") != null ||
        requireArguments().getString("rating7") != null ||
        requireArguments().getString("remarks7") != null ||
        requireArguments().getString("rating8") != null ||
        requireArguments().getString("remarks8") != null ||
        requireArguments().getString("rating9") != null ||
        requireArguments().getString("remarks9") != null ||
        requireArguments().getString("rating10") != null ||
        requireArguments().getString("remarks10") != null ||
        requireArguments().getString("rating11") != null ||
        requireArguments().getString("remarks11") != null ||
        requireArguments().getString("rating12") != null ||
        requireArguments().getString("remarks12") != null ||
        requireArguments().getString("rating13") != null ||
        requireArguments().getString("remarks13") != null ||
        requireArguments().getString("rating14") != null ||
        requireArguments().getString("remarks14") != null ||
        requireArguments().getString("rating15") != null ||
        requireArguments().getString("remarks15") != null
//        requireArguments().getString("rating16") != null ||
//        requireArguments().getString("remarks16") != null
    ){
      var linename = requireArguments().getString("linename")
      var lineposition = requireArguments().getString("lineposition")
      var salesname = requireArguments().getString("salesname")
      var salesposition = requireArguments().getString("salesposition")
      var date = requireArguments().getString("date")
      var rating1 = requireArguments().getString("rating1")
      var remarks1 = requireArguments().getString("remarks1")
      var rating2 = requireArguments().getString("rating2")
      var remarks2 = requireArguments().getString("remarks2")
      var rating3 = requireArguments().getString("rating3")
      var remarks3 = requireArguments().getString("remarks3")
      var rating4 = requireArguments().getString("rating4")
      var remarks4 = requireArguments().getString("remarks4")
      var rating5 = requireArguments().getString("rating5")
      var remarks5 = requireArguments().getString("remarks5")
      var rating6 = requireArguments().getString("rating6")
      var remarks6 = requireArguments().getString("remarks6")
      var rating7 = requireArguments().getString("rating7")
      var remarks7 = requireArguments().getString("remarks7")
      var rating8 = requireArguments().getString("rating8")
      var remarks8 = requireArguments().getString("remarks8")
      var rating9 = requireArguments().getString("rating9")
      var remarks9 = requireArguments().getString("remarks9")
      var rating10 = requireArguments().getString("rating10")
      var remarks10 = requireArguments().getString("remarks10")
      var rating11 = requireArguments().getString("rating11")
      var remarks11 = requireArguments().getString("remarks11")
      var rating12 = requireArguments().getString("rating12")
      var remarks12 = requireArguments().getString("remarks12")
      var rating13 = requireArguments().getString("rating13")
      var remarks13 = requireArguments().getString("remarks13")
      var rating14 = requireArguments().getString("rating14")
      var remarks14 = requireArguments().getString("remarks14")
      var rating15 = requireArguments().getString("rating15")
      var remarks15 = requireArguments().getString("remarks15")
//      var rating16 = requireArguments().getString("rating16")
//      var remarks16 = requireArguments().getString("remarks16")


      if (linename != null) {
        getlinename = linename
      }
      if (lineposition != null) {
        getlineposition = lineposition
      }
      if (salesname != null){
        getsalesname = salesname
      }
      if (salesposition != null) {
        getsalesposition = salesposition
      }
      if (date != null) {
        getdate = date
      }
      if (rating1 != null) {
        getrating1 = rating1
      }
      if (remarks1 != null) {
        getremarks1 = remarks1
      }
      if (rating2 != null) {
        getrating2 = rating2
      }
      if (remarks2 != null) {
        getremarks2 = remarks2
      }
      if (rating3 != null) {
        getrating3 = rating3
      }
      if (remarks3 != null) {
        getremarks3 = remarks3
      }
      if (rating4 != null) {
        getrating4 = rating4
      }
      if (remarks4 != null) {
        getremarks4 = remarks4
      }
      if (rating5 != null) {
        getrating5 = rating5
      }
      if (remarks5 != null) {
        getremarks5 = remarks5
      }
      if (rating6 != null) {
        getrating6 = rating6
      }
      if (remarks6 != null) {
        getremarks6 = remarks6
      }
      if (rating7 != null) {
        getrating7 = rating7
      }
      if (remarks7 != null) {
        getremarks7 = remarks7
      }
      if (rating8 != null) {
        getrating8 = rating8
      }
      if (remarks8 != null) {
        getremarks8 = remarks8
      }
      if (rating9 != null) {
        getrating9 = rating9
      }
      if (remarks9 != null) {
        getremarks9 = remarks9
      }
      if (rating10 != null) {
        getrating10 = rating10
      }
      if (remarks10 != null) {
        getremarks10 = remarks10
      }
      if (rating11 != null) {
        getrating11 = rating11
      }
      if (remarks11 != null) {
        getremarks11 = remarks11
      }
      if (rating12 != null) {
        getrating12 = rating12
      }
      if (remarks12 != null) {
        getremarks12 = remarks12
      }
      if (rating13 != null) {
        getrating13 = rating13
      }
      if (remarks13 != null) {
        getremarks13 = remarks13
      }
      if (rating14 != null) {
        getrating14 = rating14
      }
      if (remarks14 != null) {
        getremarks14 = remarks14
      }
      if (rating15 != null) {
        getrating15 = rating15
      }
      if (remarks15 != null) {
        getremarks15 = remarks15
      }
//      if (rating16 != null) {
//        getrating16 = rating16
//      }
//      if (remarks16 != null) {
//        getremarks16 = remarks16
//      }

    }

    //change screen orientation to portrait mode
    requireActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    signaturePad.setOnSignedListener(object : SignaturePad.OnSignedListener {
      override fun onStartSigning() {
        //Event triggered when the pad is touched
//                Toast.makeText(this@MainActivity, "onStatSigning", Toast.LENGTH_SHORT).show()
      }

      override fun onSigned() {
        //Event triggered when the pad is signed
//                Toast.makeText(this@MainActivity, "onSigned", Toast.LENGTH_SHORT).show()
        btnSave.isEnabled = true
        btnclear.isEnabled = true
      }

      override fun onClear() {
        //Event triggered when the pad is cleared
        Toast.makeText(activity, "Cleared", Toast.LENGTH_SHORT).show()
        btnSave.isEnabled = false
        btnclear.isEnabled = false
      }

    })

    btnSave.setOnClickListener() {
//      TRANSPARENT SIGNATURE BACKGROUND TO IMAGEVIEW
      val btmp =signaturePad.getSignatureBitmap()
//      ivsignature.setImageBitmap(btmp)

      if (getlinename.length.toString() > 0.toString() &&
          getlineposition.length.toString() > 0.toString() &&
          getsalesname.length.toString() > 0.toString() &&
          getsalesposition.length.toString() > 0.toString() &&
          getdate.length.toString() > 0.toString() &&
          getrating1.length.toString() > 0.toString() &&
          getremarks1.length.toString() > 0.toString() &&
          getrating2.length.toString() > 0.toString() &&
          getremarks2.length.toString() > 0.toString() &&
          getrating3.length.toString() > 0.toString() &&
          getremarks3.length.toString() > 0.toString() &&
          getrating4.length.toString() > 0.toString() &&
          getremarks4.length.toString() > 0.toString() &&
          getrating5.length.toString() > 0.toString() &&
          getremarks5.length.toString() > 0.toString() &&
          getrating6.length.toString() > 0.toString() &&
          getremarks6.length.toString() > 0.toString() &&
          getrating7.length.toString() > 0.toString() &&
          getremarks7.length.toString() > 0.toString() &&
          getrating8.length.toString() > 0.toString() &&
          getremarks8.length.toString() > 0.toString() &&
          getrating9.length.toString() > 0.toString() &&
          getremarks9.length.toString() > 0.toString() &&
          getrating10.length.toString() > 0.toString() &&
          getremarks10.length.toString() > 0.toString() &&
          getrating11.length.toString() > 0.toString() &&
          getremarks11.length.toString() > 0.toString() &&
          getrating12.length.toString() > 0.toString() &&
          getremarks12.length.toString() > 0.toString() &&
          getrating13.length.toString() > 0.toString() &&
          getremarks13.length.toString() > 0.toString() &&
          getrating14.length.toString() > 0.toString() &&
          getremarks14.length.toString() > 0.toString() &&
          getrating15.length.toString() > 0.toString() &&
          getremarks15.length.toString() > 0.toString()
//          getrating16.length.toString() > 0.toString() &&
//          getremarks16.length.toString() > 0.toString()
      )
      {
        val toFragment = salesmansignature()
        val bundle = Bundle()
        bundle.putString("linename", getlinename)
        bundle.putString("lineposition", getlineposition)
        bundle.putString("salesname", getsalesname)
        bundle.putString("salesposition", getsalesposition)
        bundle.putString("date", getdate)
        bundle.putString("rating1", getrating1)
        bundle.putString("remarks1", getremarks1)
        bundle.putString("rating2", getrating2)
        bundle.putString("remarks2", getremarks2)
        bundle.putString("rating3", getrating3)
        bundle.putString("remarks3", getremarks3)
        bundle.putString("rating4", getrating4)
        bundle.putString("remarks4", getremarks4)
        bundle.putString("rating5", getrating5)
        bundle.putString("remarks5", getremarks5)
        bundle.putString("rating6", getrating6)
        bundle.putString("remarks6", getremarks6)
        bundle.putString("rating7", getrating7)
        bundle.putString("remarks7", getremarks7)
        bundle.putString("rating8", getrating8)
        bundle.putString("remarks8", getremarks8)
        bundle.putString("rating9", getrating9)
        bundle.putString("remarks9", getremarks9)
        bundle.putString("rating10", getrating10)
        bundle.putString("remarks10", getremarks10)
        bundle.putString("rating11", getrating11)
        bundle.putString("remarks11", getremarks11)
        bundle.putString("rating12", getrating12)
        bundle.putString("remarks12", getremarks12)
        bundle.putString("rating13", getrating13)
        bundle.putString("remarks13", getremarks13)
        bundle.putString("rating14", getrating14)
        bundle.putString("remarks14", getremarks14)
        bundle.putString("rating15", getrating15)
        bundle.putString("remarks15", getremarks15)
//        bundle.putString("rating16", getrating16)
//        bundle.putString("remarks16", getremarks16)
        bundle.putParcelable("coach", btmp)
        toFragment.arguments = bundle

        val commit = requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, toFragment, "findThisFragment")
            .addToBackStack(null)
            .commit()

      }else{
        var backFrag = AddentryFragment()
        val commit = requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, backFrag, "findThisFragment")
            .addToBackStack(null)
            .commit()
      }
    }

    btnclear.setOnClickListener() {
      signaturePad.clear()
    }

  return v
  }

// END TAG ONCREATE VIEW
}