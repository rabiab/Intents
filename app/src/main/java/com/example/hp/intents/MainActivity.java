package com.example.hp.intents;

import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;

import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import static com.example.hp.intents.R.*;


public class MainActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

    }
    public void eButton(View v)
    {
        Intent email=new Intent();
       email.setAction(Intent.ACTION_SEND);
        email.setData(Uri.parse("mailto:"));
        String to[]={"ghulamshabbirranjha123@gmail.com"};
        email.putExtra(Intent.EXTRA_EMAIL,to);
        email.putExtra(Intent.EXTRA_SUBJECT,"email");
        email.putExtra(Intent.EXTRA_TEXT,"send");
        email.setType("message/rfc822");
        Intent choser= email.createChooser(email, "Send Email");
        startActivity(email);




    }
    public void contact(View v)
    {

        Intent start1= new Intent(MainActivity.this,MainActivity2.class);
        startActivity(start1);

    }

}


