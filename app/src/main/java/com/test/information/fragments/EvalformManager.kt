package com.test.information.fragments

import android.Manifest
import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.app.ActivityCompat
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import com.itextpdf.io.image.ImageData
import com.itextpdf.io.image.ImageDataFactory
import com.itextpdf.kernel.pdf.PdfDocument
import com.itextpdf.kernel.pdf.PdfWriter
import com.itextpdf.layout.Document
import com.itextpdf.layout.Style
import com.itextpdf.layout.borders.Border
import com.itextpdf.layout.element.Image
import com.itextpdf.layout.element.Paragraph
import com.itextpdf.layout.element.Table
import com.itextpdf.layout.property.HorizontalAlignment
import com.itextpdf.layout.property.Property
import com.itextpdf.layout.property.TextAlignment
import com.itextpdf.layout.property.VerticalAlignment
import com.itextpdf.layout.splitting.DefaultSplitCharacters
import com.test.information.DatabaseHandler
import com.test.information.Eval
import com.test.information.R
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.Cell
import java.io.*


class EvalformManager : Fragment() {

  lateinit var button: Button
  private lateinit var e1spn_survey1_manager: Spinner
  private lateinit var e1spn_survey2_manager: Spinner
  private lateinit var e1spn_survey3_manager: Spinner
  private lateinit var e2spn_survey1_manager: Spinner
  private lateinit var e2spn_survey2_manager: Spinner
  private lateinit var e3spn_survey1_manager: Spinner
  private lateinit var e3spn_survey2_manager: Spinner
  private lateinit var e3spn_survey3_manager: Spinner
  private lateinit var e3spn_survey4_manager: Spinner
  private lateinit var e3spn_survey5_manager: Spinner
  private lateinit var e3spn_survey6_manager: Spinner
  private lateinit var e3spn_survey7_manager: Spinner
  private lateinit var e3spn_survey8_manager: Spinner
  private lateinit var e3spn_survey9_manager: Spinner
  private lateinit var e3spn_survey10_manager: Spinner
//  private lateinit var e3spn_survey11_manager: Spinner

  private lateinit var display_name: TextView
  private lateinit var position_name: TextView
  private lateinit var btn_evalsubmit: Button

  private lateinit var e1survey1_feedback_manager: EditText
  private lateinit var e1survey2_feedback_manager: EditText
  private lateinit var e1survey3_feedback_manager: EditText
  private lateinit var e2survey1_feedback_manager: EditText
  private lateinit var e2survey2_feedback_manager: EditText
  private lateinit var e3survey1_feedback_manager: EditText
  private lateinit var e3survey2_feedback_manager: EditText
  private lateinit var e3survey3_feedback_manager: EditText
  private lateinit var e3survey4_feedback_manager: EditText
  private lateinit var e3survey5_feedback_manager: EditText
  private lateinit var e3survey6_feedback_manager: EditText
  private lateinit var e3survey7_feedback_manager: EditText
  private lateinit var e3survey8_feedback_manager: EditText
  private lateinit var e3survey9_feedback_manager: EditText
  private lateinit var e3survey10_feedback_manager: EditText
//  private lateinit var e3survey11_feedback_manager: EditText

  lateinit var drawable: Drawable
  lateinit var bitmap1: Bitmap
  lateinit var bitmap2: Bitmap
  lateinit var bitmap3: Bitmap
  lateinit var bitmapsignature1: Bitmap
  lateinit var bitmapsignature2: Bitmap
  lateinit var outputStream: OutputStream
  lateinit var pdfDocument: PdfDocument
  lateinit var document: Document
  lateinit var stream1: ByteArrayOutputStream
  lateinit var stream2: ByteArrayOutputStream
  lateinit var stream3: ByteArrayOutputStream
  lateinit var imageData1: ImageData
  lateinit var imageData2: ImageData
  lateinit var imageData3: ImageData
  lateinit var tableheader: Table
  lateinit var tablecolumn: Table
  lateinit var table: Table
  lateinit var image1: Image
  lateinit var image2: Image
  lateinit var image3: Image


  // Spinner Variable
  var vspin1 = ""
  var vspin2 = ""
  var vspin3 = ""
  var vspin4 = ""
  var vspin5 = ""
  var vspin6 = ""
  var vspin7 = ""
  var vspin8 = ""
  var vspin9 = ""
  var vspin10 = ""
  var vspin11 = ""
  var vspin12 = ""
  var vspin13 = ""
  var vspin14 = ""
  var vspin15 = ""
//  var vspin16 = ""



  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)



  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?,
  ): View? {

    var  v: View =  inflater.inflate(R.layout.fragment_evalform_manager, container, false)


    e1survey1_feedback_manager = v.findViewById(R.id.e1survey1_feedback_manager) as EditText
    e1survey2_feedback_manager = v.findViewById(R.id.e1survey2_feedback_manager) as EditText
    e1survey3_feedback_manager = v.findViewById(R.id.e1survey3_feedback_manager) as EditText
    e2survey1_feedback_manager = v.findViewById(R.id.e2survey1_feedback_manager) as EditText
    e2survey2_feedback_manager = v.findViewById(R.id.e2survey2_feedback_manager) as EditText
    e3survey1_feedback_manager = v.findViewById(R.id.e3survey1_feedback_manager) as EditText
    e3survey2_feedback_manager = v.findViewById(R.id.e3survey2_feedback_manager) as EditText
    e3survey3_feedback_manager = v.findViewById(R.id.e3survey3_feedback_manager) as EditText
    e3survey4_feedback_manager = v.findViewById(R.id.e3survey4_feedback_manager) as EditText
    e3survey5_feedback_manager = v.findViewById(R.id.e3survey5_feedback_manager) as EditText
    e3survey6_feedback_manager = v.findViewById(R.id.e3survey6_feedback_manager) as EditText
    e3survey7_feedback_manager = v.findViewById(R.id.e3survey7_feedback_manager) as EditText
    e3survey8_feedback_manager = v.findViewById(R.id.e3survey8_feedback_manager) as EditText
    e3survey9_feedback_manager = v.findViewById(R.id.e3survey9_feedback_manager) as EditText
    e3survey10_feedback_manager = v.findViewById(R.id.e3survey10_feedback_manager) as EditText
//    e3survey11_feedback_manager = v.findViewById(R.id.e3survey11_feedback_manager) as EditText

//        Remarks Value
    var e1survey1_feedback = e1survey1_feedback_manager.text
    var e1survey2_feedback = e1survey2_feedback_manager.text
    var e1survey3_feedback = e1survey3_feedback_manager.text
    var e2survey1_feedback = e2survey1_feedback_manager.text
    var e2survey2_feedback = e2survey2_feedback_manager.text
    var e3survey1_feedback = e3survey1_feedback_manager.text
    var e3survey2_feedback = e3survey2_feedback_manager.text
    var e3survey3_feedback = e3survey3_feedback_manager.text
    var e3survey4_feedback = e3survey4_feedback_manager.text
    var e3survey5_feedback = e3survey5_feedback_manager.text
    var e3survey6_feedback = e3survey6_feedback_manager.text
    var e3survey7_feedback = e3survey7_feedback_manager.text
    var e3survey8_feedback = e3survey8_feedback_manager.text
    var e3survey9_feedback = e3survey9_feedback_manager.text
    var e3survey10_feedback = e3survey10_feedback_manager.text
//    var e3survey11_feedback = e3survey11_feedback_manager.text


//Display Name

    display_name = v.findViewById(R.id.display_name)
    position_name = v.findViewById(R.id.position_name)
    display_name.text = "test"
    position_name.text = "test"
    var  display_date = "test"


// ++++++++++++++++++++++++++++++Evaluation Folder+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    ActivityCompat.requestPermissions(
      this.requireActivity(), arrayOf(
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
        android.Manifest.permission.READ_EXTERNAL_STORAGE,
        android.Manifest.permission.MANAGE_EXTERNAL_STORAGE
      ), PackageManager.PERMISSION_GRANTED
    )
