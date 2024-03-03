package almacen;

public class Main {
    public static Almacen logisticaZaragoza = new Almacen(200,500,300);
    public static StringBuilder imprimir = new StringBuilder();
    public static int resetImprimir = 0;
    public static void main(String[] args) {

        creacionAlmacen();

        Fresco fresas = new Fresco("fresas",1234,2024,3,12,2024,2,12,"España");

        anyadirProductosAlmacen(fresas);

        Congelado lubina = new Congelado("Lubina",12345,2025,1,1,-18);

        anyadirProductosAlmacen(lubina);

        Refrigerado ternera = new Refrigerado("Ternera",1346,2024,3,14,40231);

        anyadirProductosAlmacen(ternera);

        verStock();

        sacarDelAlmacen(fresas,10);

        sacarDelAlmacen(lubina,1);

        sacarDelAlmacen(ternera,12);

        verStock();
    }

    private static void verStock() {
        System.out.println(logisticaZaragoza.verStock());
    }

    private static void sacarDelAlmacen(Producto producto, int i) {
        logisticaZaragoza.sacarCantidad(producto,i);
    }

    private static void anyadirProductosAlmacen(Producto producto) {

        imprimir.append("\nProductos ha añadir: \n").append(producto);

        System.out.println(imprimir);
        imprimir.setLength(resetImprimir);

        logisticaZaragoza.registrarProducto(producto);
    }

    private static void creacionAlmacen() {

        imprimir.append("\nSe ha creado un nuevo almacén en Zaragoza.\n").append(logisticaZaragoza);
        System.out.println(imprimir);
        imprimir.setLength(resetImprimir);
    }
}
