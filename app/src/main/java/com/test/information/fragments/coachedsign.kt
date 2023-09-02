package com.test.information.fragments

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Environment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.FileProvider
import com.github.gcacace.signaturepad.views.SignaturePad
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
import com.test.information.Dashboard
import com.test.information.DatabaseHandler
import com.test.information.Eval
import com.test.information.R
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [coachedsign.newInstance] factory method to
 * create an instance of this fragment.
 */
class coachedsign : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var coachsign: Bitmap
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v: View = inflater.inflate(R.layout.fragment_coachedsign, container, false)

        val signaturePad2 = v.findViewById<SignaturePad>(R.id.signaturePad2)
        val btnclear2 = v.findViewById<Button>(R.id.btnclear2)
        val btnSave2 = v.findViewById<Button>(R.id.btnSave2)
        val finalremarksalesman = v.findViewById(R.id.et_finalremarksalesman) as EditText
//        var ivsignature2 = v.findViewById<ImageView>(R.id.ivsignature2)

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
//        var getrating5 = ""
//        var getremarks5 = ""
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
//        var getrating11 = ""
//        var getremarks11 = ""
//        var getrating12 = ""
//        var getremarks12 = ""
        var getrating13 = ""
        var getremarks13 = ""
        var getrating14 = ""
        var getremarks14 = ""
        var getrating15 = ""
        var getremarks15 = ""
        var getrating16 = ""
        var getremarks16 = ""
        var getfirstgrade = ""
        var getsecondgrade = ""
        var getfinalgrade = ""

        coachsign = getArguments()?.getParcelable("coach")!!
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
//            requireArguments().getString("rating5") != null ||
//            requireArguments().getString("remarks5") != null ||
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
//            requireArguments().getString("rating11") != null ||
//            requireArguments().getString("remarks11") != null ||
//            requireArguments().getString("rating12") != null ||
//            requireArguments().getString("remarks12") != null ||
            requireArguments().getString("rating13") != null ||
            requireArguments().getString("remarks13") != null ||
            requireArguments().getString("rating14") != null ||
            requireArguments().getString("remarks14") != null ||
            requireArguments().getString("rating15") != null ||
            requireArguments().getString("remarks15") != null ||
            requireArguments().getString("rating16") != null ||
            requireArguments().getString("remarks16") != null ||
            requireArguments().getString("firstgrade") != null ||
            requireArguments().getString("secondgrade") != null ||
            requireArguments().getString("finalgrading") != null

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
            var rating16 = requireArguments().getString("rating16")
            var remarks16 = requireArguments().getString("remarks16")
            var firstgrade = requireArguments().getString("firstgrade")
            var secondgrade = requireArguments().getString("secondgrade")
            var finalgrading = requireArguments().getString("finalgrading")

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
//            if (rating5 != null) {
//                getrating5 = rating5
//            }
//            if (remarks5 != null) {
//                getremarks5 = remarks5
//            }
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
//            if (rating11 != null) {
//                getrating11 = rating11
//            }
//            if (remarks11 != null) {
//                getremarks11 = remarks11
//            }
//            if (rating12 != null) {
//                getrating12 = rating12
//            }
//            if (remarks12 != null) {
//                getremarks12 = remarks12
//            }
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
            if (rating16 != null) {
                getrating16 = rating16
            }
            if (remarks16 != null) {
                getremarks16 = remarks16
            }
            if (firstgrade != null){
                getfirstgrade = firstgrade
            }
            if (secondgrade != null){
                getsecondgrade = secondgrade
            }
            if (finalgrading != null){
                getfinalgrade = finalgrading
            }
        }

