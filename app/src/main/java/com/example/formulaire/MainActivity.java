    package com.example.formulaire;

import static android.widget.LinearLayout.VERTICAL;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
        LinearLayout linearLayout = new LinearLayout(this);
        EditText etNom = new EditText(this);
        EditText etPrenom = new EditText(this);
        EditText etAge = new EditText(this);
        EditText etDomComp = new EditText(this);
        EditText etNumTel = new EditText(this);
        Button butSubmit = new Button(this);
        etNom.setHint("Nom");
        etPrenom.setHint("Prenom");
        etAge.setHint("Age");
        etDomComp.setHint("Domaine de compétence");
        etNumTel.setHint("Numéro de téléphone");
        butSubmit.setHint("Submit");


        linearLayout.addView(etNom, params);
        linearLayout.addView(etPrenom, params);
        linearLayout.addView(etAge, params);
        linearLayout.addView(etDomComp, params);
        linearLayout.addView(etNumTel, params);
        linearLayout.addView(butSubmit, params);

        linearLayout.setOrientation(VERTICAL);

        butSubmit.setOnClickListener(arg0 -> Toast.makeText(getApplicationContext(),
                "Bonjour "+etPrenom.getText()+" "+etNom.getText(), Toast.LENGTH_LONG).show());
        setContentView(linearLayout);
    }
}