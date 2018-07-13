package com.example.shipra.retrofit_example5;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button button_continue;
    retrofitApi mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String phone = null;



        button_continue = (Button) findViewById(R.id.btn_continue);

        button_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        register.class);
                startActivity(myIntent);












            }
        });


    }




}

