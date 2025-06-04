
class Producto {
    // Atributos privados del producto
    private String codigo;
    private String descripcion;
    private String ubicacion;
    private int stock;
    private double precio;

    // Constructor para inicializar un producto con todos sus atributos
    public Producto(String codigo, String descripcion, String ubicacion, int stock, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.stock = stock;
        this.precio = precio;
    }

    // Metodo para obtener el precio del producto
    public double getPrecio() {
        return precio;
    }

    // Metodo para obtener el codigo del producto
    public String getCodigo() {
        return codigo;
    }

    // Metodo para mostrar todos los detalles del producto
    public void mostrarDetalle() {
        System.out.println("\nCodigo: " + codigo);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Ubicacion: " + ubicacion);
        System.out.println("Stock: " + stock);
        System.out.println("Precio: $" + precio);
    }

    // Metodo para mostrar solo el precio del producto
    public void mostrarPrecio() {
        System.out.println("\nPrecio del producto: $" + precio);
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
