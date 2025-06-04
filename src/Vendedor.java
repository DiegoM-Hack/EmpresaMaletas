
class Vendedor extends Empleado {
    public Vendedor(String nombre, String id) {
        super(nombre, id, "Vendedor");
    }

    //Metodo para consultar detalles del producto
    public void consultarDetalle(Producto p) {
        p.mostrarDetalle();
    }
}