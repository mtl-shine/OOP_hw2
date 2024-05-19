import java.util.List;

public interface MarketBehaviour {
    public void acceptToMarket(Actor actor);

    public void releaseFromMarket(List<Actor> actors);

    public void update();
}
