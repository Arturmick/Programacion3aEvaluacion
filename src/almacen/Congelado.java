package almacen;

import java.time.LocalDate;

public class Congelado extends Producto {
    private final double TEMPERATURA_CONGELACION_RECOMENDADA;

    public Congelado(String nombreProducto, int NUMERO_LOTE, int anyo, int mes, int dia, double temperaturaCongelacionRecomendada) {
        super(nombreProducto, NUMERO_LOTE, anyo, mes, dia);
        TEMPERATURA_CONGELACION_RECOMENDADA = temperaturaCongelacionRecomendada;
    }


    public double getTEMPERATURA_CONGELACION_RECOMENDADA() {
        return TEMPERATURA_CONGELACION_RECOMENDADA;
    }
    @Override
    public String toString() {
        return "Producto: "+getNOMBRE_PRODUCTO()+
                "\nFecha de caducidad: "+getFECHA_CADUCIDAD()+
                "\nNúmero de lote: "+getNUMERO_LOTE()+
                "\nTemperatura de congelación recomendada: "+getTEMPERATURA_CONGELACION_RECOMENDADA();
    }
}
