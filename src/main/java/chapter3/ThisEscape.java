package chapter3;

public class ThisEscape {
    public ThisEscape(EventSource source) {
        source.registerListener(new EventListener() {
            @Override
            public void onEvent() {
                
            }
        });
    }
}
