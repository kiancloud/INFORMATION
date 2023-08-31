package com.test.information

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import android.widget.Toast
import java.io.ByteArrayOutputStream
import kotlin.collections.ArrayList


const val COL_ID = "[ID]"
//const val DATABASE_NAME_SALES = "{N1SDBSALES}"
const val TABLE_NAME_SALES = "[SupervisorTable]"
const val COL_SALESNAME = "[Salesname]"
const val COL_SALESPOSITION = "[SalesPosition]"
const val COL_DATE = "[Date]"
const val COL_EVAL1_GRADE1 = "[EVAL1G1]"
const val COL_EVAL1_GRADE1_REMARKS = "[EVAL1G1R]"
const val COL_EVAL1_GRADE2 = "[EVAL1G2]"
const val COL_EVAL1_GRADE2_REMARKS = "[EVAL1G2R]"
const val COL_EVAL1_GRADE3 = "[EVAL1G3]"
const val COL_EVAL1_GRADE3_REMARKS = "[EVAL1G3R]"
const val COL_EVAL2_GRADE1 = "[EVAL2G1]"
const val COL_EVAL2_GRADE1_REMARKS = "[EVAL2G1R]"
const val COL_EVAL2_GRADE2 = "[EVAL2G2]"
const val COL_EVAL2_GRADE2_REMARKS = "[EVAL2G2R]"
const val COL_EVAL3_GRADE1 = "[EVAL3G1]"
const val COL_EVAL3_GRADE1_REMARKS = "[EVAL3G1R]"
const val COL_EVAL3_GRADE2 = "[EVAL3G2]"
const val COL_EVAL3_GRADE2_REMARKS = "[EVAL3G2R]"
const val COL_EVAL3_GRADE3 = "[EVAL3G3]"
const val COL_EVAL3_GRADE3_REMARKS = "[EVAL3G3R]"
const val COL_EVAL3_GRADE4 = "[EVAL3G4]"
const val COL_EVAL3_GRADE4_REMARKS = "[EVAL3G4R]"
const val COL_EVAL3_GRADE5 = "[EVAL3G5]"
const val COL_EVAL3_GRADE5_REMARKS = "[EVAL3G5R]"
const val COL_EVAL3_GRADE6 = "[EVAL3G6]"
const val COL_EVAL3_GRADE6_REMARKS = "[EVAL3G6R]"
const val COL_EVAL3_GRADE7 = "[EVAL3G7]"
const val COL_EVAL3_GRADE7_REMARKS = "[EVAL3G7R]"
const val COL_EVAL3_GRADE8 = "[EVAL3G8]"
const val COL_EVAL3_GRADE8_REMARKS = "[EVAL3G8R]"
const val COL_EVAL3_GRADE9 = "[EVAL3G9]"
const val COL_EVAL3_GRADE9_REMARKS = "[EVAL3G9R]"
const val COL_EVAL3_GRADE10 = "[EVAL3G10]"
const val COL_EVAL3_GRADE10_REMARKS = "[EVAL3G10R]"
const val COL_EVAL3_GRADE11 = "[EVAL3G11]"
const val COL_EVAL3_GRADE11_REMARKS = "[EVAL3G11R]"

const val DATABASE_NAME_MANAGER = "[N1SDBMANAGER]"
const val TABLE_NAME_MANAGER = "[ManagerTable]"
const val COL_LINEMANAGERNAME = "[LineManagerName]"
const val COL_LINEMANAGERPOSITION = "[LineManagerPosition]"

const val TABLE_NAME_DASHBOARD = "[N1SDASHBOARD]"
const val COL_FIRSTGRADE = "[FIRSTGRADE]"
const val COL_SECONDGRADE = "[SECONDGRADE]"
const val COL_FINALGRADE = "[FINALGRADE]"

//Profile setup page

const val DATABASE_PROFILE = "[PROFILE]"
const val COL_PROFILENAME = "[SETUPNAME]"
const val COL_PROFILEPOSITION = "[POSITION]"
const val COL_PROFILECOMPANY = "[COMPANY]"
const val COL_PROFILEIMAGE = "[PROFILEIMAGE]"



