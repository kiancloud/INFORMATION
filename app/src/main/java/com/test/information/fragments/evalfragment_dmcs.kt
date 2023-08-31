package com.test.information.fragments

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Environment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.app.ActivityCompat
import com.itextpdf.io.image.ImageData
import com.itextpdf.kernel.pdf.PdfDocument
import com.itextpdf.layout.Document
import com.itextpdf.layout.element.Image
import com.itextpdf.layout.element.Table
import com.test.information.R
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.OutputStream


class evalfragment_dmcs : Fragment() {
    lateinit var evalsubmit: Button


    private lateinit var e1spn_survey1_dmcs: Spinner
    private lateinit var e1spn_survey2_dmcs: Spinner
    private lateinit var e1spn_survey3_dmcs: Spinner
    private lateinit var e2spn_survey1_dmcs: Spinner
    //    private lateinit var e2spn_survey2: Spinner
    private lateinit var e3spn_survey1_dmcs: Spinner
    private lateinit var e3spn_survey2_dmcs: Spinner
    private lateinit var e3spn_survey3_dmcs: Spinner
    private lateinit var e3spn_survey4_dmcs: Spinner
    private lateinit var e3spn_survey5_dmcs: Spinner
    private lateinit var e3spn_survey6_dmcs: Spinner
    private lateinit var e3spn_survey7_dmcs: Spinner
    private lateinit var e3spn_survey8_dmcs: Spinner
    private lateinit var e3spn_survey9_dmcs: Spinner
    private lateinit var e3spn_survey10_dmcs: Spinner
    private lateinit var e3spn_survey11_dmcs: Spinner

    private lateinit var display_name: TextView
    private lateinit var position_name: TextView


    private lateinit var btn_evalsubmit: Button

    private lateinit var e1survey1_feedback_dmcs: EditText
    private lateinit var e1survey2_feedback_dmcs: EditText
    private lateinit var e1survey3_feedback_dmcs: EditText
    private lateinit var e2survey1_feedback_dmcs: EditText
    //    private lateinit var e2survey2_feedback_dmcs: EditText
    private lateinit var e3survey1_feedback_dmcs: EditText
    private lateinit var e3survey2_feedback_dmcs: EditText
    private lateinit var e3survey3_feedback_dmcs: EditText
    private lateinit var e3survey4_feedback_dmcs: EditText
    private lateinit var e3survey5_feedback_dmcs: EditText
    private lateinit var e3survey6_feedback_dmcs: EditText
    private lateinit var e3survey7_feedback_dmcs: EditText
    private lateinit var e3survey8_feedback_dmcs: EditText
    private lateinit var e3survey9_feedback_dmcs: EditText
    private lateinit var e3survey10_feedback_dmcs: EditText
    private lateinit var e3survey11_feedback_dmcs: EditText

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
    var vspin11 = ""
    var vspin12 = ""
    var vspin13 = ""
    var vspin14 = ""
    var vspin15 = ""
//    var vspin16 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v: View = inflater.inflate(R.layout.fragment_evaldmcs, container, false)

