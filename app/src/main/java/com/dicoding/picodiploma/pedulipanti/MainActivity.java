package com.dicoding.picodiploma.pedulipanti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.dicoding.picodiploma.pedulipanti.adapter.About;
import com.dicoding.picodiploma.pedulipanti.adapter.ListPantiAdapter;
import com.dicoding.picodiploma.pedulipanti.model.panti;
import com.dicoding.picodiploma.pedulipanti.model.pantidata;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv_panti;
    private ArrayList<panti> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setActionBarTitle("Daftar Panti Asuhan");

        rv_panti = findViewById(R.id.rvpanti);
        rv_panti.setHasFixedSize(true);

        list.addAll(pantidata.GetListPanti());
        showRecyclerList();
    }


    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    private void showSelected(panti Panti) {
        Toast.makeText(this, "Kamu memilih " + Panti.getNamapanti(), Toast.LENGTH_SHORT).show();
    }

    private void showRecyclerList(){
        rv_panti.setLayoutManager(new LinearLayoutManager(this));
        ListPantiAdapter listPantiAdapter = new ListPantiAdapter(list);
        rv_panti.setAdapter(listPantiAdapter);
        listPantiAdapter.setOnItemClickCallback(new ListPantiAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(panti data) {
                showSelected(data);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.mainmenu:
                Intent intent = new Intent(this, About.class);
                startActivity(intent);
                return true;

        }
        return false;
    }

}
