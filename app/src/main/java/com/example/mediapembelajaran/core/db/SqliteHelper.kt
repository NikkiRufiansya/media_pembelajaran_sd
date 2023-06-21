package com.example.mediapembelajaran.core.db


import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.example.mediapembelajaran.model.NilaiModels


class SqliteHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "nilai"
        private const val TBL_NILAI = "tbl_nilai"
        private const val ID = "id"
        private const val nilai = "nilai"
    }

    override fun onCreate(db: SQLiteDatabase) {
        var createTblServer = "CREATE TABLE " + TBL_NILAI + " (" +
                ID + " INTEGER PRIMARY KEY, " +
                nilai + " TEXT );";
        db.execSQL(createTblServer)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TBL_NILAI")
        onCreate(db)
    }

    fun insertServer(std: NilaiModels): Long {
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(ID, std.id)
        contentValues.put(nilai, std.nilai)

        val success = db.insert(TBL_NILAI, null, contentValues)
        db.close()
        return success
    }


    @SuppressLint("Range")
    fun getAllNilai(): ArrayList<NilaiModels> {
        val serverList: ArrayList<NilaiModels> = ArrayList()
        val selectQuery = "SELECT * FROM $TBL_NILAI"
        val db = this.readableDatabase

        val cursor: Cursor?
        try {
            cursor = db.rawQuery(selectQuery, null)
        } catch (e: Exception) {
            e.printStackTrace()
            db.execSQL(selectQuery)
            return ArrayList()
        }

        var id: Int
        var nilai: String

        if (cursor.moveToFirst()) {
            do {
                id = cursor.getInt(cursor.getColumnIndex("id"))
                nilai = cursor.getString(cursor.getColumnIndex("nilai"))

                val servers = NilaiModels(id = id, nilai = nilai)
                serverList.add(servers)
            } while (cursor.moveToNext())
        }

        return serverList

    }


}