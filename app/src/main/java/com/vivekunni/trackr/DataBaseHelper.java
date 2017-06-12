package com.vivekunni.trackr;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by acemaster on 11/06/17.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    //Logcat log
    private static final String LOG = "DataBaseHelper";

    //Database Version
    private static final int DATABASE_VERSION = 1;

    //Database Name
    private static final String DATABASE_NAME = "Trackr";

    //Table Names
    private static final String Table_TimeTable = "TimeTable";
    private static final String Table_Subjects = "Subject";

    //TimeTable Column Names
    private static final String KEY_TT_ID = "id";
    private static final String KEY_TT_NAME = "name";
    private static final String KEY_TT_PASS_PERCENT = "pass_percent";
    private static final String KEY_TT_TOTAL_CLASS = "total_class";

    //Subject Column Names
    private static final String KEY_SUB_ID = "id";
    private static final String KEY_SUB_NAME = "name";
    private static final String KEY_SUB_TT_ID = "timetable_id";
    private static final String KEY_SUB_NO_OF_CLASSES = "no_of_classes";

    //Table Create Statements

    private static final String CREATE_TABLE_TT = "CREATE TABLE "+ Table_TimeTable + " ("+ KEY_TT_ID + "INTEGER PRIMARY KEY, "+ KEY_TT_NAME + "TEXT, "+KEY_TT_PASS_PERCENT + "REAL)";
    private static final String CREATE_TABLE_SUB = "CREATE TABLE "+ Table_Subjects + " ("+ KEY_SUB_ID + "INTEGER PRIMARY KEY, "+ KEY_SUB_NAME + "TEXT, "+KEY_SUB_TT_ID + "INTEGER, "+ KEY_SUB_NO_OF_CLASSES + "INTEGER)";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_TT);
        db.execSQL(CREATE_TABLE_SUB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ Table_TimeTable);
        db.execSQL("DROP TABLE IF EXISTS "+ Table_Subjects);

        //Create new db
        onCreate(db);
    }

    //Create new TimeTable
    public long createTimeTable(Timetable t)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TT_NAME,t.getName());
        values.put(KEY_TT_PASS_PERCENT,t.getPass_percent());

        long t_id = db.insert(Table_TimeTable,null,values);
        return t_id;
    }

    //Create New Subject
    public long createSubject(Subjects s)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_SUB_NAME,s.getName());
        values.put(KEY_SUB_NO_OF_CLASSES,s.getNo_of_classes());
        values.put(KEY_SUB_TT_ID,s.getTimetable_id());

        long s_id = db.insert(Table_Subjects,null,values);
        return s_id;
    }

    //Get All Timetables
    public List<Timetable> getAllTimeTables() {
        List<Timetable> timetables = new ArrayList<Timetable>();
        String selectQuery = "SELECT  * FROM " + Table_TimeTable;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Timetable td = new Timetable();
                td.setId(c.getInt((c.getColumnIndex(KEY_TT_ID))));
                td.setName((c.getString(c.getColumnIndex(KEY_TT_NAME))));
                td.setPass_percent(c.getFloat(c.getColumnIndex(KEY_TT_PASS_PERCENT)));

                // adding to todo list
                timetables.add(td);
            } while (c.moveToNext());
        }

        return timetables;
    }
}
