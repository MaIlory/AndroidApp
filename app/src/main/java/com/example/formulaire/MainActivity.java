    package com.example.formulaire;

import static android.widget.LinearLayout.VERTICAL;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
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

        LinearLayout linearLayout = getLinearLayout();

        EditText etNom = addLabeledEditText(linearLayout, R.string.nom, params);
        EditText etPrenom = addLabeledEditText(linearLayout, R.string.prenom, params);
        EditText etAge = addLabeledEditText(linearLayout, R.string.age, params);
        EditText etDomComp = addLabeledEditText(linearLayout, R.string.domComp, params);
        EditText etNumTel = addLabeledEditText(linearLayout, R.string.numTel, params);

        // Button
        Button butSubmit = new Button(this);
        linearLayout.addView(butSubmit, params);
        butSubmit.setHint(R.string.submit);

        butSubmit.setOnClickListener(arg0 -> Toast.makeText(getApplicationContext(),
                "Bonjour "+etPrenom.getText()+" "+etNom.getText(), Toast.LENGTH_LONG).show());

        setContentView(linearLayout);
    }

    @NonNull
    private LinearLayout getLinearLayout() {
        LinearLayout.LayoutParams layoutParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        int marginTop = (int) (10 * getResources().getDisplayMetrics().density);
        layoutParams.setMargins(0, marginTop, 0, 0);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(VERTICAL);
        return linearLayout;
    }

    private EditText addLabeledEditText(LinearLayout parent, int labelResId,
                                        LinearLayout.LayoutParams params) {
        TextView tv = new TextView(this);
        tv.setText(labelResId);
        parent.addView(tv, params);

        EditText et = new EditText(this);
        et.setHint(labelResId);
        parent.addView(et, params);

        return et;
    }

}