package com.example.hp.intents;

import android.app.ListActivity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;


public class MainActivity2 extends ActionBarActivity {

 private  ListView list;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_activity2);
        fetchcontact();



  }


    private void fetchcontact() {
        list=(ListView)findViewById(R.id.listview1);
        ArrayList<String> contacts=new ArrayList<>();

        Uri uri= ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        String[] projection={ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER ,ContactsContract.CommonDataKinds.Phone._ID };
        String slection=null;
        String [] selctionargs=null;
        String sortshort=null;
        ContentResolver resolve=getContentResolver();
        Cursor  cursor=resolve.query(uri,projection,slection,selctionargs,sortshort);
        while (cursor.moveToNext())
        {
            String name=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String num=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            Log.i("cnt", "Name-" + name + "no-" + num);
            contacts.add(name+ "=" +num);



        }


               list.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,contacts));
    }


}


