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
        etNom.setLayoutParams(params);
        etPrenom.setHint("Prenom");
        etPrenom.setLayoutParams(params);
        etAge.setHint("Age");
        etAge.setLayoutParams(params);
        etDomComp.setHint("Domaine de compétence");
        etDomComp.setLayoutParams(params);
        etNumTel.setHint("Numéro de téléphone");
        etNumTel.setLayoutParams(params);
        butSubmit.setHint("Submit");
        butSubmit.setLayoutParams(params);


        linearLayout.addView(etNom);
        linearLayout.addView(etPrenom);
        linearLayout.addView(etAge);
        linearLayout.addView(etDomComp);
        linearLayout.addView(etNumTel);
        linearLayout.addView(butSubmit);

        linearLayout.setOrientation(VERTICAL);

        butSubmit.setOnClickListener(arg0 -> Toast.makeText(getApplicationContext(),
                "Bonjour "+etPrenom.getText()+" "+etNom.getText(), Toast.LENGTH_LONG).show());
        setContentView(linearLayout);
    }
}