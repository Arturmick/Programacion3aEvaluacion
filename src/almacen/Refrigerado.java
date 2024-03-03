package almacen;

import java.time.LocalDate;

public class Refrigerado extends Producto{
    private final int CODIGO_ORG_SUPERVISION;

    public Refrigerado(String nombreProducto, int NUMERO_LOTE, int anyo, int mes, int dia, int codigoOrgSupervision) {
        super(nombreProducto, NUMERO_LOTE, anyo, mes, dia);
        CODIGO_ORG_SUPERVISION = codigoOrgSupervision;
    }


    public int getCODIGO_ORG_SUPERVISION() {
        return CODIGO_ORG_SUPERVISION;
    }
    @Override
    public String toString() {
        return "Producto: "+getNOMBRE_PRODUCTO()+
                "\nFecha de caducidad: "+getFECHA_CADUCIDAD()+
                "\nNúmero de lote: "+getNUMERO_LOTE()+
                "\nCodigo Organización Supervisión Alimentaria: "+getCODIGO_ORG_SUPERVISION();
    }
}