//                Creating folder
    val extStorageDirectory = Environment.getExternalStorageDirectory().toString()
    val folder = File(extStorageDirectory, "Evaluation Folder")
    if (folder.exists()) {
      //return
    } else {
      folder.mkdir()
    }
// +++++++++++++++++++++++++++++++++++++ END CREATE FOLDER +++++++++++++++++++++++++++++++
// +++++++++++++++++++++++++ GETTING AND SETTING THE VALUE NAME POSITION AND DATE
    var linename = ""
    var lineposition = ""
    var salesname = ""
    var salesposition = ""
    var cdate = ""


    if (arguments!!.getString("linemanagername") != null || arguments!!.getString("linemanagerposition") != null || arguments!!.get("salesmanname") !=null || arguments!!.getString("salesmanposition")  !=null || arguments!!.getString("date") != null) {
      val linemanagername = arguments!!.getString("linemanagername")
      val linemanagerposition = arguments!!.getString("linemanagerposition")
      val salesmanname = arguments!!.getString("salesmanname")
      val salesmanposition = arguments!!.getString("salesmanposition")
      val date = arguments!!.getString("date")
//          bitmapsignature1 = getArguments()?.getParcelable("signature1")!!
//          bitmapsignature2 = getArguments()?.getParcelable("signature2")!!

      if (linemanagername != null) {
        linename = linemanagername
      }
      if (linemanagerposition != null) {
        lineposition = linemanagerposition
      }
      if (salesmanname != null) {
        salesname = salesmanname
      }
      if (salesmanposition != null) {
        salesposition = salesmanposition
      }
      if (date != null) {
        cdate = date
      }

      display_name.setText(salesname)
      position_name.setText(salesposition)
      display_date = cdate


    }
//+++++++++++++++++++++ END GETTING AND SETTING THE VALUE FROM ADD ENTRY FRAGMENT ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

//++++++++++++++++++++++++++++++++++++++ SPINNER START ++++++++++++++++++++++++++++++++++++++++++

    // ++++++ Spinner 1 ++++++++
    //access string array
    val survey2ListItem = resources.getStringArray(R.array.HDlevel1)
    val survey1ListItem = resources.getStringArray(R.array.CLlevel1)
    // access the spinner and set ArrayAdaptor to control the list of items
    e1spn_survey1_manager = v.findViewById(R.id.e1spn_survey1_manager) as Spinner
    if (e1spn_survey1_manager != null) {
      val adapter = ArrayAdapter(this.requireActivity(),
        android.R.layout.simple_spinner_item, survey2ListItem)
      e1spn_survey1_manager.adapter = adapter

      e1spn_survey1_manager.onItemSelectedListener = object :
        AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
          val spin1: String = parent?.getItemAtPosition(position).toString()
          vspin1 = spin1

          //    (testing)         Toast.makeText(this@MainActivity, survey1ListItem[position], Toast.LENGTH_SHORT).show()
          // (testing variables)    Toast.makeText(this@MainActivity, vspin1, Toast.LENGTH_SHORT).show()
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
          TODO("Not yet implemented")
        }
      }
    }
// ++++++ End Spinner 1 ++++++


// ++++++ Spinner 2 ++++++++
    //access string array
    //val survey1ListItem = resources.getStringArray(R.array.level_of_compentency)
    // access the spinner and set ArrayAdaptor to control the list of items
    e1spn_survey2_manager = v.findViewById(R.id.e1spn_survey2_manager) as Spinner
    if (e1spn_survey2_manager != null) {
      val adapter = ArrayAdapter(this.requireActivity(),
        android.R.layout.simple_spinner_item, survey2ListItem)
      e1spn_survey2_manager.adapter = adapter

      e1spn_survey2_manager.onItemSelectedListener = object :
        AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
          val spin2: String = parent?.getItemAtPosition(position).toString()
          vspin2 = spin2
//             Toast.makeText(this@MainActivity, survey1ListItem[position], Toast.LENGTH_SHORT).show()
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
          TODO("Not yet implemented")
        }
      }
    }
// +++++ End Spinner 2 ++++++
// ++++++ Spinner 3 ++++++++
    //access string array
    //val survey1ListItem = resources.getStringArray(R.array.level_of_compentency)
    // access the spinner and set ArrayAdaptor to control the list of items
    e1spn_survey3_manager = v.findViewById(R.id.e1spn_survey3_manager) as Spinner
    if (e1spn_survey3_manager != null) {
      val adapter = ArrayAdapter(this.requireActivity(),
        android.R.layout.simple_spinner_item, survey2ListItem)
      e1spn_survey3_manager.adapter = adapter

      e1spn_survey3_manager.onItemSelectedListener = object :
        AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
          val spin3: String = parent?.getItemAtPosition(position).toString()
          vspin3 = spin3
          //        (testing)            Toast.makeText(this@MainActivity, survey1ListItem[position], Toast.LENGTH_SHORT).show()
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
          TODO("Not yet implemented")
        }
      }
    }
