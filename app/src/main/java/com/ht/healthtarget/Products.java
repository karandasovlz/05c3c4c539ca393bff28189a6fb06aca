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
import android.widget.Button;
import android.widget.TextView;

public class Products extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Button btn1;
    Button btn2;
    Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prod);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        btn1 = (Button)findViewById(R.id.button6);
        btn2 = (Button)findViewById(R.id.button7);
        btn3 = (Button)findViewById(R.id.button8);

        View.OnClickListener oclBtn1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.products_green);
                TextView tv1 = (TextView)findViewById(R.id.textView13);
                tv1.setText("●        Овощи, исключая картофель\n" +
                        "●        Цельнозерновые крупы: овсяная крупа (требующая варки 35-40 минут) или овсяные хлопья (требующие варки от 20 минут с надписью “Из цельного зерна”), гречка, булгур, нешлифованный рис, полба, киноа\n" +
                        "●        Чечевица, фасоль, бобы, горох, нут, соя\n" +
                        "●        Ягоды, листовая зелень\n" +
                        "●        Фрукты (если есть склонность к набору веса, то ограничьте 200 гр. в день)\n" +
                        "●        Уксус, горчица, обезжиренные приправы\n");
            } };
        btn1.setOnClickListener(oclBtn1);
        View.OnClickListener oclBtn2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.products_green);
                TextView tv1 = (TextView)findViewById(R.id.textView13);
                tv1.setText("●    Рыба и мясо птицы без кожи (курица, индейка) - не чаще 1 раза в день    \n" +
                        "●\tПостная вырезка говядины, баранины, свинины или телятины - оптимальное количество до 350 грамм в неделю. Хороший результат - не каждый день.\n" +
                        "●        Картофель, шлифованные крупы - до 250 грамм в день суммарно\n" +
                        "●        Цельнозерновые макаронные изделия и хлеб из цельнозерновой муки - до 200 грамм в день\n" +
                        "●        Кисломолочные продукты, творог со сниженным содержанием жира - до 200 грамм в день\n" +
                        "●        Яйца с желтком - 1 в день или 7 в неделю\n" +
                        "●        Оливковое и льняное масло, нетропические растительные масла, сливочное масло\n" +
                        "●        Несоленые и несладкие орехи - ежедневно. Для мужчин до 50 грамм, для женщин - 30 грамм\n");
            } };
        btn2.setOnClickListener(oclBtn2);
        View.OnClickListener oclBtn3 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.products_green);
                TextView tv1 = (TextView)findViewById(R.id.textView13);
                tv1.setText("●        Колбасы, салями, бекон, свиные ребрышки, хот-доги, мясные субпродукты\n" +
                        "●        Рафинированный хлеб, макаронные изделия из белой муки (в том числе твердых сортов), печенье, кукурузные хлопья, пирожные, кексы, пирожки, круассаны\n" +
                        "●        Сыр, сливки, цельное молоко и йогурт\n" +
                        "●        Трансжиры и маргарины, пальмовое, кокосовое масло, сало, кетчуп, майонез, сахар\n" +
                        "●        Сухофрукты, желе, варенье, консервированные фрукты, шербет, фруктовое мороженое, фруктовый сок\n" +
                        "●        Конфеты, мороженое, фруктоза, безалкогольные напитки\n" +
                        "●        Овощи, приготовленные с маслом или сливками\n");
            } };
        btn3.setOnClickListener(oclBtn3);

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
                       }
        else if (id == R.id.nav_food_diary){Intent c = new Intent(this, FoodDiary.class);
            startActivity(c);}
        else if (id == R.id.nav_products){Intent c = new Intent(this, Products.class);
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