//        Toast.makeText(activity, "$getdate + $getlinename + $getlineposition + $getsalesname + $getsalesposition + $getfirstgrade + $getsecondgrade + $getfinalgrade", Toast.LENGTH_SHORT).show()

        btnSave2.isEnabled = false
        btnclear2.isEnabled = false

        //PORTRAIT MODE ONLY
        requireActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        signaturePad2.setOnSignedListener(object : SignaturePad.OnSignedListener {
            override fun onStartSigning() {
                //Event triggered when the pad is touched
//                Toast.makeText(this@MainActivity, "onStatSigning", Toast.LENGTH_SHORT).show()
            }

            override fun onSigned() {
                //Event triggered when the pad is signed
//                Toast.makeText(this@MainActivity, "onSigned", Toast.LENGTH_SHORT).show()
                btnSave2.isEnabled = true
                btnclear2.isEnabled = true
            }

            override fun onClear() {
                //Event triggered when the pad is cleared
                Toast.makeText(activity, "Cleared", Toast.LENGTH_SHORT).show()
                btnSave2.isEnabled = false
                btnclear2.isEnabled = false
            }


        })

        btnSave2.setOnClickListener(){
            val db = DatabaseHandler(this.requireActivity())
            val coachee = signaturePad2.getSignatureBitmap()
            val coach = coachsign
//      ivsignature2.setImageBitmap(btmp2)

//      FROM COACHER_SIGNATURE
            // +++++++++++++++++++ when button press ++++++++++++++++++++++++++
            if
                (getlinename.length.toString() > 0.toString() &&
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
//                getrating5.length.toString() > 0.toString() &&
//                getremarks5.length.toString() > 0.toString() &&
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
//                getrating11.length.toString() > 0.toString() &&
//                getremarks11.length.toString() > 0.toString() &&
//                getrating12.length.toString() > 0.toString() &&
//                getremarks12.length.toString() > 0.toString() &&
                getrating13.length.toString() > 0.toString() &&
                getremarks13.length.toString() > 0.toString() &&
                getrating14.length.toString() > 0.toString() &&
                getremarks14.length.toString() > 0.toString() &&
                getrating15.length.toString() > 0.toString() &&
                getremarks15.length.toString() > 0.toString() &&
                getrating16.length.toString() > 0.toString() &&
                getremarks16.length.toString() > 0.toString() &&
                getfirstgrade.length.toString() > 0.toString() &&
                getsecondgrade.length.toString() > 0.toString() &&
                getfinalgrade.length.toString() > 0.toString()
            ) {

                var eval =
                    Eval(getlinename,
                        getlineposition,
                        getsalesname,
                        getsalesposition,
                        getdate,
                        getrating1,
                        getremarks1,
                        getrating2,
                        getremarks2,
                        getrating3,
                        getremarks3,
                        getrating4,
                        getremarks4,
//                        getrating5,
//                        getremarks5,
                        getrating6,
                        getremarks6,
                        getrating7,
                        getremarks7,
                        getrating8,
                        getremarks8,
                        getrating9,
                        getremarks9,
                        getrating10,
                        getremarks10,
//                        getrating11,
//                        getremarks11,
//                        getrating12,
//                        getremarks12,
                        getrating13,
                        getremarks13,
                        getrating14,
                        getremarks14,
                        getrating15,
                        getremarks15,
                        getrating16,
                        getremarks16
                    )
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//                db.insertData(eval)
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//          DATABASE FOR DASHHBOARD\
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                var dboard = Dashboard(
                   getlinename,
                   getlineposition,
                   getsalesname,
                   getsalesposition,
                   getfirstgrade,
                   getsecondgrade,
                   getfinalgrade,
                   getdate)

//                   db.inserDatadBoard(dboard)
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

//              END PUSH DATA TO COACHEDSIGN FRAGMENT
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

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

//                val file = File(Environment.getExternalStorageDirectory(), "/Evaluation Folder/COACHING LOG.xls")


                // ++++++++++++++++++++++++ CREATE PDF ++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                createPDFOM(linenamepdf = getlinename, linepositionpdf = getlineposition,
                    salesnamepdf = getsalesname, salespositionpdf = getsalesposition, datepdf = getdate,
                    ratingrow1 = getrating1, feedbackrow1 = getremarks1,ratingrow2 = getrating2, feedbackrow2 = getremarks2,
                    ratingrow3 = getrating3, feedbackrow3 = getremarks3,ratingrow4 = getrating4, feedbackrow4 = getremarks4,
                    ratingrow6 = getrating6, feedbackrow6 = getremarks6,
                    ratingrow7 = getrating7, feedbackrow7 = getremarks7,ratingrow8 = getrating8, feedbackrow8 = getremarks8,
                    ratingrow9 = getrating9, feedbackrow9 = getremarks9,ratingrow10 = getrating10, feedbackrow10 = getremarks10,
                    ratingrow13 = getrating13, feedbackrow13 = getremarks13,ratingrow14 = getrating14, feedbackrow14 = getremarks14,
                    ratingrow15 = getrating15, feedbackrow15 = getremarks15,ratingrow16 = getrating16, feedbackrow16 = getremarks16, signature1 = coach, signature2 = coachee, finalremarksalesman = finalremarksalesman.text.toString())
//// ++++++++++++++++++++++++END CREATE PDF +++++++++++++++++++++++++++++++++++++++++++++++++++++
//
//                val nextFrag = AddentryFragment()
//                val commit = requireActivity().supportFragmentManager.beginTransaction()
//                        .replace(R.id.frame_layout, nextFrag, "findThisFragment")
//                        .addToBackStack(null)
//                        .commit()

//                End button submit click
            } else (
                Toast.makeText(activity, "ERROR", Toast.LENGTH_SHORT).show()
                )

            //++++++++++++++++++++when button press end tag +++++++++++++++++++




        }

        btnclear2.setOnClickListener(){
            signaturePad2.clear()

        }