// +++++ End Spinner 3 ++++++
    // ++++++ Spinner 4 ++++++++
    //access string array
//        val survey1ListItem = resources.getStringArray(R.array.level_of_compentency)
//         access the spinner and set ArrayAdaptor to control the list of items
    e2spn_survey1_manager = v.findViewById(R.id.e2spn_survey1_manager) as Spinner
    if (e2spn_survey1_manager != null) {
      val adapter = ArrayAdapter(this.requireActivity(),
        android.R.layout.simple_spinner_item, survey1ListItem)
      e2spn_survey1_manager.adapter = adapter

      e2spn_survey1_manager.onItemSelectedListener = object :
        AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
          val spin4: String = parent?.getItemAtPosition(position).toString()
          vspin4 = spin4
          //                    Toast.makeText(this@MainActivity, survey1ListItem[position], Toast.LENGTH_SHORT).show()
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
          TODO("Not yet implemented")
        }
      }
    }
// +++++ End Spinner 4 ++++++
    // ++++++ Spinner 5 ++++++++
    //access string array
//        val survey1ListItem = resources.getStringArray(R.array.level_of_compentency)
//         access the spinner and set ArrayAdaptor to control the list of items
    e2spn_survey2_manager = v.findViewById(R.id.e2spn_survey2_manager) as Spinner
    if (e2spn_survey2_manager != null) {
      val adapter = ArrayAdapter(this.requireActivity(),
        android.R.layout.simple_spinner_item, survey1ListItem)
      e2spn_survey2_manager.adapter = adapter

      e2spn_survey2_manager.onItemSelectedListener = object :
        AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
          val spin5: String = parent?.getItemAtPosition(position).toString()
          vspin5 = spin5
          //                    Toast.makeText(this@MainActivity, survey1ListItem[position], Toast.LENGTH_SHORT).show()
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
          TODO("Not yet implemented")
        }
      }
    }
// +++++ End Spinner 5 ++++++
    // ++++++ Spinner 6 ++++++++
    //access string array
    //val survey1ListItem = resources.getStringArray(R.array.level_of_compentency)
    // access the spinner and set ArrayAdaptor to control the list of items
    e3spn_survey1_manager = v.findViewById(R.id.e3spn_survey1_manager) as Spinner
    if (e3spn_survey1_manager != null) {
      val adapter = ArrayAdapter(this.requireActivity(),
        android.R.layout.simple_spinner_item, survey1ListItem)
      e3spn_survey1_manager.adapter = adapter

      e3spn_survey1_manager.onItemSelectedListener = object :
        AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
          val spin6: String = parent?.getItemAtPosition(position).toString()
          vspin6 = spin6
          //                    Toast.makeText(this@MainActivity, survey1ListItem[position], Toast.LENGTH_SHORT).show()
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
          TODO("Not yet implemented")
        }
      }
    }
// +++++ End Spinner 6 ++++++
    // ++++++ Spinner 7 ++++++++
    //access string array
    //val survey1ListItem = resources.getStringArray(R.array.level_of_compentency)
//         access the spinner and set ArrayAdaptor to control the list of items
    e3spn_survey2_manager = v.findViewById(R.id.e3spn_survey2_manager) as Spinner
    if (e3spn_survey2_manager != null) {
      val adapter = ArrayAdapter(this.requireActivity(),
        android.R.layout.simple_spinner_item, survey1ListItem)
      e3spn_survey2_manager.adapter = adapter

      e3spn_survey2_manager.onItemSelectedListener = object :
        AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
          val spin7: String = parent?.getItemAtPosition(position).toString()
          vspin7 = spin7
          //                    Toast.makeText(this@MainActivity, survey1ListItem[position], Toast.LENGTH_SHORT).show()
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
          TODO("Not yet implemented")
        }
      }
    }
// +++++ End Spinner 7 ++++++
// ++++++ Spinner 8 ++++++++
    //access string array
//        val survey1ListItem = resources.getStringArray(R.array.level_of_compentency)
//         access the spinner and set ArrayAdaptor to control the list of items
    e3spn_survey3_manager = v.findViewById(R.id.e3spn_survey3_manager) as Spinner
    if (e3spn_survey3_manager != null) {
      val adapter = ArrayAdapter(this.requireActivity(),
        android.R.layout.simple_spinner_item, survey1ListItem)
      e3spn_survey3_manager.adapter = adapter

      e3spn_survey3_manager.onItemSelectedListener = object :
        AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
          val spin8: String = parent?.getItemAtPosition(position).toString()
          vspin8 = spin8
          //                    Toast.makeText(this@MainActivity, survey1ListItem[position], Toast.LENGTH_SHORT).show()
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
          TODO("Not yet implemented")
        }
      }
    }
// +++++ End Spinner 8 ++++++
// ++++++ Spinner 9 ++++++++
    //access string array
    //val survey1ListItem = resources.getStringArray(R.array.level_of_compentency)
    // access the spinner and set ArrayAdaptor to control the list of items
    e3spn_survey4_manager = v.findViewById(R.id.e3spn_survey4_manager) as Spinner
    if (e3spn_survey4_manager != null) {
      val adapter = ArrayAdapter(this.requireActivity(),
        android.R.layout.simple_spinner_item, survey1ListItem)
      e3spn_survey4_manager.adapter = adapter

      e3spn_survey4_manager.onItemSelectedListener = object :
        AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
          val spin9: String = parent?.getItemAtPosition(position).toString()
          vspin9 = spin9
          //                    Toast.makeText(this@MainActivity, survey1ListItem[position], Toast.LENGTH_SHORT).show()
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
          TODO("Not yet implemented")
        }
      }
    }
// +++++ End Spinner 9 ++++++
// ++++++ Spinner 10 ++++++++
    //access string array
