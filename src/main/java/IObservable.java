import java.util.List;

public interface IObservable {
    void subscribe(List<IObserver> observers);
    void unsubscribe(IObserver observer);
    void ObserverNotify();
}
