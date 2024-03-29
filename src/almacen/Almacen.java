package almacen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Almacen{

    private final int STOCK_MAX;
    public Almacen(int a, int b, int c) {
        Congelador congelador = new Congelador(b);
        Refrigerador refrigerador = new Refrigerador(c);
        Estantes estantes = new Estantes(a);
        this.STOCK_MAX = a + b + c;
    }

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
//    @Override
//    public String almacenar(Producto producto,ArrayList zona) {
//        producto.setProductoAlmacenado(true);
//        for (int i = 1 ; i <= producto.getStockProducto(); i++){
//            zona.add(producto);
//        }
//        return"añadido/s " + producto.getStockProducto() + " palets de "+producto.getNOMBRE_PRODUCTO()+"\n";
//    }

    public boolean comprobarStock(int stock, int max) {
        boolean flag = false;
        if (stock > max)
            System.out.println("El producto no cabe en el almacén");
        else if (stock <= 0) {
            System.out.println("Se debe introducir algo en el almacén para poder registrar un producto");
        }else flag = true;
        return flag;
    }

    public String obtenerStockAlmacen() {

        return "\nStock en almacén: \n"+
                "\nProducto congelado: "+congelador.congeladoAlmacenado.size()+
                "\nProducto fresco: "+estantes.frescoAlmacenado.size()+
                "\nProducto refrigerado: "+refrigerador.refrigeradoAlmacenado.size();
    }


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

    public void organizarAlmacenPorFecha(Congelador congelador, Refrigerador refrigerador, Estantes estantes) {
        Collections.sort(congelador.congeladoAlmacenado, Comparator.comparing(Producto::getFECHA_CADUCIDAD));
        Collections.sort(refrigerador.refrigeradoAlmacenado, Comparator.comparing(Producto::getFECHA_CADUCIDAD));
        Collections.sort(estantes.frescoAlmacenado, Comparator.comparing(Producto::getFECHA_CADUCIDAD));
    }
    public String toString(Congelador congelador, Refrigerador refrigerador, Estantes estantes){
        return "El almacén tiene una capacidad de "+STOCK_MAX+ " palets"+
                "\nlos cuales están organizados en:"+
                "\nCongelador: "+congelador.getCONGELADO_STOCK_MAX()+" palets"+
                "\nRefrigerador: "+refrigerador.getREFRIGERADO_STOCK_MAX()+" palets"+
                "\nEstantes: "+estantes.getFRESCO_STOCK_MAX()+" palets";
    }
}