//        val survey1ListItem = resources.getStringArray(R.array.level_of_compentency)
//         access the spinner and set ArrayAdaptor to control the list of items
    e3spn_survey5_manager = v.findViewById(R.id.e3spn_survey5_manager) as Spinner
    if (e3spn_survey5_manager != null) {
      val adapter = ArrayAdapter(this.requireActivity(),
        android.R.layout.simple_spinner_item, survey1ListItem)
      e3spn_survey5_manager.adapter = adapter

      e3spn_survey5_manager.onItemSelectedListener = object :
        AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
          val spin10: String = parent?.getItemAtPosition(position).toString()
          vspin10 = spin10
          //                    Toast.makeText(this@MainActivity, survey1ListItem[position], Toast.LENGTH_SHORT).show()
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
          TODO("Not yet implemented")
        }
      }
    }
// +++++ End Spinner 10 ++++++
// ++++++ Spinner 11 ++++++++
    //access string array
//        val survey1ListItem = resources.getStringArray(R.array.level_of_compentency)
//         access the spinner and set ArrayAdaptor to control the list of items
    e3spn_survey6_manager = v.findViewById(R.id.e3spn_survey6_manager) as Spinner
    if (e3spn_survey6_manager != null) {
      val adapter = ArrayAdapter(this.requireActivity(),
        android.R.layout.simple_spinner_item, survey1ListItem)
      e3spn_survey6_manager.adapter = adapter

      e3spn_survey6_manager.onItemSelectedListener = object :
        AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
          val spin11: String = parent?.getItemAtPosition(position).toString()
          vspin11 = spin11
          //                    Toast.makeText(this@MainActivity, survey1ListItem[position], Toast.LENGTH_SHORT).show()
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
          TODO("Not yet implemented")
        }
      }
    }
// +++++ End Spinner 11 ++++++

    // ++++++ Spinner 12 ++++++++
    //access string array
//        val survey1ListItem = resources.getStringArray(R.array.level_of_compentency)
//         access the spinner and set ArrayAdaptor to control the list of items
    e3spn_survey7_manager = v.findViewById(R.id.e3spn_survey7_manager) as Spinner
    if (e3spn_survey7_manager != null) {
      val adapter = ArrayAdapter(this.requireActivity(),
        android.R.layout.simple_spinner_item, survey1ListItem)
      e3spn_survey7_manager.adapter = adapter

      e3spn_survey7_manager.onItemSelectedListener = object :
        AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
          val spin12: String = parent?.getItemAtPosition(position).toString()
          vspin12 = spin12
          //                    Toast.makeText(this@MainActivity, survey1ListItem[position], Toast.LENGTH_SHORT).show()
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
          TODO("Not yet implemented")
        }
      }
    }
// +++++ End Spinner 12 ++++++
    // ++++++ Spinner 13 ++++++++
    //access string array
//        val survey1ListItem = resources.getStringArray(R.array.level_of_compentency)
//         access the spinner and set ArrayAdaptor to control the list of items
    e3spn_survey8_manager = v.findViewById(R.id.e3spn_survey8_manager) as Spinner
    if (e3spn_survey8_manager != null) {
      val adapter = ArrayAdapter(this.requireActivity(),
        android.R.layout.simple_spinner_item, survey1ListItem)
      e3spn_survey8_manager.adapter = adapter

      e3spn_survey8_manager.onItemSelectedListener = object :
        AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
          val spin13: String = parent?.getItemAtPosition(position).toString()
          vspin13 = spin13
          //                    Toast.makeText(this@MainActivity, survey1ListItem[position], Toast.LENGTH_SHORT).show()
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
          TODO("Not yet implemented")
        }
      }
    }
// +++++ End Spinner 13 ++++++
    // ++++++ Spinner 14 ++++++++
    //access string array
//        val survey1ListItem = resources.getStringArray(R.array.level_of_compentency)
//         access the spinner and set ArrayAdaptor to control the list of items
    e3spn_survey9_manager = v.findViewById(R.id.e3spn_survey9_manager) as Spinner
    if (e3spn_survey9_manager != null) {
      val adapter = ArrayAdapter(this.requireActivity(),
        android.R.layout.simple_spinner_item, survey1ListItem)
      e3spn_survey9_manager.adapter = adapter

      e3spn_survey9_manager.onItemSelectedListener = object :
        AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
          val spin14: String = parent?.getItemAtPosition(position).toString()
          vspin14 = spin14
          //                    Toast.makeText(this@MainActivity, survey1ListItem[position], Toast.LENGTH_SHORT).show()
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
          TODO("Not yet implemented")
        }
      }
    }
// +++++ End Spinner 14 ++++++
    // ++++++ Spinner 15 ++++++++
    //access string array
//        val survey1ListItem = resources.getStringArray(R.array.level_of_compentency)
//         access the spinner and set ArrayAdaptor to control the list of items
    e3spn_survey10_manager = v.findViewById(R.id.e3spn_survey10_manager) as Spinner
    if (e3spn_survey10_manager != null) {
      val adapter = ArrayAdapter(this.requireActivity(),
        android.R.layout.simple_spinner_item, survey1ListItem)
      e3spn_survey10_manager.adapter = adapter

      e3spn_survey10_manager.onItemSelectedListener = object :
        AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
          val spin15: String = parent?.getItemAtPosition(position).toString()
          vspin15 = spin15
          //                    Toast.makeText(this@MainActivity, survey1ListItem[position], Toast.LENGTH_SHORT).show()
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
          TODO("Not yet implemented")
        }
      }
    }
// +++++ End Spinner 15 ++++++
    // ++++++ Spinner 16 ++++++++
    //access string array
//        val survey1ListItem = resources.getStringArray(R.array.level_of_compentency)
//         access the spinner and set ArrayAdaptor to control the list of items
//    e3spn_survey11_manager = v.findViewById(R.id.e3spn_survey11_manager) as Spinner
//    if (e3spn_survey11_manager != null) {
//      val adapter = ArrayAdapter(this.requireActivity(),
//        android.R.layout.simple_spinner_item, survey1ListItem)
//      e3spn_survey11_manager.adapter = adapter
//
//      e3spn_survey11_manager.onItemSelectedListener = object :
//        AdapterView.OnItemSelectedListener {
//        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//          val spin16: String = parent?.getItemAtPosition(position).toString()
//          vspin16 = spin16
//          //                    Toast.makeText(this@MainActivity, survey1ListItem[position], Toast.LENGTH_SHORT).show()
//        }
//
//        override fun onNothingSelected(parent: AdapterView<*>?) {
//          TODO("Not yet implemented")
//        }
//      }
//    }
// +++++ End Spinner 16 ++++++

