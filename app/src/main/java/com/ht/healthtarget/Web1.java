package com.ht.healthtarget;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;

import com.ht.healthtarget.R;

public class Web1 extends AppCompatActivity {
    private WebView webView;
    ImageButton ib;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web1);

        ib = findViewById(R.id.imageButton14);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(Web1.this, Math.class);
                startActivity(c);

            }
        });
        webView = findViewById(R.id.webView);
        // включаем поддержку JavaScript
        webView.getSettings().setJavaScriptEnabled(true);
        // указываем страницу загрузки
        webView.loadUrl("https://blog.kdl.ru/vse-chto-vy-hoteli-znat-o-holesterine-no-boyalis-sprosit/");
    }

}
