package com.example.contentprovidertest01;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private Context context = InstrumentationRegistry.getTargetContext();
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.contentprovidertest01", appContext.getPackageName());
    }
    @Test
    public void calltest(){
        ContentResolver contentResolver = context.getContentResolver();
        ContentValues values = new ContentValues();
        values.put("name", "生命一号");
        values.put("address", "湖北");
        Uri uri = Uri.parse("content://com.example.contentprovidertest01.PersonContentProvider/person");
        contentResolver.insert(uri, values);
    }

    @Test
    public void delete(){
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = Uri.parse("content://com.example.contentprovidertest01.PersonContentProvider/person/2");
        contentResolver.delete(uri, null, null);
    }
    @Test
    public void update(){
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = Uri.parse("content://com.example.contentprovidertest01.PersonContentProvider/person/2");
        ContentValues values = new ContentValues();
        values.put("name", "李四");
        values.put("address", "上海");
        contentResolver.update(uri, values, null, null);
    }
    @Test
    public void updates(){
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = Uri.parse("content://com.example.contentprovidertest01.PersonContentProvider/person/student");
        ContentValues values = new ContentValues();
        values.put("name", "王五");
        values.put("address", "深圳");
        String where = "address = ?";
        String[] where_args = {"beijing"};
        contentResolver.update(uri, values, where, where_args);
    }
}
