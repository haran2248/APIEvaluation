package com.example.apievaluation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.apievaluation.retrofit.RetrofitClient;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormActivity extends AppCompatActivity {
    EditText Name_forms,Age_forms,City_forms,gen_forms;
    String name="",age="",city="",gend="";
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        Name_forms=findViewById(R.id.name_forms);
        Age_forms=findViewById(R.id.age_forms);
        City_forms=findViewById(R.id.city_forms);
        gen_forms=findViewById(R.id.gender_forms);
        send=findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=Name_forms.getText().toString().trim();
                age=Age_forms.getText().toString().trim();
                city=City_forms.getText().toString().trim();
                gend=gen_forms.getText().toString().trim();
                Send(name,age,city,gend);
                
            }
        });

    }

    private void Send(String name, String age, String city, String gend) {
        Map<String,String>map=new HashMap<>();
        map.put("Name",name);
        map.put("age",age);
        map.put("City",city);
        map.put("gender",gend);

        Call<Void> call= RetrofitClient.getClient().sendPeople(map);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                if(response.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(),"response success",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"something went wrong",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                t.printStackTrace();

            }
        });

    }

}
