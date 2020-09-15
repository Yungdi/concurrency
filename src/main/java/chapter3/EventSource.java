package chapter3;

public class EventSource {
    public EventListener eventListener;

    public void registerListener(EventListener eventListener) {
        this.eventListener = eventListener;
        eventListener.onEvent();
    }
}
