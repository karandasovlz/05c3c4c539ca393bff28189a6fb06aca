package com.ht.healthtarget;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.ht.healthtarget.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Profile extends AppCompatActivity {

    private final static String FILENAME2 = "2.txt";

    TextView tv;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        tv = (TextView)findViewById(R.id.textView8) ;
        ImageButton ib = (ImageButton) findViewById(R.id.imageButton);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(Profile.this, MainActivity.class);
                startActivity(c);
            }
        });
        load1();
    }
    void load1(){
        try {
            InputStream inputStream = openFileInput(FILENAME2);

            if (inputStream != null) {
                InputStreamReader isr = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(isr);
                String line;
                StringBuilder builder = new StringBuilder();



                while ((line = reader.readLine()) != null) {
                    builder.append(line + "\n");

                }

                inputStream.close();
                tv.setText(builder.toString());
            }
        } catch (Throwable t) {

            Intent c = new Intent(this, Anketa.class);
            startActivity(c);
        }
    }


}