class DatabaseHandler (var context: Context) :
    SQLiteOpenHelper(context, DATABASE_PROFILE, null, 1) {
//    override fun onCreate(db: SQLiteDatabase?) {
//        db.execSQL("CREATE TABLE $TABLE_NAME (ID INTEGER PRIMARY KEY " +
//                "AUTOINCREMENT,NAME TEXT,GALAXY TEXT,TYPE TEXT)")
//    }


    //   create table
    override fun onCreate(db: SQLiteDatabase?) {

        val profileTable = "CREATE TABLE $DATABASE_PROFILE (" +
            "$COL_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "$COL_PROFILENAME TEXT," +
            "$COL_PROFILEPOSITION TEXT," +
            "$COL_PROFILECOMPANY TEXT," +
            "$COL_PROFILEIMAGE BLOB)" // BLOB data type for storing images

        db?.execSQL(profileTable)



//        val dshboard = "CREATE TABLE" + TABLE_NAME_DASHBOARD +" (" +
//                COL_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
////            COL_LINEMANAGERNAME + " VARCHAR(256)," +
////            COL_LINEMANAGERPOSITION + " VARCHAR(256)," +
////            COL_SALESNAME + " VARCHAR(256)," +
////            COL_SALESPOSITION + " VARCHAR(256)," +
//                COL_FIRSTGRADE + " VARCHAR(256)," +
//                COL_SECONDGRADE + " VARCHAR(256)," +
//                COL_FINALGRADE + " VARCHAR(256),"
//        db?.execSQL(dshboard)

//        --------------------------------------------------------

//        val SalesTable = "CREATE TABLE" + TABLE_NAME_SALES +" (" +
//                COL_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
//                COL_LINEMANAGERNAME + " VARCHAR(256)," +
//                COL_LINEMANAGERPOSITION + " VARCHAR(256)," +
//                COL_SALESNAME + " VARCHAR(256)," +
//                COL_SALESPOSITION + " VARCHAR(256)," +
//                COL_DATE + " VARCHAR(256)," +
//                COL_EVAL1_GRADE1 + " VARCHAR(256)," +
//                COL_EVAL1_GRADE1_REMARKS + " VARCHAR(256)," +
//                COL_EVAL1_GRADE2 + " VARCHAR(256)," +
//                COL_EVAL1_GRADE2_REMARKS + " VARCHAR(256)," +
//                COL_EVAL1_GRADE3 + " VARCHAR(256)," +
//                COL_EVAL1_GRADE3_REMARKS + " VARCHAR(256)," +
//                COL_EVAL2_GRADE1 + " VARCHAR(256)," +
//                COL_EVAL2_GRADE1_REMARKS + " VARCHAR(256)," +
////                COL_EVAL2_GRADE2 + " VARCHAR(256)," +
////                COL_EVAL2_GRADE2_REMARKS + " VARCHAR(256)," +
//                COL_EVAL3_GRADE1 + " VARCHAR(256)," +
//                COL_EVAL3_GRADE1_REMARKS + " VARCHAR(256)," +
//                COL_EVAL3_GRADE2 + " VARCHAR(256)," +
//                COL_EVAL3_GRADE2_REMARKS + " VARCHAR(256)," +
//                COL_EVAL3_GRADE3 + " VARCHAR(256)," +
//                COL_EVAL3_GRADE3_REMARKS + " VARCHAR(256)," +
//                COL_EVAL3_GRADE4 + " VARCHAR(256)," +
//                COL_EVAL3_GRADE4_REMARKS + " VARCHAR(256)," +
//                COL_EVAL3_GRADE5 + " VARCHAR(256)," +
//                COL_EVAL3_GRADE5_REMARKS + " VARCHAR(256)," +
////                COL_EVAL3_GRADE6 + " VARCHAR(256)," +
////                COL_EVAL3_GRADE6_REMARKS + " VARCHAR(256)," +
////                COL_EVAL3_GRADE7 + " VARCHAR(256)," +
////                COL_EVAL3_GRADE7_REMARKS + " VARCHAR(256)," +
//                COL_EVAL3_GRADE8 + " VARCHAR(256)," +
//                COL_EVAL3_GRADE8_REMARKS + " VARCHAR(256)," +
//                COL_EVAL3_GRADE9 + " VARCHAR(256)," +
//                COL_EVAL3_GRADE9_REMARKS + " VARCHAR(256)," +
//                COL_EVAL3_GRADE10 + " VARCHAR(256)," +
//                COL_EVAL3_GRADE10_REMARKS + " VARCHAR(256)," +
//                COL_EVAL3_GRADE11 + " VARCHAR(256)," +
//                COL_EVAL3_GRADE11_REMARKS + " VARCHAR(256))"
//
//        db?.execSQL(SalesTable)
//
//        val ManagerTable = "CREATE TABLE" + TABLE_NAME_MANAGER +" (" +
//                COL_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
//                COL_LINEMANAGERNAME + " VARCHAR(256)," +
//                COL_LINEMANAGERPOSITION + " VARCHAR(256)," +
//                COL_SALESNAME + " VARCHAR(256)," +
//                COL_SALESPOSITION + " VARCHAR(256)," +
//                COL_DATE + " VARCHAR(256)," +
//                COL_EVAL1_GRADE1 + " VARCHAR(256)," +
//                COL_EVAL1_GRADE1_REMARKS + " VARCHAR(256)," +
//                COL_EVAL1_GRADE2 + " VARCHAR(256)," +
//                COL_EVAL1_GRADE2_REMARKS + " VARCHAR(256)," +
//                COL_EVAL1_GRADE3 + " VARCHAR(256)," +
//                COL_EVAL1_GRADE3_REMARKS + " VARCHAR(256)," +
//                COL_EVAL2_GRADE1 + " VARCHAR(256)," +
//                COL_EVAL2_GRADE1_REMARKS + " VARCHAR(256)," +
//                COL_EVAL2_GRADE2 + " VARCHAR(256)," +
//                COL_EVAL2_GRADE2_REMARKS + " VARCHAR(256)," +
//                COL_EVAL3_GRADE1 + " VARCHAR(256)," +
//                COL_EVAL3_GRADE1_REMARKS + " VARCHAR(256)," +
//                COL_EVAL3_GRADE2 + " VARCHAR(256)," +
//                COL_EVAL3_GRADE2_REMARKS + " VARCHAR(256)," +
//                COL_EVAL3_GRADE3 + " VARCHAR(256)," +
//                COL_EVAL3_GRADE3_REMARKS + " VARCHAR(256)," +
//                COL_EVAL3_GRADE4 + " VARCHAR(256)," +
//                COL_EVAL3_GRADE4_REMARKS + " VARCHAR(256)," +
//                COL_EVAL3_GRADE5 + " VARCHAR(256)," +
//                COL_EVAL3_GRADE5_REMARKS + " VARCHAR(256)," +
//                COL_EVAL3_GRADE6 + " VARCHAR(256)," +
//                COL_EVAL3_GRADE6_REMARKS + " VARCHAR(256)," +
//                COL_EVAL3_GRADE7 + " VARCHAR(256)," +
//                COL_EVAL3_GRADE7_REMARKS + " VARCHAR(256)," +
//                COL_EVAL3_GRADE8 + " VARCHAR(256)," +
//                COL_EVAL3_GRADE8_REMARKS + " VARCHAR(256)," +
//                COL_EVAL3_GRADE9 + " VARCHAR(256)," +
//                COL_EVAL3_GRADE9_REMARKS + " VARCHAR(256)," +
//                COL_EVAL3_GRADE10 + " VARCHAR(256)," +
//                COL_EVAL3_GRADE10_REMARKS + " VARCHAR(256)," +
//                COL_EVAL3_GRADE11 + " VARCHAR(256)," +
//                COL_EVAL3_GRADE11_REMARKS + " VARCHAR(256))"
//
//        db?.execSQL(ManagerTable)




    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")


    }

//    fun  inserDatadBoard(dboard: Dashboard) {
//        val db = this.writableDatabase
//        val cv = ContentValues()
////        cv.put(COL_LINEMANAGERNAME,dboard.liname)
////        cv.put(COL_LINEMANAGERPOSITION,dboard.lmanagerposition)
////        cv.put(COL_SALESNAME,dboard.sName)
////        cv.put(COL_SALESPOSITION,dboard.pName)
//        cv.put(COL_FIRSTGRADE,dboard.firstRowGrade)
//        cv.put(COL_SECONDGRADE,dboard.secondRowGrade)
//        cv.put(COL_FINALGRADE,dboard.finalGrade)
//
//     val rsult = db.insert(TABLE_NAME_DASHBOARD, null,cv)
//        if(rsult == (-1).toLong())
//            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
//        else
//            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
//    }




    // insert data to database
    fun insertData(eval: Eval) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COL_LINEMANAGERNAME,eval.LineName)
        cv.put(COL_LINEMANAGERPOSITION,eval.LinePosition)
        cv.put(COL_SALESNAME,eval.SalesName)
        cv.put(COL_SALESPOSITION,eval.SalesPosition)
        cv.put(COL_DATE,eval.Date)
        cv.put(COL_EVAL1_GRADE1,eval.EVAL1G1)
        cv.put(COL_EVAL1_GRADE1_REMARKS,eval.EVAL1G1R)
        cv.put(COL_EVAL1_GRADE2, eval.EVAL1G2)
        cv.put(COL_EVAL1_GRADE2_REMARKS, eval.EVAL1G2R)
        cv.put(COL_EVAL1_GRADE3, eval.EVAL1G2)
        cv.put(COL_EVAL1_GRADE3_REMARKS, eval.EVAL1G2R)
        cv.put(COL_EVAL2_GRADE1, eval.EVAL2G1)
        cv.put(COL_EVAL2_GRADE1_REMARKS, eval.EVAL2G1R)
