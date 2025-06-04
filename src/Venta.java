import java.time.LocalDateTime;

class Venta {
    private Producto producto;
    private int cantidad;
    private double total;
    private LocalDateTime fecha;

    public Venta(Producto producto, int cantidad, double total) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.total = total;
        this.fecha = LocalDateTime.now();
    }

    public void mostrarVenta() {
        System.out.println("Producto: " + producto.getCodigo() + " | Cantidad: " + cantidad +
                " | Total: $" + total + " | Fecha: " + fecha);
    }

}
