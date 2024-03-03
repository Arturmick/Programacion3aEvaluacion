//duda, como dejar un atributo sin setear en el constructor, pero que sea final para que en el futuro se pueda setear, pero no se pueda cambiar
//quiero que el precio sea final para cada objeto, pero no setearlo al crear el producto sino a la llegada al almacén
package almacen;

import java.time.LocalDate;

public class Producto {
    private final int NUMERO_LOTE;
    private final LocalDate FECHA_CADUCIDAD;
    private final String NOMBRE_PRODUCTO;
    private double precioProducto;
    private boolean productoAlmacenado = false;

    public Producto (String nombreProducto, int NUMERO_LOTE,int anyoCaducidad, int mesCaducidad, int diaCaducidad) {
        this.NOMBRE_PRODUCTO = nombreProducto;
        this.FECHA_CADUCIDAD = LocalDate.of(anyoCaducidad, mesCaducidad, diaCaducidad);
        this.NUMERO_LOTE = NUMERO_LOTE;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public void setProductoAlmacenado(boolean productoAlmacenado) {
        this.productoAlmacenado = productoAlmacenado;
    }

    public String getNOMBRE_PRODUCTO() {
        return NOMBRE_PRODUCTO;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public int getNUMERO_LOTE() {
        return NUMERO_LOTE;
    }

    public LocalDate getFECHA_CADUCIDAD() {
        return FECHA_CADUCIDAD;
    }

    public boolean isProductoAlmacenado() {
        return productoAlmacenado;
    }

}