//        cv.put(COL_EVAL2_GRADE2, eval.EVAL2G2)
//        cv.put(COL_EVAL2_GRADE2_REMARKS, eval.EVAL2G2R)
        cv.put(COL_EVAL3_GRADE1, eval.EVAL3G1)
        cv.put(COL_EVAL3_GRADE1_REMARKS, eval.EVAL1G1R)
        cv.put(COL_EVAL3_GRADE2, eval.EVAL1G2)
        cv.put(COL_EVAL3_GRADE2_REMARKS, eval.EVAL1G2R)
        cv.put(COL_EVAL3_GRADE3, eval.EVAL1G3)
        cv.put(COL_EVAL3_GRADE3_REMARKS, eval.EVAL3G3R)
        cv.put(COL_EVAL3_GRADE4, eval.EVAL3G4)
        cv.put(COL_EVAL3_GRADE4_REMARKS, eval.EVAL3G4R)
        cv.put(COL_EVAL3_GRADE5, eval.EVAL3G5)
        cv.put(COL_EVAL3_GRADE5_REMARKS, eval.EVAL3G5R)
//        cv.put(COL_EVAL3_GRADE6, eval.EVAL3G6)
//        cv.put(COL_EVAL3_GRADE6_REMARKS, eval.EVAL3G6R)
//        cv.put(COL_EVAL3_GRADE7, eval.EVAL3G7)
//        cv.put(COL_EVAL3_GRADE7_REMARKS, eval.EVAL3G7R)
        cv.put(COL_EVAL3_GRADE8, eval.EVAL3G8)
        cv.put(COL_EVAL3_GRADE8_REMARKS, eval.EVAL3G8R)
        cv.put(COL_EVAL3_GRADE9, eval.EVAL3G9)
        cv.put(COL_EVAL3_GRADE9_REMARKS, eval.EVAL3G9R)
        cv.put(COL_EVAL3_GRADE10, eval.EVAL3G10)
        cv.put(COL_EVAL3_GRADE10_REMARKS, eval.EVAL3G10R)
        cv.put(COL_EVAL3_GRADE11, eval.EVAL3G11)
        cv.put(COL_EVAL3_GRADE11_REMARKS, eval.EVAL3G11R)


        val result = db.insert(TABLE_NAME_SALES,null,cv)
        if(result == (-1).toLong())
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }

    fun insertDataP(setupD: SetupProfile) {

        try {


            val db = this.writableDatabase
            val contentValues = ContentValues()
            contentValues.put(COL_PROFILENAME, setupD.name)
            contentValues.put(COL_PROFILEPOSITION, setupD.position)
            contentValues.put(COL_PROFILECOMPANY, setupD.company)
//            val imageByteArray = bitmapToByteArray(imageBitmap)
            contentValues.put(COL_PROFILEIMAGE,setupD.ownerImage)

            db.insert(DATABASE_PROFILE, null, contentValues)
            db.close()
        }catch (e: Exception) {
            // Handle the exception here
            Log.e("DatabaseError", "Error inserting data: ${e.message}")
        }
    }

    private fun bitmapToByteArray(bitmap: Bitmap): ByteArray {
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
        return stream.toByteArray()
    }