//    ONCREATEVIEW END TAG
        return v
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun createPDFOM(linenamepdf: String, linepositionpdf: String,
                    salesnamepdf: String, salespositionpdf: String, datepdf: String,
                    ratingrow1: String, feedbackrow1: String,ratingrow2: String, feedbackrow2: String,
                    ratingrow3: String, feedbackrow3: String,ratingrow4: String, feedbackrow4: String,
                    ratingrow6: String, feedbackrow6: String,
                    ratingrow7: String, feedbackrow7: String,ratingrow8: String, feedbackrow8: String,
                    ratingrow9: String, feedbackrow9: String,ratingrow10: String, feedbackrow10: String,

                    ratingrow13: String, feedbackrow13: String,ratingrow14: String, feedbackrow14: String,
                    ratingrow15: String, feedbackrow15: String, ratingrow16: String, feedbackrow16: String, signature1:Bitmap, signature2:Bitmap, finalremarksalesman: String) {
        // Permission on Storage
        ActivityCompat.requestPermissions(
            this.requireActivity(), arrayOf(
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.MANAGE_EXTERNAL_STORAGE
        ), PackageManager.PERMISSION_GRANTED
        )

//             PATH TO SAVE
        val pdfPath = File(Environment.getExternalStorageDirectory(), "/Evaluation Folder").toString()
        val file = File(pdfPath, "$salesnamepdf $datepdf.pdf")
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
//        image2.scaleAbsolute(20f,)

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
        tableheader.addCell(com.itextpdf.layout.element.Cell().setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(8f).add(Paragraph(salespositionpdf)))
        tableheader.addCell(com.itextpdf.layout.element.Cell().setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(8f).add(Paragraph(salesnamepdf).setBorder(Border.NO_BORDER)))
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
        table.addCell(com.itextpdf.layout.element.Cell().setVerticalAlignment(VerticalAlignment.MIDDLE).setMinHeight(25f).setFontSize(5f).add(Paragraph("LEARNING AGILITY (WILLINGNESS TO LEARN AND ACCEPT QUICKLY)")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph("D")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph(ratingrow1)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph(feedbackrow1)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph("RIGHT M&B WITH SELF: PASSION TO MAKE A DIFFERENCE AND DELIVER RESULTS (MASIPAG, MATIYAGA, DISCIPLINED, COMMITED)")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph("D")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph(ratingrow2)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph(feedbackrow2)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(50f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph("RIGHT M&B WITH OTHERS: HIGHLY ENGAGES, PRO-ACTIVE/ INITIATES, SERVICE-ORIENTED, SEEKS FIRST TO UNDERSTAND THEN TO BE UNDERSTOOD, THINKS WIN-WIN ")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph("D")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).setFontSize(5f).add(Paragraph(ratingrow3)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph(feedbackrow3)))

//         TABLE ROW (2ND ROW)
        table.addCell(com.itextpdf.layout.element.Cell(1, 2).setVerticalAlignment(VerticalAlignment.MIDDLE).addStyle(Style().setBold()).setFontSize(8f).add(Paragraph("FUNCTIONAL COMPETENCY")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph("MASTERY OF A SALESMAN DIAL (DAILY IN A LIFE)")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph("CL4")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph(ratingrow4)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph(feedbackrow4)))

//         TABLE CELL SEPARATOR
        table.addCell(com.itextpdf.layout.element.Cell(1, 6))

//         TABLE ROW/COLUMN FOR PLAN DO CHECK AND ACT
        table.addCell(com.itextpdf.layout.element.Cell(9, 1).setVerticalAlignment(VerticalAlignment.BOTTOM).setRotationAngle(33F).addStyle(Style().setBold()).setFontSize(12f).add(Paragraph("OBSERVABLE BEHAVIORS RELATED TO FUNCTIONAL COMPETENCY")))

//         TABLE ROW (3RD ROW)
        table.addCell(com.itextpdf.layout.element.Cell(3, 1).setVerticalAlignment(VerticalAlignment.MIDDLE).addStyle(Style().setBold()).setFontSize(8f).setMinWidth(100f).add(Paragraph("PLAN")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph("CONSISTENT AND ACCURATE FILLING OUT OF DAILY SALES REPORT")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph("CL4")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph(ratingrow6)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph(feedbackrow6)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph("COMPUTES AND ENSURES CORRECT LOAD PLAN WITH MUST-HAVE'S")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph("CL4")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph(ratingrow7)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph(feedbackrow7)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph("CONSISTENCY IN LOGGING ACTION PLANS")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph("CL4")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph(ratingrow8)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph(feedbackrow8)))

//         TABLE ROW (4TH ROW)
        table.addCell(com.itextpdf.layout.element.Cell(2, 1).setVerticalAlignment(VerticalAlignment.MIDDLE).addStyle(Style().setBold()).setFontSize(8f).add(Paragraph("DO")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph("CONSISTENTLY AND EFFECTIVELY FOLLOWS/EXECUTES D.I.A.L.")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph("CL4")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph(ratingrow9)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph(feedbackrow9)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph("CONSISTENTLY REVIEW LOAD PLAN AND ENSURE MSDP SKU'S ARE COMPLETE, RIGHT PRODUCT MIX AND STOCK WEIGHT")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph("CL4")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph(ratingrow10)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph(feedbackrow10)))

//         TABLE ROW (5TH)
        table.addCell(com.itextpdf.layout.element.Cell(2, 1).setVerticalAlignment(VerticalAlignment.MIDDLE).addStyle(Style().setBold()).setFontSize(8f).add(Paragraph("CHECK")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph("CONSISTENT AND EFFECTIVE DOING ANALYSIS (POST-CALL REVIEW) IN REFERENCE TO D.I.A.L.")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph("CL4")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph(ratingrow13)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph(feedbackrow13)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph("CONSISTENT AND EFFECTIVE IN ANALYSIS (END OF DAY)  IN REFERENCE TO D.I.A.L.")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph("CL4")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph(ratingrow14)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph(feedbackrow14)))
//            TABLE ROW (6TH)
        table.addCell(com.itextpdf.layout.element.Cell(2, 1).setVerticalAlignment(VerticalAlignment.MIDDLE).addStyle(Style().setBold()).setFontSize(8f).add(Paragraph("ACT")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph("CONSISTENCY AND EFFECTIVENESS IN DOING PROBLEM SOLVING (ROOT CAUSE MINDSET) TO ADDRESS ISSUES/GAPS TO BE ABLE TO GENERATE EFFECTIVE ACTION PLANS. THIS ALSO INCLUDES CONSISTENCY AND EFFECTIVENESS IN EXECUTING THE ACTIONS TO BE DULY MONITORED IN THE REVIEWS")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph("CL4")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph(ratingrow15)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph(feedbackrow15)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph("CONSISTENCY IN ESCALATING ISSUES TO THE LINE MANAGER")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph("CL4")))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph(ratingrow16)))
        table.addCell(com.itextpdf.layout.element.Cell().setMinHeight(25f).setVerticalAlignment(VerticalAlignment.MIDDLE).setFontSize(5f).add(Paragraph(feedbackrow16)))

        //         TABLE CELL SEPARATOR
        table.addCell(com.itextpdf.layout.element.Cell(1, 6))

        //    FINAL REMARKS
        table.addCell(com.itextpdf.layout.element.Cell().setBorder(Border.NO_BORDER).addStyle(Style().setBold()).setMinHeight(25f).setFontSize(7f).add(Paragraph("Remarks:")))
        table.addCell(com.itextpdf.layout.element.Cell(1,2).setBorder(Border.NO_BORDER).setVerticalAlignment(VerticalAlignment.MIDDLE).setTextAlignment(TextAlignment.LEFT).setMinHeight(25f).setFontSize(7f).add(Paragraph("$finalremarksalesman.")))
        table.addCell(com.itextpdf.layout.element.Cell(1, 3).setMinHeight(25f).setBorder(Border.NO_BORDER))


