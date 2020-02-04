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


public class SendMailDir extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

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
        setContentView(R.layout.activity_dir);
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
                    //num = "Пользватель не оставил информацию";
                    dialog = new Dialog(SendMailDir.this);
                    dialog.setTitle("");
                    dialog.setContentView(R.layout.dialog_view);
                    TextView text = (TextView) dialog.findViewById(R.id.dialogTextView);
                    text.setText("Пожалуйста заполните поле обратной связи");
                    dialog.show();
                }
                if(mail.getText().toString().contains("@"))
                {num = String.valueOf(mail.getText().toString());
                    SendMailDir.sender_mail_async async_sending = SendMailDir.this.new sender_mail_async((SendMailDir.sender_mail_async)null);
                    async_sending.execute(new Object[0]);}
                else{
                    dialog = new Dialog(SendMailDir.this);
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

        private sender_mail_async(SendMailDir.sender_mail_async sender_mail_async) {
        }

        protected void onPreExecute() {
            this.WaitingDialog = ProgressDialog.show(SendMailDir.this, "Отправка данных", "Отправляем сообщение...", true);
        }

        protected void onPostExecute(Boolean result) {
            this.WaitingDialog.dismiss();
            Toast.makeText(SendMailDir.this.mainContext, "Отправка завершена!!!", Toast.LENGTH_SHORT).show();
            ((Activity)SendMailDir.this.mainContext).finish();
            Intent c = new Intent(SendMailDir.this, MainActivity.class);
            startActivity(c);
        }


        protected Boolean doInBackground(Object... params) {

            try {
                SendMailDir.this.title = "Сообщение директору";
                SendMailDir.this.text = "Сообщение от: "
                        +((EditText)SendMailDir.this.findViewById(R.id.editText)).getText().toString()
                        +"\n"+"Контактные данные:"
                        +((EditText)SendMailDir.this.findViewById(R.id.editText2)).getText().toString()
                        +"\n\n"+((EditText)SendMailDir.this.findViewById(R.id.editText3)).getText().toString()
                        +"\n";
                SendMailDir.this.from = "app82226@gmail.com";
                SendMailDir.this.where = "kdl34@mail.ru";//;
                MailSenderClass sender = new MailSenderClass("app82226@gmail.com", "a44ZpZuWTLfS");
                sender.sendMail(SendMailDir.this.title, SendMailDir.this.text, SendMailDir.this.from, SendMailDir.this.where, SendMailDir.this.attach);
            } catch (Exception var3) {
                Toast.makeText(SendMailDir.this.mainContext, "Ошибка отправки сообщения!", Toast.LENGTH_LONG).show();
            }

            return false;
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


        }else if (id == R.id.nav_food_diary){Intent c = new Intent(this, FoodDiary.class);
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
