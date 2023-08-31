package com.test.information.fragments

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.fonts.Font
import android.graphics.fonts.FontStyle
import android.os.Bundle
import android.os.Environment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.FileProvider
import com.test.information.R
import com.github.gcacace.signaturepad.views.SignaturePad
import com.itextpdf.io.image.ImageData
import com.itextpdf.io.image.ImageDataFactory
import com.itextpdf.kernel.colors.Color
import com.itextpdf.kernel.colors.ColorConstants
import com.itextpdf.kernel.colors.DeviceRgb
import com.itextpdf.kernel.colors.DeviceRgb.BLUE
import com.itextpdf.kernel.colors.DeviceRgb.WHITE
import com.itextpdf.kernel.pdf.PdfDocument
import com.itextpdf.kernel.pdf.PdfWriter
import com.itextpdf.layout.Document
import com.itextpdf.layout.Style
import com.itextpdf.layout.borders.Border
import com.itextpdf.layout.element.Cell
import com.itextpdf.layout.element.Image
import com.itextpdf.layout.element.Paragraph
import com.itextpdf.layout.element.Table
import com.itextpdf.layout.property.Background
import com.itextpdf.layout.property.HorizontalAlignment
import com.itextpdf.layout.property.TextAlignment
import com.itextpdf.layout.property.VerticalAlignment
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHighlightColor.DARK_BLUE
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream


class dmcs_check_and_act_form_signature : Fragment() {

  lateinit var btnSave: Button
  lateinit var btnClear: Button
  // for pdf
  lateinit var bitmap: Bitmap
  lateinit var stream: ByteArrayOutputStream
  lateinit var image: Image
  lateinit var imageData: ImageData
  lateinit var bitmap1: Bitmap
  lateinit var stream1: ByteArrayOutputStream
  lateinit var imageData1: ImageData
  lateinit var image1: Image
  //for pdf table
  lateinit var tableheader: Table
  lateinit var table: Table

  // FOR PDF
  lateinit var outputStream: OutputStream

  //Catching info from check and act form list with this variable
  var getlinename = ""


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    arguments?.let {

    }
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
    val v: View = inflater.inflate(R.layout.fragment_dmcs_check_and_act_form_signature, container, false)

