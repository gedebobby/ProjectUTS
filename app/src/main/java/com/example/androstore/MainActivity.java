package com.example.androstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //private String [] dataSepatu={"Nike Venom","Nike Tiempo", "Nike Mercurial", "Adidas Predator", "Adidas X"};
    private MenuAdapter adapter;
    private String[] dataNama;
    private String[] dataDeskripsi;
    private String[] dataHarga;
    private String[] dataBenefits;
    private TypedArray dataImg;
    private TypedArray dataGambar;
    private ArrayList<Menu> menus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvlist= findViewById(R.id.lv_list);
        adapter = new MenuAdapter(this);

        lvlist.setAdapter(adapter);
        prepare();
        tambahitem();

        lvlist.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent pindahdata = new Intent(MainActivity.this, DetailActivity.class);
                pindahdata.putExtra(DetailActivity.datanama, menus.get(i).getNama());
                pindahdata.putExtra(DetailActivity.dataDeskripsi, menus.get(i).getDeskripsi());
                pindahdata.putExtra(DetailActivity.datagambar, menus.get(i).getGambar());
                pindahdata.putExtra(DetailActivity.dataHarga, menus.get(i).getHarga());
                pindahdata.putExtra(DetailActivity.dataBenefits, menus.get(i).getBenefits());
                pindahdata.putExtra(DetailActivity.dataImg, menus.get(i).getImg());
                startActivity(pindahdata);

            }
        });
    }

    private void prepare(){
        dataNama = getResources().getStringArray(R.array.data_sepatu);
        dataDeskripsi = getResources().getStringArray(R.array.data_deskripsi);
        dataGambar = getResources().obtainTypedArray(R.array.data_gambar);
        dataHarga = getResources().getStringArray(R.array.data_harga);
        dataBenefits = getResources().getStringArray(R.array.data_benefits);
        dataImg = getResources().obtainTypedArray(R.array.data_gambar2);
    }

    private void tambahitem(){
        menus = new ArrayList<>();

        for(int i=0; i <dataNama.length;i++){
            Menu menu = new Menu();
            menu.setGambar(dataGambar.getResourceId(i, -1));
            menu.setNama(dataNama[i]);
            menu.setDeskripsi(dataDeskripsi[i]);
            menu.setHarga(dataHarga[i]);
            menu.setBenefits(dataBenefits[i]);
            menu.setImg(dataImg.getResourceId(i, -1));
            menus.add(menu);
        }
        adapter.setMenus(menus);
    }

}
