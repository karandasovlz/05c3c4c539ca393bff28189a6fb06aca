package com.ht.healthtarget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.ht.healthtarget.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Bad_result extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private final static String FILENAME2 = "2.txt";
    private final static String FILENAME = "anketa.txt";
    private final static String FILENAME1 = "1.txt";
    private final static String FILENAME3 = "cb.txt";
    EditText mail;
    ImageButton btn;
    String DATA;
    Context mainContext;
    String title;
    Dialog dialog;
    String text;
    String from;
    String where;
    final String LOG_TAG = "myLogs";
    String attach;
    String num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bad);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.mainContext = this;
        this.attach = "";
        mail=(EditText) findViewById(R.id.editText74);
        btn=(ImageButton) findViewById(R.id.imageButton8);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mail.getText().toString().isEmpty()) {
                    //num = "Пользватель не оставил информацию";
                    dialog = new Dialog(Bad_result.this);
                    dialog.setTitle("");
                    dialog.setContentView(R.layout.dialog_view);
                    TextView text = (TextView) dialog.findViewById(R.id.dialogTextView);
                    text.setText("Пожалуйста заполните поле обратной связи");
                    dialog.show();
                }
                if(mail.getText().toString().contains("@"))
                {num = String.valueOf(mail.getText().toString());
                    Bad_result.sender_mail_async async_sending = Bad_result.this.new sender_mail_async((Bad_result.sender_mail_async)null);
                    async_sending.execute(new Object[0]);}
                else{
                    dialog = new Dialog(Bad_result.this);
                    dialog.setTitle("");
                    dialog.setContentView(R.layout.dialog_view);
                    TextView text = (TextView) dialog.findViewById(R.id.dialogTextView);
                    text.setText("E-mail введен неверно");
                    dialog.show();

            }}
        });
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


        //else if (id == R.id.nav_send) { }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @SuppressLint("StaticFieldLeak")
    private class sender_mail_async extends AsyncTask<Object, String, Boolean> {
        ProgressDialog WaitingDialog;

        private sender_mail_async(sender_mail_async sender_mail_async) {
        }

        protected void onPreExecute() {
            this.WaitingDialog = ProgressDialog.show(Bad_result.this, "Отправка данных", "Отправляем сообщение...", true);
        }

        protected void onPostExecute(Boolean result) {
            this.WaitingDialog.dismiss();
            Toast.makeText(Bad_result.this.mainContext, "Отправка завершена! Ожидайте ответа специалиста на вашу почту.", Toast.LENGTH_SHORT).show();
            ((Activity)Bad_result.this.mainContext).finish();
            Intent c = new Intent(Bad_result.this, MainActivity.class);
            startActivity(c);
        }


        protected Boolean doInBackground(Object... params) {

load1();
            try {InputStream inputStream = openFileInput(FILENAME3);
                InputStreamReader isr = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(isr);
                String line;
                StringBuilder builder = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    builder.append(line + "\n");

                }

                inputStream.close();
                Bad_result.this.title = "test#";
                Bad_result.this.text = "Обратная связь:"
                        +((EditText)Bad_result.this.findViewById(R.id.editText74)).getText().toString()
                        +"\n"+builder+DATA;
                Bad_result.this.from = ((EditText)Bad_result.this.findViewById(R.id.editText74)).getText().toString();
                Bad_result.this.where = "app82226@gmail.com";
                MailSenderClass sender = new MailSenderClass("app82226@gmail.com", "a44ZpZuWTLfS");
                sender.sendMail(Bad_result.this.title, Bad_result.this.text, Bad_result.this.from, Bad_result.this.where, Bad_result.this.attach);
            } catch (Exception var3) {
                Toast.makeText(Bad_result.this.mainContext, "Ошибка отправки сообщения!", Toast.LENGTH_LONG).show();
            }

            return false;
        }

    }
    void load1(){
        try {
            InputStream inputStream = openFileInput(FILENAME2);

            if (inputStream != null) {
                InputStreamReader isr = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(isr);
                String line;
                StringBuilder builder1 = new StringBuilder();



                while ((line = reader.readLine()) != null) {
                    builder1.append(line + "\n");
                    DATA = String.valueOf(builder1);
                }

                inputStream.close();
            }
        } catch (Throwable t) {


        }
    }
}
