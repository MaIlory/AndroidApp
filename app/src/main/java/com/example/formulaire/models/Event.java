package com.example.formulaire.models;

import androidx.annotation.NonNull;
import java.util.Calendar;

public class Event {
    private String title;
    private String description;
    private Calendar date;
    private String time;

    public Event(String title, String description, Calendar date, String time) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDateKey() {
        return date.get(Calendar.YEAR) + "-" + 
               (date.get(Calendar.MONTH) + 1) + "-" + 
               date.get(Calendar.DAY_OF_MONTH);
    }

    @NonNull
    @Override
    public String toString() {
        return title + " - " + time;
    }
}