    //Catching info from check and act form list
//    var linename = arguments!!.getString("linename")
//    var lineposition = arguments!!.getString("lineposition")
//    var salesname = arguments!!.getString("salesname")
//    var salesposition = arguments!!.getString("salesposition")
//    var cdate = arguments!!.getString("cdate")
//    var dmcscustomertext = arguments!!.getString("dmcscustomertext")
//    var dmcsbranchtext = arguments!!.getString("dmcsbranchtext")
//    var dmcscallobjtext = arguments!!.getString("dmcscallobjecttext")

//    // get content from the list 1
//    var DHA1 = arguments!!.getString("DHA1")
//    var DHB1 = arguments!!.getString("DHB1")
//    var DHC1 = arguments!!.getString("DHC1")
//    var DHD1 = arguments!!.getString("DHD1")
//
//    var DHA2 = arguments!!.getString("DHA2")
//    var DHB2 = arguments!!.getString("DHB2")
//    var DHC2 = arguments!!.getString("DHC2")
//    var DHD2 = arguments!!.getString("DHD2")
//
//    var DHA3 = arguments!!.getString("DHA3")
//    var DHB3 = arguments!!.getString("DHB3")
//    var DHC3 = arguments!!.getString("DHC3")
//    var DHD3 = arguments!!.getString("DHD3")
//
//    var DHA4 = arguments!!.getString("DHA4")
//    var DHB4 = arguments!!.getString("DHB4")
//    var DHC4 = arguments!!.getString("DHC4")
//    var DHD4 = arguments!!.getString("DHD4")
//
//    var DHA5 = arguments!!.getString("DHA5")
//    var DHB5 = arguments!!.getString("DHB5")
//    var DHC5 = arguments!!.getString("DHC5")
//    var DHD5 = arguments!!.getString("DHD5")
//
//    var DHA6 = arguments!!.getString("DHA6")
//    var DHB6 = arguments!!.getString("DHB6")
//    var DHC6 = arguments!!.getString("DHC6")
//    var DHD6 = arguments!!.getString("DHD6")
//
//    var DHA7 = arguments!!.getString("DHA7")
//    var DHB7 = arguments!!.getString("DHB7")
//    var DHC7 = arguments!!.getString("DHC7")
//    var DHD7 = arguments!!.getString("DHD7")
//
//    // get content from the list 2
//    var CBA1 = arguments!!.getString("CBA1")
//    var CBB1 = arguments!!.getString("CBB1")
//    var CBC1 = arguments!!.getString("CBC1")
//    var CBD1 = arguments!!.getString("CBD1")
//
//    var CBA2 = arguments!!.getString("CBA2")
//    var CBB2 = arguments!!.getString("CBB2")
//    var CBC2 = arguments!!.getString("CBC2")
//    var CBD2 = arguments!!.getString("CBD2")
//
//    var CBA3 = arguments!!.getString("CBA3")
//    var CBB3 = arguments!!.getString("CBB3")
//    var CBC3 = arguments!!.getString("CBC3")
//    var CBD3 = arguments!!.getString("CBD3")
//
//    var CBA4 = arguments!!.getString("CBA4")
//    var CBB4 = arguments!!.getString("CBB4")
//    var CBC4 = arguments!!.getString("CBC4")
//    var CBD4 = arguments!!.getString("CBD4")
//
//    var CBA5 = arguments!!.getString("CBA5")
//    var CBB5 = arguments!!.getString("CBB5")
//    var CBC5 = arguments!!.getString("CBC5")
//    var CBD5 = arguments!!.getString("CBD5")
//
//    var CBA6 = arguments!!.getString("CBA6")
//    var CBB6 = arguments!!.getString("CBB6")
//    var CBC6 = arguments!!.getString("CBC6")
//    var CBD6 = arguments!!.getString("CBD6")
//
//    var CBA7 = arguments!!.getString("CBA7")
//    var CBB7 = arguments!!.getString("CBB7")
//    var CBC7 = arguments!!.getString("CBC7")
//    var CBD7 = arguments!!.getString("CBD7")
//
//    // get content from the list 3
//    var MILA1 = arguments!!.getString("MILA1")
//    var MILB1 = arguments!!.getString("MILB1")
//    var MILC1 = arguments!!.getString("MILC1")
//    var MILD1 = arguments!!.getString("MILD1")
//
//    var MILA2 = arguments!!.getString("MILA2")
//    var MILB2 = arguments!!.getString("MILB2")
//    var MILC2 = arguments!!.getString("MILC2")
//    var MILD2 = arguments!!.getString("MILD2")
//
//    var MILA3 = arguments!!.getString("MILA3")
//    var MILB3 = arguments!!.getString("MILB3")
//    var MILC3 = arguments!!.getString("MILC3")
//    var MILD3 = arguments!!.getString("MILD3")
//
//    var MILA4 = arguments!!.getString("MILA4")
//    var MILB4 = arguments!!.getString("MILB4")
//    var MILC4 = arguments!!.getString("MILC4")
//    var MILD4 = arguments!!.getString("MILD4")
//
//    var MILA5 = arguments!!.getString("MILA5")
//    var MILB5 = arguments!!.getString("MILB5")
//    var MILC5 = arguments!!.getString("MILC5")
//    var MILD5 = arguments!!.getString("MILD5")
//
//    var MILA6 = arguments!!.getString("MILA6")
//    var MILB6 = arguments!!.getString("MILB6")
//    var MILC6 = arguments!!.getString("MILC6")
//    var MILD6 = arguments!!.getString("MILD6")
//
//    var MILA7 = arguments!!.getString("MILA7")
//    var MILB7 = arguments!!.getString("MILB7")
//    var MILC7 = arguments!!.getString("MILC7")
//    var MILD7 = arguments!!.getString("MILD7")
//
//    // get content from the list 4
//    var FADA1 = arguments!!.getString("FADA1")
//    var FADB1 = arguments!!.getString("FADB1")
//    var FADC1 = arguments!!.getString("FADC1")
//    var FADD1 = arguments!!.getString("FADD1")
//
//    var FADA2 = arguments!!.getString("FADA2")
//    var FADB2 = arguments!!.getString("FADB2")
//    var FADC2 = arguments!!.getString("FADC2")
//    var FADD2 = arguments!!.getString("FADD2")
//
//    var FADA3 = arguments!!.getString("FADA3")
//    var FADB3 = arguments!!.getString("FADB3")
//    var FADC3 = arguments!!.getString("FADC3")
//    var FADD3 = arguments!!.getString("FADD3")
//
//    var FADA4 = arguments!!.getString("FADA4")
//    var FADB4 = arguments!!.getString("FADB4")
//    var FADC4 = arguments!!.getString("FADC4")
//    var FADD4 = arguments!!.getString("FADD4")
//
//    var FADA5 = arguments!!.getString("FADA5")
//    var FADB5 = arguments!!.getString("FADB5")
//    var FADC5 = arguments!!.getString("FADC5")
//    var FADD5 = arguments!!.getString("FADD5")
//
//    var FADA6 = arguments!!.getString("FADA6")
//    var FADB6 = arguments!!.getString("FADB6")
//    var FADC6 = arguments!!.getString("FADC6")
//    var FADD6 = arguments!!.getString("FADD6")
//
//    var FADA7 = arguments!!.getString("FADA7")
//    var FADB7 = arguments!!.getString("FADB7")
//    var FADC7 = arguments!!.getString("FADC7")
//    var FADD7 = arguments!!.getString("FADD7")
//
//
//    // get content from the list 5
//    var RTA1 = arguments!!.getString("RTA1")
//    var RTB1 = arguments!!.getString("RTB1")
//    var RTC1 = arguments!!.getString("RTC1")
//    var RTD1 = arguments!!.getString("RTD1")
//
//    var RTA2 = arguments!!.getString("RTA2")
//    var RTB2 = arguments!!.getString("RTB2")
//    var RTC2 = arguments!!.getString("RTC2")
//    var RTD2 = arguments!!.getString("RTD2")
//
//    var RTA3 = arguments!!.getString("RTA3")
//    var RTB3 = arguments!!.getString("RTB3")
//    var RTC3 = arguments!!.getString("RTC3")
//    var RTD3 = arguments!!.getString("RTD3")
//
//    var RTA4 = arguments!!.getString("RTA4")
//    var RTB4 = arguments!!.getString("RTB4")
//    var RTC4 = arguments!!.getString("RTC4")
//    var RTD4 = arguments!!.getString("RTD4")
//
//    var RTA5 = arguments!!.getString("RTA5")
//    var RTB5 = arguments!!.getString("RTB5")
//    var RTC5 = arguments!!.getString("RTC5")
//    var RTD5 = arguments!!.getString("RTD5")
//
//    var RTA6 = arguments!!.getString("RTA6")
//    var RTB6 = arguments!!.getString("RTB6")
//    var RTC6 = arguments!!.getString("RTC6")
//    var RTD6 = arguments!!.getString("RTD6")
//
//    var RTA7 = arguments!!.getString("RTA7")
//    var RTB7 = arguments!!.getString("RTB7")
//    var RTC7 = arguments!!.getString("RTC7")
//    var RTD7 = arguments!!.getString("RTD7")
//
//    // get content from the list 6
//    var NESTA1 = arguments!!.getString("NESTA1")
//    var NESTB1 = arguments!!.getString("NESTB1")
//    var NESTC1 = arguments!!.getString("NESTC1")
//    var NESTD1 = arguments!!.getString("NESTD1")
//
//    var NESTA2 = arguments!!.getString("NESTA2")
//    var NESTB2 = arguments!!.getString("NESTB2")
//    var NESTC2 = arguments!!.getString("NESTC2")
//    var NESTD2 = arguments!!.getString("NESTD2")
//
//    var NESTA3 = arguments!!.getString("NESTA3")
//    var NESTB3 = arguments!!.getString("NESTB3")
//    var NESTC3 = arguments!!.getString("NESTC3")
//    var NESTD3 = arguments!!.getString("NESTD3")
//
//    var NESTA4 = arguments!!.getString("NESTA4")
//    var NESTB4 = arguments!!.getString("NESTB4")
//    var NESTC4 = arguments!!.getString("NESTC4")
//    var NESTD4 = arguments!!.getString("NESTD4")
//
//    var NESTA5 = arguments!!.getString("NESTA5")
//    var NESTB5 = arguments!!.getString("NESTB5")
//    var NESTC5 = arguments!!.getString("NESTC5")
//    var NESTD5 = arguments!!.getString("NESTD5")
//
//    var NESTA6 = arguments!!.getString("NESTA6")
//    var NESTB6 = arguments!!.getString("NESTB6")
//    var NESTC6 = arguments!!.getString("NESTC6")
//    var NESTD6 = arguments!!.getString("NESTD6")
//
//    var NESTA7 = arguments!!.getString("NESTA7")
//    var NESTB7 = arguments!!.getString("NESTB7")
//    var NESTC7 = arguments!!.getString("NESTC7")
//    var NESTD7 = arguments!!.getString("NESTD7")
//
//    // get content from the list 7
//    var BRKCREALA1 = arguments!!.getString("BRKCREALA1")
//    var BRKCREALB1 = arguments!!.getString("BRKCREALB1")
//    var BRKCREALC1 = arguments!!.getString("BRKCREALC1")
//    var BRKCREALD1 = arguments!!.getString("BRKCREALD1")
//
//    var BRKCREALA2 = arguments!!.getString("BRKCREALA2")
//    var BRKCREALB2 = arguments!!.getString("BRKCREALB2")
//    var BRKCREALC2 = arguments!!.getString("BRKCREALC2")
//    var BRKCREALD2 = arguments!!.getString("BRKCREALD2")
//
//    var BRKCREALA3 = arguments!!.getString("BRKCREALA3")
//    var BRKCREALB3 = arguments!!.getString("BRKCREALB3")
//    var BRKCREALC3 = arguments!!.getString("BRKCREALC3")
//    var BRKCREALD3 = arguments!!.getString("BRKCREALD3")
//
//    var BRKCREALA4 = arguments!!.getString("BRKCREALA4")
//    var BRKCREALB4 = arguments!!.getString("BRKCREALB4")
//    var BRKCREALC4 = arguments!!.getString("BRKCREALC4")
//    var BRKCREALD4 = arguments!!.getString("BRKCREALD4")
//
//    var BRKCREALA5 = arguments!!.getString("BRKCREALA5")
//    var BRKCREALB5 = arguments!!.getString("BRKCREALB5")
//    var BRKCREALC5 = arguments!!.getString("BRKCREALC5")
//    var BRKCREALD5 = arguments!!.getString("BRKCREALD5")
//
//    var BRKCREALA6 = arguments!!.getString("BRKCREALA6")
//    var BRKCREALB6 = arguments!!.getString("BRKCREALB6")
//    var BRKCREALC6 = arguments!!.getString("BRKCREALC6")
//    var BRKCREALD6 = arguments!!.getString("BRKCREALD6")
//
//    var BRKCREALA7 = arguments!!.getString("BRKCREALA7")
//    var BRKCREALB7 = arguments!!.getString("BRKCREALB7")
//    var BRKCREALC7 = arguments!!.getString("BRKCREALC7")
//    var BRKCREALD7 = arguments!!.getString("BRKCREALD7")
//
//    // get content from the list 8
//    var INFNTNUTA1 = arguments!!.getString("INFNTNUTA1")
//    var INFNTNUTB1 = arguments!!.getString("INFNTNUTB1")
//    var INFNTNUTC1 = arguments!!.getString("INFNTNUTC1")
//    var INFNTNUTD1 = arguments!!.getString("INFNTNUTD1")
//
//    var INFNTNUTA2 = arguments!!.getString("INFNTNUTA2")
//    var INFNTNUTB2 = arguments!!.getString("INFNTNUTB2")
//    var INFNTNUTC2 = arguments!!.getString("INFNTNUTC2")
//    var INFNTNUTD2 = arguments!!.getString("INFNTNUTD2")
//
//    var INFNTNUTA3 = arguments!!.getString("INFNTNUTA3")
//    var INFNTNUTB3 = arguments!!.getString("INFNTNUTB3")
//    var INFNTNUTC3 = arguments!!.getString("INFNTNUTC3")
//    var INFNTNUTD3 = arguments!!.getString("INFNTNUTD3")
//
//    var INFNTNUTA4 = arguments!!.getString("INFNTNUTA4")
//    var INFNTNUTB4 = arguments!!.getString("INFNTNUTB4")
//    var INFNTNUTC4 = arguments!!.getString("INFNTNUTC4")
//    var INFNTNUTD4 = arguments!!.getString("INFNTNUTD4")
//
//    var INFNTNUTA5 = arguments!!.getString("INFNTNUTA5")
//    var INFNTNUTB5 = arguments!!.getString("INFNTNUTB5")
//    var INFNTNUTC5 = arguments!!.getString("INFNTNUTC5")
//    var INFNTNUTD5 = arguments!!.getString("INFNTNUTD5")
//
//    var INFNTNUTA6 = arguments!!.getString("INFNTNUTA6")
//    var INFNTNUTB6 = arguments!!.getString("INFNTNUTB6")
//    var INFNTNUTC6 = arguments!!.getString("INFNTNUTC6")
//    var INFNTNUTD6 = arguments!!.getString("INFNTNUTD6")
//
//    var INFNTNUTA7 = arguments!!.getString("INFNTNUTA7")
//    var INFNTNUTB7 = arguments!!.getString("INFNTNUTB7")
//    var INFNTNUTC7 = arguments!!.getString("INFNTNUTC7")
//    var INFNTNUTD7 = arguments!!.getString("INFNTNUTD7")
//
//    // get content from the list 9
//    var CONFCA1 = arguments!!.getString("CONFCA1")
//    var CONFCB1 = arguments!!.getString("CONFCB1")
//    var CONFCC1 = arguments!!.getString("CONFCC1")
//    var CONFCD1 = arguments!!.getString("CONFCD1")
//
//    var CONFCA2 = arguments!!.getString("CONFCA2")
//    var CONFCB2 = arguments!!.getString("CONFCB2")
//    var CONFCC2 = arguments!!.getString("CONFCC2")
//    var CONFCD2 = arguments!!.getString("CONFCD2")
//
//    var CONFCA3 = arguments!!.getString("CONFCA3")
//    var CONFCB3 = arguments!!.getString("CONFCB3")
//    var CONFCC3 = arguments!!.getString("CONFCC3")
//    var CONFCD3 = arguments!!.getString("CONFCD3")
//
//    var CONFCA4 = arguments!!.getString("CONFCA4")
//    var CONFCB4 = arguments!!.getString("CONFCB4")
//    var CONFCC4 = arguments!!.getString("CONFCC4")
//    var CONFCD4 = arguments!!.getString("CONFCD4")
//
//    var CONFCA5 = arguments!!.getString("CONFCA5")
//    var CONFCB5 = arguments!!.getString("CONFCB5")
//    var CONFCC5 = arguments!!.getString("CONFCC5")
//    var CONFCD5 = arguments!!.getString("CONFCD5")
//
//    var CONFCA6 = arguments!!.getString("CONFCA6")
//    var CONFCB6 = arguments!!.getString("CONFCB6")
//    var CONFCC6 = arguments!!.getString("CONFCC6")
//    var CONFCD6 = arguments!!.getString("CONFCD6")
//
//    var CONFCA7 = arguments!!.getString("CONFCA7")
//    var CONFCB7 = arguments!!.getString("CONFCB7")
//    var CONFCC7 = arguments!!.getString("CONFCC7")
//    var CONFCD7 = arguments!!.getString("CONFCD7")

//    // get content from the list 10
//    var OTHERSA1 = arguments!!.getString("OTHERSA1")
//    var OTHERSB1 = arguments!!.getString("OTHERSB1")
//    var OTHERSC1 = arguments!!.getString("OTHERSC1")
//    var OTHERSD1 = arguments!!.getString("OTHERSD1")
//
//    var OTHERSA2 = arguments!!.getString("OTHERSA2")
//    var OTHERSB2 = arguments!!.getString("OTHERSB2")
//    var OTHERSC2 = arguments!!.getString("OTHERSC2")
//    var OTHERSD2 = arguments!!.getString("OTHERSD2")
//
//    var OTHERSA3 = arguments!!.getString("OTHERSA3")
//    var OTHERSB3 = arguments!!.getString("OTHERSB3")
//    var OTHERSC3 = arguments!!.getString("OTHERSC3")
//    var OTHERSD3 = arguments!!.getString("OTHERSD3")
//
//    var OTHERSA4 = arguments!!.getString("OTHERSA4")
//    var OTHERSB4 = arguments!!.getString("OTHERSB4")
//    var OTHERSC4 = arguments!!.getString("OTHERSC4")
//    var OTHERSD4 = arguments!!.getString("OTHERSD4")

//    var OTHERSA5 = arguments!!.getString("OTHERSA5")
//    var OTHERSB5 = arguments!!.getString("OTHERSB5")
//    var OTHERSC5 = arguments!!.getString("OTHERSC5")
//    var OTHERSD5 = arguments!!.getString("OTHERSD5")
//
//    // get content from the list 11
//    var BDATOPIC1 = arguments!!.getString("BDATOPIC1")
//    var BDATOPIC2 = arguments!!.getString("BDATOPIC2")
//    var BDATOPIC3 = arguments!!.getString("BDATOPIC3")
//    var BDATOPIC4 = arguments!!.getString("BDATOPIC4")
//    var BDATOPIC5 = arguments!!.getString("BDATOPIC5")
//    var BDATOPIC6 = arguments!!.getString("BDATOPIC6")
//    var BDATOPIC7 = arguments!!.getString("BDATOPIC7")
//
//    var BDAA1 = arguments!!.getString("BDAA1")
//    var BDAB1 = arguments!!.getString("BDAB1")
//    var BDAC1 = arguments!!.getString("BDAC1")
//    var BDAD1 = arguments!!.getString("BDAD1")
//
//    var BDAA2 = arguments!!.getString("BDAA2")
//    var BDAB2 = arguments!!.getString("BDAB2")
//    var BDAC2 = arguments!!.getString("BDAC2")
//    var BDAD2 = arguments!!.getString("BDAD2")
//
//    var BDAA3 = arguments!!.getString("BDAA3")
//    var BDAB3 = arguments!!.getString("BDAB3")
//    var BDAC3 = arguments!!.getString("BDAC3")
//    var BDAD3 = arguments!!.getString("BDAD3")
//
//    var BDAA4 = arguments!!.getString("BDAA4")
//    var BDAB4 = arguments!!.getString("BDAB4")
//    var BDAC4 = arguments!!.getString("BDAC4")
//    var BDAD4 = arguments!!.getString("BDAD4")
//
//    var BDAA5 = arguments!!.getString("BDAA5")
//    var BDAB5 = arguments!!.getString("BDAB5")
//    var BDAC5 = arguments!!.getString("BDAC5")
//    var BDAD5 = arguments!!.getString("BDAD5")
//
//    var BDAA6 = arguments!!.getString("BDAA6")
//    var BDAB6 = arguments!!.getString("BDAB6")
//    var BDAC6 = arguments!!.getString("BDAC6")
//    var BDAD6 = arguments!!.getString("BDAD6")
//
//    var BDAA7 = arguments!!.getString("BDAA7")
//    var BDAB7 = arguments!!.getString("BDAB7")
//    var BDAC7 = arguments!!.getString("BDAC7")
//    var BDAD7 = arguments!!.getString("BDAD7")




