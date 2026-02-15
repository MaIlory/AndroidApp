package com.example.formulaire.activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.formulaire.R;
import com.example.formulaire.models.Train;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_layout);

        // 1. Récupérer les infos de la page précédente
        String villeDep = getIntent().getStringExtra("DEPART");
        String villeArr = getIntent().getStringExtra("ARRIVEE");

        // 2. Mettre à jour le titre
        TextView tvTitle = findViewById(R.id.tvRouteTitle);
        tvTitle.setText(villeDep + " → " + villeArr);

        // 3. Créer une liste de données fictives
        ArrayList<Train> listeTrains = new ArrayList<>();
        listeTrains.add(new Train("08:12", "TGV INOUI", "45€"));
        listeTrains.add(new Train("10:45", "OUIGO", "19€"));
        listeTrains.add(new Train("14:20", "TER", "25€"));
        listeTrains.add(new Train("17:05", "TGV INOUI", "62€"));

        // 4. Lier à la ListView via un Adapter
        ListView lv = findViewById(R.id.lvTrains);
        ArrayAdapter<Train> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1, // Layout de ligne par défaut
                listeTrains
        );
        lv.setAdapter(adapter);
    }
}