//    fun retrieveProfileData(): SetupProfile? {
//        val db = this.readableDatabase
//        val query = "SELECT * FROM $DATABASE_PROFILE"
//        val cursor = db.rawQuery(query, null)
//        var profileData: SetupProfile? = null
//
//        if (cursor.moveToFirst()) {
//            // Log the column indices
//            val columns = cursor.columnNames.joinToString(", ")
//            Log.d("DatabaseDebug", "Columns: $columns")
//
//            val nameIndex = cursor.getColumnIndex(COL_PROFILENAME)
//            val positionIndex = cursor.getColumnIndex(COL_PROFILEPOSITION)
//            val companyIndex = cursor.getColumnIndex(COL_PROFILECOMPANY)
//            val imageIndex = cursor.getColumnIndex(COL_PROFILEIMAGE)
//
//            if (nameIndex != -1 && positionIndex != -1 && companyIndex != -1 && imageIndex != -1) {
//                // Log the indices and values
//                Log.d("DatabaseDebug", "Name Index: $nameIndex, Position Index: $positionIndex, Company Index: $companyIndex, Image Index: $imageIndex")
//
//                // Retrieve and log the values
//                val name = cursor.getString(nameIndex)
//                val position = cursor.getString(positionIndex)
//                val company = cursor.getString(companyIndex)
//                Log.d("DatabaseDebug", "Name: $name, Position: $position, Company: $company")
//
//                // Retrieve the image data as a byte array and log its size
//                val imageByteArray = cursor.getBlob(imageIndex)
//                Log.d("DatabaseDebug", "Image Byte Array Size: ${imageByteArray.size}")
//
//                profileData = SetupProfile(name, position, company, ownerImage = imageByteArray)
//            } else {
//                Log.e("DatabaseError", "Column indices are not valid.")
//            }
//        } else {
//            Log.e("DatabaseError", "Cursor is empty.")
//        }
//
//        cursor.close()
//        db.close()
//
//        return profileData


