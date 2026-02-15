package com.example.formulaire.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.formulaire.R;
import com.example.formulaire.adapters.EventAdapter;
import com.example.formulaire.models.Event;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class AgendaActivity extends AppCompatActivity {

    private CalendarView calendarView;
    private TextView selectedDateText;
    private CardView eventsCard;
    private RecyclerView eventsRecyclerView;
    private FloatingActionButton fabAddEvent;
    
    private Calendar selectedDate;
    private HashMap<String, List<Event>> eventsMap;
    private EventAdapter eventAdapter;
    
    private ActivityResultLauncher<Intent> addEventLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        initViews();
        initData();
        setupRecyclerView();
        setupCalendar();
        setupFAB();
        
        updateEventsDisplay();
    }

    private void initViews() {
        calendarView = findViewById(R.id.calendarView);
        selectedDateText = findViewById(R.id.selectedDateText);
        eventsCard = findViewById(R.id.eventsCard);
        eventsRecyclerView = findViewById(R.id.eventsRecyclerView);
        fabAddEvent = findViewById(R.id.fabAddEvent);
        
        selectedDate = Calendar.getInstance();
    }

    private void initData() {
        eventsMap = new HashMap<>();
        
        Calendar cal = Calendar.getInstance();
        cal.set(2026, Calendar.FEBRUARY, 15);
        addEventToMap(new Event("Réunion d'équipe", "Discuter des objectifs du trimestre", (Calendar) cal.clone(), "10:00"));
        addEventToMap(new Event("Présentation client", "Démo de la nouvelle fonctionnalité", (Calendar) cal.clone(), "14:30"));
        
        cal.set(2026, Calendar.FEBRUARY, 18);
        addEventToMap(new Event("Formation Java", "Session sur les nouveautés Java 17", (Calendar) cal.clone(), "09:00"));
        
        cal.set(2026, Calendar.FEBRUARY, 20);
        addEventToMap(new Event("Revue de code", "Analyse du module agenda", (Calendar) cal.clone(), "11:00"));
        
        cal.set(2026, Calendar.FEBRUARY, 22);
        addEventToMap(new Event("Déjeuner d'équipe", "Restaurant italien", (Calendar) cal.clone(), "12:30"));
        
        cal.set(2026, Calendar.FEBRUARY, 25);
        addEventToMap(new Event("Atelier design", "Nouvelles maquettes UI/UX", (Calendar) cal.clone(), "15:00"));
        
        cal.set(2026, Calendar.MARCH, 1);
        addEventToMap(new Event("Conférence tech", "Android Summit 2026", (Calendar) cal.clone(), "09:00"));
    }

    private void addEventToMap(Event event) {
        String dateKey = event.getDateKey();
        if (!eventsMap.containsKey(dateKey)) {
            eventsMap.put(dateKey, new ArrayList<>());
        }
        eventsMap.get(dateKey).add(event);
    }

    private void setupRecyclerView() {
        eventAdapter = new EventAdapter(new ArrayList<>());
        eventsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        eventsRecyclerView.setAdapter(eventAdapter);
    }

    private void setupCalendar() {
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectedDate.set(year, month, dayOfMonth);
                updateEventsDisplay();
            }
        });
    }

    private void setupFAB() {
        addEventLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                            Intent data = result.getData();
                            String title = data.getStringExtra("title");
                            String description = data.getStringExtra("description");
                            String time = data.getStringExtra("time");
                            long dateMillis = data.getLongExtra("date", selectedDate.getTimeInMillis());
                            
                            Calendar eventDate = Calendar.getInstance();
                            eventDate.setTimeInMillis(dateMillis);
                            
                            Event newEvent = new Event(title, description, eventDate, time);
                            addEventToMap(newEvent);
                            
                            if (isSameDay(selectedDate, eventDate)) {
                                updateEventsDisplay();
                            }
                        }
                    }
                }
        );
        
        fabAddEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgendaActivity.this, AddEventActivity.class);
                intent.putExtra("selectedDate", selectedDate.getTimeInMillis());
                addEventLauncher.launch(intent);
            }
        });
    }

    private void updateEventsDisplay() {
        String dateKey = selectedDate.get(Calendar.YEAR) + "-" + 
                        (selectedDate.get(Calendar.MONTH) + 1) + "-" + 
                        selectedDate.get(Calendar.DAY_OF_MONTH);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", Locale.FRANCE);
        selectedDateText.setText(sdf.format(selectedDate.getTime()));
        
        List<Event> events = eventsMap.get(dateKey);
        
        if (events != null && !events.isEmpty()) {
            eventsCard.setVisibility(View.VISIBLE);
            eventAdapter.updateEvents(events);
        } else {
            eventsCard.setVisibility(View.GONE);
        }
    }

    private boolean isSameDay(Calendar cal1, Calendar cal2) {
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
               cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) &&
               cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
    }
}
