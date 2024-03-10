package almacen;

public class Main {
    public static StringBuilder imprimir = new StringBuilder();
    public static int resetImprimir = 0;
    public static void main(String[] args) {

        Almacen logisticaZaragoza = new Almacen(200,500,300);

        creacionAlmacen(logisticaZaragoza);

        Fresco fresas = new Fresco("fresas",1234,2024,3,12,2024,2,12,"España");

        anyadirProductosAlmacen(logisticaZaragoza,fresas);

        Congelado lubina = new Congelado("Lubina",12345,2025,1,1,-18);

        anyadirProductosAlmacen(logisticaZaragoza,lubina);

        Refrigerado ternera = new Refrigerado("Ternera",1346,2024,3,14,40231);

        anyadirProductosAlmacen(logisticaZaragoza,ternera);



        sacarDelAlmacen(logisticaZaragoza,fresas,10);

        sacarDelAlmacen(logisticaZaragoza,lubina,1);

        sacarDelAlmacen(logisticaZaragoza,ternera,12);



    }

    private static void sacarDelAlmacen(Almacen almacen, Producto producto, int i) {
        almacen.sacarCantidad(producto,i);
    }

    private static void anyadirProductosAlmacen(Almacen almacen, Producto producto) {

        imprimir.append("\nProductos ha añadir: \n").append(producto);

        System.out.println(imprimir);
        imprimir.setLength(resetImprimir);

        almacen.registrarProducto(producto);
    }

    private static void creacionAlmacen(Almacen a) {

        imprimir.append("\nSe ha creado un nuevo almacén en Zaragoza.\n").append(a);
        System.out.println(imprimir);
        imprimir.setLength(resetImprimir);
    }
}
