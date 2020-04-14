public class BeerConsumer extends Thread {

    int id;
    String nombre;
    BeerHouse b;
    //clase que la birra de beerhouse, puedo hacer un randon para ver cuanto consume en un "dia"


    public BeerConsumer(int id, String nombre, BeerHouse b) {
        this.id = id;
        this.nombre = nombre;
        this.b = b;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BeerHouse getB() {
        return b;
    }

    public void setB(BeerHouse b) {
        this.b = b;
    }

    public synchronized int consumir() {
        int consumido = (int) (Math.random() * 15) + 2;
        int compradas=this.b.venderCerveza(consumido);
        if (consumido== compradas) {
            System.out.println("Consumidor: Compre " + consumido + " cervezas =S");
        }
        else{
            System.out.println("Consumidor: Solo pude comprar  " + compradas + " cervezas =(");

        }
        this.notifyAll();
        return compradas;
    }

    public void run(){
        while (this.b.isAbierto()){
            this.consumir();
        }
    }



}
