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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class SendMailDoc extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    EditText mail;
    EditText text1;
    EditText text2;
    Button btn;
    Context mainContext;
    String title;
    String text;
    String from;
    String where;
    String attach;
    String num;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.mainContext = this;
        this.attach = "";
        mail=(EditText) findViewById(R.id.editText2);
        text1 = (EditText)findViewById(R.id.editText);
        text2 = (EditText)findViewById(R.id.editText3);
        btn=(Button) findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mail.getText().toString().isEmpty()) {
                    dialog = new Dialog(SendMailDoc.this);
                    dialog.setTitle("");
                    dialog.setContentView(R.layout.dialog_view);
                    TextView text = (TextView) dialog.findViewById(R.id.dialogTextView);
                    text.setText("Пожалуйста заполните поле обратной связи");
                    dialog.show();
                }
                if(mail.getText().toString().contains("@"))
                {num = String.valueOf(mail.getText().toString());
                    SendMailDoc.sender_mail_async async_sending = SendMailDoc.this.new sender_mail_async((SendMailDoc.sender_mail_async)null);
                    async_sending.execute(new Object[0]);}
                else{
                    dialog = new Dialog(SendMailDoc.this);
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

        Context context = getApplicationContext();

    }
    @SuppressLint("StaticFieldLeak")
    private class sender_mail_async extends AsyncTask<Object, String, Boolean> {
        ProgressDialog WaitingDialog;

        private sender_mail_async(SendMailDoc.sender_mail_async sender_mail_async) {
        }

        protected void onPreExecute() {
            this.WaitingDialog = ProgressDialog.show(SendMailDoc.this, "Отправка данных", "Отправляем сообщение...", true);
        }

        protected void onPostExecute(Boolean result) {
            this.WaitingDialog.dismiss();
            Toast.makeText(SendMailDoc.this.mainContext, "Отправка завершена!!!", Toast.LENGTH_SHORT).show();
            ((Activity)SendMailDoc.this.mainContext).finish();
            Intent c = new Intent(SendMailDoc.this, MainActivity.class);
            startActivity(c);
        }


        protected Boolean doInBackground(Object... params) {

            try {
                SendMailDoc.this.title = "Сообщение врачу";
                SendMailDoc.this.text = "Сообщение от: "
                        +((EditText)SendMailDoc.this.findViewById(R.id.editText)).getText().toString()
                        +"\n"+"Контактные данные:"
                        +((EditText)SendMailDoc.this.findViewById(R.id.editText2)).getText().toString()
                        +"\n\n"+((EditText)SendMailDoc.this.findViewById(R.id.editText3)).getText().toString()+
                        "\n";
                SendMailDoc.this.from = "app82226@gmail.com";
                SendMailDoc.this.where = "dewerutest@gmail.com";
                MailSenderClass sender = new MailSenderClass("app82226@gmail.com", "a44ZpZuWTLfS");
                sender.sendMail(SendMailDoc.this.title, SendMailDoc.this.text, SendMailDoc.this.from, SendMailDoc.this.where, SendMailDoc.this.attach);
            } catch (Exception var3) {
                Toast.makeText(SendMailDoc.this.mainContext, "Ошибка отправки сообщения!", Toast.LENGTH_LONG).show();
            }

            return false;
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
