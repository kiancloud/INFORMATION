package com.test.information.fragments

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


class EvalFragmentMain : Fragment() {

    lateinit var button: Button


    private lateinit var e1spn_survey1: Spinner
    private lateinit var e1spn_survey2: Spinner
    private lateinit var e1spn_survey3: Spinner
    private lateinit var e2spn_survey1: Spinner
//    private lateinit var e2spn_survey2: Spinner
    private lateinit var e3spn_survey1: Spinner
    private lateinit var e3spn_survey2: Spinner
    private lateinit var e3spn_survey3: Spinner
    private lateinit var e3spn_survey4: Spinner
    private lateinit var e3spn_survey5: Spinner
//    private lateinit var e3spn_survey6: Spinner
//    private lateinit var e3spn_survey7: Spinner
    private lateinit var e3spn_survey8: Spinner
    private lateinit var e3spn_survey9: Spinner
    private lateinit var e3spn_survey10: Spinner
    private lateinit var e3spn_survey11: Spinner

    private lateinit var display_name: TextView
    private lateinit var position_name: TextView


    private lateinit var btn_evalsubmit: Button

    private lateinit var e1survey1_feedback: EditText
    private lateinit var e1survey2_feedback: EditText
    private lateinit var e1survey3_feedback: EditText
    private lateinit var e2survey1_feedback: EditText
//    private lateinit var e2survey2_feedback: EditText
    private lateinit var e3survey1_feedback: EditText
    private lateinit var e3survey2_feedback: EditText
    private lateinit var e3survey3_feedback: EditText
    private lateinit var e3survey4_feedback: EditText
    private lateinit var e3survey5_feedback: EditText
//    private lateinit var e3survey6_feedback: EditText
//    private lateinit var e3survey7_feedback: EditText
    private lateinit var e3survey8_feedback: EditText
    private lateinit var e3survey9_feedback: EditText
    private lateinit var e3survey10_feedback: EditText
    private lateinit var e3survey11_feedback: EditText

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

//    lateinit var drawable: Drawable
//    lateinit var bitmap1: Bitmap
//    lateinit var outputStream: OutputStream
//    lateinit var pdfDocument: PdfDocument
//    lateinit var document: Document
//    lateinit var stream1: ByteArrayOutputStream
//    lateinit var imageData1: ImageData
//    lateinit var tableheader: Table
//    lateinit var tablecolumn: Table
//    lateinit var table: Table
//    lateinit var image1: Image



    // Spinner Variable
    var vspin1 = ""
    var vspin2 = ""
    var vspin3 = ""
    var vspin4 = ""
//    var vspin5 = ""
    var vspin6 = ""
    var vspin7 = ""
    var vspin8 = ""
    var vspin9 = ""
    var vspin10 = ""
//    var vspin11 = ""
//    var vspin12 = ""
    var vspin13 = ""
    var vspin14 = ""
    var vspin15 = ""
    var vspin16 = ""


