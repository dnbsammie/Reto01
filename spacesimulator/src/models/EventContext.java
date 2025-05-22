package models;

import java.util.Set;

public class EventContext {
    private Set<String> eventHistory;

    public EventContext(Set<String> eventHistory) { this.eventHistory = eventHistory; }

    public boolean hasOccurred(String eventName) { return eventHistory.contains(eventName); }

    public void markAsOccurred(String eventName) { eventHistory.add(eventName); }
}
