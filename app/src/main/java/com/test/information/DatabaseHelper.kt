package com.test.information

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(var context: Context) :
    SQLiteOpenHelper(context, DATABASE_PROFILE, null, 1)  {

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = "CREATE TABLE $DATABASE_PROFILE " +
            "($COL_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "$COL_PROFILENAME TEXT, " +
            "$COL_PROFILEPOSITION TEXT, " +
            "$COL_PROFILECOMPANY TEXT, " +
            "$COL_PROFILEIMAGE BLOB)" // Adding the image column
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        val dropTableQuery = "DROP TABLE IF EXISTS $DATABASE_PROFILE "
        db.execSQL(dropTableQuery)
        onCreate(db)
    }

}