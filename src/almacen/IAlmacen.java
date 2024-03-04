package almacen;

import java.util.ArrayList;

public interface IAlmacen {

    public void registrarProducto(Producto producto);
    public void almacenar(Producto producto,ArrayList zona);
    public String obtenerStock();
    public void sacarCantidad(Producto producto, int cantidad);
    public void organizarPorFecha(ArrayList aray);
    public int extraerProducto(int cantidad, ArrayList array);
    public double asignarPrecio(Producto producto);
    public int definirStock();
    public boolean comprobarStock(int stock, int max);
}
