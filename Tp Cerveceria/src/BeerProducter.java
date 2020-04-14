public class BeerProducter extends Thread{

    //clase que produce la birra para beerhouse, puedo hacer un randon para ver cuanto produce en un "dia"
    int id;
    String nombre;
    BeerHouse b;

    public BeerProducter(int id, String nombre, BeerHouse b) {
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

    public synchronized  int producir () throws InterruptedException {
        //cantidad de cervezas producidas
        int producido = (int) (Math.random() * 10) + 2;

        while (this.b.checkEspacio(producido)) {
            System.out.println("Productor: Cerveceria sin espacio");
            System.out.println("Productor: Esperando a un consumidor...");

            this.wait();
        }
        this.b.recibirCerveza(producido);
        System.out.println("Productor: Vendi mis "+ producido+ " cervezas =)");
        return producido;
    }

    public void run(){
        while (this.b.isAbierto()){
            try {
                this.producir();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
