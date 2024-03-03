package almacen;

import java.time.LocalDate;

public class Fresco extends Producto{
    private final LocalDate FECHA_ENVASADO;
    private final String PAIS_ORIGEN;

    public Fresco(String nombreProducto, int NUMERO_LOTE, int anyo, int mes, int dia,int anyoEnvase, int mesEnvase, int diaEnvase, String paisOrigen) {
        super(nombreProducto, NUMERO_LOTE, anyo, mes, dia);
        FECHA_ENVASADO = LocalDate.of(anyoEnvase,mesEnvase,diaEnvase);
        PAIS_ORIGEN = paisOrigen;
    }

    public LocalDate getFECHA_ENVASADO() {
        return FECHA_ENVASADO;
    }

    public String getPAIS_ORIGEN() {
        return PAIS_ORIGEN;
    }
    @Override
    public String toString() {
        return "Producto: "+getNOMBRE_PRODUCTO() +
                "\nFecha de caducidad: "+getFECHA_CADUCIDAD()+
                "\nNúmero de lote: "+getNUMERO_LOTE()+
                "\nFecha de envasado: "+getFECHA_ENVASADO()+
                "\nPaís de origen: "+getPAIS_ORIGEN();
    }
}
