package com.example.stek3.childregistry;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.stek3.childregistry.code.child;
import com.example.stek3.childregistry.code.parent;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Stek3 on 22-Dec-17.
 */

public class db extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "uhif";

    // Contacts table name
    private static final String TABLE_CHILDREN = "child";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_FIRSTNAME = "firstname";
    private static final String KEY_LASTNAME = "lastname";
    private static final String KEY_MIDDLENAME = "middlename";
    private static final String KEY_DOB = "dob";

    public db(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    private boolean DataBaseExists(String path) {

        //check if database exists code here

        return true;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_CHILD_TABLE = "CREATE TABLE " + TABLE_CHILDREN + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_FIRSTNAME + " TEXT,"
                + KEY_LASTNAME + " TEXT," + KEY_MIDDLENAME + " TEXT," + KEY_DOB + " TEXT" + ")";

        String CREATE_PARENT_TABLE = "Create table [IF NOT EXISTS] Parents (id integer primary key, child_id integer, firstname text, lastname text, middlename text," +
                "FOREIGN KEY (child_id) REFERENCES " + TABLE_CHILDREN + " " + KEY_ID;

        //  db.execSQL("DROP TABLE" + TABLE_CHILDREN);

        db.execSQL(CREATE_CHILD_TABLE);
        db.execSQL(CREATE_PARENT_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHILDREN);

        // Create tables again
        onCreate(db);

    }

    public boolean AddParent(parent Parent) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_FIRSTNAME, Parent.getFirstName());
        values.put(KEY_LASTNAME, Parent.getLastName());
        values.put(KEY_MIDDLENAME, Parent.getMiddleName());

        //  values.put(KEY_DOB,Child.getDOB().toString());

        try {

//            if(!PatientExists(Child)) {
            db.insert("parents", null, values);
            db.close();
//
            return true;
//            }
//            else {
//
//                return false;
//            }
        } catch (Exception ex) {

            return false;
        }
    }

    public boolean AddChild(child Child) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_FIRSTNAME, Child.getFirstName());
        values.put(KEY_LASTNAME, Child.getLastName());
        values.put(KEY_MIDDLENAME, Child.getMiddleName());
        // values.put(KEY_DOB,Child.getDOB().toString());

        try {

//            if(!PatientExists(Child)) {
            db.insert(TABLE_CHILDREN, null, values);
            db.close();
//
            return true;
//            }
//            else {
//
//                return false;
//            }
        } catch (Exception ex) {

            return false;
        }
    }


    public boolean PatientExists(child Child) {

        String Query = "SELECT COUNT * FROM " + TABLE_CHILDREN + " WHERE " + KEY_FIRSTNAME + "=" + Child.getFirstName();
        String Count = null;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(Query, null);

        if (cursor.moveToFirst()) {

            Count = cursor.getString(0);
        }

        db.close();

        if (Integer.parseInt(Count) > 0) {

            return true;
        } else {

            return false;
        }


    }

    public List<child> getChildren() {

        List<child> ChildrenList = new ArrayList<child>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CHILDREN;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {

            do {
                child Child = new child();
                //Child.setID(Integer.parseInt(cursor.getString(0)));
                Child.setFirstName(cursor.getString(0));
                Child.setLastName(cursor.getString(1));
                // contact.setName(cursor.getString(1));
                //contact.setPhoneNumber(cursor.getString(2));
                // Adding contact to list

                ChildrenList.add(Child);

            }

            while (cursor.moveToNext());
        }

        db.close();

        return ChildrenList;

    }
}
