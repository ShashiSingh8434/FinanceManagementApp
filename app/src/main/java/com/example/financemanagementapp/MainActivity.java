package com.example.financemanagementapp;

import android.app.backup.FileBackupHelper;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.financemanagementapp.databinding.ActivityMainBinding;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .setAnchorView(R.id.fab).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

//------------------------------------------------------getFromUser() this function is working just fine
    public String getFromUser(View view) {

        EditText detail = findViewById(R.id.detail);
        EditText date = findViewById(R.id.editTextDate);
        EditText amount = findViewById(R.id.editTextNumber);

        String text = date.getText().toString() + "  " +amount.getText().toString() + "  " + detail.getText().toString();

        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        return text;
    }
//-------------------------------------------------------------------throwing file not found exception means have to change below code to read and write txt. files and also to create one


//    public void write_in_file(View view) {
//        String text = getFromUser(view);
//
//        if (!text.isEmpty()) {
//            File file = new File(getExternalFilesDir("MyFileDir") ,"record.txt");
//            if (!file.exists()) {
//                if(file.mkdirs()){
//                    Toast.makeText(this, "exist", Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(this, "not exist", Toast.LENGTH_SHORT).show();
//                }
//            }else{
//                Toast.makeText(this, "exist", Toast.LENGTH_SHORT).show();
//            }
//
//            try {
//                FileOutputStream fileOutputStream = new FileOutputStream(file);
//                fileOutputStream.write(text.getBytes());
//                Toast.makeText(MainActivity.this, "Saved your text", Toast.LENGTH_LONG).show();
//
//            } catch (Exception e) {
//
//            }
//        }
//    }
//    public void read_file(View view)  {
//        File file = new File(getExternalFilesDir("MyFileDir") ,"record.txt");
//
//        Toast.makeText(MainActivity.this, "text", Toast.LENGTH_LONG).show();
//
//        FileReader fileReader;
//        BufferedReader bufferedReader;
//        StringBuilder output = new StringBuilder();
//        try {
//            fileReader = new FileReader(file);
//            Toast.makeText(this, "exist", Toast.LENGTH_SHORT).show();
//            bufferedReader = new BufferedReader(fileReader);
//            Toast.makeText(this, "exist", Toast.LENGTH_SHORT).show();
//            String line = bufferedReader.readLine();
//
//            Toast.makeText(this, "exist", Toast.LENGTH_SHORT).show();
//
//            while(line != null){
//                output.append(line).append("\n");
//                line = bufferedReader.readLine();
//            }
//        } catch (FileNotFoundException e) {
//
//        } catch (IOException e) {
//
//        }
//
//        Toast.makeText(this, output, Toast.LENGTH_SHORT).show();
//    }
}