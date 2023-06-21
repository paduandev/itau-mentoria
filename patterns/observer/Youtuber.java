package observer;

import java.util.ArrayList;

public class Youtuber implements Subject {
    private ArrayList<Observer> subscribers;
    private String youtuberName;

    public Youtuber(String youtuberName) {
        this.subscribers = new ArrayList<>();
        this.youtuberName = youtuberName;
    }

    @Override
    public void subscribe(Observer observer) {
        subscribers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        subscribers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : subscribers) {
            observer.update(message);
        }
    }

    public void newVideo(String videoName) {
        notifyObservers(youtuberName + " publicou um novo vídeo: " + videoName);
    }

    public void online(String liveName) {
        notifyObservers(youtuberName + " está online: " + liveName);
    }
}
