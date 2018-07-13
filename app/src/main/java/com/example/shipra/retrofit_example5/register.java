package com.example.shipra.retrofit_example5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import dmax.dialog.SpotsDialog;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.example.shipra.retrofit_example5.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

public class register extends AppCompatActivity

{

    Button button_register;
    EditText phone;
    EditText name;
    EditText email;
    retrofitApi mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        phone = (EditText) findViewById(R.id.edt_phone);
        name = (EditText) findViewById(R.id.edt_name);
        email = (EditText) findViewById(R.id.edt_email);
        button_register = (Button) findViewById(R.id.btn_register);

        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                OkHttpClient client = new OkHttpClient.Builder()
                        .connectTimeout(100, TimeUnit.SECONDS)
                        .readTimeout(100,TimeUnit.SECONDS).build();





             /*   OkHttpClient client = new OkHttpClient();

                Gson gson = new GsonBuilder()

                        .setLenient()
                        .create();
              */

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://10.0.2.2/mobileapp/")
                        .client(client)
                        .addConverterFactory(GsonConverterFactory.create(new Gson()))
                        .build();

                retrofitApi service = retrofit.create(retrofitApi.class);
                User user = new User();
                user.setPhone(phone.getText().toString());
                user.setName(name.getText().toString());
                user.setEmail(email.getText().toString());
                Call<User> call = service.registerNewUser(user.getPhone(), user.getName(), user.getEmail());



                call.enqueue(new Callback<User>() {


                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        Toast.makeText(register.this, "response" , Toast.LENGTH_LONG).show();

                        Toast.makeText(register.this, "response" + response, Toast.LENGTH_LONG).show();

                        phone.setText("");
                        name.setText("");
                        email.setText("");

                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {


                        Log.i("Hello", "" + t);
                        Toast.makeText(register.this, "Throwable  error   " + t, Toast.LENGTH_LONG).show();

                    }
                });


            }

        });


        }
    }