//+++++++++++++++++++++++++++++++++++++++ SPINNER END++++++++++++++++++++++++++++++++++++++++++++++++++
// ++++++++++++++++++++++++++++++++++++++++ variable end +++++++++++++++++++++++++++++++++++++++++
    // Inflate the layout for this fragment

//        var  v: View =  inflater.inflate(R.layout.evalfragmentmain, container, false)
//        val db = DatabaseHandler(this.requireActivity())
//        this.btn_evalsubmit = findViewById(R.id.btn_evalsubmit)
    this.button = v.findViewById(R.id.btn_evalsubmit) as Button
    this.button.setOnClickListener(View.OnClickListener() {
//            Toast.makeText(activity, "functional", Toast.LENGTH_SHORT).show()

// +++++++++++++++++++ when button press ++++++++++++++++++++++++++
      if
              (linename.length.toString() > 0.toString() &&
        lineposition.length.toString() > 0.toString() &&
        position_name.text.length.toString() > 0.toString() &&
        display_name.text.length.toString() > 0.toString() &&
        display_date.length.toString() > 0.toString() &&
        vspin1.length.toString() > 0.toString() &&
        e1survey1_feedback.length.toString() > 0.toString() &&
        vspin2.length.toString() > 0.toString() &&
        e1survey2_feedback.length.toString() > 0.toString() &&
        vspin3.length.toString() > 0.toString() &&
        e1survey3_feedback.length.toString() > 0.toString() &&
        vspin4.length.toString() > 0.toString() &&
        e2survey1_feedback.length.toString() > 0.toString() &&
        vspin5.length.toString() > 0.toString() &&
        e2survey2_feedback.length.toString() > 0.toString() &&
        vspin6.length.toString() > 0.toString() &&
        e3survey1_feedback.length.toString() > 0.toString() &&
        vspin7.length.toString() > 0.toString() &&
        e3survey2_feedback.length.toString() > 0.toString() &&
        vspin8.length.toString() > 0.toString() &&
        e3survey3_feedback.length.toString() > 0.toString() &&
        vspin9.length.toString() > 0.toString() &&
        e3survey4_feedback.length.toString() > 0.toString() &&
        vspin10.length.toString() > 0.toString() &&
        e3survey5_feedback.length.toString() > 0.toString() &&
        vspin11.length.toString() > 0.toString() &&
        e3survey6_feedback.length.toString() > 0.toString() &&
        vspin12.length.toString() > 0.toString() &&
        e3survey7_feedback.length.toString() > 0.toString() &&
        vspin13.length.toString() > 0.toString() &&
        e3survey8_feedback.length.toString() > 0.toString() &&
        vspin14.length.toString() > 0.toString() &&
        e3survey9_feedback.length.toString() > 0.toString() &&
        vspin15.length.toString() > 0.toString() &&
        e3survey10_feedback.length.toString() > 0.toString()
//        vspin16.length.toString() > 0.toString()
//        e3survey11_feedback.length.toString() > 0.toString()
      ) {

//                var eval =
//                        Eval(position_name.text.toString(),
//                                display_name.text.toString(),
//                                display_date,
//                                vspin1,
//                                e1survey1_feedback.toString(),
//                                vspin2,
//                                e1survey2_feedback.toString(),
//                                vspin3,
//                                e1survey3_feedback.toString(),
//                                vspin4,
//                                e2survey1_feedback.toString(),
//                                vspin5,
//                                e2survey2_feedback.toString(),
//                                vspin6,
//                                e3survey1_feedback.toString(),
//                                vspin7,
//                                e3survey2_feedback.toString(),
//                                vspin8,
//                                e3survey3_feedback.toString(),
//                                vspin9,
//                                e3survey4_feedback.toString(),
//                                vspin10,
//                                e3survey5_feedback.toString(),
//                                vspin11,
//                                e3survey6_feedback.toString(),
//                                vspin12,
//                                e3survey7_feedback.toString(),
//                                vspin13,
//                                e3survey8_feedback.toString(),
//                                vspin14,
//                                e3survey9_feedback.toString(),
//                                vspin15,
//                                e3survey10_feedback.toString(),
//                                vspin16,
//                                e3survey11_feedback.toString()
//                        )
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//              db.insertData(eval)
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//              PUSH DATA TO COACHER SIGNATURE FRAGMENT
        val toFragment = linemanagersignature()
        val bundle = Bundle()
        bundle.putString("linename", linename)
        bundle.putString("lineposition", lineposition)
        bundle.putString("salesname", display_name.text.toString())
        bundle.putString("salesposition", position_name.text.toString())
        bundle.putString("date", display_date)
        bundle.putString("rating1", vspin1)
        bundle.putString("remarks1", e1survey1_feedback.toString())
        bundle.putString("rating2", vspin2)
        bundle.putString("remarks2", e1survey2_feedback.toString())
        bundle.putString("rating3", vspin3)
        bundle.putString("remarks3", e1survey3_feedback.toString())
        bundle.putString("rating4", vspin4)
        bundle.putString("remarks4", e2survey1_feedback.toString())
        bundle.putString("rating5", vspin5)
        bundle.putString("remarks5", e2survey2_feedback.toString())
        bundle.putString("rating6", vspin6)
        bundle.putString("remarks6", e3survey1_feedback.toString())
        bundle.putString("rating7", vspin7)
        bundle.putString("remarks7", e3survey2_feedback.toString())
        bundle.putString("rating8", vspin8)
        bundle.putString("remarks8", e3survey3_feedback.toString())
        bundle.putString("rating9", vspin9)
        bundle.putString("remarks9", e3survey4_feedback.toString())
        bundle.putString("rating10", vspin10)
        bundle.putString("remarks10", e3survey5_feedback.toString())
        bundle.putString("rating11",vspin11)
        bundle.putString("remarks11", e3survey6_feedback.toString())
        bundle.putString("rating12", vspin12)
        bundle.putString("remarks12", e3survey7_feedback.toString())
        bundle.putString("rating13", vspin13)
        bundle.putString("remarks13", e3survey8_feedback.toString())
        bundle.putString("rating14", vspin14)
        bundle.putString("remarks14", e3survey9_feedback.toString())
        bundle.putString("rating15", vspin15)
        bundle.putString("remarks15", e3survey10_feedback.toString())
//        bundle.putString("rating16", vspin16)
//        bundle.putString("remarks16", e3survey11_feedback.toString())
        toFragment.arguments = bundle



//              END PUSH DATA TO COACHER SIGNATURE FRAGMENT
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

//              permission
        ActivityCompat.requestPermissions(
          this.requireActivity(), arrayOf(
            WRITE_EXTERNAL_STORAGE,
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.MANAGE_EXTERNAL_STORAGE
          ), PackageManager.PERMISSION_GRANTED
        )

        //             CREATING EVALUATION FOLDER IF ACCIDENTALLY DELETED
        val extStorageDirectory = Environment.getExternalStorageDirectory().toString()
        val folder = File(extStorageDirectory, "Evaluation Folder")
        if (folder.exists()) {
        } else {
          folder.mkdir()
        }

//                val file = File(Environment.getExternalStorageDirectory(), "/Evaluation Folder/COACHING LOG.xls")


        // ++++++++++++++++++++++++ CREATE PDF ++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//                createPDFOM(positionpdf = cposition, namepdf = cname, datepdf = cdate,
//                        ratingrow1 = vspin1, feedbackrow1 = e1survey1_feedback.toString(),ratingrow2 = vspin2, feedbackrow2 = e1survey2_feedback.toString(),
//                        ratingrow3 = vspin3, feedbackrow3 = e1survey3_feedback.toString(),ratingrow4 = vspin4, feedbackrow4 = e2survey1_feedback.toString(),
//                        ratingrow5 = vspin5, feedbackrow5 = e2survey2_feedback.toString(),ratingrow6 = vspin6, feedbackrow6 = e3survey1_feedback.toString(),
//                        ratingrow7 = vspin7, feedbackrow7 = e3survey2_feedback.toString(),ratingrow8 = vspin8, feedbackrow8 = e3survey3_feedback.toString(),
//                        ratingrow9 = vspin9, feedbackrow9 = e3survey4_feedback.toString(),ratingrow10 = vspin10, feedbackrow10 = e3survey5_feedback.toString(),
//                        ratingrow11 = vspin11, feedbackrow11 = e3survey6_feedback.toString(),ratingrow12 = vspin12, feedbackrow12 = e3survey7_feedback.toString(),
//                        ratingrow13 = vspin13, feedbackrow13 = e3survey8_feedback.toString(),ratingrow14 = vspin14, feedbackrow14 = e3survey9_feedback.toString(),
//                        ratingrow15 = vspin15, feedbackrow15 = e3survey10_feedback.toString(),ratingrow16 = vspin16, feedbackrow16 = e3survey11_feedback.toString(), signature1 = bitmapsignature1, signature2 = bitmapsignature2)
//// ++++++++++++++++++++++++END CREATE PDF +++++++++++++++++++++++++++++++++++++++++++++++++++++
//
//                val nextFrag = AddentryFragment()
//                val commit = requireActivity().supportFragmentManager.beginTransaction()
//                        .replace(R.id.frame_layout, nextFrag, "findThisFragment")
//                        .addToBackStack(null)
//                        .commit()

        val commit = requireActivity().supportFragmentManager.beginTransaction()
          .replace(R.id.frame_layout, toFragment, "findThisFragment")
          .addToBackStack(null)
          .commit()

//                End button submit click
      } else (
              Toast.makeText(activity, "Fill All The Required Data", Toast.LENGTH_SHORT).show()
              )

      //++++++++++++++++++++when button press end tag +++++++++++++++++++

    })

    return v

  }


  @SuppressLint("UseCompatLoadingForDrawables")
  fun createPDFOM(positionpdf: String, namepdf: String, datepdf: String,
                  ratingrow1: String, feedbackrow1: String,ratingrow2: String, feedbackrow2: String,
                  ratingrow3: String, feedbackrow3: String,ratingrow4: String, feedbackrow4: String,
                  ratingrow5: String, feedbackrow5: String,ratingrow6: String, feedbackrow6: String,
                  ratingrow7: String, feedbackrow7: String,ratingrow8: String, feedbackrow8: String,
                  ratingrow9: String, feedbackrow9: String,ratingrow10: String, feedbackrow10: String,
                  ratingrow11: String, feedbackrow11: String,ratingrow12: String, feedbackrow12: String,
                  ratingrow13: String, feedbackrow13: String,ratingrow14: String, feedbackrow14: String,
                  ratingrow15: String, feedbackrow15: String,
//                  ratingrow16: String, feedbackrow16: String,
                  signature1:Bitmap, signature2:Bitmap) {
    // Permission on Storage
    ActivityCompat.requestPermissions(
      this.requireActivity(), arrayOf(
        WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.MANAGE_EXTERNAL_STORAGE
      ), PERMISSION_GRANTED
    )

//             PATH TO SAVE
    val pdfPath = File(Environment.getExternalStorageDirectory(), "/Evaluation Folder").toString()
    val file = File(pdfPath, "$namepdf $datepdf.pdf")
    outputStream = FileOutputStream(file)

//         CREATE DOCUMENT
    var writer = PdfWriter(outputStream)
    var pdfDocument = PdfDocument(writer)
    var document = Document(pdfDocument)

//         SET HEADER LOGO
    document.setMargins(5F, 0F, 0F, 0F)
    var headerlogo = this.requireActivity().applicationContext.resources.getDrawable(R.drawable.headerlogo)
    bitmap1 = (headerlogo as BitmapDrawable).bitmap
    stream1 = ByteArrayOutputStream()
    bitmap1.compress(Bitmap.CompressFormat.JPEG,100, stream1)
    val bitmapData1 =stream1.toByteArray()
    imageData1 = ImageDataFactory.create(bitmapData1)
    image1 = Image(imageData1)
    image1.scaleAbsolute(200F,40f)

//       SET SIGNATURE FROM IMAGE DRAWABLE
//       var emmansignature = this.requireActivity().applicationContext.resources.getDrawable(R.drawable.emmansignature)
//       bitmap1 = (emmansignature as BitmapDrawable).bitmap
//       stream2 = ByteArrayOutputStream()
//       bitmap1.compress(Bitmap.CompressFormat.JPEG,100, stream2)
//       val bitmapData2 =stream2.toByteArray()
//       imageData2 = ImageDataFactory.create(bitmapData2)
//       image2 = Image(imageData2)
//       image2.scaleAbsolute(200F,40f)

//       SET SIGNATURE FOR COACHER
    var  coachersign = signature1
//       bitmap2 = (coachersign as BitmapDrawable).bitmap
    stream2 = ByteArrayOutputStream()
    coachersign.compress(Bitmap.CompressFormat.JPEG,100, stream2)
    val  bitmapData2 = stream2.toByteArray()
    imageData2 = ImageDataFactory.create(bitmapData2)
    image2 = Image(imageData2)

//       SET SIGNATURE FOR COACHEE
    var coached = signature2
//       bitmap3 = (coached as BitmapDrawable).bitmap
    stream3 = ByteArrayOutputStream()
    coached.compress(Bitmap.CompressFormat.JPEG, 100, stream3)
    val bitmapData3 = stream3.toByteArray()
    imageData3 = ImageDataFactory.create(bitmapData3)
    image3 = Image(imageData3)

//         SETTING TABLE CELL
    val cell1 = floatArrayOf(110f, 110f, 110f, 110f, 110f, 110f)
    tableheader = Table(cell1)
    tableheader.addCell(com.itextpdf.layout.element.Cell().setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(8f).add(Paragraph(positionpdf)))
    tableheader.addCell(com.itextpdf.layout.element.Cell().setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(8f).add(Paragraph(namepdf).setBorder(Border.NO_BORDER)))
    tableheader.addCell(com.itextpdf.layout.element.Cell(2, 4).setVerticalAlignment(VerticalAlignment.MIDDLE).setBorder(Border.NO_BORDER).addStyle(Style().setBold()).setFontSize(14f).setTextAlignment(TextAlignment.CENTER).add(Paragraph("Compentency Developement Plan (Field Coaching Form)")))
    tableheader.addCell(com.itextpdf.layout.element.Cell().setFontSize(8f).add(Paragraph("Date of Coaching:")))
    tableheader.addCell(com.itextpdf.layout.element.Cell().setFontSize(8f).add(Paragraph(datepdf).setBorder(Border.NO_BORDER)))
    tableheader.addCell(com.itextpdf.layout.element.Cell(1, 7).setFontSize(6f).add(Paragraph("Functional Competency and Observation Behaviors " +
            "- Zero Knowledge(CL1), Trained(CL2), Can do with help(CL3)," +
            " Can do Alone(CL4)," +
            " Can teach others(CL5)")))

    val cell2 = floatArrayOf(120f, 120f, 120f, 120f, 120f, 120f)
    table = Table(cell2)

//         TABLE COLUMN
    table.addCell(com.itextpdf.layout.element.Cell(1, 2).setVerticalAlignment(VerticalAlignment.MIDDLE).addStyle(Style().setBold()).setFontSize(11f).setMinWidth(120f).add(Paragraph("COMPETENCY DEVELOPMENT PLAN"))).setTextAlignment(TextAlignment.CENTER)
    table.addCell(com.itextpdf.layout.element.Cell().setVerticalAlignment(VerticalAlignment.MIDDLE).addStyle(Style().setBold()).setMinWidth(250f).setFontSize(9f).add(Paragraph("COMPETENCIES DESCRIPTION")))
    table.addCell(com.itextpdf.layout.element.Cell().setVerticalAlignment(VerticalAlignment.MIDDLE).addStyle(Style().setBold()).setFontSize(9f).add(Paragraph("Company Required Competency Level (RIGHT PEOPLE)"))).setProperty(Property.SPLIT_CHARACTERS, DefaultSplitCharacters())
    table.addCell(com.itextpdf.layout.element.Cell().setVerticalAlignment(VerticalAlignment.MIDDLE).addStyle(Style().setBold()).setFontSize(9f).add(Paragraph("RATING")))
    table.addCell(com.itextpdf.layout.element.Cell().setVerticalAlignment(VerticalAlignment.MIDDLE).addStyle(Style().setBold()).setFontSize(9f).add(Paragraph("COACH/LM OBSERVATION NOTES")))
//         TABLE ROW (1ST ROW)
    table.addCell(com.itextpdf.layout.element.Cell(3, 2).setVerticalAlignment(VerticalAlignment.MIDDLE).addStyle(Style().setBold()).setFontSize(8f).add(Paragraph("MINDSET AND BEHAVIOR")))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setFontSize(7f).add(Paragraph("LEARNING AGILITY (WILLINGNESS TO LEARN AND ACCEPT QUICKLY)")))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("HD")))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(ratingrow1)))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(feedbackrow1)))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("RIGHT M&B WITH SELF: PASSION TO MAKE A DIFFERENCE AND DELIVER RESULTS (MASIPAG, MATIYAGA, DISCIPLINED, COMMITED)")))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("HD")))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(ratingrow2)))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(feedbackrow2)))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(50f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("RIGHT M&B WITH OTHERS: INSPIRING LEADER THAT ENABLES RESULT THROUGH OTHERS, COURAGEOUS, HIGHLY ENGAGES, PRO-ACTIVE/INITIATES, SERVICE-ORIENTED. SEEK FIRST TO UNDERSTAND THEN TO BE UNDERSTOOD,THINKS WIN-WIN")))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("HD")))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).setFontSize(7f).add(Paragraph(ratingrow3)))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(feedbackrow3)))