        e1survey1_feedback_dmcs = v.findViewById(R.id.e1survey1_feedback_dmcs) as EditText
        e1survey2_feedback_dmcs = v.findViewById(R.id.e1survey2_feedback_dmcs) as EditText
        e1survey3_feedback_dmcs = v.findViewById(R.id.e1survey3_feedback_dmcs) as EditText
        e2survey1_feedback_dmcs = v.findViewById(R.id.e2survey1_feedback_dmcs) as EditText
//        e2survey2_feedback_dmcs = v.findViewById(R.id.e2survey2_feedback_dmcs) as EditText
        e3survey1_feedback_dmcs = v.findViewById(R.id.e3survey1_feedback_dmcs) as EditText
        e3survey2_feedback_dmcs = v.findViewById(R.id.e3survey2_feedback_dmcs) as EditText
        e3survey3_feedback_dmcs = v.findViewById(R.id.e3survey3_feedback_dmcs) as EditText
        e3survey4_feedback_dmcs = v.findViewById(R.id.e3survey4_feedback_dmcs) as EditText
        e3survey5_feedback_dmcs = v.findViewById(R.id.e3survey5_feedback_dmcs) as EditText
        e3survey6_feedback_dmcs = v.findViewById(R.id.e3survey6_feedback_dmcs) as EditText
        e3survey7_feedback_dmcs = v.findViewById(R.id.e3survey7_feedback_dmcs) as EditText
        e3survey8_feedback_dmcs = v.findViewById(R.id.e3survey8_feedback_dmcs) as EditText
        e3survey9_feedback_dmcs = v.findViewById(R.id.e3survey9_feedback_dmcs) as EditText
        e3survey10_feedback_dmcs = v.findViewById(R.id.e3survey10_feedback_dmcs) as EditText
//        e3survey11_feedback_dmcs = v.findViewById(R.id.e3survey11_feedback_dmcs) as EditText

//        Remarks Value
        var e1survey1_feedback_dmcs = e1survey1_feedback_dmcs.text
        var e1survey2_feedback_dmcs = e1survey2_feedback_dmcs.text
        var e1survey3_feedback_dmcs = e1survey3_feedback_dmcs.text
        var e2survey1_feedback_dmcs = e2survey1_feedback_dmcs.text
//        var e2survey2_feedback_dmcs = e2survey2_feedback_dmcs.text
        var e3survey1_feedback_dmcs = e3survey1_feedback_dmcs.text
        var e3survey2_feedback_dmcs = e3survey2_feedback_dmcs.text
        var e3survey3_feedback_dmcs = e3survey3_feedback_dmcs.text
        var e3survey4_feedback_dmcs = e3survey4_feedback_dmcs.text
        var e3survey5_feedback_dmcs = e3survey5_feedback_dmcs.text
        var e3survey6_feedback_dmcs = e3survey6_feedback_dmcs.text
        var e3survey7_feedback_dmcs = e3survey7_feedback_dmcs.text
        var e3survey8_feedback_dmcs = e3survey8_feedback_dmcs.text
        var e3survey9_feedback_dmcs = e3survey9_feedback_dmcs.text
        var e3survey10_feedback_dmcs = e3survey10_feedback_dmcs.text
//        var e3survey11_feedback_dmcs = e3survey11_feedback_dmcs.text


//Display Name

