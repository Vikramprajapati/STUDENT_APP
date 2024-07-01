package com.example.citcollege;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.citcollege.ui.about.AboutFragment;
import com.example.citcollege.ui.admin.AdminFragment;
import com.example.citcollege.ui.faculty.FacultyFragment;
import com.example.citcollege.ui.home.HomeFragment;
import com.example.citcollege.ui.profile.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;
    Toolbar toolbar;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId=item.getItemId();
       if(itemId==R.id.Settings){
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
        }
        else if(itemId==R.id.share){
            Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
        } else if(itemId==R.id.logout){
            Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bottomNavigationView=findViewById(R.id.bottomNavView);
        frameLayout=findViewById(R.id.framelayout);
        toolbar=findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId=item.getItemId();
                if (itemId==R.id.navigation_home){
                    getSupportActionBar().setTitle("CIT College");
                    FragmentManager fragmentManager=getSupportFragmentManager();
                    FragmentTransaction transaction=fragmentManager.beginTransaction();
                    transaction.replace(R.id.framelayout,new HomeFragment());
                    transaction.commit();
                }else  if (itemId==R.id.navigation_admin){
                    getSupportActionBar().setTitle("Admin");
                    FragmentManager fragmentManager=getSupportFragmentManager();

                    FragmentTransaction transaction=fragmentManager.beginTransaction();
                    transaction.replace(R.id.framelayout,new AdminFragment());
                    transaction.commit();
                }

                else  if (itemId==R.id.navigation_faculty){
                    getSupportActionBar().setTitle("Faculty");
                    FragmentManager fragmentManager=getSupportFragmentManager();

                    FragmentTransaction transaction=fragmentManager.beginTransaction();
                    transaction.replace(R.id.framelayout,new FacultyFragment());
                    transaction.commit();
                }
                else  if (itemId==R.id.navigation_about){
                    getSupportActionBar().setTitle("About");
                    FragmentManager fragmentManager=getSupportFragmentManager();

                    FragmentTransaction transaction=fragmentManager.beginTransaction();
                    transaction.replace(R.id.framelayout,new AboutFragment());
                    transaction.commit();
                }
                else  if (itemId==R.id.navigation_profile){
                    getSupportActionBar().setTitle("Profile");
                    FragmentManager fragmentManager=getSupportFragmentManager();

                    FragmentTransaction transaction=fragmentManager.beginTransaction();
                    transaction.replace(R.id.framelayout,new ProfileFragment());
                    transaction.commit();
                }
                return true;

            }
        });
        getSupportActionBar().setTitle("CIT College ");
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.framelayout,new HomeFragment());
        transaction.commit();
    }
}