//         TABLE ROW (2ND ROW)
    table.addCell(com.itextpdf.layout.element.Cell(2, 2).setVerticalAlignment(VerticalAlignment.MIDDLE).addStyle(Style().setBold()).setFontSize(8f).add(Paragraph("FUNCTIONAL COMPETENCY")))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("MASTER OF DAILY/WEEKLY/MONTHLY ACTIVITIES FOR DIRECT REPORTS")))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("CL5")))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(ratingrow4)))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(feedbackrow4)))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("MASTERY OF A SALESMAN DIAL (DAILY IN A LIFE)")))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("CL5")))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).setFontSize(7f).add(Paragraph(ratingrow5)))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(feedbackrow5)))

//         TABLE CELL SEPARATOR
    table.addCell(com.itextpdf.layout.element.Cell(1, 6))

//         TABLE ROW FOR PLAN DO AND CHECK AND ACT
    table.addCell(com.itextpdf.layout.element.Cell(11, 1).setVerticalAlignment(VerticalAlignment.BOTTOM).setRotationAngle(33F).addStyle(Style().setBold()).setFontSize(14f).add(Paragraph("OBSERVABLE BEHAVIORS RELATED TO FUNCTIONAL COMPETENCY")))
//         TABLE ROW (3RD ROW)
    table.addCell(com.itextpdf.layout.element.Cell(3, 1).setVerticalAlignment(VerticalAlignment.MIDDLE).addStyle(Style().setBold()).setFontSize(8f).setMinWidth(100f).add(Paragraph("PLAN")))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("CONSISTENTLY REVIEW THE QUALITY OF DSR AND DOR")))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("CL5")))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(ratingrow6)))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(feedbackrow6)))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("ABLE TO CRAFT EFFECTIVE COMPETENCY AND DEVELOPMENT PLAN FOR EACH SALESMAN")))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("CL5")))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(ratingrow7)))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(feedbackrow7)))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("ABLE TO CREATE TERRITORY OPTIMIZATION PLAN (MCP) FOR THE MOST EFFICIENT AND DEFECTIVE COVERAGE FOR THE TERRITORY")))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("CL5")))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(ratingrow8)))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(feedbackrow8)))
