package com.example.somiti;

//import java.util.*;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {

    private ActionBarDrawerToggle mToggle;
    private DrawerLayout dl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dl= (DrawerLayout) findViewById(R.id.dl);
        mToggle = new ActionBarDrawerToggle(this,dl,R.string.open,R.string.close);
        mToggle.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nav_view = (NavigationView) findViewById(R.id.nav_id);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id=menuItem.getItemId();
                if(id==R.id.myProfile)
                {
                    Toast.makeText(MainActivity.this,"My Profile",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.settings)
                {
                    Toast.makeText(MainActivity.this,"Settings",Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.editProfile)
                {
                    Toast.makeText(MainActivity.this,"Edit Profile",Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.right_menu,menu);
        return true;
    }
}
