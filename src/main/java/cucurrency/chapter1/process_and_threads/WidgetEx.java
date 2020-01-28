package cucurrency.chapter1.process_and_threads;

public class WidgetEx {
    public static void main(String[] args) {
        Widget widget = new LoggingWidget();
        widget.doSomething();
    }
}
