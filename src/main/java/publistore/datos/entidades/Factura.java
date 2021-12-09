package publistore.datos.entidades;

public class Factura {
    private int idFactura;
    private int cedula;
    private String nombre;
    private String apellido;
    private int idDetalle;
    private int idServicio;
    private String nombreServicio;
    private float descuento;
    private float total;

    public Factura() {
    }

    public Factura(int idFactura, int cedula, int idDetalle) {
        this.idFactura = idFactura;
        this.cedula = cedula;
        this.idDetalle = idDetalle;
    }

    public Factura(int idFactura, int cedula, String nombre, String apellido, int idDetalle, int idServicio, String nombreServicio, float descuento, float total) {
        this.idFactura = idFactura;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.idDetalle = idDetalle;
        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
        this.descuento = descuento;
        this.total = total;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

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
