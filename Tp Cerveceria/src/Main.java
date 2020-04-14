public class Main {
    public static void main(String[] args) {

  BeerHouse beerHouse = new BeerHouse(100,25);
  BeerConsumer consumer = new BeerConsumer(1,"juan",beerHouse);
  BeerProducter producter = new BeerProducter(1,"bianca",beerHouse);


  beerHouse.start();
  producter.start();
  consumer.start();
    }
}
