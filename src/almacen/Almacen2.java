package almacen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Almacen2 implements IAlmacen{
    public static Scanner sc = new Scanner(System.in);
    private final int STOCK_MAX;
    private final int FRESCO_STOCK_MAX;
    private final int CONGELADO_STOCK_MAX;
    private final int REFRIGERADO_STOCK_MAX;
    public ArrayList <Fresco> frescoAlmacenado;
    public ArrayList <Congelado> congeladoAlmacenado;
    public ArrayList <Refrigerado> refrigeradoAlmacenado;


    public Almacen2() {

        this.FRESCO_STOCK_MAX = fresco;
        this.REFRIGERADO_STOCK_MAX = refrigerado;
        this.CONGELADO_STOCK_MAX = congelado;
        this.STOCK_MAX = stockMax;

        frescoAlmacenado = new ArrayList<>();
        congeladoAlmacenado = new ArrayList<>();
        refrigeradoAlmacenado = new ArrayList<>();

    }
    @Override
    public void registrarProducto(Producto producto) {

        if (producto instanceof Congelado) {
            if(comprobarStock(producto.getStockProducto(),CONGELADO_STOCK_MAX)){
                almacenar(producto,congeladoAlmacenado);
                organizarPorFecha(congeladoAlmacenado);
            }
        } else if (producto instanceof Fresco) {
            if(comprobarStock(producto.getStockProducto(),FRESCO_STOCK_MAX)){
                almacenar(producto,frescoAlmacenado);
                organizarPorFecha(frescoAlmacenado);
            }
        }else {
            if(comprobarStock(producto.getStockProducto(),REFRIGERADO_STOCK_MAX)){
                almacenar(producto,refrigeradoAlmacenado);
                organizarPorFecha(refrigeradoAlmacenado);
            }
        }
    }
    @Override
    public String almacenar(Producto producto,ArrayList zona) {
        producto.setProductoAlmacenado(true);
        for (int i = 1 ; i <= producto.getStockProducto(); i++){
            zona.add(producto);
        }
        return"añadido/s " + producto.getStockProducto() + " palets de "+producto.getNOMBRE_PRODUCTO()+"\n";
    }
    @Override
    public boolean comprobarStock(int stock, int max) {
        boolean flag = false;
        if (stock > max)
            System.out.println("El producto no cabe en el almacén");
        else if (stock <= 0) {
            System.out.println("Se debe introducir algo en el almacén para poder registrar un producto");
        }else flag = true;
        return flag;
    }

    @Override
    public String obtenerStock(Almacen2 almacen) {
        return "\nStock en almacén: \n"+
                "\nProducto congelado: "+almacen.congeladoAlmacenado.size()+
                "\nProducto fresco: "+almacen.frescoAlmacenado.size()+
                "\nProducto refrigerado: "+almacen.refrigeradoAlmacenado.size();
    }

    @Override
    public String sacarCantidad(Producto producto, int cantidad) {
        int i = 0;
        if (producto instanceof Congelado) {
            i = extraerProducto(cantidad,congeladoAlmacenado);
        } else if (producto instanceof Fresco) {
            i = extraerProducto(cantidad,frescoAlmacenado);
        }else {
            i = extraerProducto(cantidad,refrigeradoAlmacenado);
        }
        return"Se ha sacado una cantidad de stock de: "+i;
    }
    @Override
    public int extraerProducto(int cantidad,ArrayList array) {
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
        return "El almacén tiene una capacidad de "+STOCK_MAX+ " palets"+
                "\nlos cuales están organizados en:"+
                "\nCongelador: "+CONGELADO_STOCK_MAX+" palets"+
                "\nRefrigerador: "+REFRIGERADO_STOCK_MAX+" palets"+
                "\nEstantes: "+FRESCO_STOCK_MAX+" palets";
    }
}
