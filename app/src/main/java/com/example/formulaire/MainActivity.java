    package com.example.formulaire;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
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

        butSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(R.string.attention);
                builder.setMessage(R.string.voulez_vous_continuer);

                builder.setPositiveButton(R.string.continuer, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Action si OUI
                        Toast.makeText(MainActivity.this, "Vous avez cliqué sur Continuer", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton(R.string.dismiss, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }
}