//         TABLE ROW (4TH ROW)
    table.addCell(com.itextpdf.layout.element.Cell(4, 1).setVerticalAlignment(VerticalAlignment.MIDDLE).addStyle(Style().setBold()).setFontSize(8f).add(Paragraph("DO")))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("ABLTE TO COACH EFFECTIVELY")))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("CL5")))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(ratingrow9)))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(feedbackrow9)))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("CONSISTENTLY REVIEW LOAD PLAN AND ENSURE MSDP SKU'S ARE COMPLETE, RIGHT PRODUCT MIX AND STOCK WEIGHT")))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("CL5")))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(ratingrow10)))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(feedbackrow10)))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("ABLE TO CHALLENGE SALESMAN KPI'S DURING DOR")))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("CL5")))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(ratingrow11)))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(feedbackrow11)))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("EFFECTIVELY COMMUNICATE ALIGNED OBJECTIVE TO THE TEAM")))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("CL5")))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(ratingrow12)))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(feedbackrow12)))
//         TABLE ROW (5TH)
    table.addCell(com.itextpdf.layout.element.Cell(4, 1).setVerticalAlignment(VerticalAlignment.MIDDLE).addStyle(Style().setBold()).setFontSize(8f).add(Paragraph("CHECK & ACT")))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("ABLE TO RUN DOR AND WOR EFFECTIVELY AND EFFICIENTLY")))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("CL5")))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(ratingrow13)))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(feedbackrow13)))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("ANALYSIS TRENDS OF THE GROUP/AREA/STORE PERFORMANCE AND CREATES EFFECTIVE ACTIONS")))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("CL5")))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(ratingrow14)))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(feedbackrow14)))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("ABLE TO DO EFFECTIVE PROBLEM SOLVING (ROOT CAUSE MINDSET) ON THE ISSUES RELEVANT TO THE GROUP")))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("CL5")))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(ratingrow15)))
    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(feedbackrow15)))
