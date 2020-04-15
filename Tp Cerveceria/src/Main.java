public class Main {
    public static void main(String[] args) {

  BeerHouse beerHouse = new BeerHouse(100,25);
  BeerConsumer consumer = new BeerConsumer("juan",beerHouse);
  BeerProducter producter = new BeerProducter("bianca",beerHouse);

  producter.start();
  consumer.start();
    }
}
