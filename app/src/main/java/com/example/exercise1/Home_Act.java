package com.example.exercise1;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.SearchView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.example.exercise1.LihatData;
import com.example.exercise1.ListViewAdapter;

import java.util.ArrayList;
import java.util.Collection;

public class Home_Act extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener, SearchView.OnQueryTextListener{
    private ListView list;
    private ListViewAdapter adapter;
    private SearchView search;
    String nama;
    String[] listNama;

    public static ArrayList<com.example.exercise1.Kelas_Nama> classNamaArrayList = new ArrayList<Kelas_Nama>();
    Bundle bundle = new Bundle();
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
        setContentView(R.layout.datakontak);
        SearchView search = findViewById(R.id.idsearch);

        listNama = new String[]{"Renjun", "Jeno", "Jaemin",
                "Chenle", "Jisung", "Haechan", "Mark", "Juki", "Jeki", "Sungsung"};

        list = findViewById(R.id.listKontak);

        classNamaArrayList = new ArrayList<>();

        int x = 0;
        while (true) {
            String[] strArray = listNama;
            if (x < strArray.length) {
                classNamaArrayList.add(new Kelas_Nama(strArray[x]));
                x++;
            } else {
                ListViewAdapter listAdapter = new ListViewAdapter(this);
                adapter = listAdapter;
                list.setAdapter(listAdapter);
                search = search;
                search.setOnQueryTextListener(this);

                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        nama = classNamaArrayList.get(position).getNama();
                        bundle.putString("b", nama.trim());

                        PopupMenu pm = new PopupMenu(getApplicationContext(), view);
                        pm.setOnMenuItemClickListener(Home_Act.this);
                        pm.inflate(R.menu.menu_popup);
                        pm.show();
                    }
                });
                return;
            }
        }
    }
    @Override
    public boolean onMenuItemClick (MenuItem item){
        switch (item.getItemId()) {
            case R.id.mnview:
                intent = new Intent(getApplicationContext(), LihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnedit:
                Toast.makeText(getApplicationContext(), LihatData.nomor,
                        Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }
    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.cariNama(newText);
        return false;
    }
}