//    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("COACHES TRENDS ANALYSIS AND PROBLEM SOLVING SKILLS TO THE TEAM")))
//    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("CL5")))
//    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(ratingrow16)))
//    table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(feedbackrow16)))
//         SIGNATURE AREA
    table.addCell(com.itextpdf.layout.element.Cell(1,2).setVerticalAlignment(VerticalAlignment.MIDDLE).setHorizontalAlignment(HorizontalAlignment.LEFT).add(image2.setAutoScale(true)).setBorder(Border.NO_BORDER).setMaxHeight(45f))
    table.addCell(com.itextpdf.layout.element.Cell().setBorder(Border.NO_BORDER).setMinHeight(45f))
    table.addCell(com.itextpdf.layout.element.Cell(1, 3).setVerticalAlignment(VerticalAlignment.MIDDLE).setHorizontalAlignment(HorizontalAlignment.LEFT).add(image3.setAutoScale(true)).setBorder(Border.NO_BORDER).setMaxHeight(45f))
//         SIGNATURE NAME
    table.addCell(com.itextpdf.layout.element.Cell(1, 2,).setBorder(Border.NO_BORDER).setVerticalAlignment(VerticalAlignment.BOTTOM).setTextAlignment(TextAlignment.LEFT).setMinHeight(15f).addStyle(Style().setUnderline()).setFontSize(10f).add(Paragraph("Emman M. Barillo")))
    table.addCell(com.itextpdf.layout.element.Cell().setBorder(Border.NO_BORDER).setMinHeight(15f))
    table.addCell(com.itextpdf.layout.element.Cell(1, 3).setBorder(Border.NO_BORDER).setVerticalAlignment(VerticalAlignment.BOTTOM).setTextAlignment(TextAlignment.LEFT).setMinHeight(15f).addStyle(Style().setUnderline()).setFontSize(10f).add(Paragraph(namepdf)))
//         SIGNATURE POSITION
    table.addCell(com.itextpdf.layout.element.Cell(1, 2).setBorder(Border.NO_BORDER).setVerticalAlignment(VerticalAlignment.TOP).setTextAlignment(TextAlignment.LEFT).setMinHeight(15f).setFontSize(10f).add(Paragraph("Operation Manager")))
    table.addCell(com.itextpdf.layout.element.Cell().setBorder(Border.NO_BORDER).setMinHeight(15f))
    table.addCell(com.itextpdf.layout.element.Cell(1, 3).setBorder(Border.NO_BORDER).setVerticalAlignment(VerticalAlignment.BOTTOM).setTextAlignment(TextAlignment.LEFT).setMinHeight(15f).setFontSize(10f).add(Paragraph(positionpdf)))


//         IMPLEMENT DESIGN
    document.add(image1)
    document.add(tableheader)
    document.add(table)
    document.close()

    Toast.makeText(requireActivity(), "PDF CREATED", Toast.LENGTH_SHORT).show()


    ActivityCompat.requestPermissions(
      this.requireActivity(), arrayOf(
        WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.MANAGE_EXTERNAL_STORAGE,
        Manifest.permission.INTERNET
      ), PERMISSION_GRANTED
    )

    val bmpUri = FileProvider.getUriForFile(this.requireActivity(), "com.test.information.fileprovider", file)

    val share = Intent()
    share.action = Intent.ACTION_SEND
    share.type = "*/*"
    share.putExtra(Intent.EXTRA_STREAM, bmpUri )
    share.flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
    share.setPackage("com.viber.voip")
    startActivity(Intent.createChooser(share, "Share it"))




//  +++++++++++++++++++++++++++ createPDF end tag+++++++++++++++++++++++++++++++
//         createPDF end tag
  }
}