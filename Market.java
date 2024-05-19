import java.util.ArrayList;
import java.util.List;

public class Market implements QueueBehaviour, MarketBehaviour {
    private List<Actor> queueList = new ArrayList<>();

    @Override
    public void acceptToMarket(Actor actor) {
        System.out.println(actor.getName() + " came to the market");
        takeInQueue(actor);
    }

    @Override
    public void takeInQueue(Actor actor) {
        queueList.add(actor);
        System.out.println(actor.getName() + " stood in line");
    }

    @Override
    public void takeOrders() {
        for (Actor actor : queueList) {
            if (!actor.isMakeOrder()) {
                actor.isMakeOrder = true;
                System.out.println(actor.getName() + " has made an order");
            }
        }
    }

    @Override
    public void giveOrders() {
        for (Actor actor : queueList) {
            if (actor.isMakeOrder()) {
                actor.isTakeOrder = true;
                System.out.println(actor.getName() + " has got the order");
            }
        }
    }

    @Override
    public void releaseFromQueue() {
        List<Actor> releaseQueue = new ArrayList<>();
        for (Actor actor : queueList) {
            if (actor.isTakeOrder()) {
                System.out.println(actor.getName() + " has left the queue");
                releaseQueue.add(actor);
            }
        }
        releaseFromMarket(releaseQueue);
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for (Actor actor : actors) {
            System.out.println(actor.getName() + " has left the market");
            queueList.remove(actor);
        }
    }

    @Override
    public void update() {
        takeOrders();
        giveOrders();
        releaseFromQueue();
    }

}