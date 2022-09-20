import java.util.LinkedList;
import java.util.List;

public class Twitter implements IObservable {
    private List<IObserver> _observers = new LinkedList<>();
    private List<String> _twits = new LinkedList<>();

    public Twitter() {}

    public Twitter(List<IObserver> observers) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void subscribe(List<IObserver> observers) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void unsubscribe(IObserver observer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void ObserverNotify() {
        throw new UnsupportedOperationException();
    }

    public List<IObserver> getObservers() {
        throw new UnsupportedOperationException();
    }

    public List<String> getTwits() {
        throw new UnsupportedOperationException();
    }

    public void post(String twit) {
        throw new UnsupportedOperationException();
    }

    private boolean exists(IObserver followerToFind) {
        throw new UnsupportedOperationException();
    }
}
