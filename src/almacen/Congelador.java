package almacen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Congelador {
    private final int CONGELADO_STOCK_MAX;
    public ArrayList<Congelado> congeladoAlmacenado;

    public Congelador(int congeladoStockMax) {
        CONGELADO_STOCK_MAX = congeladoStockMax;
    }
    public String almacenarCongelador(Congelado congelado) {
        congelado.setProductoAlmacenado(true);
        for (int i = 1 ; i <= congelado.getStockProducto(); i++){
            congeladoAlmacenado.add(congelado);
        }
        return"añadido/s " + congelado.getStockProducto() + " palets de "+congelado.getNOMBRE_PRODUCTO()+"\n";
    }

    public String obtenerStockCongelador() {
        return "\nStock en congelador: \n" + congeladoAlmacenado.size();
    }
    public void organizarCongeladorPorFecha() {
        Collections.sort(congeladoAlmacenado, Comparator.comparing(Producto::getFECHA_CADUCIDAD));
    }

    public int getCONGELADO_STOCK_MAX() {
        return CONGELADO_STOCK_MAX;
    }
}
