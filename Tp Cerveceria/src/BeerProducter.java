public class BeerProducter extends Thread {

    String nombre;
    BeerHouse b;

    //Constructor
    public BeerProducter(String nombre, BeerHouse b) {
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

    public int producir() throws InterruptedException {
        //cantidad de cervezas producidas
        int producido = (int) (Math.random() * 10) + 2;
        this.b.recibirCerveza(producido);
        System.out.println("Productor "+this.nombre+": Vendi mis " + producido + " cervezas =)");
        return producido;
    }

    public void run() {
        while (this.b.isAbierto()) {
            try {
                this.producir();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Productor "+this.nombre+": La cerveceria cerro, supongo que ire a vender mis productos a otro lado");

    }


}