    // Signature pad on DMCS
    val dmcssignature = v.findViewById<SignaturePad>(R.id.signaturePadcheckandact)
    btnSave = v.findViewById(R.id.btnSaveCheckandAct)
    btnClear = v.findViewById(R.id.btnClearCheckandAct)

    btnSave.isEnabled = false
    btnClear.isEnabled = false

    dmcssignature.setOnSignedListener(object : SignaturePad.OnSignedListener {
      override fun onStartSigning() {
        //Event triggered when the pad is touched
//                Toast.makeText(this@MainActivity, "onStatSigning", Toast.LENGTH_SHORT).show()
      }

      override fun onSigned() {
        //Event triggered when the pad is signed
//                Toast.makeText(this@MainActivity, "onSigned", Toast.LENGTH_SHORT).show()
        btnSave.isEnabled = true
        btnClear.isEnabled = true
      }

      override fun onClear() {
        //Event triggered when the pad is cleared
        Toast.makeText(activity, "Cleared", Toast.LENGTH_SHORT).show()
        btnSave.isEnabled = false
        btnClear.isEnabled = false
      }


    })


    btnSave.setOnClickListener(){

      // Getting value form form list
      var linename = arguments!!.getString("linename")
      var lineposition = arguments!!.getString("lineposition")
      var salesname = arguments!!.getString("salesname")
      var salesposition = arguments!!.getString("salesposition")
      var cdate = arguments!!.getString("cdate")
      var dmcscustomertext = arguments!!.getString("dmcscustomertext")
      var dmcsbranchtext = arguments!!.getString("dmcsbranchtext")
      var dmcscallobjtext = arguments!!.getString("dmcscallobjecttext")



      // get content from the list 1
      var DHA1 = arguments!!.getString("DHA1")
      var DHB1 = arguments!!.getString("DHB1")
      var DHC1 = arguments!!.getString("DHC1")
      var DHD1 = arguments!!.getString("DHD1")

      var DHA2 = arguments!!.getString("DHA2")
      var DHB2 = arguments!!.getString("DHB2")
      var DHC2 = arguments!!.getString("DHC2")
      var DHD2 = arguments!!.getString("DHD2")

      var DHA3 = arguments!!.getString("DHA3")
      var DHB3 = arguments!!.getString("DHB3")
      var DHC3 = arguments!!.getString("DHC3")
      var DHD3 = arguments!!.getString("DHD3")

      var DHA4 = arguments!!.getString("DHA4")
      var DHB4 = arguments!!.getString("DHB4")
      var DHC4 = arguments!!.getString("DHC4")
      var DHD4 = arguments!!.getString("DHD4")

      var DHA5 = arguments!!.getString("DHA5")
      var DHB5 = arguments!!.getString("DHB5")
      var DHC5 = arguments!!.getString("DHC5")
      var DHD5 = arguments!!.getString("DHD5")

      var DHA6 = arguments!!.getString("DHA6")
      var DHB6 = arguments!!.getString("DHB6")
      var DHC6 = arguments!!.getString("DHC6")
      var DHD6 = arguments!!.getString("DHD6")

      var DHA7 = arguments!!.getString("DHA7")
      var DHB7 = arguments!!.getString("DHB7")
      var DHC7 = arguments!!.getString("DHC7")
      var DHD7 = arguments!!.getString("DHD7")

      // get content from the list 2
      var CBA1 = arguments!!.getString("CBA1")
      var CBB1 = arguments!!.getString("CBB1")
      var CBC1 = arguments!!.getString("CBC1")
      var CBD1 = arguments!!.getString("CBD1")

      var CBA2 = arguments!!.getString("CBA2")
      var CBB2 = arguments!!.getString("CBB2")
      var CBC2 = arguments!!.getString("CBC2")
      var CBD2 = arguments!!.getString("CBD2")

      var CBA3 = arguments!!.getString("CBA3")
      var CBB3 = arguments!!.getString("CBB3")
      var CBC3 = arguments!!.getString("CBC3")
      var CBD3 = arguments!!.getString("CBD3")

      var CBA4 = arguments!!.getString("CBA4")
      var CBB4 = arguments!!.getString("CBB4")
      var CBC4 = arguments!!.getString("CBC4")
      var CBD4 = arguments!!.getString("CBD4")

      var CBA5 = arguments!!.getString("CBA5")
      var CBB5 = arguments!!.getString("CBB5")
      var CBC5 = arguments!!.getString("CBC5")
      var CBD5 = arguments!!.getString("CBD5")

      var CBA6 = arguments!!.getString("CBA6")
      var CBB6 = arguments!!.getString("CBB6")
      var CBC6 = arguments!!.getString("CBC6")
      var CBD6 = arguments!!.getString("CBD6")

      var CBA7 = arguments!!.getString("CBA7")
      var CBB7 = arguments!!.getString("CBB7")
      var CBC7 = arguments!!.getString("CBC7")
      var CBD7 = arguments!!.getString("CBD7")

      // get content from the list 3
      var MILA1 = arguments!!.getString("MILA1")
      var MILB1 = arguments!!.getString("MILB1")
      var MILC1 = arguments!!.getString("MILC1")
      var MILD1 = arguments!!.getString("MILD1")

      var MILA2 = arguments!!.getString("MILA2")
      var MILB2 = arguments!!.getString("MILB2")
      var MILC2 = arguments!!.getString("MILC2")
      var MILD2 = arguments!!.getString("MILD2")

      var MILA3 = arguments!!.getString("MILA3")
      var MILB3 = arguments!!.getString("MILB3")
      var MILC3 = arguments!!.getString("MILC3")
      var MILD3 = arguments!!.getString("MILD3")

      var MILA4 = arguments!!.getString("MILA4")
      var MILB4 = arguments!!.getString("MILB4")
      var MILC4 = arguments!!.getString("MILC4")
      var MILD4 = arguments!!.getString("MILD4")

      var MILA5 = arguments!!.getString("MILA5")
      var MILB5 = arguments!!.getString("MILB5")
      var MILC5 = arguments!!.getString("MILC5")
      var MILD5 = arguments!!.getString("MILD5")

      var MILA6 = arguments!!.getString("MILA6")
      var MILB6 = arguments!!.getString("MILB6")
      var MILC6 = arguments!!.getString("MILC6")
      var MILD6 = arguments!!.getString("MILD6")

      var MILA7 = arguments!!.getString("MILA7")
      var MILB7 = arguments!!.getString("MILB7")
      var MILC7 = arguments!!.getString("MILC7")
      var MILD7 = arguments!!.getString("MILD7")

      // get content from the list 4
      var FADA1 = arguments!!.getString("FADA1")
      var FADB1 = arguments!!.getString("FADB1")
      var FADC1 = arguments!!.getString("FADC1")
      var FADD1 = arguments!!.getString("FADD1")

      var FADA2 = arguments!!.getString("FADA2")
      var FADB2 = arguments!!.getString("FADB2")
      var FADC2 = arguments!!.getString("FADC2")
      var FADD2 = arguments!!.getString("FADD2")

      var FADA3 = arguments!!.getString("FADA3")
      var FADB3 = arguments!!.getString("FADB3")
      var FADC3 = arguments!!.getString("FADC3")
      var FADD3 = arguments!!.getString("FADD3")

      var FADA4 = arguments!!.getString("FADA4")
      var FADB4 = arguments!!.getString("FADB4")
      var FADC4 = arguments!!.getString("FADC4")
      var FADD4 = arguments!!.getString("FADD4")

      var FADA5 = arguments!!.getString("FADA5")
      var FADB5 = arguments!!.getString("FADB5")
      var FADC5 = arguments!!.getString("FADC5")
      var FADD5 = arguments!!.getString("FADD5")

      var FADA6 = arguments!!.getString("FADA6")
      var FADB6 = arguments!!.getString("FADB6")
      var FADC6 = arguments!!.getString("FADC6")
      var FADD6 = arguments!!.getString("FADD6")

      var FADA7 = arguments!!.getString("FADA7")
      var FADB7 = arguments!!.getString("FADB7")
      var FADC7 = arguments!!.getString("FADC7")
      var FADD7 = arguments!!.getString("FADD7")


      // get content from the list 5
      var RTA1 = arguments!!.getString("RTA1")
      var RTB1 = arguments!!.getString("RTB1")
      var RTC1 = arguments!!.getString("RTC1")
      var RTD1 = arguments!!.getString("RTD1")

      var RTA2 = arguments!!.getString("RTA2")
      var RTB2 = arguments!!.getString("RTB2")
      var RTC2 = arguments!!.getString("RTC2")
      var RTD2 = arguments!!.getString("RTD2")

      var RTA3 = arguments!!.getString("RTA3")
      var RTB3 = arguments!!.getString("RTB3")
      var RTC3 = arguments!!.getString("RTC3")
      var RTD3 = arguments!!.getString("RTD3")

      var RTA4 = arguments!!.getString("RTA4")
      var RTB4 = arguments!!.getString("RTB4")
      var RTC4 = arguments!!.getString("RTC4")
      var RTD4 = arguments!!.getString("RTD4")

      var RTA5 = arguments!!.getString("RTA5")
      var RTB5 = arguments!!.getString("RTB5")
      var RTC5 = arguments!!.getString("RTC5")
      var RTD5 = arguments!!.getString("RTD5")

      var RTA6 = arguments!!.getString("RTA6")
      var RTB6 = arguments!!.getString("RTB6")
      var RTC6 = arguments!!.getString("RTC6")
      var RTD6 = arguments!!.getString("RTD6")

      var RTA7 = arguments!!.getString("RTA7")
      var RTB7 = arguments!!.getString("RTB7")
      var RTC7 = arguments!!.getString("RTC7")
      var RTD7 = arguments!!.getString("RTD7")

      // get content from the list 6
      var NESTA1 = arguments!!.getString("NESTA1")
      var NESTB1 = arguments!!.getString("NESTB1")
      var NESTC1 = arguments!!.getString("NESTC1")
      var NESTD1 = arguments!!.getString("NESTD1")

      var NESTA2 = arguments!!.getString("NESTA2")
      var NESTB2 = arguments!!.getString("NESTB2")
      var NESTC2 = arguments!!.getString("NESTC2")
      var NESTD2 = arguments!!.getString("NESTD2")

      var NESTA3 = arguments!!.getString("NESTA3")
      var NESTB3 = arguments!!.getString("NESTB3")
      var NESTC3 = arguments!!.getString("NESTC3")
      var NESTD3 = arguments!!.getString("NESTD3")

      var NESTA4 = arguments!!.getString("NESTA4")
      var NESTB4 = arguments!!.getString("NESTB4")
      var NESTC4 = arguments!!.getString("NESTC4")
      var NESTD4 = arguments!!.getString("NESTD4")

      var NESTA5 = arguments!!.getString("NESTA5")
      var NESTB5 = arguments!!.getString("NESTB5")
      var NESTC5 = arguments!!.getString("NESTC5")
      var NESTD5 = arguments!!.getString("NESTD5")

      var NESTA6 = arguments!!.getString("NESTA6")
      var NESTB6 = arguments!!.getString("NESTB6")
      var NESTC6 = arguments!!.getString("NESTC6")
      var NESTD6 = arguments!!.getString("NESTD6")

      var NESTA7 = arguments!!.getString("NESTA7")
      var NESTB7 = arguments!!.getString("NESTB7")
      var NESTC7 = arguments!!.getString("NESTC7")
      var NESTD7 = arguments!!.getString("NESTD7")

      // get content from the list 7
      var BRKCREALA1 = arguments!!.getString("BRKCREALA1")
      var BRKCREALB1 = arguments!!.getString("BRKCREALB1")
      var BRKCREALC1 = arguments!!.getString("BRKCREALC1")
      var BRKCREALD1 = arguments!!.getString("BRKCREALD1")

      var BRKCREALA2 = arguments!!.getString("BRKCREALA2")
      var BRKCREALB2 = arguments!!.getString("BRKCREALB2")
      var BRKCREALC2 = arguments!!.getString("BRKCREALC2")
      var BRKCREALD2 = arguments!!.getString("BRKCREALD2")

      var BRKCREALA3 = arguments!!.getString("BRKCREALA3")
      var BRKCREALB3 = arguments!!.getString("BRKCREALB3")
      var BRKCREALC3 = arguments!!.getString("BRKCREALC3")
      var BRKCREALD3 = arguments!!.getString("BRKCREALD3")

      var BRKCREALA4 = arguments!!.getString("BRKCREALA4")
      var BRKCREALB4 = arguments!!.getString("BRKCREALB4")
      var BRKCREALC4 = arguments!!.getString("BRKCREALC4")
      var BRKCREALD4 = arguments!!.getString("BRKCREALD4")

      var BRKCREALA5 = arguments!!.getString("BRKCREALA5")
      var BRKCREALB5 = arguments!!.getString("BRKCREALB5")
      var BRKCREALC5 = arguments!!.getString("BRKCREALC5")
      var BRKCREALD5 = arguments!!.getString("BRKCREALD5")

      var BRKCREALA6 = arguments!!.getString("BRKCREALA6")
      var BRKCREALB6 = arguments!!.getString("BRKCREALB6")
      var BRKCREALC6 = arguments!!.getString("BRKCREALC6")
      var BRKCREALD6 = arguments!!.getString("BRKCREALD6")

      var BRKCREALA7 = arguments!!.getString("BRKCREALA7")
      var BRKCREALB7 = arguments!!.getString("BRKCREALB7")
      var BRKCREALC7 = arguments!!.getString("BRKCREALC7")
      var BRKCREALD7 = arguments!!.getString("BRKCREALD7")

      // get content from the list 8
      var INFNTNUTA1 = arguments!!.getString("INFNTNUTA1")
      var INFNTNUTB1 = arguments!!.getString("INFNTNUTB1")
      var INFNTNUTC1 = arguments!!.getString("INFNTNUTC1")
      var INFNTNUTD1 = arguments!!.getString("INFNTNUTD1")

      var INFNTNUTA2 = arguments!!.getString("INFNTNUTA2")
      var INFNTNUTB2 = arguments!!.getString("INFNTNUTB2")
      var INFNTNUTC2 = arguments!!.getString("INFNTNUTC2")
      var INFNTNUTD2 = arguments!!.getString("INFNTNUTD2")

      var INFNTNUTA3 = arguments!!.getString("INFNTNUTA3")
      var INFNTNUTB3 = arguments!!.getString("INFNTNUTB3")
      var INFNTNUTC3 = arguments!!.getString("INFNTNUTC3")
      var INFNTNUTD3 = arguments!!.getString("INFNTNUTD3")

      var INFNTNUTA4 = arguments!!.getString("INFNTNUTA4")
      var INFNTNUTB4 = arguments!!.getString("INFNTNUTB4")
      var INFNTNUTC4 = arguments!!.getString("INFNTNUTC4")
      var INFNTNUTD4 = arguments!!.getString("INFNTNUTD4")

      var INFNTNUTA5 = arguments!!.getString("INFNTNUTA5")
      var INFNTNUTB5 = arguments!!.getString("INFNTNUTB5")
      var INFNTNUTC5 = arguments!!.getString("INFNTNUTC5")
      var INFNTNUTD5 = arguments!!.getString("INFNTNUTD5")

      var INFNTNUTA6 = arguments!!.getString("INFNTNUTA6")
      var INFNTNUTB6 = arguments!!.getString("INFNTNUTB6")
      var INFNTNUTC6 = arguments!!.getString("INFNTNUTC6")
      var INFNTNUTD6 = arguments!!.getString("INFNTNUTD6")

      var INFNTNUTA7 = arguments!!.getString("INFNTNUTA7")
      var INFNTNUTB7 = arguments!!.getString("INFNTNUTB7")
      var INFNTNUTC7 = arguments!!.getString("INFNTNUTC7")
      var INFNTNUTD7 = arguments!!.getString("INFNTNUTD7")

      // get content from the list 9
      var CONFCA1 = arguments!!.getString("CONFCA1")
      var CONFCB1 = arguments!!.getString("CONFCB1")
      var CONFCC1 = arguments!!.getString("CONFCC1")
      var CONFCD1 = arguments!!.getString("CONFCD1")

      var CONFCA2 = arguments!!.getString("CONFCA2")
      var CONFCB2 = arguments!!.getString("CONFCB2")
      var CONFCC2 = arguments!!.getString("CONFCC2")
      var CONFCD2 = arguments!!.getString("CONFCD2")

      var CONFCA3 = arguments!!.getString("CONFCA3")
      var CONFCB3 = arguments!!.getString("CONFCB3")
      var CONFCC3 = arguments!!.getString("CONFCC3")
      var CONFCD3 = arguments!!.getString("CONFCD3")

      var CONFCA4 = arguments!!.getString("CONFCA4")
      var CONFCB4 = arguments!!.getString("CONFCB4")
      var CONFCC4 = arguments!!.getString("CONFCC4")
      var CONFCD4 = arguments!!.getString("CONFCD4")

      var CONFCA5 = arguments!!.getString("CONFCA5")
      var CONFCB5 = arguments!!.getString("CONFCB5")
      var CONFCC5 = arguments!!.getString("CONFCC5")
      var CONFCD5 = arguments!!.getString("CONFCD5")

      var CONFCA6 = arguments!!.getString("CONFCA6")
      var CONFCB6 = arguments!!.getString("CONFCB6")
      var CONFCC6 = arguments!!.getString("CONFCC6")
      var CONFCD6 = arguments!!.getString("CONFCD6")

      var CONFCA7 = arguments!!.getString("CONFCA7")
      var CONFCB7 = arguments!!.getString("CONFCB7")
      var CONFCC7 = arguments!!.getString("CONFCC7")
      var CONFCD7 = arguments!!.getString("CONFCD7")

      // get content from the list 10
      var OTHERSA1 = arguments!!.getString("OTHERSA1")
      var OTHERSB1 = arguments!!.getString("OTHERSB1")
      var OTHERSC1 = arguments!!.getString("OTHERSC1")
      var OTHERSD1 = arguments!!.getString("OTHERSD1")

      var OTHERSA2 = arguments!!.getString("OTHERSA2")
      var OTHERSB2 = arguments!!.getString("OTHERSB2")
      var OTHERSC2 = arguments!!.getString("OTHERSC2")
      var OTHERSD2 = arguments!!.getString("OTHERSD2")

      var OTHERSA3 = arguments!!.getString("OTHERSA3")
      var OTHERSB3 = arguments!!.getString("OTHERSB3")
      var OTHERSC3 = arguments!!.getString("OTHERSC3")
      var OTHERSD3 = arguments!!.getString("OTHERSD3")

      var OTHERSA4 = arguments!!.getString("OTHERSA4")
      var OTHERSB4 = arguments!!.getString("OTHERSB4")
      var OTHERSC4 = arguments!!.getString("OTHERSC4")
      var OTHERSD4 = arguments!!.getString("OTHERSD4")

      var OTHERSA5 = arguments!!.getString("OTHERSA5")
      var OTHERSB5 = arguments!!.getString("OTHERSB5")
      var OTHERSC5 = arguments!!.getString("OTHERSC5")
      var OTHERSD5 = arguments!!.getString("OTHERSD5")

      // get content from the list 11
      var BDATOPIC1 = arguments!!.getString("BDATOPIC1")
      var BDATOPIC2 = arguments!!.getString("BDATOPIC2")
      var BDATOPIC3 = arguments!!.getString("BDATOPIC3")
      var BDATOPIC4 = arguments!!.getString("BDATOPIC4")
      var BDATOPIC5 = arguments!!.getString("BDATOPIC5")
      var BDATOPIC6 = arguments!!.getString("BDATOPIC6")
      var BDATOPIC7 = arguments!!.getString("BDATOPIC7")

      var BDAA1 = arguments!!.getString("BDAA1")
      var BDAB1 = arguments!!.getString("BDAB1")
      var BDAC1 = arguments!!.getString("BDAC1")
      var BDAD1 = arguments!!.getString("BDAD1")

      var BDAA2 = arguments!!.getString("BDAA2")
      var BDAB2 = arguments!!.getString("BDAB2")
      var BDAC2 = arguments!!.getString("BDAC2")
      var BDAD2 = arguments!!.getString("BDAD2")

      var BDAA3 = arguments!!.getString("BDAA3")
      var BDAB3 = arguments!!.getString("BDAB3")
      var BDAC3 = arguments!!.getString("BDAC3")
      var BDAD3 = arguments!!.getString("BDAD3")

      var BDAA4 = arguments!!.getString("BDAA4")
      var BDAB4 = arguments!!.getString("BDAB4")
      var BDAC4 = arguments!!.getString("BDAC4")
      var BDAD4 = arguments!!.getString("BDAD4")

      var BDAA5 = arguments!!.getString("BDAA5")
      var BDAB5 = arguments!!.getString("BDAB5")
      var BDAC5 = arguments!!.getString("BDAC5")
      var BDAD5 = arguments!!.getString("BDAD5")

      var BDAA6 = arguments!!.getString("BDAA6")
      var BDAB6 = arguments!!.getString("BDAB6")
      var BDAC6 = arguments!!.getString("BDAC6")
      var BDAD6 = arguments!!.getString("BDAD6")

      var BDAA7 = arguments!!.getString("BDAA7")
      var BDAB7 = arguments!!.getString("BDAB7")
      var BDAC7 = arguments!!.getString("BDAC7")
      var BDAD7 = arguments!!.getString("BDAD7")





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

      //             PATH TO SAVE
      val pdfPath = File(Environment.getExternalStorageDirectory(), "/CHECK AND ACT FOLDER").toString()
      val file = File(pdfPath, "$salesname $cdate.pdf")
      outputStream = FileOutputStream(file)

      //         CREATE DOCUMENT
      var writer = PdfWriter(outputStream)
      var pdfDocument = PdfDocument(writer)
      var document = Document(pdfDocument)






//    var  coachersign = signature
//       bitmap = (signaturedmcs as BitmapDrawable).bitmap
//      stream = ByteArrayOutputStream()
//      signaturedmcs.compress(Bitmap.CompressFormat.JPEG,100, stream)
//      val  bitmapData2 = stream.toByteArray()
//      imageData = ImageDataFactory.create(bitmapData2)
//      image = Image(imageData)
//        image.scaleAbsolute(200f,40f)

      //         SET HEADER LOGO
      document.setMargins(5F, 0F, 5F, 0F)
      var headerlogo = this.requireActivity().applicationContext.resources.getDrawable(R.drawable.headerlogo)
      bitmap1 = (headerlogo as BitmapDrawable).bitmap
      stream1 = ByteArrayOutputStream()
      bitmap1.compress(Bitmap.CompressFormat.JPEG,100, stream1)
      val bitmapData1 =stream1.toByteArray()
      imageData1 = ImageDataFactory.create(bitmapData1)
      image1 = Image(imageData1)
      image1.scaleAbsolute(200F,40f)

//             SET SIGNATURE FOR DMCS
      val signature = dmcssignature.getSignatureBitmap()
      var signaturedmcs = signature

      stream = ByteArrayOutputStream()
      signature.compress(Bitmap.CompressFormat.JPEG, 100, stream)
      val bitmapdata = stream.toByteArray()
      imageData = ImageDataFactory.create(bitmapdata)
      image = Image(imageData)



      //         SETTING TABLEHEADER CELL
      val cell1 = floatArrayOf(110f, 110f, 110f, 110f, 110f, 110f)
      tableheader = Table(cell1)
      tableheader.addCell(com.itextpdf.layout.element.Cell().setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(8f).setBorder(Border.NO_BORDER).add(Paragraph("CUSTOMER NAME:")))
      tableheader.addCell(com.itextpdf.layout.element.Cell().setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(8f).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT).add(Paragraph(dmcscustomertext)))
      tableheader.addCell(com.itextpdf.layout.element.Cell(2, 4).setVerticalAlignment(VerticalAlignment.MIDDLE).setBorder(Border.NO_BORDER).addStyle(Style().setBold()).setFontSize(14f).setTextAlignment(TextAlignment.LEFT).add(Paragraph("DMCS CHECK AND ACT FORM")))
      tableheader.addCell(Cell().setFontSize(8f).setBorder(Border.NO_BORDER).add(Paragraph("BRANCH NAME    :")))
      tableheader.addCell(Cell().setFontSize(8f).setBorder(Border.NO_BORDER).setVerticalAlignment(VerticalAlignment.MIDDLE).setTextAlignment(TextAlignment.LEFT).add(Paragraph(dmcsbranchtext)))
      tableheader.addCell(com.itextpdf.layout.element.Cell().setFontSize(8f).setBorder(Border.NO_BORDER).add(Paragraph("DATE OF VISIT     :")))
      tableheader.addCell(com.itextpdf.layout.element.Cell().setBorder(Border.NO_BORDER).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(8f).setTextAlignment(TextAlignment.LEFT).add(Paragraph(cdate)))

