    package com.example.formulaire;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText etNom = findViewById(R.id.editTextNom);
        EditText etPrenom = findViewById(R.id.editTextPrenom);
        EditText etAge = findViewById(R.id.editTextAge);
        EditText etDomComp = findViewById(R.id.editTextDom);
        EditText etNumTel = findViewById(R.id.editTextPhone2);
        Button butSubmit = findViewById(R.id.button);

        butSubmit.setOnClickListener(arg0 -> Toast.makeText(getApplicationContext(),
                "Bonjour "+etPrenom.getText()+" "+etNom.getText(), Toast.LENGTH_LONG).show());
    }
}