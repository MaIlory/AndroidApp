    package com.example.formulaire;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText etNom = (EditText) findViewById(R.id.editTextNom);
        EditText etPrenom = (EditText) findViewById(R.id.editTextPrenom);
        EditText etAge = (EditText) findViewById(R.id.editTextAge);
        EditText etDomComp = (EditText) findViewById(R.id.editTextDom);
        EditText etNumTel = (EditText) findViewById(R.id.editTextPhone2);
        Button butSubmit = (Button) findViewById(R.id.button);

        butSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(getApplicationContext(),"Bonjour "+etPrenom.getText()+" "+etNom.getText(), Toast.LENGTH_LONG).show();
            }
        });
    }
}