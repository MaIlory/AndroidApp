package com.example.formulaire.models;

import androidx.annotation.NonNull;

public class Train {
    private String heure;
    private String type; // ex: TGV, TER
    private String prix;

    public Train(String heure, String type, String prix) {
        this.heure = heure;
        this.type = type;
        this.prix = prix;
    }

    @NonNull
    @Override
    public String toString() {
        return heure + " - " + type + " (" + prix + ")";
    }
}
