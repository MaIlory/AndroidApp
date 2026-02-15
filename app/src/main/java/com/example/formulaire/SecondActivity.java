package com.example.formulaire;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    Button buttonOK;
    Button buttonReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        TextView tvInformation = findViewById(R.id.tvResult);
        Bundle extras = getIntent().getExtras();


        // Extraction des données
        String prenom = null;
        String nom = null;
        String age = null;
        String domaine = null;
        String telephone = null;
        if (extras != null) {
            prenom = extras.getString("firstName");
            nom = extras.getString("lastName");
            age = extras.getString("age");
            domaine = extras.getString("domComp");
            telephone = extras.getString("numTel");
        }

        // Construction de la chaîne d'affichage
        String infos = "Prénom : " + valeurOuDefaut(prenom) + "\n" +
                "Nom : " + valeurOuDefaut(nom) + "\n" +
                "Âge : " + valeurOuDefaut(age) + " ans\n" +
                "Domaine : " + valeurOuDefaut(domaine) + "\n" +
                "Téléphone : " + valeurOuDefaut(telephone);

        // Affichage final
        tvInformation.setText(infos);
        tvInformation.setText(infos);

        buttonOK = findViewById(R.id.buttonOK);
        buttonOK.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });

        buttonReturn = findViewById(R.id.buttonReturn);
        buttonReturn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    
    private String valeurOuDefaut(String valeur) {
        return (valeur != null && !valeur.isEmpty()) ? valeur : "Non renseigné";
    }


}
