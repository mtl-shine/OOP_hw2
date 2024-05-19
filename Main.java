public class Main {
    public static void main(String[] args) {
        Market market = new Market();
        Human human1 = new Human("Alexander");
        Human human2 = new Human("Tatiana");
        Human human3 = new Human("Sergei");
        market.acceptToMarket(human1);
        market.acceptToMarket(human2);
        market.acceptToMarket(human3);
        market.update();
    }
}