//    }

    fun  retrieveProfileData(): MutableList<SetupProfile>{
        val list: MutableList<SetupProfile> = ArrayList()
        val db = this.readableDatabase
        val query= "Select * from  $DATABASE_PROFILE"
        val result =db.rawQuery(query, null)

        if(result.moveToFirst()){
            do {
                val setupP = SetupProfile(
                    result.getString(1),  // Name
                    result.getString(2),  // Position
                    result.getString(3),  // Company
                    result.getBlob(4))   // Image
                setupP.ID = result.getInt(0) // ID
                list.add(setupP)
            }while ((result.moveToNext()))
        }
        result.close()
        return list
    }



    // insert data to database
    fun insertData(evalm: EvalManager) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COL_LINEMANAGERNAME,evalm.LineName)
        cv.put(COL_LINEMANAGERPOSITION,evalm.LinePosition)
        cv.put(COL_SALESNAME,evalm.SalesName)
        cv.put(COL_SALESPOSITION,evalm.SalesPosition)
        cv.put(COL_DATE,evalm.Date)
        cv.put(COL_EVAL1_GRADE1,evalm.EVAL1G1)
        cv.put(COL_EVAL1_GRADE1_REMARKS,evalm.EVAL1G1R)
        cv.put(COL_EVAL1_GRADE2, evalm.EVAL1G2)
        cv.put(COL_EVAL1_GRADE2_REMARKS, evalm.EVAL1G2R)
        cv.put(COL_EVAL1_GRADE3, evalm.EVAL1G2)
        cv.put(COL_EVAL1_GRADE3_REMARKS, evalm.EVAL1G2R)
        cv.put(COL_EVAL2_GRADE1, evalm.EVAL2G1)
        cv.put(COL_EVAL2_GRADE1_REMARKS, evalm.EVAL2G1R)
        cv.put(COL_EVAL2_GRADE2, evalm.EVAL2G2)
        cv.put(COL_EVAL2_GRADE2_REMARKS, evalm.EVAL2G2R)
        cv.put(COL_EVAL3_GRADE1, evalm.EVAL3G1)
        cv.put(COL_EVAL3_GRADE1_REMARKS, evalm.EVAL1G1R)
        cv.put(COL_EVAL3_GRADE2, evalm.EVAL1G2)
        cv.put(COL_EVAL3_GRADE2_REMARKS, evalm.EVAL1G2R)
        cv.put(COL_EVAL3_GRADE3, evalm.EVAL1G3)
        cv.put(COL_EVAL3_GRADE3_REMARKS, evalm.EVAL3G3R)
        cv.put(COL_EVAL3_GRADE4, evalm.EVAL3G4)
        cv.put(COL_EVAL3_GRADE4_REMARKS, evalm.EVAL3G4R)
        cv.put(COL_EVAL3_GRADE5, evalm.EVAL3G5)
        cv.put(COL_EVAL3_GRADE5_REMARKS, evalm.EVAL3G5R)
        cv.put(COL_EVAL3_GRADE6, evalm.EVAL3G6)
        cv.put(COL_EVAL3_GRADE6_REMARKS, evalm.EVAL3G6R)
        cv.put(COL_EVAL3_GRADE7, evalm.EVAL3G7)
        cv.put(COL_EVAL3_GRADE7_REMARKS, evalm.EVAL3G7R)
        cv.put(COL_EVAL3_GRADE8, evalm.EVAL3G8)
        cv.put(COL_EVAL3_GRADE8_REMARKS, evalm.EVAL3G8R)
        cv.put(COL_EVAL3_GRADE9, evalm.EVAL3G9)
        cv.put(COL_EVAL3_GRADE9_REMARKS, evalm.EVAL3G9R)
        cv.put(COL_EVAL3_GRADE10, evalm.EVAL3G10)
        cv.put(COL_EVAL3_GRADE10_REMARKS, evalm.EVAL3G10R)
