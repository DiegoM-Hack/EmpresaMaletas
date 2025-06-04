class Cajero extends Empleado {
    // Constructor que asigna el rol "Cajero"
    public Cajero(String nombre, String id) {
        super(nombre, id, "Cajero");
    }

    // Metodo para realizar una venta de un producto
    public void realizarVenta(Producto p, int cantidad) {
        if (cantidad > p.getStock()) {
            System.out.println("Stock insuficiente. Solo hay " + p.getStock() + " unidades disponibles.");
            return;
        }


        double subtotal = p.getPrecio() * cantidad;
        if (p instanceof Mochila) subtotal *= 0.90;
        if (p instanceof MaletaViaje) subtotal *= 0.80;
        double total = subtotal * 1.15;

        // Descontar stock
        p.setStock(p.getStock() - cantidad);

        Main.historialVentas.add(new Venta(p, cantidad, total));

        System.out.println("Venta realizada. Total a pagar: $" + total);
    }

    // Metodo para consultar el detalle de un producto
    public void consultarDetalle(Producto p) {
        p.mostrarDetalle();
    }

    public void consultarDetalle(Producto p, String mensaje) {
        System.out.println(mensaje);
        p.mostrarDetalle();
    }
}