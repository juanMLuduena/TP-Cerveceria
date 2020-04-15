public class BeerHouse{


    public static int capacidad;
    public static int stock;
    public static boolean abierto;

    public BeerHouse(int capacidad, int stock) {
        this.capacidad = capacidad;
        this.stock = stock;
        this.abierto =true;
    }

    public static int getCapacidad() {
        return capacidad;
    }

    public static void setCapacidad(int capacidad) {
        BeerHouse.capacidad = capacidad;
    }

    public static int getStock() {
        return stock;
    }

    public static void setStock(int stock) {
        BeerHouse.stock = stock;
    }

    public static boolean isAbierto() {
        return abierto;
    }

    public static void setAbierto(boolean abierto) {
        BeerHouse.abierto = abierto;
    }



    public  synchronized  void recibirCerveza(int i) {

        //dudo mucho que esto sea efectivo pero bueno
        while (((stock + i) > capacidad)) {
            System.out.println("Cerveceria sin espacio, esperando que alguien compre...");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.setStock(this.stock + i);
        System.out.println("BeerHouse: Recibi " + i + " cervezas, ahora tengo un stock de: " + this.stock + ".");

    }


    public  synchronized int venderCerveza(int i) {

        if (this.stock < i) {
            int vendidas = this.stock;
            this.stock = 0;
            this.abierto=false;
            return vendidas;
        } else {
            this.stock = this.stock - i;
            notifyAll();
            return i;
        }

    }

}
