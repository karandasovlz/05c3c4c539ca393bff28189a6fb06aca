package com.ht.healthtarget;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;



import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Anketa extends AppCompatActivity implements View.OnClickListener {


    public static final String NAME_PREFERENCES = "mysetting";

    SharedPreferences mSet;
    public static final String BOOL_1 = "checkboxset1";
    public EditText et1,et2,et3,et4;
    public Spinner spinner;
    public CheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9;
    public Button button;
    private final static String FILENAME = "anketa.txt";
    private final static String FILENAME1 = "1.txt";
    private final static String FILENAME3 = "cb.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_questioning);


        ImageButton btn1 = (ImageButton) findViewById(R.id.imageButton5);
        View.OnClickListener oclBtn1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list();

            } };
        btn1.setOnClickListener(oclBtn1);}
       void list() {setContentView(R.layout.anketa_v2);



        spinner = (Spinner)findViewById(R.id.spinner);

        et1=(EditText)findViewById(R.id.num1);
        et2=(EditText)findViewById(R.id.num2);
        et3=(EditText)findViewById(R.id.num3);
        et4=(EditText)findViewById(R.id.num4);


        cb1=(CheckBox)findViewById(R.id.cb1);
        cb2=(CheckBox)findViewById(R.id.cb2);
        cb3=(CheckBox)findViewById(R.id.cb3);
        cb4=(CheckBox)findViewById(R.id.cb4);
        cb5=(CheckBox)findViewById(R.id.cb5);
        cb6=(CheckBox)findViewById(R.id.cb6);
        cb7=(CheckBox)findViewById(R.id.cb7);
        cb8=(CheckBox)findViewById(R.id.cb8);
        cb9=(CheckBox)findViewById(R.id.cb9);
        button=(Button )findViewById(R.id.butt);

        Resources res = getResources();
        final TypedArray selectedValues = res.obtainTypedArray(R.array.pol2);
        mSet = getSharedPreferences(NAME_PREFERENCES, Context.MODE_PRIVATE);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                int selectedValue = selectedValues.getInt(position, -1);
                Log.d("demo", " = " + selectedValue);
                return;
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });
        SharedPreferences.Editor editor = getPreferences(0).edit();
        int selectedPosition = spinner.getSelectedItemPosition();
        editor.putInt("spinnerSelection", selectedPosition);
        editor.apply();


        if(mSet.contains(BOOL_1)){cb1.setChecked(mSet.getBoolean(BOOL_1, false));}
        if(mSet.contains(BOOL_1)){cb2.setChecked(mSet.getBoolean(BOOL_1, false));}
        if(mSet.contains(BOOL_1)){cb3.setChecked(mSet.getBoolean(BOOL_1, false));}
        if(mSet.contains(BOOL_1)){cb4.setChecked(mSet.getBoolean(BOOL_1, false));}
        if(mSet.contains(BOOL_1)){cb5.setChecked(mSet.getBoolean(BOOL_1, false));}
        if(mSet.contains(BOOL_1)){cb6.setChecked(mSet.getBoolean(BOOL_1, false));}
        if(mSet.contains(BOOL_1)){cb7.setChecked(mSet.getBoolean(BOOL_1, false));}
        if(mSet.contains(BOOL_1)){cb8.setChecked(mSet.getBoolean(BOOL_1, false));}
        if(mSet.contains(BOOL_1)){cb9.setChecked(mSet.getBoolean(BOOL_1, false));}
        button.setOnClickListener(this);


    }
    public void saveCB(String FILENAME3)  {
        float num1,num2,num3,num4;

        if(et1.getText().toString().isEmpty()) {
            num1= 0;
        }else {num1 = Float.parseFloat(et1.getText().toString());}
        if(et2.getText().toString().isEmpty()) {
            num2= 0;
        }else { num2 = Float.parseFloat(et2.getText().toString());}
        if(et3.getText().toString().isEmpty()) {
            num3= 0;
        }else { num3 = Float.parseFloat(et3.getText().toString());}
        if(et4.getText().toString().isEmpty()) {
            num4= 0;
        }else { num4 = Float.parseFloat(et4.getText().toString());}
        spinner = (Spinner)findViewById(R.id.spinner);
        String text = spinner.getSelectedItem().toString();
        try {
            OutputStream outputStream = openFileOutput(FILENAME3, 0);

        OutputStreamWriter osw = new OutputStreamWriter(outputStream);
        osw.write("Возраст: "+num1+"\n");
        osw.write("Вес в кг: "+num2+"\n");
        osw.write("Рост в см: "+num3+"\n");
        osw.write("Окружность талии в см: "+num4+"\n");

        if (text.equals("Мужской")){osw.write("Пол мужской\n");}
        else {osw.write("Пол женский\n");}

        if(cb1.isChecked())osw.write("Был инфаркт\n");
        if(cb2.isChecked())osw.write("Был инсульт\n");
        if(cb3.isChecked())osw.write("Было стентирование/аорто-коронарное шунтирование\n");
        if(cb4.isChecked())osw.write("Есть стенокардия\n");
        if(cb5.isChecked())osw.write("Есть бляшки в сосудах\n");
        if(cb6.isChecked())osw.write("Есть облитерирующий атеросклероз артерий\n");
        if(cb7.isChecked())osw.write("Есть сахарный диабет\n");
        if(cb8.isChecked())osw.write("Бывает давление в покое 180/110\n");
        if(cb9.isChecked())osw.write("Курит\n");
        osw.close();}
        catch (Throwable t) {
            Toast.makeText(getApplicationContext(),
                    "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void onClick(View v){
    saveFile(FILENAME);
    spinner1(FILENAME1);
    saveCB(FILENAME3);
        Intent c = new Intent(Anketa.this, Math.class);
        startActivity(c);
    }


    private void saveFile(String FILENAME) {

        float num1=0,num2=0,num3=0,num4=0;
        float result=0,result1=0,result2=0,result3=0,result4=0;
        double k1=0.01;

        EditText et1=(EditText)findViewById(R.id.num1);
        EditText et2=(EditText)findViewById(R.id.num2);
        EditText et3=(EditText)findViewById(R.id.num3);
        EditText et4=(EditText)findViewById(R.id.num4);

        if(et1.getText().toString().isEmpty()) {
            num1=0;
        }else {num1=Float.parseFloat(et1.getText().toString());}
        if(et2.getText().toString().isEmpty()) {
           num2=0;
        }else {num2=Float.parseFloat(et2.getText().toString());}
        if(et3.getText().toString().isEmpty()) {
            num3=0;
        }else {num3=Float.parseFloat(et3.getText().toString());}
        if(et4.getText().toString().isEmpty()) {
           num4= 0;
        }else {num4=Float.parseFloat(et4.getText().toString());}



        //1
        result= (float) (num2/((num3*k1)*(num3*k1)));
        String rc1 = String.valueOf(result);
        try {

            OutputStream outputStream = openFileOutput(FILENAME, 0);
            OutputStreamWriter osw = new OutputStreamWriter(outputStream);
            osw.write(rc1);
            osw.close();

        } catch (Throwable t) {
            Toast.makeText(getApplicationContext(),
                    "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }
    }


    void spinner1(String FILENAME1){



        double a1=144, a2=141, res;
        double b1=0.7, b2=0.9;
        double c11=-0.329,c12=-1.209, c21=-0.411;
        double rec=0;
        double num;
        double kt=0;
        EditText et=(EditText)findViewById(R.id.numEX50);

        /*if(et.getText().toString().isEmpty()) {
            kt= 0.0;
        }else {kt=Double.parseDouble(et.getText().toString());}*/
        EditText et1=(EditText)findViewById(R.id.num1);
        if(et1.getText().toString().isEmpty()) {
           num = 0;
        }else{num=Double.parseDouble(et1.getText().toString());}
        //int kt= Integer.parseInt(String.valueOf(et));



        spinner = (Spinner)findViewById(R.id.spinner);
        String text = spinner.getSelectedItem().toString();
        if (text.equals("Мужской")){
            if (kt<7){
                rec=(a2*(kt/b2)*c21*0.993*num);
            }
        }
        else {
            rec=(a2*(kt/b2)*c12*0.993*num);

        }
        if (text.equals("Женский")){
            if (kt>7){rec=(a1*(kt/b1)*c12*0.993*num);}
        }
        else {rec=(a1*(kt/b1)*c11*0.993*num);

        }

        try {

            OutputStream outputStream = openFileOutput(FILENAME1, 0);
            OutputStreamWriter osw = new OutputStreamWriter(outputStream);
            String rc = String.valueOf(rec);
            osw.write(rc);
            osw.close();

        } catch (Throwable t) {
            Toast.makeText(getApplicationContext(),
                    "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }

    }
}
