package almacen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Estantes{
    private final int FRESCO_STOCK_MAX;
    public ArrayList<Fresco> frescoAlmacenado;
    public Estantes(int stockMax) {
        FRESCO_STOCK_MAX = stockMax;
        ArrayList <Congelado> frescoAlmacenado = new ArrayList<>();
    }
    public String almacenarEstantes(Fresco fresco) {
        fresco.setProductoAlmacenado(true);
        for (int i = 1 ; i <= fresco.getStockProducto(); i++){
            frescoAlmacenado.add(fresco);
        }
        return"añadido/s " + fresco.getStockProducto() + " palets de "+fresco.getNOMBRE_PRODUCTO()+"\n";
    }
    public String obtenerStockEstantes() {
        return "\nStock en congelador: \n" + frescoAlmacenado.size();
    }
    public void organizarEstantesPorFecha() {
        Collections.sort(frescoAlmacenado, Comparator.comparing(Producto::getFECHA_CADUCIDAD));
    }

    public int getFRESCO_STOCK_MAX() {
        return FRESCO_STOCK_MAX;
    }
}
