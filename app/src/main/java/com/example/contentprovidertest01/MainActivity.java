package com.example.contentprovidertest01;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        insert(this);
        query(this);
    }
    public void insert(Context context){
        ContentResolver contentResolver = context.getContentResolver();
        ContentValues values = new ContentValues();
        values.put("name", "生命一号");
        values.put("address", "湖北");
        Uri uri = Uri.parse("content://com.example.contentprovidertest01.PersonContentProvider/person");
        contentResolver.insert(uri, values);
    }
    public void query(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = Uri.parse("content://com.example.contentprovidertest01.PersonContentProvider/person");
        Cursor cursor = contentResolver.query(uri, null, null, null, null);
        while (cursor.moveToNext()) {
            Log.i("ExampleInstrumentedTest", "--->>" + cursor.getString(cursor.getColumnIndex("name")));
        }
        cursor.close();
    }

}
