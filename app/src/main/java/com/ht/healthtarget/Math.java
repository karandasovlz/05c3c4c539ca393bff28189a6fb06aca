package com.ht.healthtarget;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Math extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private final static String FILENAME = "anketa.txt";
    private final static String FILENAME1 = "1.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ImageButton btn2 = (ImageButton)findViewById(R.id.imageButton6);
        ImageButton btn=(ImageButton)findViewById(R.id.imageButton7);
        TextView web=(TextView) findViewById(R.id.textView18);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(Math.this, Web2.class);
                startActivity(c);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(Math.this, Anketa_dop.class);
                startActivity(c);
            }
        });
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(Math.this, Web1.class);
                startActivity(c);

            }
        });
       load1();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Context context = getApplicationContext();
    }

    void load1(){
        try {
            InputStream inputStream = openFileInput(FILENAME);

            if (inputStream != null) {
                InputStreamReader isr = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(isr);
                String line;
                StringBuilder builder = new StringBuilder();



                while ((line = reader.readLine()) != null) {
                    builder.append(line + "\n");

                }

                inputStream.close();
            }
        } catch (Throwable t) {
        }load2();
    }
    void load2(){
        try {
            InputStream inputStream = openFileInput(FILENAME1);

            if (inputStream != null) {
                InputStreamReader isr = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(isr);
                String line;
                StringBuilder builder = new StringBuilder();



                while ((line = reader.readLine()) != null) {
                    builder.append(line + "\n");

                }

                inputStream.close();
            }
        } catch (Throwable t) {

            Intent c = new Intent(this, Anketa.class);
            startActivity(c);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_camera) {

        } else if (id == R.id.nav_gallery) {
            Intent c = new Intent(this, Recep.class);
            startActivity(c);
        } else if (id == R.id.nav_slideshow) {


        }else if (id == R.id.nav_food_diary){Intent c = new Intent(this, Recep.class);
            startActivity(c);}
        else  if (id==R.id.nav_share){Intent c = new Intent(this, Anketa.class);
            startActivity(c);}
        else if (id==R.id.nav_send){Intent c = new Intent(this, SendMailDir.class);
            startActivity(c);}
        else if (id==R.id.nav_doc){Intent c = new Intent(this, SendMailDoc.class);
            startActivity(c);}

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