        display_name = v.findViewById(R.id.display_name)
        position_name = v.findViewById(R.id.position_name)
        display_name.text = "test"
        position_name.text = "test"
        var display_date = "test"

// ++++++++++++++++++++++++++++++CREATING EVALUATION FOLDERr+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        ActivityCompat.requestPermissions(
            this.requireActivity(), arrayOf(
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
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
        e1spn_survey1_dmcs = v.findViewById(R.id.e1spn_survey1_dmcs) as Spinner
        if (e1spn_survey1_dmcs != null) {
            val adapter = ArrayAdapter(this.requireActivity(),
                android.R.layout.simple_spinner_item, survey2ListItem)
            e1spn_survey1_dmcs.adapter = adapter

            e1spn_survey1_dmcs.onItemSelectedListener = object :
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
        e1spn_survey2_dmcs = v.findViewById(R.id.e1spn_survey2_dmcs) as Spinner
        if (e1spn_survey2_dmcs != null) {
            val adapter = ArrayAdapter(this.requireActivity(),
                android.R.layout.simple_spinner_item, survey2ListItem)
            e1spn_survey2_dmcs.adapter = adapter

            e1spn_survey2_dmcs.onItemSelectedListener = object :
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
        e1spn_survey3_dmcs = v.findViewById(R.id.e1spn_survey3_dmcs) as Spinner
        if (e1spn_survey3_dmcs != null) {
            val adapter = ArrayAdapter(this.requireActivity(),
                android.R.layout.simple_spinner_item, survey2ListItem)
            e1spn_survey3_dmcs.adapter = adapter

            e1spn_survey3_dmcs.onItemSelectedListener = object :
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
        e2spn_survey1_dmcs = v.findViewById(R.id.e2spn_survey1_dmcs) as Spinner
        if (e2spn_survey1_dmcs != null) {
            val adapter = ArrayAdapter(this.requireActivity(),
                android.R.layout.simple_spinner_item, survey1ListItem)
            e2spn_survey1_dmcs.adapter = adapter

            e2spn_survey1_dmcs.onItemSelectedListener = object :
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
//            val adapter = ArrayAdapter(this.requireActivity(),
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
        e3spn_survey1_dmcs = v.findViewById(R.id.e3spn_survey1_dmcs) as Spinner
        if (e3spn_survey1_dmcs != null) {
            val adapter = ArrayAdapter(this.requireActivity(),
                android.R.layout.simple_spinner_item, survey1ListItem)
            e3spn_survey1_dmcs.adapter = adapter

            e3spn_survey1_dmcs.onItemSelectedListener = object :
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
        e3spn_survey2_dmcs = v.findViewById(R.id.e3spn_survey2_dmcs) as Spinner
        if (e3spn_survey2_dmcs != null) {
            val adapter = ArrayAdapter(this.requireActivity(),
                android.R.layout.simple_spinner_item, survey1ListItem)
            e3spn_survey2_dmcs.adapter = adapter

            e3spn_survey2_dmcs.onItemSelectedListener = object :
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
        e3spn_survey3_dmcs = v.findViewById(R.id.e3spn_survey3_dmcs) as Spinner
        if (e3spn_survey3_dmcs != null) {
            val adapter = ArrayAdapter(this.requireActivity(),
                android.R.layout.simple_spinner_item, survey1ListItem)
            e3spn_survey3_dmcs.adapter = adapter

            e3spn_survey3_dmcs.onItemSelectedListener = object :
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
        e3spn_survey4_dmcs = v.findViewById(R.id.e3spn_survey4_dmcs) as Spinner
        if (e3spn_survey4_dmcs != null) {
            val adapter = ArrayAdapter(this.requireActivity(),
                android.R.layout.simple_spinner_item, survey1ListItem)
            e3spn_survey4_dmcs.adapter = adapter

            e3spn_survey4_dmcs.onItemSelectedListener = object :
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
        e3spn_survey5_dmcs = v.findViewById(R.id.e3spn_survey5_dmcs) as Spinner
        if (e3spn_survey5_dmcs != null) {
            val adapter = ArrayAdapter(this.requireActivity(),
                android.R.layout.simple_spinner_item, survey1ListItem)
            e3spn_survey5_dmcs.adapter = adapter

            e3spn_survey5_dmcs.onItemSelectedListener = object :
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
        e3spn_survey6_dmcs = v.findViewById(R.id.e3spn_survey6_dmcs) as Spinner
        if (e3spn_survey6_dmcs != null) {
            val adapter = ArrayAdapter(this.requireActivity(),
                    android.R.layout.simple_spinner_item, survey1ListItem)
            e3spn_survey6_dmcs.adapter = adapter

            e3spn_survey6_dmcs.onItemSelectedListener = object :
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
        e3spn_survey7_dmcs = v.findViewById(R.id.e3spn_survey7_dmcs) as Spinner
        if (e3spn_survey7_dmcs != null) {
            val adapter = ArrayAdapter(this.requireActivity(),
                    android.R.layout.simple_spinner_item, survey1ListItem)
            e3spn_survey7_dmcs.adapter = adapter

            e3spn_survey7_dmcs.onItemSelectedListener = object :
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
        e3spn_survey8_dmcs = v.findViewById(R.id.e3spn_survey8_dmcs) as Spinner
        if (e3spn_survey8_dmcs != null) {
            val adapter = ArrayAdapter(this.requireActivity(),
                android.R.layout.simple_spinner_item, survey1ListItem)
            e3spn_survey8_dmcs.adapter = adapter

            e3spn_survey8_dmcs.onItemSelectedListener = object :
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
        e3spn_survey9_dmcs = v.findViewById(R.id.e3spn_survey9_dmcs) as Spinner
        if (e3spn_survey9_dmcs != null) {
            val adapter = ArrayAdapter(this.requireActivity(),
                android.R.layout.simple_spinner_item, survey1ListItem)
            e3spn_survey9_dmcs.adapter = adapter

            e3spn_survey9_dmcs.onItemSelectedListener = object :
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
        e3spn_survey10_dmcs = v.findViewById(R.id.e3spn_survey10_dmcs) as Spinner
        if (e3spn_survey10_dmcs != null) {
            val adapter = ArrayAdapter(this.requireActivity(),
                android.R.layout.simple_spinner_item, survey1ListItem)
            e3spn_survey10_dmcs.adapter = adapter

            e3spn_survey10_dmcs.onItemSelectedListener = object :
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
//        e3spn_survey11_dmcs = v.findViewById(R.id.e3spn_survey11_dmcs) as Spinner
//        if (e3spn_survey11_dmcs != null) {
//            val adapter = ArrayAdapter(this.requireActivity(),
//                android.R.layout.simple_spinner_item, survey1ListItem)
//            e3spn_survey11_dmcs.adapter = adapter
//
//            e3spn_survey11_dmcs.onItemSelectedListener = object :
//                AdapterView.OnItemSelectedListener {
//                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                    val spin16: String = parent?.getItemAtPosition(position).toString()
//                    vspin16 = spin16
//                    //                    Toast.makeText(this@MainActivity, survey1ListItem[position], Toast.LENGTH_SHORT).show()
//                }
//
//                override fun onNothingSelected(parent: AdapterView<*>?) {
//                    TODO("Not yet implemented")
//                }
//            }
//        }
// +++++ End Spinner 16 ++++++

//+++++++++++++++++++++++++++++++++++++++ SPINNER END++++++++++++++++++++++++++++++++++++++++++++++++++
// ++++++++++++++++++++++++++++++++++++++++ variable end +++++++++++++++++++++++++++++++++++++++++

        evalsubmit = v.findViewById(R.id.btn_evalsubmitdmcs) as Button
        evalsubmit.setOnClickListener(View.OnClickListener() {
            if (linename.length.toString() > 0.toString() &&
                lineposition.length.toString() > 0.toString() &&
                position_name.text.toString() > 0.toString() &&
                display_name.text.length.toString() > 0.toString() &&
                display_date.length.toString() > 0.toString() &&
                vspin1.length.toString() > 0.toString() &&
                e1survey1_feedback_dmcs.length.toString() > 0.toString() &&
                vspin2.length.toString() > 0.toString() &&
                e1survey2_feedback_dmcs.length.toString() > 0.toString() &&
                vspin3.length.toString() > 0.toString() &&
                e1survey3_feedback_dmcs.length.toString() > 0.toString() &&
                vspin4.length.toString() > 0.toString() &&
                e2survey1_feedback_dmcs.length.toString() > 0.toString() &&
//                    vspin5.length.toString() > 0.toString() &&
//                    e2survey2_feedback_dmcs.length.toString() > 0.toString() &&
                vspin6.length.toString() > 0.toString() &&
                e3survey1_feedback_dmcs.length.toString() > 0.toString() &&
                vspin7.length.toString() > 0.toString() &&
                e3survey2_feedback_dmcs.length.toString() > 0.toString() &&
                vspin8.length.toString() > 0.toString() &&
                e3survey3_feedback_dmcs.length.toString() > 0.toString() &&
                vspin9.length.toString() > 0.toString() &&
                e3survey4_feedback_dmcs.length.toString() > 0.toString() &&
                vspin10.length.toString() > 0.toString() &&
                e3survey5_feedback_dmcs.length.toString() > 0.toString() &&
                vspin11.length.toString() > 0.toString() &&
                e3survey6_feedback_dmcs.length.toString() > 0.toString() &&
                vspin12.length.toString() > 0.toString() &&
                e3survey7_feedback_dmcs.length.toString() > 0.toString() &&
                vspin13.length.toString() > 0.toString() &&
                e3survey8_feedback_dmcs.length.toString() > 0.toString() &&
                vspin14.length.toString() > 0.toString() &&
                e3survey9_feedback_dmcs.length.toString() > 0.toString() &&
                vspin15.length.toString() > 0.toString() &&
                e3survey10_feedback_dmcs.length.toString() > 0.toString()
//                vspin16.length.toString() > 0.toString()
//                e3survey11_feedback_dmcs.length.toString() > 0.toString()
            ) {

                //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//                PUSH DATA TO COACHER_DMCSSIGNATURE
                val DMCSFragment = coacher_dmcssignature()
                val bundle = Bundle()
                bundle.putString("linename", linename)
                bundle.putString("lineposition", lineposition)
                bundle.putString("salesname", display_name.text.toString())
                bundle.putString("salesposition", position_name.text.toString())
                bundle.putString("date", display_date)
                bundle.putString("rating1", vspin1)
                bundle.putString("remarks1", e1survey1_feedback_dmcs.toString())
                bundle.putString("rating2", vspin2)
                bundle.putString("remarks2", e1survey2_feedback_dmcs.toString())
                bundle.putString("rating3", vspin3)
                bundle.putString("remarks3", e1survey3_feedback_dmcs.toString())
                bundle.putString("rating4", vspin4)
                bundle.putString("remarks4", e2survey1_feedback_dmcs.toString())
//              bundle.putString("rating5", vspin5)
//              bundle.putString("remarks5", e2survey2_feedback_dmcs.toString())
                bundle.putString("rating6", vspin6)
                bundle.putString("remarks6", e3survey1_feedback_dmcs.toString())
                bundle.putString("rating7", vspin7)
                bundle.putString("remarks7", e3survey2_feedback_dmcs.toString())
                bundle.putString("rating8", vspin8)
                bundle.putString("remarks8", e3survey3_feedback_dmcs.toString())
                bundle.putString("rating9", vspin9)
                bundle.putString("remarks9", e3survey4_feedback_dmcs.toString())
                bundle.putString("rating10", vspin10)
                bundle.putString("remarks10", e3survey5_feedback_dmcs.toString())
                bundle.putString("rating11",vspin11)
                bundle.putString("remarks11", e3survey6_feedback_dmcs.toString())
                bundle.putString("rating12", vspin12)
                bundle.putString("remarks12", e3survey7_feedback_dmcs.toString())
                bundle.putString("rating13", vspin13)
                bundle.putString("remarks13", e3survey8_feedback_dmcs.toString())
                bundle.putString("rating14", vspin14)
                bundle.putString("remarks14", e3survey9_feedback_dmcs.toString())
                bundle.putString("rating15", vspin15)
                bundle.putString("remarks15", e3survey10_feedback_dmcs.toString())
//                bundle.putString("rating16", vspin16)
//                bundle.putString("remarks16", e3survey11_feedback_dmcs.toString())
                DMCSFragment.arguments = bundle


                //              permission
                ActivityCompat.requestPermissions(
                    this.requireActivity(), arrayOf(
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
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

                val commit = requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_layout, DMCSFragment, "findThisFragment")
                    .addToBackStack(null)
                    .commit()

//                End button submit click
            } else (
                Toast.makeText(activity, "Fill All The Required Data", Toast.LENGTH_SHORT)
                    .show()
                )


        })



        return v
    }


}