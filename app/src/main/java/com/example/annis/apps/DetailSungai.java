package com.example.annis.apps;

import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.widget.DrawerLayout;
import com.squareup.picasso.Picasso;

public class DetailSungai extends AppCompatActivity {
TextView txtnama, txtlokasi, txtpanjang, txtluas, txthilir, txtkemiringan, txtpengelola;
ImageView imggambar;
ActionBar actionBar;
Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sungai);
        toolbar = (Toolbar)findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        actionBar.setDisplayHomeAsUpEnabled(true);

        txtnama = (TextView)findViewById(R.id.NamaSungai);
        txtlokasi = (TextView)findViewById(R.id.LokasiSungai);
        txtpanjang = (TextView)findViewById(R.id.PanjangSungai);
        txtluas = (TextView)findViewById(R.id.LuasSungai);
        txthilir = (TextView)findViewById(R.id.Hilir);
        txtkemiringan = (TextView)findViewById(R.id.Kemiringan);
        txtpengelola = (TextView)findViewById(R.id.Pengelola);
        imggambar = (ImageView)findViewById(R.id.Gambar);

        txtnama.setText(getIntent().getStringExtra("NamaSungai"));
        txtlokasi.setText(getIntent().getStringExtra("LokasiSungai"));
        txtpanjang.setText(getIntent().getStringExtra("PanjangSungai"));
        txtluas.setText(getIntent().getStringExtra("LuasSungai"));
        txthilir.setText(getIntent().getStringExtra("Hilir"));
        txtkemiringan.setText(getIntent().getStringExtra("Kemiringan"));
        txtpengelola.setText(getIntent().getStringExtra("Pengelola"));
        Picasso.with(this).load("http://simonir.com/foto/"+getIntent().getStringExtra("Gambar")).resize(150,150).into(imggambar);
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
