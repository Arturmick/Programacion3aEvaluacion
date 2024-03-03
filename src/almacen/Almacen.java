package almacen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Almacen implements IAlmacen{
    public static Scanner sc = new Scanner(System.in);
    private final int STOCK_MAX;
    private final int FRESCO_STOCK_MAX;
    private final int CONGELADO_STOCK_MAX;
    private final int REFRIGERADO_STOCK_MAX;
    private int stock;
    private double precio;
    public ArrayList <Fresco> frescoAlmacenado;
    public ArrayList <Congelado> congeladoAlmacenado;
    public ArrayList <Refrigerado> refrigeradoAlmacenado;


    public Almacen(int fresco, int congelado, int refrigerado) {

        this.FRESCO_STOCK_MAX = fresco;
        this.REFRIGERADO_STOCK_MAX = refrigerado;
        this.CONGELADO_STOCK_MAX = congelado;
        this.STOCK_MAX = fresco + refrigerado + congelado;

        frescoAlmacenado = new ArrayList<>();
        congeladoAlmacenado = new ArrayList<>();
        refrigeradoAlmacenado = new ArrayList<>();

    }

    public void registrarProducto(Producto producto) {

        precio = asignarPrecio(producto);

        if (producto instanceof Congelado) {
            if(comprobarStock(definirStock(),CONGELADO_STOCK_MAX)){
                almacenar(producto,congeladoAlmacenado);
                organizarPorFecha(congeladoAlmacenado);
            }
        } else if (producto instanceof Fresco) {
            if(comprobarStock(definirStock(),FRESCO_STOCK_MAX)){
                almacenar(producto,frescoAlmacenado);
                organizarPorFecha(frescoAlmacenado);
            }
        }else {
            if(comprobarStock(definirStock(),REFRIGERADO_STOCK_MAX)){
                almacenar(producto,refrigeradoAlmacenado);
                organizarPorFecha(refrigeradoAlmacenado);
            }
        }
    }

    public void almacenar(Producto producto,ArrayList zona) {
        producto.setProductoAlmacenado(true);
        for (int i = 1 ; i <= stock; i++){
            zona.add(producto);
        }
        System.out.println("añadido/s " + stock + " palets de "+producto.getNOMBRE_PRODUCTO()+"\n");
    }

    private boolean comprobarStock(int stock, int max) {
        boolean flag = false;
        if (stock >= max)
            System.out.println("El producto no cabe en el almacén");
        else if (stock <= 0) {
            System.out.println("Se debe introducir algo en el almacén para poder registrar un producto");
        }else flag = true;
        return flag;
    }
    private int definirStock() {
        System.out.println("Stock: ");
        return stock = sc.nextInt();
    }

    private double asignarPrecio(Producto producto) {

        boolean flag = true;

        while (flag) {

            System.out.println("Precio: ");
            precio = sc.nextDouble();

            if (precio <= 0) {
                System.out.println("El precio no es correcto");

            }else flag= false;
        }
        producto.setPrecioProducto(precio);
        return precio;
    }

    @Override
    public String verStock() {

        return "\nStock en almacén: \n"+
                "\nProducto congelado: "+congeladoAlmacenado.size()+
                "\nProducto fresco: "+frescoAlmacenado.size()+
                "\nProducto refrigerado: "+refrigeradoAlmacenado.size();
    }

    @Override
    public void sacarCantidad(Producto producto, int cantidad) {
        int i = 0;
        if (producto instanceof Congelado) {
            i = extraerProducto(cantidad,congeladoAlmacenado);
        } else if (producto instanceof Fresco) {
            i = extraerProducto(cantidad,frescoAlmacenado);
        }else {
            i = extraerProducto(cantidad,refrigeradoAlmacenado);
        }
        System.out.println("Se ha sacado una cantidad de stock de: "+i);
    }

    private int extraerProducto(int cantidad,ArrayList array) {
        int i = 0;
        try {
            for (i = 0; i < cantidad; i++) {
                array.remove(0);
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println("No queda suficiente stock");
        }
        return i;
    }

    @Override
    public void organizarPorFecha(ArrayList array) {
        Collections.sort(array, Comparator.comparing(Producto::getFECHA_CADUCIDAD));
    }
    public String toString(){
        return "El almacén tiene una capacidad de "+STOCK_MAX+
                " palets"+
                "\nlos cuales están organizados en:"+
                "\nCongelador: "+CONGELADO_STOCK_MAX+" palets"+
                "\nRefrigerador: "+REFRIGERADO_STOCK_MAX+" palets"+
                "\nEstantes: "+FRESCO_STOCK_MAX+" palets";
    }
}