      val cell2 = floatArrayOf(120f, 120f, 120f, 120f, 120f)
      table = Table(cell2)

      //SEPARATOR
      table.addCell(Cell(1,5).setBorder(Border.NO_BORDER).setBackgroundColor(WHITE))

      //KEY CALL OBJECTIVES
      table.addCell(Cell().setBorder(Border.NO_BORDER).setFontSize(8f).add(Paragraph("KEY CALL OBJECTIVES:")))
      table.addCell(Cell(1,4).setFontSize(8f).setItalic().setBorder(Border.NO_BORDER).add(Paragraph(dmcscallobjtext)))

      //SEPARATOR
      table.addCell(Cell(1,5).setBorder(Border.NO_BORDER).setBackgroundColor(WHITE))

      //Table DHNS
      table.addCell(Cell(1,5).setFontSize(14f).setBold().setFontSize(12f).setTextAlignment(TextAlignment.CENTER).setFontColor(ColorConstants.WHITE).setBackgroundColor(DeviceRgb(6, 57, 111)).add(Paragraph("DHNS")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("ITEMS TO CHECK")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("I / O")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("ACTION PLAN")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("RESPONSIBLE")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("WHEN")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("OOSA OSA  SKU's")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$DHA1")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$DHB1")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$DHC1")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$DHD1")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("SHELF PRICE OF KEY SKU's")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$DHA2")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$DHB2")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$DHC2")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$DHD2")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("PLAN CYCLE EXECUTION")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$DHA3")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$DHB3")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$DHC3")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$DHD3")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("PLANOGRAM EXECUTION/DISPLAY")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$DHA4")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$DHB4")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$DHC4")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$DHD4")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("FEFO / AGEING / INVTY LEVEL")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$DHA5")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$DHB5")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$DHC5")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$DHD5")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("COMPETITOR ACTIVITY DETAILS")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$DHA6")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$DHB6")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$DHC6")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$DHD6")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("OTHERS")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$DHA7")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$DHB7")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$DHC7")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$DHD7")))

      //SEPARATOR
      table.addCell(Cell(1,5).setBorder(Border.NO_BORDER).setBackgroundColor(WHITE))

      //Table 3CBU
      table.addCell(Cell(1,5).setFontSize(14f).setBold().setFontSize(12f).setTextAlignment(TextAlignment.CENTER).setFontColor(ColorConstants.WHITE).setBackgroundColor(DeviceRgb(6, 57, 111)).add(Paragraph("3CBU")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("ITEMS TO CHECK")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("I / O")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("ACTION PLAN")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("RESPONSIBLE")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("WHEN")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("OOSA OSA SKU's")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CBA1")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CBB1")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CBC1")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CBD1")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("SHELF PRICE OF KEY SKU's")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CBA2")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CBB2")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CBC2")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CBD2")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("CYCLE PLAN EXECUTION")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CBA3")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CBB3")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CBC3")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CBD3")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("PLANOGRAM EXECUTION/DISPLAY")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CBA4")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CBB4")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CBC4")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CBD4")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("FEFO / AGEING / INVTY LEVEL")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CBA5")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CBB5")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CBC5")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CBD5")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("COMPETITOR ACTIVITY DETAILS")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CBA6")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CBB6")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CBC6")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CBD6")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("OTHERS")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CBA7")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CBB7")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CBC7")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CBD7")))

      //SEPARATOR
      table.addCell(Cell(1,5).setBorder(Border.NO_BORDER).setBackgroundColor(WHITE))

      //Table MILO
      table.addCell(Cell(1,5).setBold().setFontSize(12f).setTextAlignment(TextAlignment.CENTER).setFontColor(ColorConstants.WHITE).setBackgroundColor(DeviceRgb(6, 57, 111)).add(Paragraph("MILO")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("ITEMS TO CHECK")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("I / O")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("ACTION PLAN")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("RESPONSIBLE")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("WHEN")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("OOSA OSA SKU's")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$MILA1")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$MILB1")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$MILC1")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$MILD1")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("SHELF PRICE SKU's")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$MILA2")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$MILB2")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$MILC2")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$MILD2")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("CYCLE PLAN EXECUTION")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$MILA3")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$MILB3")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$MILC3")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$MILD3")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("PLANOGRAM EXECUTION/DISPLAY")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$MILA4")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$MILB4")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$MILC4")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$MILD4")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("FEFO / AGEING / INVTY LEVEL")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$MILA5")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$MILB5")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$MILC5")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$MILD5")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("COMPETITOR ACTIVITY DETAILS")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$MILA6")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$MILB6")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$MILC6")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$MILD6")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("OTHERS")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$MILA7")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$MILB7")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$MILC7")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$MILD7")))

      //SEPARATOR
      table.addCell(Cell(1,5).setBorder(Border.NO_BORDER).setBackgroundColor(WHITE))

      //Table FOOD AND DAIRY CULINARY
      table.addCell(Cell(1,5).setBold().setFontSize(12f).setTextAlignment(TextAlignment.CENTER).setFontColor(ColorConstants.WHITE).setBackgroundColor(DeviceRgb(6, 57, 111)).add(Paragraph("FOOD AND DAIRY CULINARY")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("ITEMS TO CHECK")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("I / O")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("ACTION PLAN")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("RESPONSIBLE")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("WHEN")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("OOSA OSA SKU's")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$FADA1")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$FADB1")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$FADC1")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$FADD1")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("SHELF PRICE OF KEY SKU's")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$FADA2")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$FADB2")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$FADC2")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$FADD2")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("CYCLE PLAN EXECUTION")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$FADA3")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$FADB3")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$FADC3")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$FADD3")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("PLANOGRAM EXECUTION/DISPLAY")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$FADA4")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$FADB4")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$FADC4")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$FADD4")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("FEFO / AGEING / INVTY LEVEL")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$FADA5")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$FADB5")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$FADC5")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$FADD5")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("COMPETITOR ACTIVITY DETAILS")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$FADA6")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$FADB6")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$FADC6")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$FADD6")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("OTHERS")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$FADA7")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$FADB7")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$FADC7")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$FADD7")))

      //SEPARATOR
      table.addCell(Cell(1,5).setBorder(Border.NO_BORDER).setBackgroundColor(WHITE))

      //Table FOOD AND DAIRY CULINARY
      table.addCell(Cell(1,5).setBold().setFontSize(12f).setTextAlignment(TextAlignment.CENTER).setFontColor(ColorConstants.WHITE).setBackgroundColor(DeviceRgb(6, 57, 111)).add(Paragraph("READY - TO - DRINK")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("ITEMS TO CHECK")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("I / O")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("ACTION PLAN")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("RESPONSIBLE")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("WHEN")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("OOSA OSA SKU's")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$RTA1")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$RTB1")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$RTC1")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$RTD1")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("SHELF PRICE OF KEY SKU's")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$RTA2")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$RTB2")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$RTC2")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$RTD2")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("CYCLE PLAN EXECUTION")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$RTA3")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$RTB3")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$RTC3")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$RTD3")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("PLANOGRAM EXECUTION/DISPLAY")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$RTA4")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$RTB4")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$RTC4")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$RTD4")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("FEFO /AGEING / INVTY LEVEL")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$RTA5")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$RTB5")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$RTC5")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$RTD5")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("COMPETITOR ACTIVITY DETAILS")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$RTA6")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$RTB6")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$RTC6")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$RTD6")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("OTHERS")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$RTA7")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$RTB7")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$RTC7")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$RTD7")))

      //SEPARATOR
      table.addCell(Cell(1,5).setBorder(Border.NO_BORDER).setBackgroundColor(WHITE))

      //Table NESTEA
      table.addCell(Cell(1,5).setBold().setFontSize(12f).setTextAlignment(TextAlignment.CENTER).setFontColor(ColorConstants.WHITE).setBackgroundColor(DeviceRgb(6, 57, 111)).add(Paragraph("NESTEA")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("ITEMS TO CHECK")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("I / O")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("ACTION PLAN")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("RESPONSIBLE")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("WHEN")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("OOSA OSA SKU'S")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$NESTA1")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$NESTB1")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$NESTC1")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$NESTD1")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("SHELF PRICE OF KEY SKU's")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$NESTA2")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$NESTB2")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$NESTC2")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$NESTD2")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("CYCLE PLAN EXECUTION")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$NESTA3")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$NESTB3")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$NESTC3")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$NESTD3")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("PLANOGRAM EXECUTION/DISPLAY")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$NESTA4")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$NESTB4")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$NESTC4")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$NESTD4")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("FEFO / AGEING /INVTY LEVEL")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$NESTA5")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$NESTB5")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$NESTC5")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$NESTD5")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("COMPETITOR ACTIVITY DETAILS")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$NESTA6")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$NESTB6")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$NESTC6")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$NESTD6")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("OTHERS")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$NESTA7")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$NESTB7")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$NESTC7")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$NESTD7")))

      //SEPARATOR
      table.addCell(Cell(1,5).setBorder(Border.NO_BORDER).setBackgroundColor(WHITE))

      //Table BREAKFAST CEREALS
      table.addCell(Cell(1,5).setBold().setFontSize(12f).setTextAlignment(TextAlignment.CENTER).setFontColor(ColorConstants.WHITE).setBackgroundColor(DeviceRgb(6, 57, 111)).add(Paragraph("BREAKFAST CEREALS")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("ITEMS TO CHECK")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("I / O")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("ACTION PLAN")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("RESPONSIBLE")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("WHEN")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("OOSA OSA SKU's")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BRKCREALA1")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BRKCREALB1")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BRKCREALC1")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BRKCREALD1")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("SHELF PRICE OF KEY SKU's")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BRKCREALA2")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BRKCREALB2")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BRKCREALC2")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BRKCREALD2")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("CYCLE PLAN EXECUTION")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BRKCREALA3")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BRKCREALB3")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BRKCREALC3")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BRKCREALD3")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("PLANOGRAM EXECUTION/DISPLAY")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BRKCREALA4")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BRKCREALB4")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BRKCREALC4")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BRKCREALD4")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("FEFO / AGEING / INVTY LEVEL")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BRKCREALA5")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BRKCREALB5")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BRKCREALC5")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BRKCREALD5")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("COMPETITOR ACTIVITY DETAILS")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BRKCREALA6")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BRKCREALB6")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BRKCREALC6")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BRKCREALD6")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("OTHERS")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BRKCREALA7")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BRKCREALB7")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BRKCREALC7")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BRKCREALD7")))

      //SEPARATOR
      table.addCell(Cell(1,5).setBorder(Border.NO_BORDER).setBackgroundColor(WHITE))

      //Table INFANT NUTRITION
      table.addCell(Cell(1,5).setBold().setFontSize(12f).setTextAlignment(TextAlignment.CENTER).setFontColor(ColorConstants.WHITE).setBackgroundColor(DeviceRgb(6, 57, 111)).add(Paragraph("INFANT NUTRITION")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("ITEMS TO CHECK")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("I / O")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("ACTION PLAN")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("RESPONSIBLE")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("WHEN")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("OOSA OSA SKU's")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$INFNTNUTA1")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$INFNTNUTB1")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$INFNTNUTC1")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$INFNTNUTD1")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("SHELF PRICE OF KEY SKU's")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$INFNTNUTA2")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$INFNTNUTB2")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$INFNTNUTC2")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$INFNTNUTD2")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("CYCLE PLAN EXECUTION")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$INFNTNUTA3")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$INFNTNUTB3")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$INFNTNUTC3")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$INFNTNUTD3")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("PLANOGRAM EXECUTION/DISPLAY")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$INFNTNUTA4")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$INFNTNUTB4")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$INFNTNUTC4")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$INFNTNUTD4")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("FEFO / AGEING / INVTY LEVEL")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$INFNTNUTA5")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$INFNTNUTB5")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$INFNTNUTC5")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$INFNTNUTD5")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("COMPETITOR ACTIVITY DETAILS")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$INFNTNUTA6")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$INFNTNUTB6")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$INFNTNUTC6")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$INFNTNUTD6")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("MILK CODE COMPLIANCE ")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$INFNTNUTA7")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$INFNTNUTB7")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$INFNTNUTC7")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$INFNTNUTD7")))

      //SEPARATOR
      table.addCell(Cell(1,5).setBorder(Border.NO_BORDER).setBackgroundColor(WHITE))

      //Table CONFECTIONERY
      table.addCell(Cell(1,5).setBold().setFontSize(12f).setTextAlignment(TextAlignment.CENTER).setFontColor(ColorConstants.WHITE).setBackgroundColor(DeviceRgb(6, 57, 111)).add(Paragraph("CONFECTIONERY")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("ITEMS TO CHECK")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("I / O")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("ACTION PLAN")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("RESPONSIBLE")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("WHEN")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("OOSA OSA SKU's")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CONFCA1")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CONFCB1")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CONFCC1")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CONFCD1")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("SHELF PRICE OF KEY SKU's")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CONFCA2")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CONFCB2")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CONFCC2")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CONFCD2")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("CYCLE PLAN EXECUTION")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CONFCA3")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CONFCB3")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CONFCC3")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CONFCD3")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("PLANOGRAM EXECUTION/DISPLAY")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CONFCA4")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CONFCB4")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CONFCC4")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CONFCD4")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("FEFO / AGEING / INVTY LEVEL")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CONFCA5")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CONFCB5")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CONFCC5")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CONFCD5")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("COMPETITOR ACTIVITY DETAILS")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CONFCA6")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CONFCB6")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CONFCC6")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CONFCD6")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("OTHERS")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CONFCA7")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CONFCB7")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CONFCC7")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$CONFCD7")))

      //SEPARATOR
      table.addCell(Cell(1,5).setBorder(Border.NO_BORDER).setBackgroundColor(WHITE))

      //Table OTHER ITEMS
      table.addCell(Cell(1,5).setBold().setFontSize(12f).setTextAlignment(TextAlignment.CENTER).setFontColor(ColorConstants.WHITE).setBackgroundColor(DeviceRgb(6, 57, 111)).add(Paragraph("OTHER ITEMS/DISCUSSION WITH OTHER STORE PERSONNEL / FEEDBACK")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("ITEMS TO CHECK")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("I / O")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("ACTION PLAN")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("RESPONSIBLE")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("WHEN")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("CHANNEL PROGRAM EXECUTION")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$OTHERSA1")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$OTHERSB1")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$OTHERSC1")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$OTHERSD1")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("CUSTOMER SPECIFIC ACTIVITY")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$OTHERSA2")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$OTHERSB2")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$OTHERSC2")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$OTHERSD2")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("BACKROOM/BODEGA CONDITION")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$OTHERSA3")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$OTHERSB3")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$OTHERSC3")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$OTHERSD3")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("AR (COLLECTION)")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$OTHERSA4")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$OTHERSB4")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$OTHERSC4")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$OTHERSD4")))

      table.addCell(Cell().setFontSize(9f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("SHOPPER FEEDBACK")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$OTHERSA5")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$OTHERSB5")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$OTHERSC5")))
      table.addCell(Cell().setFontSize(8f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$OTHERSD5")))

      //SEPARATOR
      table.addCell(Cell(1,5).setBorder(Border.NO_BORDER).setBackgroundColor(WHITE))

      //Table BUSINESS DEVELOPMENT DISCUSS & AGREEMENT
      table.addCell(Cell(1,5).setBold().setFontSize(12f).setTextAlignment(TextAlignment.CENTER).setFontColor(ColorConstants.WHITE).setBackgroundColor(DeviceRgb(6, 57, 111)).add(Paragraph("BUSINESS DEVELOPMENT DISCUSS & AGREEMENT")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("ITEMS TO CHECK")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("I / O")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("ACTION PLAN")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("RESPONSIBLE")))
      table.addCell(Cell().setFontSize(10f).setTextAlignment(TextAlignment.CENTER).setBold().setBackgroundColor(DeviceRgb(149, 175, 202)).add(Paragraph("WHEN")))

      table.addCell(Cell().setFontSize(9f).setMinHeight(10f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("$BDATOPIC1")))
      table.addCell(Cell().setFontSize(8f).setMinHeight(10f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BDAA1")))
      table.addCell(Cell().setFontSize(8f).setMinHeight(10f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BDAB1")))
      table.addCell(Cell().setFontSize(8f).setMinHeight(10f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BDAC1")))
      table.addCell(Cell().setFontSize(8f).setMinHeight(10f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BDAD1")))

      table.addCell(Cell().setFontSize(9f).setMinHeight(10f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("$BDATOPIC2")))
      table.addCell(Cell().setFontSize(8f).setMinHeight(10f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BDAA2")))
      table.addCell(Cell().setFontSize(8f).setMinHeight(10f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BDAB2")))
      table.addCell(Cell().setFontSize(8f).setMinHeight(10f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BDAC2")))
      table.addCell(Cell().setFontSize(8f).setMinHeight(10f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BDAD2")))

      table.addCell(Cell().setFontSize(9f).setMinHeight(10f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("$BDATOPIC3")))
      table.addCell(Cell().setFontSize(8f).setMinHeight(10f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BDAA3")))
      table.addCell(Cell().setFontSize(8f).setMinHeight(10f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BDAB3")))
      table.addCell(Cell().setFontSize(8f).setMinHeight(10f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BDAC3")))
      table.addCell(Cell().setFontSize(8f).setMinHeight(10f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BDAD3")))

      table.addCell(Cell().setFontSize(9f).setMinHeight(10f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("$BDATOPIC4")))
      table.addCell(Cell().setFontSize(8f).setMinHeight(10f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BDAA4")))
      table.addCell(Cell().setFontSize(8f).setMinHeight(10f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BDAB4")))
      table.addCell(Cell().setFontSize(8f).setMinHeight(10f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BDAC4")))
      table.addCell(Cell().setFontSize(8f).setMinHeight(10f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BDAD4")))

      table.addCell(Cell().setFontSize(9f).setMinHeight(10f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("$BDATOPIC5")))
      table.addCell(Cell().setFontSize(8f).setMinHeight(10f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BDAA5")))
      table.addCell(Cell().setFontSize(8f).setMinHeight(10f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BDAB5")))
      table.addCell(Cell().setFontSize(8f).setMinHeight(10f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BDAC5")))
      table.addCell(Cell().setFontSize(8f).setMinHeight(10f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BDAD5")))

      table.addCell(Cell().setFontSize(9f).setMinHeight(10f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("$BDATOPIC6")))
      table.addCell(Cell().setFontSize(8f).setMinHeight(10f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BDAA6")))
      table.addCell(Cell().setFontSize(8f).setMinHeight(10f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BDAB6")))
      table.addCell(Cell().setFontSize(8f).setMinHeight(10f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BDAC6")))
      table.addCell(Cell().setFontSize(8f).setMinHeight(10f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BDAD6")))

      table.addCell(Cell().setFontSize(9f).setMinHeight(10f).setTextAlignment(TextAlignment.CENTER).setBold().add(Paragraph("$BDATOPIC7")))
      table.addCell(Cell().setFontSize(8f).setMinHeight(10f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BDAA7")))
      table.addCell(Cell().setFontSize(8f).setMinHeight(10f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BDAB7")))
      table.addCell(Cell().setFontSize(8f).setMinHeight(10f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BDAC7")))
      table.addCell(Cell().setFontSize(8f).setMinHeight(10f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("$BDAD7")))

      //SEPARATOR
      table.addCell(Cell(1,5).setBorder(Border.NO_BORDER).setMinHeight(45f).setBackgroundColor(WHITE))

      // BLANK LINE SIGNATURE
      //SEPARATOR
      table.addCell(Cell(1,2).setBorder(Border.NO_BORDER).setMinHeight(45f).setBackgroundColor(WHITE))
      //MIDDLE SEPARATOR
      table.addCell(Cell().setBorder(Border.NO_BORDER).setMinHeight(45f).setBackgroundColor(WHITE))
      // SIGNATURE AREA
      table.addCell(com.itextpdf.layout.element.Cell(1,2).setVerticalAlignment(VerticalAlignment.MIDDLE).setHorizontalAlignment(
          HorizontalAlignment.LEFT).add(image.setAutoScale(true)).setBorder(Border.NO_BORDER).setMaxHeight(45f))


      // linename
      table.addCell(com.itextpdf.layout.element.Cell(1, 2,).setBorder(Border.NO_BORDER).setVerticalAlignment(VerticalAlignment.BOTTOM).setTextAlignment(TextAlignment.LEFT).setMinHeight(15f).addStyle(Style().setUnderline()).setFontSize(10f).add(Paragraph("$linename")))

      //MIDDLE SEPARATOR
      table.addCell(Cell().setBorder(Border.NO_BORDER).setMinHeight(45f).setBackgroundColor(WHITE))

      //salesmanname
      table.addCell(com.itextpdf.layout.element.Cell(1, 2).setBorder(Border.NO_BORDER).setVerticalAlignment(VerticalAlignment.BOTTOM).setMinHeight(15f).addStyle(Style().setUnderline()).setFontSize(10f).add(Paragraph("$salesname")))

      //LINE POSITION
      table.addCell(com.itextpdf.layout.element.Cell(1, 2).setBorder(Border.NO_BORDER).setVerticalAlignment(VerticalAlignment.TOP).setTextAlignment(TextAlignment.LEFT).setMinHeight(15f).setFontSize(10f).add(Paragraph("$lineposition")))

      //MIDDLE SEPARATOR
      table.addCell(Cell().setBorder(Border.NO_BORDER).setMinHeight(45f).setBackgroundColor(WHITE))

      //SALES  POSITION
      table.addCell(com.itextpdf.layout.element.Cell(1, 2).setBorder(Border.NO_BORDER).setVerticalAlignment(VerticalAlignment.TOP).setTextAlignment(TextAlignment.LEFT).setMinHeight(15f).setFontSize(10f).add(Paragraph("$salesposition")))






//    TABLE IMPLEMENTATION

      document.add(image1)
      document.add((tableheader))
      document.add(table)
      document.close()


      ActivityCompat.requestPermissions(
          this.requireActivity(), arrayOf(
          Manifest.permission.WRITE_EXTERNAL_STORAGE,
          Manifest.permission.READ_EXTERNAL_STORAGE,
          Manifest.permission.MANAGE_EXTERNAL_STORAGE,
          Manifest.permission.INTERNET
      ), PackageManager.PERMISSION_GRANTED
      )

      val bmpUri = FileProvider.getUriForFile(this.requireActivity(), "com.test.information.fileprovider", file)

      val share = Intent()
      share.action = Intent.ACTION_SEND
      share.type = "*/*"
      share.putExtra(Intent.EXTRA_STREAM, bmpUri )
      share.flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
      share.setPackage("com.viber.voip")
      startActivity(Intent.createChooser(share, "Share It"))


      var backFrag = addentry_select_form()
      val commit = requireActivity().supportFragmentManager.beginTransaction()
          .replace(R.id.frame_layout, backFrag, "findThisFragment")
          .addToBackStack(null)
          .commit()

// end signature button bracket
    }




    btnClear.setOnClickListener(){
      dmcssignature.clear()
    }


  return v
  }


}