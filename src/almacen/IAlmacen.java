package almacen;

import java.util.ArrayList;

public interface IAlmacen {

    public String verStock();
    public void sacarCantidad(Producto producto, int cantidad);
    public void organizarPorFecha(ArrayList aray);
}
//        if (stock >= CONGELADO_STOCK_MAX)
//        System.out.println("El producto no cabe en el almacén");
//        else if (stock <= SIN_STOCK) {
//        System.out.println("Se debe introducir algo en el almacén para poder registrar un producto");
//        }else {
//almacenar(congelado);
//organizarPorFecha(congeladoAlmacenado);
//            System.out.println("productos almacenados");
//        }

//    public void almacenar (Refrigerado refrigerado){
//        refrigerado.setProductoAlmacenado(true);
//        for (int i = 1 ; i <= stock; i++){
//            refrigeradoAlmacenado.add(refrigerado);
//        }
//    }
//    public void almacenar (Fresco fresco){
//        fresco.setProductoAlmacenado(true);
//        for (int i = 1 ; i <= stock; i++){
//            frescoAlmacenado.add(fresco);
//        }
//    }
