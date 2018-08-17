package com.example.annis.apps;

import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.widget.DrawerLayout;
import com.squareup.picasso.Picasso;

public class DetailMonitoring extends AppCompatActivity {
    TextView txtnama2,txtketinggian, txtstatus, txtwaktu;
    ActionBar actionBar;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_monitoring);
        WebView web = (WebView) findViewById(R.id.web_view);
        WebSettings webSettings = web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        web.loadUrl("http://informatikapolines.com/anting/grafikandroid/grafikmonitoring.php");
        web.setWebViewClient(new WebViewClient());
        toolbar = (Toolbar)findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        actionBar.setDisplayHomeAsUpEnabled(true);

        txtnama2 = (TextView)findViewById(R.id.NamaSungai2);
        txtketinggian = (TextView)findViewById(R.id.Ketinggian);
        txtstatus = (TextView)findViewById(R.id.Status);
        txtwaktu = (TextView)findViewById(R.id.waktu);


        txtnama2.setText(getIntent().getStringExtra("NamaSungai"));
        txtketinggian.setText(getIntent().getStringExtra("Ketinggian"));
        txtstatus.setText(getIntent().getStringExtra("Status"));
        txtwaktu.setText(getIntent().getStringExtra("Waktu"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home)
            finish();

        return super.onOptionsItemSelected(item);
    }

}
