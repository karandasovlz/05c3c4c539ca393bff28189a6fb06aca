package com.ht.healthtarget;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ImageButton btnHealth = (ImageButton) findViewById(R.id.imageButton4);
        ImageButton btnDiary = (ImageButton) findViewById(R.id.imageButton3);
        ImageButton btnProf = (ImageButton) findViewById(R.id.imageButton2);
        setSupportActionBar(toolbar);

        View.OnClickListener oclBtn1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            } };
        btnHealth.setOnClickListener(oclBtn1);
        View.OnClickListener oclBtn2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            } };
        btnDiary.setOnClickListener(oclBtn2);
        View.OnClickListener oclBtn3 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(MainActivity.this, Anketa.class);
                startActivity(c);

            } };
        btnProf.setOnClickListener(oclBtn3);




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


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
            Intent c = new Intent(MainActivity.this, Recep.class);
            startActivity(c);
        } else if (id == R.id.nav_slideshow) {


        }  else if (id==R.id.nav_food_diary){Intent c = new Intent(MainActivity.this, FoodDiary.class);
            startActivity(c);}
        else if (id==R.id.nav_products){Intent c = new Intent(this, Products.class);
            startActivity(c);}
        else  if (id==R.id.nav_share){Intent c = new Intent(MainActivity.this, Anketa.class);
            startActivity(c);}
        else if (id==R.id.nav_send){Intent c = new Intent(MainActivity.this, SendMailDir.class);
            startActivity(c);}
        else if (id==R.id.nav_doc){Intent c = new Intent(this, SendMailDoc.class);
            startActivity(c);}



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

     @Override
     public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("")
                .setMessage("Заркыть приложение?")
                .setPositiveButton("Да", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("Нет", null)
                .show();
    }
}
