package com.example.androstore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Menu> menus= new ArrayList<>();

    public void setMenus(ArrayList<Menu> menus) {
        this.menus = menus;
    }

    public MenuAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return menus.size();
    }

    @Override
    public Object getItem(int i) {
        return menus.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemview = view;
        if(itemview==null){
            itemview = LayoutInflater.from(context).inflate(R.layout.item_menu, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(itemview);
        Menu menu= (Menu) getItem(i);
        viewHolder.bind(menu);
        return itemview;

    }

    private class ViewHolder{
        private TextView tvnama;
        private TextView tvDesc;
        private ImageView gambar;

        ViewHolder(View view){
            tvnama = view.findViewById(R.id.tv_menu);
            tvDesc = view.findViewById(R.id.tv_desc);
            gambar = view.findViewById(R.id.img_menu);
        }
        void bind(Menu menu){
            tvnama.setText(menu.getNama());
            tvDesc.setText(menu.getDeskripsi());
            gambar.setImageResource(menu.getGambar());

        }
    }
}
