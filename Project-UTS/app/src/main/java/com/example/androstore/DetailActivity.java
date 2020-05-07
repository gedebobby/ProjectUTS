package com.example.androstore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {


    public static final String datanama="datanama";
    public static final String dataDeskripsi="datadeskripsi";
    public static final String datagambar="null";
    public static final String dataHarga="rupiah";
    public static final String dataBenefits="databenefits";
    public static final String dataImg="null";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView tvnama = findViewById(R.id.tv_nama);
        TextView tvDeskripsi = findViewById(R.id.tv_desc);
        ImageView imgGambar = findViewById(R.id.img_gambar);
        TextView harga = findViewById(R.id.tv_harga);
        TextView benefits = findViewById(R.id.tv_benefits);
        ImageView img = findViewById(R.id.img_gambar);


        tvnama.setText(getIntent().getStringExtra(datanama));
        tvDeskripsi.setText(getIntent().getStringExtra(dataDeskripsi));
        imgGambar.setImageResource(getIntent().getIntExtra(datagambar, 0));
        harga.setText(getIntent().getStringExtra(dataHarga));
        benefits.setText(getIntent().getStringExtra(dataBenefits));
        img.setImageResource(getIntent().getIntExtra(dataImg, 0));




    }
}
