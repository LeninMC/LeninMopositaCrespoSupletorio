package com.example.leninmopositacresposupletorio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class ActivityHomeMCLB extends AppCompatActivity {


    private String nombre;
    TabLayout tabLayout;
    ViewPager viewPager;
    TabItem personal,bissnes;
    PagesController_MCLB adapterPagesController_MCLB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_mclb);

        tabLayout = findViewById(R.id.tablayout_aj);
        viewPager =  findViewById(R.id.viewPager_aj);
        personal  = findViewById(R.id.personal_aj);
        bissnes = findViewById(R.id.bissness_aj);

        adapterPagesController_MCLB = new PagesController_MCLB(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapterPagesController_MCLB);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0){
                    adapterPagesController_MCLB.notifyDataSetChanged();
                }
                if(tab.getPosition()==1){
                    adapterPagesController_MCLB.notifyDataSetChanged();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener( new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    @Override
    public  boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_mclb,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.agregar_tarea){
            Bundle bundle = getIntent().getExtras();
            nombre = bundle.getString("mail").toString();
            Toast.makeText(ActivityHomeMCLB.this, "Agregar"+nombre, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ActivityHomeMCLB.this, MainActivityCrearListaMCLB.class);
            intent.putExtra("mail",nombre);
            startActivity(intent);
        }
        if (id == R.id.borrar_tareas){
            Toast.makeText(ActivityHomeMCLB.this, "Opcion 1s", Toast.LENGTH_SHORT).show();

        }
        if (id == R.id.cerrar_sesion){
           // FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(ActivityHomeMCLB.this, MainActivityMCLB.class));

        }
        return super.onOptionsItemSelected(menuItem);
    }
}