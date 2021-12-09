package publistore.datos.entidades;

public class Detalles {
    private int idDetalle;
    private int codServicio;
    private String nombreServicio;
    private float precioServicio;
    //private int iva;
    private float descuento;
    private float total;

    public Detalles() {
    }

    public Detalles(int idDetalle, int codServicio, /*int iva,*/float descuento, float total) {
        this.idDetalle = idDetalle;
        this.codServicio = codServicio;
        //this.iva = iva;
        this.descuento = descuento;
        this.total = total;
    }

    public Detalles(int idDetalle, int codServicio, String nombreServicio, float precioProducto,/* int iva,*/ float descuento, float total) {
        this.idDetalle = idDetalle;
        this.codServicio = codServicio;
        this.nombreServicio = nombreServicio;
        this.precioServicio = precioServicio;
        //this.iva = iva;
        this.descuento = descuento;
        this.total = total;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getCodServicio() {
        return codServicio;
    }

    public void setCodServicio(int codServicio) {
        this.codServicio = codServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public float getPrecioServicio() {
        return precioServicio;
    }

    public void setPrecioServicio(float precioServicio) {
        this.precioServicio = precioServicio;
    }

//    public int getIva() {
//        return iva;
//    }
//
//    public void setIva(int iva) {
//        this.iva = iva;
//    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    
}
