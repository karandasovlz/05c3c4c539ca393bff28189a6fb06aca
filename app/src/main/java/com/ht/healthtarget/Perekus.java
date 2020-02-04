package com.ht.healthtarget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ht.healthtarget.R;

public class Perekus extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rec_obeduzhin);
        String[] colors = {"17. Тост с овощами",
                "18. Банановые маффины",
                "19. Сельдерей с арахисовым маслом",
                "20. Груша с зеленым чаем",
                "21. Мандарины",
                "22. Сливы с чаем",
                "23. Грейпфрут (не рекомендуется людям, которые принимают статины или варфарин)",
                "24. Банан с зеленым чаем",
                "25. Яблоки",
                "26. Черешня",
                "27. Груша с орехом",
                "28. Печеное яблоко",
                "29. Салат из яблока с отварной свеклой",
                "30. Салат из помидоров и огурцов с хлебом",
                "31. Яйцо с помидором и петрушкой",
                "32. Морковно-яблочное пюре",
                "33.  Овощное пюре с хлебцами",
        "34. Яблочный крамбл"};



        setContentView(R.layout.res_perekus);

        // Связываемся с ListView
        ListView list3 = (ListView) findViewById(R.id.list2);

        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, colors);

        // устанавливаем адаптер списку
        list3.setAdapter(adapter);
        list3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // Toast.makeText(getApplicationContext(), "itemClick: position = " +
               //                 position + ", id = " + id + ", " + parent.getAdapter().getItem(position),
               //         Toast.LENGTH_SHORT).show();
                if(position==0){
                    setContentView(R.layout.recept_data);
                    TextView textView = findViewById(R.id.textViewr);
                    textView.setText("17.  Тост с овощами\n" +
                            " \n" +
                            "Ингредиенты\n" +
                            "Цельнозерновой тост или хлеб\n" +
                            "20 г салата листового\n" +
                            "30 г помидора\n" +
                            "30 г огурца\n" +
                            "30 г сыра рикотта (или любого твердого)\n" +
                            "5 г свежего базилика\n" +
                            "1 стакан зеленого чая или кофе\n" +
                            " \n" +
                            "Приготовление\n" +
                            "Тост подсушите в печи в течение 1-2 минут.\n" +
                            "Овощи нарежьте пластинками, лук - кольцами. Намажьте тост рикоттой (или положите тонкую пластинку твердого сыра), выложите на него лист салата,  сверху - томат,\n" +
                            "огурец. Украсьте свежим базиликом.\n");
                    textView . setMovementMethod ( new ScrollingMovementMethod());
                }
                if(position==1){
                    setContentView(R.layout.recept_data);
                    TextView textView = findViewById(R.id.textViewr);
                    textView.setText("18.  Банановые маффины\n" +
                            " \n" +
                            "Ингредиенты\n" +
                            " \n" +
                            "2 стакана овсяных хлопьев – нежнее получаются из тех, что не требуют варки\n" +
                            "3 банана\n" +
                            "2 яйца или 2 ст.л молотых семян льна, заваренных 2 ст.л кипятка\n" +
                            "¾ очищенных фиников\n" +
                            "Молотая корица (щепотка)\n" +
                            "50 г темного натурального шоколада без сахара и сахарозаменителей\n" +
                            " \n" +
                            "Приготовление\n" +
                            " \n" +
                            "Разогрейте духовку до 180С.\n" +
                            "Смешайте в блендере или кухонном комбайне все ингредиенты (кроме шоколада) до полностью однородного состояния.\n" +
                            "Порубите мелко ножом шоколад до состояния крошки.\n" +
                            "Перелейте тесто в формочки для маффинов. Посыпьте шоколадом.\n" +
                            "Выпекайте маффины 15-20 минут до готовности. Проверяйте готовность с помощью ножа или зубочистки, она должна быть сухой, когда проткнете маффин.\n" +
                            " \n" +
                            " \n");
                    textView . setMovementMethod ( new ScrollingMovementMethod());
                }
                if(position==2){
                    setContentView(R.layout.recept_data);
                    TextView textView = findViewById(R.id.textViewr);
                    textView.setText("19.  Сельдерей с арахисовым маслом\n" +
                            " \n" +
                            "Ингредиенты\n" +
                            "100 г сельдерея                 \t\n" +
                            "2 ст. л. арахисового масла  \n" +
                            " \n" +
                            "Приготовление\n" +
                            "Нарезать сельдерей на тонкие полоски.\n" +
                            "Добавить ореховое   масло.\n");
                    textView . setMovementMethod ( new ScrollingMovementMethod());
                }
                if(position==3){
                    setContentView(R.layout.recept_data);
                    TextView textView = findViewById(R.id.textViewr);
                    textView.setText("20.  Груша с зеленым чаем\n" +
                            " \n" +
                            "100 г груши\n" +
                            "1 стакан зеленого чая\n" +
                            "Грушу нарезать на кусочки.\n");
                    textView . setMovementMethod ( new ScrollingMovementMethod());
                }
                if(position==4){
                    setContentView(R.layout.recept_data);
                    TextView textView = findViewById(R.id.textViewr);
                    textView.setText("21.  Мандарины\n" +
                            " \n" +
                            "2 мандарина\n");
                    textView . setMovementMethod ( new ScrollingMovementMethod());
                }
                if(position==5){
                    setContentView(R.layout.recept_data);
                    TextView textView = findViewById(R.id.textViewr);
                    textView.setText("22.  Сливы с чаем\n" +
                            " \n" +
                            "5 крупных слив\n" +
                            "1 стакан черного или зеленого чая\n");
                    textView . setMovementMethod ( new ScrollingMovementMethod());
                }
                if(position==6){
                    setContentView(R.layout.recept_data);
                    TextView textView = findViewById(R.id.textViewr);
                    textView.setText("23. Грейпфрут (не рекомендуется людям, которые принимают статины или варфарин)\n" +
                            " \n" +
                            "1 грейпфрут\n");
                    textView . setMovementMethod ( new ScrollingMovementMethod());
                }
                if(position==7){
                    setContentView(R.layout.recept_data);
                    TextView textView = findViewById(R.id.textViewr);
                    textView.setText("24.   Банан с зеленым чаем\n" +
                            " \n" +
                            "1 банан\n" +
                            "1 зеленый чай\n");
                    textView . setMovementMethod ( new ScrollingMovementMethod());
                }
                if(position==8){
                    setContentView(R.layout.recept_data);
                    TextView textView = findViewById(R.id.textViewr);
                    textView.setText("25. Яблоки\n" +
                            " \n" +
                            "2 яблока\n");
                    textView . setMovementMethod ( new ScrollingMovementMethod());
                }
                if(position==9){
                    setContentView(R.layout.recept_data);
                    TextView textView = findViewById(R.id.textViewr);
                    textView.setText("26.   Черешня\n" +
                            " \n" +
                            "150 грамм черешни с кофе\n");
                    textView . setMovementMethod ( new ScrollingMovementMethod());
                }
                if(position==10){
                    setContentView(R.layout.recept_data);
                    TextView textView = findViewById(R.id.textViewr);
                    textView.setText("27.   Груша с орехом\n" +
                            " \n" +
                            "1 твердая груша\n" +
                            "2 грецких ореха\n");
                    textView . setMovementMethod ( new ScrollingMovementMethod());
                }
                if(position==11){
                    setContentView(R.layout.recept_data);
                    TextView textView = findViewById(R.id.textViewr);
                    textView.setText("28.  Печеное яблоко\n" +
                            "Ингредиенты\n" +
                            "1 я6локо     \t\n" +
                            "5 г корицы \t\n" +
                            "Приготовление\n" +
                            "Яблоко помыть, удалить сердцевину.\n" +
                            "Запекать 10 минут при температуре 170 градусов или 5-6 минут в микроволновке на максимальной мощности. Вынимать нужно, когда растрескается кожица.\n" +
                            "Посыпать корицей. Сахар не добавлять.\n");
                    textView . setMovementMethod ( new ScrollingMovementMethod());
                }
                if(position==12){
                    setContentView(R.layout.recept_data);
                    TextView textView = findViewById(R.id.textViewr);
                    textView.setText("29.  Салат из яблока с отварной свеклой\n" +
                            " \n" +
                            "Ингредиенты\n" +
                            "100 г яблока                         \t\n" +
                            "50 г свеклы\n" +
                            " \n" +
                            "Приготовление\n" +
                            "Яблоко порезать тонкой соломкой.      \t\n" +
                            "Отварить свеклу и порезать соломкой.\n" +
                            "Смешать.\n");
                    textView . setMovementMethod ( new ScrollingMovementMethod());
                }
                if(position==13){
                    setContentView(R.layout.recept_data);
                    TextView textView = findViewById(R.id.textViewr);
                    textView.setText("30.  Салат из помидоров и огурцов с хлебом\n" +
                            " \n" +
                            "Ингредиенты\n" +
                            "200 г салата (помидоры, огурцы)\n" +
                            "Хлеб из цельнозерновой муки\n" +
                            " \n" +
                            "Приготовление\n" +
                            "Порезать помидоры и огурцы.\n");
                    textView . setMovementMethod ( new ScrollingMovementMethod());
                }
                if(position==14){
                    setContentView(R.layout.recept_data);
                    TextView textView = findViewById(R.id.textViewr);
                    textView.setText("31.  Яйцо с помидором и петрушкой\n" +
                            " \n" +
                            "Ингредиенты\n" +
                            "1 яйцо                              \t\n" +
                            "100 г томатов                  \t\n" +
                            "30 г свежей зелени\n" +
                            " \n" +
                            "Приготовление\n" +
                            "Яйцо отварите (10 минут). Мелко порезать и перемешать с порезанным томатом и зеленью.\n");
                    textView . setMovementMethod ( new ScrollingMovementMethod());
                }
                if(position==15){
                    setContentView(R.layout.recept_data);
                    TextView textView = findViewById(R.id.textViewr);
                    textView.setText("32.  Морковно-яблочное пюре\n" +
                            " \n" +
                            "Ингредиенты\n" +
                            " \n" +
                            "2 яблока\n" +
                            "100 г моркови\n" +
                            " \n" +
                            "Приготовление\n" +
                            "Продукты очистите, запеките, пюрируйте в блендере или при помощи сита.\n");
                    textView . setMovementMethod ( new ScrollingMovementMethod());
                }
                if(position==16){
                    setContentView(R.layout.recept_data);
                    TextView textView = findViewById(R.id.textViewr);
                    textView.setText("33.  Овощное пюре с хлебцами\n" +
                            "Ингредиенты\n" +
                            "150 г овощного пюре (брокколи, цветная капуста, морковь)\n" +
                            "Хлебцы цельнозерновые или цельнозерновой хлеб\n" +
                            "Приготовление\n" +
                            "Овощи отварите и разбейте в блендере.\n");
                    textView . setMovementMethod ( new ScrollingMovementMethod());
                }
                if(position==17){
                    setContentView(R.layout.recept_data);
                    TextView textView = findViewById(R.id.textViewr);
                    textView.setText("34.  Яблочный крамбл\n" +
                            "Ингредиенты\n" +
                            "1/2 стакана очищенных грецких орехов\n" +
                            "2 шт. фиников без косточек\n" +
                            "3 яблока\n" +
                            "1 ст.л. лимонного сока\n" +
                            "Для соуса\n" +
                            "2 яблока\n" +
                            "2 ст.л. лимонного сока\n" +
                            "5 шт. фиников без косточек\n" +
                            "¼ стакана изюма\n" +
                            "¼ ч.л. корицы\n" +
                            "¼ ч.л. мускатного ореха\n" +
                            " \n" +
                            "Приготовление\n" +
                            "Смешайте грецкие орехи и финики в кухонном комбайне до текстуры, похожей на виноградные косточки. Переложите в небольшую миску и отставьте в сторону.\n" +
                            "В миске перемешайте 3 очищенных и нарезанных кубиками яблока с 1 столовой ложкой лимонного сока и отставьте в сторону.\n" +
                            "В кухонном комбайне смешайте все ингредиенты для соуса: 2 яблока, 2 столовые ложки лимонного сока, 5 фиников без косточек, изюм, корицу, мускатный орех.\n" +
                            "Добавьте эту смесь к нарезанным яблокам. Разделите полученную массу на 4 креманки посыпьте сверху орехово-финиковой крошкой.\n");
                    textView . setMovementMethod ( new ScrollingMovementMethod());
                }
            }
        });

    }

}
