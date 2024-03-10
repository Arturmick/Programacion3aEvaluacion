package almacen;

import java.util.ArrayList;

public interface IAlmacen {

    public void registrarProducto(Producto producto);
    public String almacenar(Producto producto,ArrayList zona);
    public String obtenerStock(Almacen almacen);
    public String sacarCantidad(Producto producto, int cantidad);
    public void organizarPorFecha(ArrayList aray);
    public int extraerProducto(int cantidad, ArrayList array);
    public boolean comprobarStock(int stock, int max);
}
