package performance;

public class PidRange implements Cloneable {
    int from = 0;
    int to = 100;
    String type = "abc";


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
