package com.example.mybrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    WebView webview;
    Button btnGo;
    EditText txtAddres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtAddres=findViewById(R.id.address);

        webview=findViewById(R.id.webview);
        webview.setWebViewClient(new WebViewClient());

        if (getIntent() != null && getIntent().getData() != null){
            txtAddres.setText(getIntent().getData().toString());
            webview.loadUrl(getIntent().getData().toString());
        }


        btnGo=findViewById(R.id.btnGo);


        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webview.loadUrl("http://" +txtAddres.getText());
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

}