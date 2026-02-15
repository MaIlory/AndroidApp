package com.example.formulaire.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.formulaire.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);

        CardView cardProfile = findViewById(R.id.cardProfile);
        CardView cardTrains = findViewById(R.id.cardTrains);
        CardView cardAgenda = findViewById(R.id.cardAgenda);

        // Aller vers le profil (MainActivity)
        cardProfile.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, MainActivity.class);
            startActivity(intent);
        });

        // Aller vers la recherche de trains (SearchActivity)
        cardTrains.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, SearchActivity.class);
            startActivity(intent);
        });

        // Aller vers l'agenda (AgendaActivity)
        cardAgenda.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, AgendaActivity.class);
            startActivity(intent);
        });
    }
}