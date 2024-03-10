package almacen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Refrigerador{
    private final int REFRIGERADO_STOCK_MAX;
    public ArrayList<Refrigerado> refrigeradoAlmacenado;
    public Refrigerador(int stockMax) {
        REFRIGERADO_STOCK_MAX = stockMax;
        ArrayList <Refrigerado> refrigeradoAlmacenado = new ArrayList<>();
    }
    public String almacenarRefrigerador(Refrigerado refrigerado) {
        refrigerado.setProductoAlmacenado(true);
        for (int i = 1 ; i <= refrigerado.getStockProducto(); i++){
            refrigeradoAlmacenado.add(refrigerado);
        }
        return"añadido/s " + refrigerado.getStockProducto() + " palets de "+refrigerado.getNOMBRE_PRODUCTO()+"\n";
    }
    public String obtenerStockRefrigerador() {
        return "\nStock en congelador: \n" + refrigeradoAlmacenado.size();
    }
    public void organizarRefrigeradorPorFecha() {
        Collections.sort(refrigeradoAlmacenado, Comparator.comparing(Producto::getFECHA_CADUCIDAD));
    }

    public int getREFRIGERADO_STOCK_MAX() {
        return REFRIGERADO_STOCK_MAX;
    }
}
