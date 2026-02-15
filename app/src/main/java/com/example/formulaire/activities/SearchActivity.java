package com.example.formulaire.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.formulaire.R;

public class SearchActivity extends AppCompatActivity {

    private EditText etCityDepart;
    private EditText etCityArrivee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.research_layout);

        // Initialisation des composants
        etCityDepart = findViewById(R.id.etCityDepart);
        etCityArrivee = findViewById(R.id.etCityArrivee);
        Button btnSearchTrains = findViewById(R.id.btnSearchTrains);

        // Logique du bouton de recherche
        btnSearchTrains.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1. Récupération des saisies
                String depart = etCityDepart.getText().toString().trim();
                String arrivee = etCityArrivee.getText().toString().trim();

                // 2. Validation simple
                if (depart.isEmpty() || arrivee.isEmpty()) {
                    Toast.makeText(SearchActivity.this,
                            "Veuillez saisir une ville de départ et d'arrivée",
                            Toast.LENGTH_SHORT).show();
                } else {
                    // 3. Passage à l'activité de résultats avec les données
                    Intent intent = new Intent(SearchActivity.this, ResultActivity.class);
                    intent.putExtra("DEPART", depart);
                    intent.putExtra("ARRIVEE", arrivee);
                    startActivity(intent);
                }
            }
        });
    }
}