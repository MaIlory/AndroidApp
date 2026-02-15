package com.example.formulaire.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.formulaire.R;
import com.example.formulaire.models.Event;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private List<Event> events;

    public EventAdapter(List<Event> events) {
        this.events = events;
    }

    public void updateEvents(List<Event> newEvents) {
        this.events = newEvents;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_event, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        Event event = events.get(position);
        holder.bind(event);
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    static class EventViewHolder extends RecyclerView.ViewHolder {
        private final TextView eventTimeText;
        private final TextView eventTitleText;
        private final TextView eventDescriptionText;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            eventTimeText = itemView.findViewById(R.id.eventTimeText);
            eventTitleText = itemView.findViewById(R.id.eventTitleText);
            eventDescriptionText = itemView.findViewById(R.id.eventDescriptionText);
        }

        public void bind(Event event) {
            eventTimeText.setText(event.getTime());
            eventTitleText.setText(event.getTitle());
            eventDescriptionText.setText(event.getDescription());
        }
    }
}