//        cv.put(COL_EVAL3_GRADE11, evalm.EVAL3G11)
//        cv.put(COL_EVAL3_GRADE11_REMARKS, evalm.EVAL3G11R)


        val result = db.insert(TABLE_NAME_MANAGER,null,cv)
        if(result == (-1).toLong()) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
        }
    }


//    THIS IS WORKING JUST UNCOMMENT IT
//    fun readData() : ArrayList<Eval>{
//        var list : ArrayList<Eval> = ArrayList<Eval>()
//
//        val db = this.readableDatabase
//        val query = "Select $COL_CNAME, $COL_POSITION, $COL_CNAME, $COL_DATE from $TABLE_NAME"
//        var  cursor: Cursor? = null
////        val result = db.rawQuery(query, null)
//
//        try {
//            cursor = db.rawQuery(query, null)
//        } catch (e: SQLiteException) {
//            db.execSQL(query)
//            return ArrayList()
//        }
//        var ID: Int
//        var Position: String
//        var CName: String
//        var Date: String
//
//        if (cursor.moveToFirst()) {
//        do {
////                var eval = Eval()
//            ID = cursor.getString(cursor.getColumnIndex(COL_ID)).toInt()
//            Position = cursor.getString(cursor.getColumnIndex(COL_POSITION))
//            CName = cursor.getString(cursor.getColumnIndex(COL_CNAME))
//            Date = cursor.getString(cursor.getColumnIndex(COL_DATE))
//
//            val em = Eval(ID = ID,Position = Position, CName = CName, Date = Date)
//            list.add(em)
//
//        } while (cursor.moveToNext())
//        }
//        cursor.close()
//        db.close()
//        return list
//    }

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

//    READING DATABASE
    fun salesmanResultDB(): MutableList<Dashboard> {
    val list: MutableList<Dashboard> = ArrayList()
    val db = this.readableDatabase
    val query = "Select * from $TABLE_NAME_DASHBOARD"
    val result = db.rawQuery(query, null)
    if (result.moveToFirst()){
        do {
            var dshbrd = Dashboard()
            dshbrd.ID = result.getString(0).toInt()
//            dshbrd.liname = result.getString(1)
//            dshbrd.lmanagerposition = result.getString(2)
//            dshbrd.sName = result.getString(3)
//            dshbrd.pName = result.getString(4)
            dshbrd.firstRowGrade = result.getString(1)
            dshbrd.secondRowGrade = result.getString(2)
            dshbrd.finalGrade = result.getString(3)
            dshbrd.dateTime = result.getString(4)
            list.add(dshbrd)
        }while (result.moveToNext())
    }
    result.close()
    return list
    }



//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    }