  // OUTPUT VALUE BY PERCENTAGE
    var vspin1HD1 = 0
    var vspin2HD2 = 0
    var vspin3HD3 = 0
    var vspin4CLLEVEL4 = 0
    var vspin6CLLEVEL6 = 0
    var vspin7CLLEVEL7 = 0
    var vspin8CLLEVEL8 = 0
    var vspin9CLLEVEL9 = 0
    var vspin10CLLEVEL10 = 0
    var vspin13CLLEVEL13 = 0
    var vspin14CLLEVEL14 = 0
    var vspin15CLLEVEL15 = 0
    var vspin16CLLEVEL16 = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {

        var  v: View =  inflater.inflate(R.layout.evalfragmentmain, container, false)


        e1survey1_feedback = v.findViewById(R.id.e1survey1_feedback) as EditText
        e1survey2_feedback = v.findViewById(R.id.e1survey2_feedback) as EditText
        e1survey3_feedback = v.findViewById(R.id.e1survey3_feedback) as EditText
        e2survey1_feedback = v.findViewById(R.id.e2survey1_feedback) as EditText
//        e2survey2_feedback = v.findViewById(R.id.e2survey2_feedback) as EditText
        e3survey1_feedback = v.findViewById(R.id.e3survey1_feedback) as EditText
        e3survey2_feedback = v.findViewById(R.id.e3survey2_feedback) as EditText
        e3survey3_feedback = v.findViewById(R.id.e3survey3_feedback) as EditText
        e3survey4_feedback = v.findViewById(R.id.e3survey4_feedback) as EditText
        e3survey5_feedback = v.findViewById(R.id.e3survey5_feedback) as EditText
//        e3survey6_feedback = v.findViewById(R.id.e3survey6_feedback) as EditText
//        e3survey7_feedback = v.findViewById(R.id.e3survey7_feedback) as EditText
        e3survey8_feedback = v.findViewById(R.id.e3survey8_feedback) as EditText
        e3survey9_feedback = v.findViewById(R.id.e3survey9_feedback) as EditText
        e3survey10_feedback = v.findViewById(R.id.e3survey10_feedback) as EditText
        e3survey11_feedback = v.findViewById(R.id.e3survey11_feedback) as EditText

//        Remarks Value
        var e1survey1_feedback = e1survey1_feedback.text
        var e1survey2_feedback = e1survey2_feedback.text
        var e1survey3_feedback = e1survey3_feedback.text
        var e2survey1_feedback = e2survey1_feedback.text
//        var e2survey2_feedback = e2survey2_feedback.text
        var e3survey1_feedback = e3survey1_feedback.text
        var e3survey2_feedback = e3survey2_feedback.text
        var e3survey3_feedback = e3survey3_feedback.text
        var e3survey4_feedback = e3survey4_feedback.text
        var e3survey5_feedback = e3survey5_feedback.text
//        var e3survey6_feedback = e3survey6_feedback.text
//        var e3survey7_feedback = e3survey7_feedback.text
        var e3survey8_feedback = e3survey8_feedback.text
        var e3survey9_feedback = e3survey9_feedback.text
        var e3survey10_feedback = e3survey10_feedback.text
        var e3survey11_feedback = e3survey11_feedback.text


//Display Name

        display_name = v.findViewById(R.id.display_name)
        position_name = v.findViewById(R.id.position_name)
        display_name.text = "test"
        position_name.text = "test"
       var  display_date = "test"

// ++++++++++++++++++++++++++++++CREATING EVALUATION FOLDERr+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        ActivityCompat.requestPermissions(
                this.activity!!, arrayOf(
                WRITE_EXTERNAL_STORAGE,
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
//+++++++++++++++++++++++++++ END CREATING EVALUATION FOLDER

      var linename = ""
      var lineposition = ""
      var salesname = ""
      var salesposition = ""
      var cdate = ""



// +++++++++++++++++++++++++ GETTING AND SETTING THE VALUE NAME POSITION AND DATE


      if (arguments!!.getString("linemanagername") != null || arguments!!.getString("linemanagerposition") != null || arguments!!.getString("date") != null) {
        val linemanagername = arguments!!.getString("linemanagername")
        val linemananagerposition = arguments!!.getString("linemanagerposition")
        val salesmanname = arguments!!.getString("salesmanname")
        val salesmanposition = arguments!!.getString("salesmanposition")
        val date = arguments!!.getString("date")
//            bitmapsignature1 = getArguments()?.getParcelable("signature1")!!
//            bitmapsignature2 = getArguments()?.getParcelable("signature2")!!

        if (linemanagername != null) {
          linename = linemanagername
        }
        if (linemananagerposition != null) {
          lineposition = linemananagerposition
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

// +++++++++++++++++++++ END GETTING AND SETTING THE VALUE FROM THE ADD ENTRY FRAGMENT ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

//++++++++++++++++++++++++++++++++++++++ SPINNER START ++++++++++++++++++++++++++++++++++++++++++

        // ++++++ Spinner 1 ++++++++
        //access string array
        val survey2ListItem = resources.getStringArray(R.array.HDlevel)
        val survey1ListItem = resources.getStringArray(R.array.CLlevel)
        // access the spinner and set ArrayAdaptor to control the list of items
        e1spn_survey1 = v.findViewById(R.id.e1spn_survey1) as Spinner
        if (e1spn_survey1 != null) {
            val adapter = ArrayAdapter(this.activity!!,
                    android.R.layout.simple_spinner_item, survey2ListItem)
            e1spn_survey1.adapter = adapter

            e1spn_survey1.onItemSelectedListener = object :
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
        e1spn_survey2 = v.findViewById(R.id.e1spn_survey2) as Spinner
        if (e1spn_survey2 != null) {
            val adapter = ArrayAdapter(this.activity!!,
                    android.R.layout.simple_spinner_item, survey2ListItem)
            e1spn_survey2.adapter = adapter

            e1spn_survey2.onItemSelectedListener = object :
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
        e1spn_survey3 = v.findViewById(R.id.e1spn_survey3) as Spinner
        if (e1spn_survey3 != null) {
            val adapter = ArrayAdapter(this.activity!!,
                    android.R.layout.simple_spinner_item, survey2ListItem)
            e1spn_survey3.adapter = adapter

            e1spn_survey3.onItemSelectedListener = object :
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
        e2spn_survey1 = v.findViewById(R.id.e2spn_survey1) as Spinner
        if (e2spn_survey1 != null) {
            val adapter = ArrayAdapter(this.activity!!,
                    android.R.layout.simple_spinner_item, survey1ListItem)
            e2spn_survey1.adapter = adapter

            e2spn_survey1.onItemSelectedListener = object :
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
//        e2spn_survey2 = v.findViewById(R.id.e2spn_survey2) as Spinner
//        if (e2spn_survey2 != null) {
//            val adapter = ArrayAdapter(this.activity!!,
//                    android.R.layout.simple_spinner_item, survey1ListItem)
//            e2spn_survey2.adapter = adapter
//
//            e2spn_survey2.onItemSelectedListener = object :
//                    AdapterView.OnItemSelectedListener {
//                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                    val spin5: String = parent?.getItemAtPosition(position).toString()
//                    vspin5 = spin5
//                    //                    Toast.makeText(this@MainActivity, survey1ListItem[position], Toast.LENGTH_SHORT).show()
//                }
//
//                override fun onNothingSelected(parent: AdapterView<*>?) {
//                    TODO("Not yet implemented")
//                }
//            }
//        }
// +++++ End Spinner 5 ++++++
        // ++++++ Spinner 6 ++++++++
        //access string array
        //val survey1ListItem = resources.getStringArray(R.array.level_of_compentency)
        // access the spinner and set ArrayAdaptor to control the list of items
        e3spn_survey1 = v.findViewById(R.id.e3spn_survey1) as Spinner
        if (e3spn_survey1 != null) {
            val adapter = ArrayAdapter(this.activity!!,
                    android.R.layout.simple_spinner_item, survey1ListItem)
            e3spn_survey1.adapter = adapter

            e3spn_survey1.onItemSelectedListener = object :
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
        e3spn_survey2 = v.findViewById(R.id.e3spn_survey2) as Spinner
        if (e3spn_survey2 != null) {
            val adapter = ArrayAdapter(this.activity!!,
                    android.R.layout.simple_spinner_item, survey1ListItem)
            e3spn_survey2.adapter = adapter

            e3spn_survey2.onItemSelectedListener = object :
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
        e3spn_survey3 = v.findViewById(R.id.e3spn_survey3) as Spinner
        if (e3spn_survey3 != null) {
            val adapter = ArrayAdapter(this.activity!!,
                    android.R.layout.simple_spinner_item, survey1ListItem)
            e3spn_survey3.adapter = adapter

            e3spn_survey3.onItemSelectedListener = object :
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
        e3spn_survey4 = v.findViewById(R.id.e3spn_survey4) as Spinner
        if (e3spn_survey4 != null) {
            val adapter = ArrayAdapter(this.activity!!,
                    android.R.layout.simple_spinner_item, survey1ListItem)
            e3spn_survey4.adapter = adapter

            e3spn_survey4.onItemSelectedListener = object :
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
        e3spn_survey5 = v.findViewById(R.id.e3spn_survey5) as Spinner
        if (e3spn_survey5 != null) {
            val adapter = ArrayAdapter(this.activity!!,
                    android.R.layout.simple_spinner_item, survey1ListItem)
            e3spn_survey5.adapter = adapter

            e3spn_survey5.onItemSelectedListener = object :
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
//        e3spn_survey6 = v.findViewById(R.id.e3spn_survey6) as Spinner
//        if (e3spn_survey6 != null) {
//            val adapter = ArrayAdapter(this.activity!!,
//                    android.R.layout.simple_spinner_item, survey1ListItem)
//            e3spn_survey6.adapter = adapter
//
//            e3spn_survey6.onItemSelectedListener = object :
//                    AdapterView.OnItemSelectedListener {
//                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                    val spin11: String = parent?.getItemAtPosition(position).toString()
//                    vspin11 = spin11
//                    //                    Toast.makeText(this@MainActivity, survey1ListItem[position], Toast.LENGTH_SHORT).show()
//                }
//
//                override fun onNothingSelected(parent: AdapterView<*>?) {
//                    TODO("Not yet implemented")
//                }
//            }
//        }
// +++++ End Spinner 11 ++++++

        // ++++++ Spinner 12 ++++++++
        //access string array
//        val survey1ListItem = resources.getStringArray(R.array.level_of_compentency)
//         access the spinner and set ArrayAdaptor to control the list of items
//        e3spn_survey7 = v.findViewById(R.id.e3spn_survey7) as Spinner
//        if (e3spn_survey7 != null) {
//            val adapter = ArrayAdapter(this.activity!!,
//                    android.R.layout.simple_spinner_item, survey1ListItem)
//            e3spn_survey7.adapter = adapter
//
//            e3spn_survey7.onItemSelectedListener = object :
//                    AdapterView.OnItemSelectedListener {
//                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                    val spin12: String = parent?.getItemAtPosition(position).toString()
//                    vspin12 = spin12
//                    //                    Toast.makeText(this@MainActivity, survey1ListItem[position], Toast.LENGTH_SHORT).show()
//                }
//
//                override fun onNothingSelected(parent: AdapterView<*>?) {
//                    TODO("Not yet implemented")
//                }
//            }
//        }
// +++++ End Spinner 12 ++++++
        // ++++++ Spinner 13 ++++++++
        //access string array
//        val survey1ListItem = resources.getStringArray(R.array.level_of_compentency)
//         access the spinner and set ArrayAdaptor to control the list of items
        e3spn_survey8 = v.findViewById(R.id.e3spn_survey8) as Spinner
        if (e3spn_survey8 != null) {
            val adapter = ArrayAdapter(this.activity!!,
                    android.R.layout.simple_spinner_item, survey1ListItem)
            e3spn_survey8.adapter = adapter

            e3spn_survey8.onItemSelectedListener = object :
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
        e3spn_survey9 = v.findViewById(R.id.e3spn_survey9) as Spinner
        if (e3spn_survey9 != null) {
            val adapter = ArrayAdapter(this.activity!!,
                    android.R.layout.simple_spinner_item, survey1ListItem)
            e3spn_survey9.adapter = adapter

            e3spn_survey9.onItemSelectedListener = object :
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
        e3spn_survey10 = v.findViewById(R.id.e3spn_survey10) as Spinner
        if (e3spn_survey10 != null) {
            val adapter = ArrayAdapter(this.activity!!,
                    android.R.layout.simple_spinner_item, survey1ListItem)
            e3spn_survey10.adapter = adapter

            e3spn_survey10.onItemSelectedListener = object :
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
        e3spn_survey11 = v.findViewById(R.id.e3spn_survey11) as Spinner
        if (e3spn_survey11 != null) {
            val adapter = ArrayAdapter(this.activity!!,
                    android.R.layout.simple_spinner_item, survey1ListItem)
            e3spn_survey11.adapter = adapter

            e3spn_survey11.onItemSelectedListener = object :
                    AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    val spin16: String = parent?.getItemAtPosition(position).toString()
                    vspin16 = spin16
                    //                    Toast.makeText(this@MainActivity, survey1ListItem[position], Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
        }
// +++++ End Spinner 16 ++++++

//+++++++++++++++++++++++++++++++++++++++ SPINNER END++++++++++++++++++++++++++++++++++++++++++++++++++
// ++++++++++++++++++++++++++++++++++++++++ variable end +++++++++++++++++++++++++++++++++++++++++
        // Inflate the layout for this fragment

//        var  v: View =  inflater.inflate(R.layout.evalfragmentmain, container, false)
        val db = DatabaseHandler(this.activity!!)
//        this.btn_evalsubmit = findViewById(R.id.btn_evalsubmit)
        this.button = v.findViewById(R.id.btn_evalsubmitsupervisor) as Button
        this.button.setOnClickListener(View.OnClickListener() {
//            Toast.makeText(activity, "functional", Toast.LENGTH_SHORT).show()


//          VALUE FOR SPINNER
          var HDLEVEL1 = "HD - High Developed"
          var HDLEVEL2 = "D - Developed"
          var HDLEVEL3 = "ND - Not Developed"


          var CLLEVEL01 = "CL1 - Zero Knowledge"
          var CLLEVEL02 = "CL2 - Trained"
          var CLLEVEL03 = "CL3 - Can do with help"
          var CLLEVEL04 = "CL4 - Can do alone"
          var CLLEVEL05 = "CL5 - Can teach others"

//          OUTPUT VALUE BY PERCENTAGE (HD LEVEL)
          var HD100 = 100
          var D85 = 85
          var ND75 = 75

//            OUTPUT LEVEL BY PERCENTAGE (CL LEVEL)
          var CL5100 = 100
          var CL495 = 95
          var CL385 = 85
          var CL275 = 75
          var CL170 = 70




//          CONVERT OUTPUT INTO PERCENTAGE (MINDSET BEHAVIOR)
          if (vspin1 == HDLEVEL1){
             vspin1HD1 = HD100
          }else if (vspin1 == HDLEVEL2){
             vspin1HD1 = D85
          } else {
             vspin1HD1 = ND75
          }

          if (vspin2 == HDLEVEL1){
             vspin2HD2 = HD100
          }else if (vspin1 == HDLEVEL2){
             vspin2HD2 = D85
          } else {
             vspin2HD2 = ND75
          }

          if (vspin3 == HDLEVEL1){
             vspin3HD3 = HD100
          }else if (vspin1 == HDLEVEL2){
             vspin3HD3 = D85
          } else {
             vspin3HD3 = ND75
          }

//          FUNCTIONAL COMPETENCY
          if (vspin4 == CLLEVEL01){
             vspin4CLLEVEL4 = CL170
          }else if (vspin4 == CLLEVEL02){
             vspin4CLLEVEL4 = CL275
          } else if (vspin4 == CLLEVEL03) {
             vspin4CLLEVEL4 = CL385
          } else if (vspin4 == CLLEVEL04) {
             vspin4CLLEVEL4 = CL495
          } else {
             vspin4CLLEVEL4 = CL5100
          }
//
//          if (vspin4 == CLLEVEL01){
//             vspin4CLLEVEL4 = CL170
//          }else if (vspin4 == CLLEVEL02){
//             vspin4CLLEVEL4 = CL275
//          } else if (vspin4 == CLLEVEL03) {
//             vspin4CLLEVEL4 = CL385
//          } else if (vspin4 == CLLEVEL04) {
//             vspin4CLLEVEL4 = CL495
//          } else {
//             vspin4CLLEVEL4 = CL5100
//          }

          if (vspin6 == CLLEVEL01){
             vspin6CLLEVEL6 = CL170
          }else if (vspin6 == CLLEVEL02){
             vspin6CLLEVEL6 = CL275
          } else if (vspin6 == CLLEVEL03) {
             vspin6CLLEVEL6 = CL385
          } else if (vspin6 == CLLEVEL04) {
             vspin6CLLEVEL6 = CL495
          } else {
             vspin6CLLEVEL6 = CL5100
          }

          if (vspin7 == CLLEVEL01){
             vspin7CLLEVEL7 = CL170
          }else if (vspin7 == CLLEVEL02){
             vspin7CLLEVEL7 = CL275
          } else if (vspin7 == CLLEVEL03) {
             vspin7CLLEVEL7 = CL385
          } else if (vspin7 == CLLEVEL04) {
             vspin7CLLEVEL7 = CL495
          } else {
             vspin7CLLEVEL7 = CL5100
          }

          if (vspin8 == CLLEVEL01){
             vspin8CLLEVEL8 = CL170
          }else if (vspin8 == CLLEVEL02){
             vspin8CLLEVEL8 = CL275
          } else if (vspin8 == CLLEVEL03) {
             vspin8CLLEVEL8 = CL385
          } else if (vspin8 == CLLEVEL04) {
             vspin8CLLEVEL8 = CL495
          } else {
             vspin8CLLEVEL8 = CL5100
          }

          if (vspin9 == CLLEVEL01){
             vspin9CLLEVEL9 = CL170
          }else if (vspin9 == CLLEVEL02){
             vspin9CLLEVEL9 = CL275
          } else if (vspin9 == CLLEVEL03) {
             vspin9CLLEVEL9 = CL385
          } else if (vspin9 == CLLEVEL04) {
             vspin9CLLEVEL9 = CL495
          } else {
             vspin9CLLEVEL9 = CL5100
          }

          if (vspin10 == CLLEVEL01){
             vspin10CLLEVEL10 = CL170
          }else if (vspin10 == CLLEVEL02){
             vspin10CLLEVEL10 = CL275
          } else if (vspin10 == CLLEVEL03) {
             vspin10CLLEVEL10 = CL385
          } else if (vspin10 == CLLEVEL04) {
             vspin10CLLEVEL10 = CL495
          } else {
             vspin10CLLEVEL10 = CL5100
          }

          if (vspin13 == CLLEVEL01){
             vspin13CLLEVEL13 = CL170
          }else if (vspin10 == CLLEVEL02){
             vspin13CLLEVEL13 = CL275
          } else if (vspin13 == CLLEVEL03) {
             vspin13CLLEVEL13 = CL385
          } else if (vspin13 == CLLEVEL04) {
             vspin13CLLEVEL13 = CL495
          } else {
             vspin13CLLEVEL13 = CL5100
          }

          if (vspin14 == CLLEVEL01){
             vspin14CLLEVEL14 = CL170
          }else if (vspin14 == CLLEVEL02){
             vspin14CLLEVEL14 = CL275
          } else if (vspin14 == CLLEVEL03) {
             vspin14CLLEVEL14 = CL385
          } else if (vspin14 == CLLEVEL04) {
             vspin14CLLEVEL14 = CL495
          } else {
             vspin14CLLEVEL14 = CL5100
          }

          if (vspin15 == CLLEVEL01){
             vspin15CLLEVEL15 = CL170
          }else if (vspin15 == CLLEVEL02){
             vspin15CLLEVEL15 = CL275
          } else if (vspin15 == CLLEVEL03) {
             vspin15CLLEVEL15 = CL385
          } else if (vspin15 == CLLEVEL04) {
             vspin15CLLEVEL15 = CL495
          } else {
             vspin15CLLEVEL15 = CL5100
          }

          if (vspin16 == CLLEVEL01){
             vspin16CLLEVEL16 = CL170
          }else if (vspin16 == CLLEVEL02){
             vspin16CLLEVEL16 = CL275
          } else if (vspin16 == CLLEVEL03) {
             vspin16CLLEVEL16 = CL385
          } else if (vspin16 == CLLEVEL04) {
             vspin16CLLEVEL16 = CL495
          } else {
             vspin16CLLEVEL16 = CL5100
          }

//          MINDSET AND BEHAVIOR GRADES

          var mindset_and_behavior_grade = vspin1HD1 + vspin2HD2 + vspin3HD3
          var grade1 = mindset_and_behavior_grade / 3
          var vspin1HD1g1 = grade1.toString()

          var functional_check_plan_act = vspin4CLLEVEL4 + vspin6CLLEVEL6 + vspin7CLLEVEL7 + vspin8CLLEVEL8 + vspin9CLLEVEL9 + vspin10CLLEVEL10 + vspin13CLLEVEL13 + vspin14CLLEVEL14 + vspin15CLLEVEL15 + vspin16CLLEVEL16
          var grade2 = functional_check_plan_act / 10
          var vspin1HD1g2 = grade2.toString()

          var partialgrade = grade1 + grade2
          var finalgrade = partialgrade / 2
          var finalgrade1 = finalgrade.toString()
          Toast.makeText(activity, finalgrade1, Toast.LENGTH_SHORT).show()

// +++++++++++++++++++ when button press ++++++++++++++++++++++++++
            if
                    (linename.length.toString() > 0.toString() &&
                    lineposition.length.toString() > 0.toString() &&
                    position_name.text.toString() > 0.toString() &&
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
//                    vspin5.length.toString() > 0.toString() &&
//                    e2survey2_feedback.length.toString() > 0.toString() &&
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
//                    vspin11.length.toString() > 0.toString() &&
//                    e3survey6_feedback.length.toString() > 0.toString() &&
//                    vspin12.length.toString() > 0.toString() &&
//                    e3survey7_feedback.length.toString() > 0.toString() &&
                    vspin13.length.toString() > 0.toString() &&
                    e3survey8_feedback.length.toString() > 0.toString() &&
                    vspin14.length.toString() > 0.toString() &&
                    e3survey9_feedback.length.toString() > 0.toString() &&
                    vspin15.length.toString() > 0.toString() &&
                    e3survey10_feedback.length.toString() > 0.toString() &&
                    vspin16.length.toString() > 0.toString() &&
                    e3survey11_feedback.length.toString() > 0.toString() &&
                    vspin1HD1g1.length.toString() > 0.toString() &&
                    vspin1HD1g2.length.toString() > 0.toString() &&
                    finalgrade1.length.toString() > 0.toString()



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
////                                vspin5,
////                                e2survey2_feedback.toString(),
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
////                                vspin11,
////                                e3survey6_feedback.toString(),
////                                vspin12,
////                                e3survey7_feedback.toString(),
//                                vspin13,
//                                e3survey8_feedback.toString(),
//                                vspin14,
//                                e3survey9_feedback.toString(),
//                                vspin15,
//                                e3survey10_feedback.toString(),
//                                vspin16,
//                                e3survey11_feedback.toString()

//                        )
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//                db.insertData(eval)
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//                PUSH DATA TO COACHERSIGN
              val toFragment = coacher_signature()
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
//              bundle.putString("rating5", vspin5)
//              bundle.putString("remarks5", e2survey2_feedback.toString())
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
//              bundle.putString("rating11",vspin11)
//              bundle.putString("remarks11", e3survey6_feedback.toString())
//              bundle.putString("rating12", vspin12)
//              bundle.putString("remarks12", e3survey7_feedback.toString())
              bundle.putString("rating13", vspin13)
              bundle.putString("remarks13", e3survey8_feedback.toString())
              bundle.putString("rating14", vspin14)
              bundle.putString("remarks14", e3survey9_feedback.toString())
              bundle.putString("rating15", vspin15)
              bundle.putString("remarks15", e3survey10_feedback.toString())
              bundle.putString("rating16", vspin16)
              bundle.putString("remarks16", e3survey11_feedback.toString())
              bundle.putString("firstgrade", vspin1HD1g1)
              bundle.putString("secondgrade", vspin1HD1g2)
              bundle.putString("finalgrading", finalgrade1)
              toFragment.arguments = bundle


//              permission
                ActivityCompat.requestPermissions(
                        this.activity!!, arrayOf(
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
//                createPDFOM(positionpdf = position_name.text.toString(), namepdf = display_name.text.toString(), datepdf = display_date,
//                        ratingrow1 = vspin1, feedbackrow1 = e1survey1_feedback.toString(),ratingrow2 = vspin2, feedbackrow2 = e1survey2_feedback.toString(),
//                        ratingrow3 = vspin3, feedbackrow3 = e1survey3_feedback.toString(),ratingrow4 = vspin4, feedbackrow4 = e2survey1_feedback.toString(),
//                        ratingrow5 = vspin6, feedbackrow5 = e3survey1_feedback.toString(),ratingrow6 = vspin7, feedbackrow6 = e3survey2_feedback.toString(),
//                        ratingrow7 = vspin8, feedbackrow7 = e3survey3_feedback.toString(),ratingrow8 = vspin9, feedbackrow8 = e3survey4_feedback.toString(),
//                        ratingrow9 = vspin10, feedbackrow9 = e3survey5_feedback.toString(),ratingrow10 = vspin13, feedbackrow10 = e3survey8_feedback.toString(),
//                        ratingrow11 = vspin14, feedbackrow11 = e3survey9_feedback.toString(),ratingrow12 = vspin15, feedbackrow12 = e3survey10_feedback.toString(),
//                        ratingrow13 = vspin16, feedbackrow13 = e3survey11_feedback.toString(), signature1 = bitmapsignature1, signature2 = bitmapsignature2)
// ++++++++++++++++++++++++END CREATE PDF +++++++++++++++++++++++++++++++++++++++++++++++++++++



                val commit = activity!!.supportFragmentManager.beginTransaction()
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
    fun createPDFOM(positionpdf: String = position_name.text.toString(), namepdf: String = display_name.text.toString(), datepdf: String,
                    ratingrow1: String, feedbackrow1: String,ratingrow2: String, feedbackrow2: String,
                    ratingrow3: String, feedbackrow3: String,ratingrow4: String, feedbackrow4: String,
                    ratingrow5: String, feedbackrow5: String,ratingrow6: String, feedbackrow6: String,
                    ratingrow7: String, feedbackrow7: String,ratingrow8: String, feedbackrow8: String,
                    ratingrow9: String, feedbackrow9: String,ratingrow10: String, feedbackrow10: String,
                    ratingrow11: String, feedbackrow11: String,ratingrow12: String, feedbackrow12: String,
                    ratingrow13: String, feedbackrow13: String, signature1:Bitmap, signature2:Bitmap) {
        // Permission on Storage
        ActivityCompat.requestPermissions(
                this.activity!!, arrayOf(
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                android.Manifest.permission.READ_EXTERNAL_STORAGE,
                android.Manifest.permission.MANAGE_EXTERNAL_STORAGE
        ), PackageManager.PERMISSION_GRANTED
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
        var headerlogo = this.activity!!.applicationContext.resources.getDrawable(R.drawable.headerlogo)
        bitmap1 = (headerlogo as BitmapDrawable).bitmap
        stream1 = ByteArrayOutputStream()
        bitmap1.compress(Bitmap.CompressFormat.JPEG,100, stream1)
        val bitmapData1 =stream1.toByteArray()
        imageData1 = ImageDataFactory.create(bitmapData1)
        image1 = Image(imageData1)
        image1.scaleAbsolute(200F,40f)

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
        table.addCell(com.itextpdf.layout.element.Cell().setVerticalAlignment(VerticalAlignment.MIDDLE).setMinHeight(30f).setFontSize(7f).add(Paragraph("LEARNING AGILITY (WILLINGNESS TO LEARN AND ACCEPT QUICKLY)")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("D")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(ratingrow1)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(feedbackrow1)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("RIGHT M&B WITH SELF: PASSION TO MAKE A DIFFERENCE AND DELIVER RESULTS (MASIPAG, MATIYAGA, DISCIPLINED, COMMITED)")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("D")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(ratingrow2)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(feedbackrow2)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(50f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("RIGHT M&B WITH OTHERS: HIGHLY ENGAGES, PRO-ACTIVE/ INITIATES, SERVICE-ORIENTED, SEEKS FIRST TO UNDERSTAND THEN TO BE UNDERSTOOD, THINKS WIN-WIN ")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("D")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).setFontSize(7f).add(Paragraph(ratingrow3)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(feedbackrow3)))

//         TABLE ROW (2ND ROW)
        table.addCell(com.itextpdf.layout.element.Cell(1, 2).setVerticalAlignment(VerticalAlignment.MIDDLE).addStyle(Style().setBold()).setFontSize(8f).add(Paragraph("FUNCTIONAL COMPETENCY")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("MASTERY OF A SALESMAN DIAL (DAILY IN A LIFE)")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("CL4")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(ratingrow4)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(feedbackrow4)))

//         TABLE CELL SEPARATOR
        table.addCell(com.itextpdf.layout.element.Cell(1, 6))

//         TABLE ROW/COLUMN FOR PLAN DO CHECK AND ACT
        table.addCell(com.itextpdf.layout.element.Cell(9, 1).setVerticalAlignment(VerticalAlignment.BOTTOM).setRotationAngle(33F).addStyle(Style().setBold()).setFontSize(14f).add(Paragraph("OBSERVABLE BEHAVIORS RELATED TO FUNCTIONAL COMPETENCY")))

//         TABLE ROW (3RD ROW)
        table.addCell(com.itextpdf.layout.element.Cell(3, 1).setVerticalAlignment(VerticalAlignment.MIDDLE).addStyle(Style().setBold()).setFontSize(8f).setMinWidth(100f).add(Paragraph("PLAN")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("CONSISTENT AND ACCURATE FILLING OUT OF DAILY SALES REPORT")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("CL4")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(ratingrow5)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(feedbackrow5)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("COMPUTES AND ENSURES CORRECT LOAD PLAN WITH MUST-HAVE'S")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("CL4")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(ratingrow6)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(feedbackrow6)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("CONSISTENCY IN LOGGING ACTION PLANS")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("CL4")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(ratingrow7)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(feedbackrow7)))

//         TABLE ROW (4TH ROW)
        table.addCell(com.itextpdf.layout.element.Cell(2, 1).setVerticalAlignment(VerticalAlignment.MIDDLE).addStyle(Style().setBold()).setFontSize(8f).add(Paragraph("DO")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("CONSISTENTLY AND EFFECTIVELY FOLLOWS/EXECUTES D.I.A.L.")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("CL4")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(ratingrow8)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(feedbackrow8)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("CONSISTENTLY REVIEW LOAD PLAN AND ENSURE MSDP SKU'S ARE COMPLETE, RIGHT PRODUCT MIX AND STOCK WEIGHT")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("CL4")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(ratingrow9)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(feedbackrow9)))

//         TABLE ROW (5TH)
        table.addCell(com.itextpdf.layout.element.Cell(2, 1).setVerticalAlignment(VerticalAlignment.MIDDLE).addStyle(Style().setBold()).setFontSize(8f).add(Paragraph("CHECK")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("CONSISTENT AND EFFECTIVE DOING ANALYSIS (POST-CALL REVIEW) IN REFERENCE TO D.I.A.L.")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("CL4")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(ratingrow10)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(feedbackrow10)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("CONSISTENT AND EFFECTIVE IN ANALYSIS (END OF DAY)  IN REFERENCE TO D.I.A.L.")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("CL4")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(ratingrow11)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(feedbackrow11)))
//            TABLE ROW (6TH)
        table.addCell(com.itextpdf.layout.element.Cell(2, 1).setVerticalAlignment(VerticalAlignment.MIDDLE).addStyle(Style().setBold()).setFontSize(8f).add(Paragraph("ACT")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("CONSISTENCY AND EFFECTIVENESS IN DOING PROBLEM SOLVING (ROOT CAUSE MINDSET) TO ADDRESS ISSUES/GAPS TO BE ABLE TO GENERATE EFFECTIVE ACTION PLANS. THIS ALSO INCLUDES CONSISTENCY AND EFFECTIVENESS IN EXECUTING THE ACTIONS TO BE DULY MONITORED IN THE REVIEWS")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("CL4")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(ratingrow12)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(feedbackrow12)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("CONSISTENCY IN ESCALATING ISSUES TO THE LINE MANAGER")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph("CL4")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(ratingrow13)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(30f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(7f).add(Paragraph(feedbackrow13)))
//         SIGNATURE AREA
        table.addCell(com.itextpdf.layout.element.Cell(1,2).setVerticalAlignment(VerticalAlignment.MIDDLE).setHorizontalAlignment(
            HorizontalAlignment.LEFT).add(image2.setAutoScale(true)).setBorder(Border.NO_BORDER).setMaxHeight(45f))
        table.addCell(com.itextpdf.layout.element.Cell().setBorder(Border.NO_BORDER).setMinHeight(45f))
        table.addCell(com.itextpdf.layout.element.Cell(1, 3).setVerticalAlignment(VerticalAlignment.MIDDLE).setHorizontalAlignment(
            HorizontalAlignment.LEFT).add(image3.setAutoScale(true)).setBorder(Border.NO_BORDER).setMaxHeight(45f))
//         SIGNATURE NAME
        table.addCell(com.itextpdf.layout.element.Cell(1, 2,).setBorder(Border.NO_BORDER).setVerticalAlignment(VerticalAlignment.BOTTOM).setTextAlignment(TextAlignment.LEFT).setMinHeight(15f).addStyle(Style().setUnderline()).setFontSize(10f).add(Paragraph("Christine Louie Tequillo")))
        table.addCell(com.itextpdf.layout.element.Cell().setBorder(Border.NO_BORDER).setMinHeight(15f))
        table.addCell(com.itextpdf.layout.element.Cell(1, 3).setBorder(Border.NO_BORDER).setVerticalAlignment(VerticalAlignment.BOTTOM).setTextAlignment(TextAlignment.LEFT).setMinHeight(15f).addStyle(Style().setUnderline()).setFontSize(10f).add(Paragraph(namepdf)))
//         SIGNATURE POSITION
        table.addCell(com.itextpdf.layout.element.Cell(1, 2).setBorder(Border.NO_BORDER).setVerticalAlignment(VerticalAlignment.TOP).setTextAlignment(TextAlignment.LEFT).setMinHeight(15f).setFontSize(10f).add(Paragraph("General Trade Manager")))
        table.addCell(com.itextpdf.layout.element.Cell().setBorder(Border.NO_BORDER).setMinHeight(15f))
        table.addCell(com.itextpdf.layout.element.Cell(1, 3).setBorder(Border.NO_BORDER).setVerticalAlignment(VerticalAlignment.BOTTOM).setTextAlignment(TextAlignment.LEFT).setMinHeight(15f).setFontSize(10f).add(Paragraph(positionpdf)))


//         IMPLEMENT DESIGN
        document.add(image1)
        document.add(tableheader)
        document.add(table)
        document.close()

        Toast.makeText(activity!!, "PDF CREATED", Toast.LENGTH_SHORT).show()

//  +++++++++++++++++++++++++++ createPDF  tag+++++++++++++++++++++++++++++++
        ActivityCompat.requestPermissions(
                this.activity!!, arrayOf(
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                android.Manifest.permission.READ_EXTERNAL_STORAGE,
                android.Manifest.permission.MANAGE_EXTERNAL_STORAGE,
                android.Manifest.permission.INTERNET
        ), PackageManager.PERMISSION_GRANTED
        )

        val bmpUri = FileProvider.getUriForFile(this.activity!!, "com.test.information.fileprovider", file)

        val share = Intent()
        share.action = Intent.ACTION_SEND
        share.type = "*/*"
        share.putExtra(Intent.EXTRA_STREAM, bmpUri )
        share.flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
        share.setPackage("com.viber.voip")
        startActivity(Intent.createChooser(share, "Share it"))




//  +++++++++++++++++++++++++++ createPDF end tag+++++++++++++++++++++++++++++++
    }

}