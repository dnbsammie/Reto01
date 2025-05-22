package models;

import java.util.function.BiConsumer;

public class Event {
    private String name;
    private int probability;
    private BiConsumer<Object[], EventContext> action;

    public Event(String name, int probability, BiConsumer<Object[], EventContext> action) {
        this.name = name;
        this.probability = probability;
        this.action = action;
    }

    public String getName() { return name; }

    public int getProbability() { return probability; }

    public void trigger(Object[] args, EventContext context) { action.accept(args, context); }
}
