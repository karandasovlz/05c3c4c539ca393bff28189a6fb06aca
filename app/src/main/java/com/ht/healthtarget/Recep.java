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

import com.ht.healthtarget.R;

public class Recep extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recept_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        ImageButton btnZ = (ImageButton) findViewById(R.id.imageButton10);
        ImageButton btnOU = (ImageButton) findViewById(R.id.imageButton12);
        ImageButton btnP = (ImageButton) findViewById(R.id.imageButton11);
        //Button btnIz = (Button) findViewById(R.id.button6);
        View.OnClickListener oclBtn1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(Recep.this, Zavtr.class);
                startActivity(c);
            } };
        btnZ.setOnClickListener(oclBtn1);
        View.OnClickListener oclBtn2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(Recep.this, Obed.class);
                startActivity(c);
            } };
        btnOU.setOnClickListener(oclBtn2);
        View.OnClickListener oclBtn3 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(Recep.this, Perekus.class);
                startActivity(c);

            } };
        btnP.setOnClickListener(oclBtn3);
        /*View.OnClickListener oclBtn4 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            } };
        btnIz.setOnClickListener(oclBtn4);*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Context context = getApplicationContext();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        // if (id == R.id.action_settings) {
        //     return true;
        // }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            //Intent c= new Intent(this,Profile.class);
            //startActivity(c);
        } else if (id == R.id.nav_gallery) {
            Intent c = new Intent(this, Recep.class);
            startActivity(c);
        } else if (id == R.id.nav_slideshow) {
            //Intent c= new Intent(this, Math.class);
            //startActivity(c);

        }
        else if (id == R.id.nav_food_diary){Intent c = new Intent(this, Recep.class);
            startActivity(c);}
        else  if (id==R.id.nav_share){Intent c = new Intent(this, /*Qestioning_v2*/Anketa.class);
            startActivity(c);}
        else if (id==R.id.nav_send){Intent c = new Intent(this, SendMailDir.class);
            startActivity(c);}
        else if (id==R.id.nav_doc){Intent c = new Intent(this, SendMailDoc.class);
            startActivity(c);}


        //else if (id == R.id.nav_send) { }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