//         SIGNATURE AREA
        table.addCell(com.itextpdf.layout.element.Cell(1,2).setVerticalAlignment(VerticalAlignment.MIDDLE).setHorizontalAlignment(
            HorizontalAlignment.LEFT).add(image2.setAutoScale(true)).setBorder(Border.NO_BORDER).setMaxHeight(45f))
        table.addCell(com.itextpdf.layout.element.Cell().setBorder(Border.NO_BORDER).setMinHeight(45f))
        table.addCell(com.itextpdf.layout.element.Cell(1, 3).setVerticalAlignment(VerticalAlignment.MIDDLE).setHorizontalAlignment(
            HorizontalAlignment.LEFT).add(image3.setAutoScale(true)).setBorder(Border.NO_BORDER).setMaxHeight(45f))
//         SIGNATURE NAME
        table.addCell(com.itextpdf.layout.element.Cell(1, 2,).setBorder(Border.NO_BORDER).setVerticalAlignment(VerticalAlignment.BOTTOM).setTextAlignment(TextAlignment.LEFT).setMinHeight(15f).addStyle(Style().setUnderline()).setFontSize(10f).add(Paragraph(linenamepdf)))
        table.addCell(com.itextpdf.layout.element.Cell().setBorder(Border.NO_BORDER).setMinHeight(15f))
        table.addCell(com.itextpdf.layout.element.Cell(1, 3).setBorder(Border.NO_BORDER).setVerticalAlignment(VerticalAlignment.BOTTOM).setTextAlignment(TextAlignment.LEFT).setMinHeight(15f).addStyle(Style().setUnderline()).setFontSize(10f).add(Paragraph(salesnamepdf)))
//         SIGNATURE POSITION
        table.addCell(com.itextpdf.layout.element.Cell(1, 2).setBorder(Border.NO_BORDER).setVerticalAlignment(VerticalAlignment.TOP).setTextAlignment(TextAlignment.LEFT).setMinHeight(15f).setFontSize(10f).add(Paragraph(linepositionpdf)))
        table.addCell(com.itextpdf.layout.element.Cell().setBorder(Border.NO_BORDER).setMinHeight(15f))
        table.addCell(com.itextpdf.layout.element.Cell(1, 3).setBorder(Border.NO_BORDER).setVerticalAlignment(VerticalAlignment.BOTTOM).setTextAlignment(TextAlignment.LEFT).setMinHeight(15f).setFontSize(10f).add(Paragraph(salespositionpdf)))


//         IMPLEMENT DESIGN
        document.add(image1)
        document.add(tableheader)
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


        var backFrag = AddentryFragment()
        val commit = requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, backFrag, "findThisFragment")
            .addToBackStack(null)
            .commit()


//  +++++++++++++++++++++++++++ createPDF end tag+++++++++++++++++++++++++++++++
//         createPDF end tag
    }

// END COACHER SIGNATURE TAG
}


