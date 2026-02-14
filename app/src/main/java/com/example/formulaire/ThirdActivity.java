package com.example.formulaire;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class ThirdActivity extends AppCompatActivity{
    Button buttonCall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
        String telephone;
        if (getIntent().getExtras() != null) {
            telephone = getIntent().getExtras().getString("phoneNumber");
        } else {
            telephone = "123456";
        }
        TextView tvPhoneNumber = findViewById(R.id.tvDisplayPhone);
        tvPhoneNumber.setText(telephone);
        buttonCall = findViewById(R.id.buttonCall);
        buttonCall.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // "tel:" est obligatoire avant le numéro
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + telephone));
                startActivity(intent);
            }
        });
    }
}