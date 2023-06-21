package observer;

public class Subscriber implements Observer {
    private String subscriberName;

    public Subscriber(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    @Override
    public void update(String message) {
        System.out.println(subscriberName + " new message: " + message);
    }
}
