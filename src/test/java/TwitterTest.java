import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TwitterTest {
    public Twitter twitter;

    @BeforeEach
    void setup() {
        twitter = new Twitter();
    }

    @Test
    public void Observers_AfterInstanciationWithoutObservers_Succes() {
        //when
        //refere to Setup method
        int exceptedAmountOfObservers = 0;

        //then
        //event is called directly by the assertion

        //when
        assertEquals(exceptedAmountOfObservers, twitter.getObservers().size());
    }

    @Test
    public void Observers_AfterInstanciationWithObservers_Succes()
    {
        //when
        int exceptedAmountOfObservers = 10;
        twitter = new Twitter(GenerateObserver(exceptedAmountOfObservers));

        //then
        //event is called directly by the assertion

        //when
        assertEquals(exceptedAmountOfObservers, twitter.getObservers().size());
    }

    @Test
    public void Twits_AfterInstanciation_Success()
    {
        //when
        int exceptedAmountOfTwits = 0;
        twitter = new Twitter();

        //then
        //event is called directly by the assertion

        //when
        assertEquals(exceptedAmountOfTwits, twitter.getTwits().size());
    }

    @Test
    public void Notify_EmptyListOfSubscriber_ThrowsException()
    {
        //given
        //refere to Setup method

        //when
        //event is called directly by the assertion

        //then
        assertThrows(EmptyListOfSubscribersException.class, () -> twitter.ObserverNotify());
    }

    @Test
    public void Subscribe_AddFirstSubscribers_Success()
    {
        //given
        //refere to Setup method
        int expectedAmountOfSubscribers = 15;
        List<IObserver> followers = GenerateObserver(expectedAmountOfSubscribers);

        //when
        twitter.subscribe(followers);

        //then
        assertEquals(expectedAmountOfSubscribers, twitter.getObservers().size());
    }

    @Test
    public void Subscribe_AddSubscribersToExistingList_Success()
    {
        //given
        //refere to Setup method
        int expectedAmountOfSubscribers = 30;
        List<IObserver> followers = GenerateObserver(expectedAmountOfSubscribers / 2);
        twitter.subscribe(followers);
        List<IObserver> followers2nd = GenerateObserver(expectedAmountOfSubscribers / 2);

        //when
        twitter.subscribe(followers2nd);

        //then
        assertEquals(expectedAmountOfSubscribers, twitter.getObservers().size());
    }

    @Test
    public void Subscribe_SubscriberAlreadyExists_ThrowsException()
    {
        //given
        //refere to Setup method
        int expectedAmountOfSubscribers = 15;
        List<IObserver> followers = GenerateObserver(expectedAmountOfSubscribers);
        twitter.subscribe(followers);
        List<IObserver> followersDuplicate = new LinkedList<>(List.of(followers.get(0)));

        //when
        //event is called directly by the assertion

        //then
        assertThrows(SubscriberAlreadyExistsException.class, () -> twitter.subscribe(followersDuplicate));
    }

    @Test
    public void Unsubscribe_NominalCase_Success()
    {
        //given
        //refer to Setup method
        List<IObserver> followers = GenerateObserver(20);
        twitter.subscribe(followers);

        //when
        twitter.unsubscribe(followers.get(10));

        //then
        assertEquals(followers.size() - 1, twitter.getObservers().size());
    }

    @Test
    public void Unsubscribe_EmptyListOfSubscriber_ThrowsException()
    {
        //given
        //refer to Setup method
        Follower followerToRemove = new Follower();

        //when
        //event is called directly by the assertion

        //then
        assertThrows(EmptyListOfSubscribersException.class, () -> twitter.unsubscribe(followerToRemove));
    }

    @Test
    public void Unsubscribe_SubscriberNotFound_ThrowsException()
    {
        //given
        //refere to Setup method
        IObserver followerNotFound = new Follower();
        twitter.subscribe(GenerateObserver(10));

        //when
        //event is called directly by the assertion

        //then
        assertThrows(SubscriberNotFoundException.class, () -> twitter.unsubscribe(followerNotFound));
    }

    private List<IObserver> GenerateObserver(int amountOfObserverToCreate)
    {
        List<IObserver> observers = new LinkedList<>();
        for (int i = 0; i < amountOfObserverToCreate; i++)
        {
            observers.add(new Follower());
        }
        return observers;
    }
}