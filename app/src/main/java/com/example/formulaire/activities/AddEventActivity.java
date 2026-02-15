package com.example.formulaire.activities;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.formulaire.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddEventActivity extends AppCompatActivity {

    private EditText editTitle;
    private EditText editDescription;
    private TextView textSelectedDate;
    private TextView textSelectedTime;
    private Button btnSelectDate;
    private Button btnSelectTime;
    private Button btnSave;
    private Button btnCancel;
    
    private Calendar selectedDate;
    private String selectedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        initViews();
        initDate();
        setupListeners();
    }

    private void initViews() {
        editTitle = findViewById(R.id.editTitle);
        editDescription = findViewById(R.id.editDescription);
        textSelectedDate = findViewById(R.id.textSelectedDate);
        textSelectedTime = findViewById(R.id.textSelectedTime);
        btnSelectDate = findViewById(R.id.btnSelectDate);
        btnSelectTime = findViewById(R.id.btnSelectTime);
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);
    }

    private void initDate() {
        selectedDate = Calendar.getInstance();
        
        long dateMillis = getIntent().getLongExtra("selectedDate", selectedDate.getTimeInMillis());
        selectedDate.setTimeInMillis(dateMillis);
        
        selectedTime = String.format(Locale.getDefault(), "%02d:%02d", 
                selectedDate.get(Calendar.HOUR_OF_DAY), 
                selectedDate.get(Calendar.MINUTE));
        
        updateDateDisplay();
        updateTimeDisplay();
    }

    private void setupListeners() {
        btnSelectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });

        btnSelectTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePicker();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveEvent();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void showDatePicker() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        selectedDate.set(year, month, dayOfMonth);
                        updateDateDisplay();
                    }
                },
                selectedDate.get(Calendar.YEAR),
                selectedDate.get(Calendar.MONTH),
                selectedDate.get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    private void showTimePicker() {
        int hour = Integer.parseInt(selectedTime.split(":")[0]);
        int minute = Integer.parseInt(selectedTime.split(":")[1]);
        
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        selectedTime = String.format(Locale.getDefault(), "%02d:%02d", hourOfDay, minute);
                        updateTimeDisplay();
                    }
                },
                hour,
                minute,
                true
        );
        timePickerDialog.show();
    }

    private void updateDateDisplay() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", Locale.FRANCE);
        textSelectedDate.setText(sdf.format(selectedDate.getTime()));
    }

    private void updateTimeDisplay() {
        textSelectedTime.setText(selectedTime);
    }

    private void saveEvent() {
        String title = editTitle.getText().toString().trim();
        String description = editDescription.getText().toString().trim();
        
        if (title.isEmpty()) {
            Toast.makeText(this, "Veuillez entrer un titre", Toast.LENGTH_SHORT).show();
            editTitle.requestFocus();
            return;
        }
        
        Intent resultIntent = new Intent();
        resultIntent.putExtra("title", title);
        resultIntent.putExtra("description", description);
        resultIntent.putExtra("time", selectedTime);
        resultIntent.putExtra("date", selectedDate.getTimeInMillis());
        
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
