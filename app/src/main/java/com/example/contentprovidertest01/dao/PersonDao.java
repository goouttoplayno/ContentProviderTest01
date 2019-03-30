package com.example.contentprovidertest01.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.contentprovidertest01.db.DBHelper;

public class PersonDao {
    private DBHelper dbHelper = null;

    public PersonDao(Context context) {
        dbHelper = new DBHelper(context);
    }

    //插入操作，返回long类型的插入当前行的行号
    public long insertPerson(ContentValues values) {
        long id = -1;
        SQLiteDatabase database = null;
        try {
            database = dbHelper.getWritableDatabase();
            id = database.insert("person", null, values);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (database != null) {
                database.close();
            }
        }
        return id;
    }

    //返回受影响的行数
    public int deletePerson(String whereClause, String[] whereArgs) {
        int count = -1;
        SQLiteDatabase database = null;
        try {
            database = dbHelper.getWritableDatabase();
            count = database.delete("person", whereClause, whereArgs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (database != null) {
                database.close();
            }
        }
        return count;
    }

    //
    public int updatePerson(ContentValues values, String whereClause, String[] whereArgs) {
        int count = -1;
        SQLiteDatabase database = null;
        try {
            database = dbHelper.getWritableDatabase();
            count = database.update("person", values, whereClause, whereArgs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (database != null) {
                database.close();
            }
        }
        return count;
    }

    //
    public Cursor queryPersons(String selection, String[] selectionArgs) {
        SQLiteDatabase database = null;
        Cursor cursor = null;
        try {
            database = dbHelper.getReadableDatabase();
            cursor = database.query(true, "person", null, selection, selectionArgs, null, null, null, null);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (database != null) {
                database.close();
            }
        }
        return cursor;
    }
}
