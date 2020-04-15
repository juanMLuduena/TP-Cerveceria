public class BeerConsumer extends Thread {

    private String nombre;
    private BeerHouse b;

    //Constructor
    public BeerConsumer(String nombre, BeerHouse b) {
        super();
        this.nombre = nombre;
        this.b = b;
    }

    //Getters y setters
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

    public int consumir() {
        int consumido = (int) (Math.random() * 15) + 2;
        int compradas=this.b.venderCerveza(consumido);
        if (consumido== compradas) {
            System.out.println("Consumidor "+this.nombre+": Compre " + consumido + " cervezas =S");
        }
        else{
            System.out.println("Consumidor "+this.nombre+": Solo pude comprar  " + compradas + " cervezas =(");

        }
        return compradas;
    }

    public void run(){
        while (this.b.isAbierto()){
            this.consumir();
        }
        System.out.println("Consumidor "+this.nombre+": La cerveceria cerro, hora de mimir");

    }



}
