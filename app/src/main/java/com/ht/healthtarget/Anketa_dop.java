package com.ht.healthtarget;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Anketa_dop extends AppCompatActivity implements View.OnClickListener {


    private final static String FILENAME2 = "2.txt";
    private final static String FILENAME3 = "cb.txt";

    public EditText et1,et2,et3,et4,et5,et6,et7,et8,et9,et10,et11,et12,et13;

    Button buttt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anketa_v2dop);

        //вопросы
        //et1=(EditText)findViewById(R.id.num10);
        //et2=(EditText)findViewById(R.id.num20);
        //et3=(EditText)findViewById(R.id.num30);
        et4=(EditText)findViewById(R.id.numEX50);//Общий холестерин
        et5= (EditText)findViewById(R.id.numEX51);//ЛПОНП
        //et6= (EditText)findViewById(R.id.numEX52);
        et7= (EditText)findViewById(R.id.numEX53);//Триглицериды
        et8= (EditText)findViewById(R.id.numEX54);//Холестерин-ЛПВП
        //et9= (EditText)findViewById(R.id.numEX55);
        et10=(EditText)findViewById(R.id.numEX56);//Холестерин-ЛПНП
        et11=(EditText)findViewById(R.id.numEX57);//Коэффициент атерогенности
        //et12=(EditText)findViewById(R.id.numEX58);
        //et13=(EditText)findViewById(R.id.numEX59);
        buttt=(Button)findViewById(R.id.butttt);
        buttt.setOnClickListener(this);


    }
    @Override
    public void onClick(View v){
        writerData(FILENAME3);

    }

void writerData(String FILENAME3){


    double num4,num5,num7,num8,num10,num11;
    int perlamutrus = 0;

    if(et4.getText().toString().isEmpty()) {
        num4=0.0;
    }else {num4 = Float.parseFloat(et4.getText().toString());}
    if(et5.getText().toString().isEmpty()) {
        num5=0.0;
    }else {num5 = Float.parseFloat(et5.getText().toString());}

    if(et7.getText().toString().isEmpty()) {
        num7=0.0;
    }else{
    num7 = Float.parseFloat(et7.getText().toString());}
    if(et8.getText().toString().isEmpty()) {
        num8=0.0;
    }else {
    num8 = Float.parseFloat(et8.getText().toString());}

    if(et10.getText().toString().isEmpty()) {
        num10=0.0;
    }else {
    num10 = Float.parseFloat(et10.getText().toString());}
    if(et11.getText().toString().isEmpty()) {
        num11=0.0;
    }else{
        num11 = Float.parseFloat(et11.getText().toString());}

    try {

        OutputStream outputStream = openFileOutput(FILENAME2, 0);
        OutputStreamWriter osw = new OutputStreamWriter(outputStream);

        if(num4>6.2){perlamutrus=1;}osw.write("Холестерин"+num4+"\n");

        if(num5<0.16|num5>0.85){perlamutrus=1;}osw.write("ЛЛОНП"+num5+"\n");

        if(num7>2.26){perlamutrus=1;}osw.write("Триглицериды"+num7+"\n");
        if(num8<1.03){perlamutrus=1;}osw.write("Холестерин лпвп"+num8+"\n");

        if(num10>4){perlamutrus=1;}osw.write("Холестерин лпнп"+num10+"\n");
        if(num11<1|num11>3.5){perlamutrus=1;}osw.write("Коэффициент атерогенности"+num11+"\n");

        osw.close();

        if(perlamutrus==1){Intent c = new Intent(Anketa_dop.this, Bad_result.class);
            startActivity(c);}
        else {Intent c = new Intent(Anketa_dop.this, Norm_result.class);
            startActivity(c);}

    } catch (Throwable t) {
        Toast.makeText(getApplicationContext(),
                "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
    }

}

}
