import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    // Lista de productos disponibles
    static ArrayList<Producto> productos = new ArrayList<>();

    // Lista de empleados registrados
    static ArrayList<Empleado> empleados = new ArrayList<>();

    public static ArrayList<Venta> historialVentas = new ArrayList<>();

    // Scanner para leer la entrada del usuario
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Inicializa los datos de prueba
        inicializarDatos();

        // Se asume que los primeros empleados son cajeros y vendedor
        Cajero cajero1 = (Cajero) empleados.get(0);
        Cajero cajero2 = (Cajero) empleados.get(1);
        Vendedor vendedor1 = (Vendedor) empleados.get(2);

        int opcion;
        do {
            // Menu principal
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Consultar detalle del producto (Cajero/Vendedor)");
            System.out.println("2. Consultar precio (Cliente)");
            System.out.println("3. Realizar venta (Cajero)");
            System.out.println("4. Ver todos los productos");
            System.out.println("5. Ver empleados registrados");
            System.out.println("6. Agregar nuevo producto (Administrador)");
            System.out.println("7. Mostrar productos con bajo stock");
            System.out.println("8. Mostrar historial de ventas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            // Ejecuta la opcion seleccionada
            switch(opcion) {
                case 1 -> consultarDetalle();       // Consulta detalles de un producto
                case 2 -> clienteConsultar();       // Consulta precio del producto
                case 3 -> realizarVenta(cajero1);   // Realiza una venta con el cajero 1
                case 4 -> mostrarTodos();           // Muestra todos los productos
                case 5 -> mostrarEmpleados();       // Muestra todos los empleados
                case 6 -> agregarProducto();        // Agregar producto
                case 7 -> mostrarBajoStock();       // Mostrar productos de bajo stock
                case 8 -> mostrarHistorialVentas(); // Mostrar historial de ventas
            }
        } while(opcion != 0); // Continua hasta que el usuario decida salir
    }

    // Metodo para agregar productos y empleados iniciales
    static void inicializarDatos() {
        // Productos
        productos.add(new Mochila("M01", "Mochila Escolar", "Estante A", 10, 20.5));
        productos.add(new Bolso("B01", "Bolso Mujer", "Estante B", 5, 35.0));
        productos.add(new MaletaViaje("MV01", "Maleta de Viaje", "Estante C", 3, 60.0));
        productos.add(new Lonchera("L01", "Lonchera Ninos", "Estante D", 12, 15.0));

        // Empleados
        empleados.add(new Cajero("Carlos", "C01"));
        empleados.add(new Cajero("Laura", "C02"));
        empleados.add(new Vendedor("Luis", "V01"));
        empleados.add(new Vendedor("Ana", "V02"));
        empleados.add(new Vendedor("Mario", "V03"));
        empleados.add(new Administrador("Lucia", "A01"));
        empleados.add(new Gerente("Raul", "G01"));
        empleados.add(new PersonalLimpieza("Pablo", "L01"));
        empleados.add(new PersonalLimpieza("Sofia", "L02"));
    }

    // Busca un producto por su codigo
    static Producto buscarProducto(String codigo) {
        for (Producto p : productos)
            if (p.getCodigo().equalsIgnoreCase(codigo))
                return p;
        return null;
    }

    // Permite consultar el detalle de un producto
    static void consultarDetalle() {
        System.out.print("Ingrese el codigo del producto: ");
        String cod = sc.next();
        Producto p = buscarProducto(cod);
        if (p != null) p.mostrarDetalle();
        else System.out.println("Producto no encontrado.");
    }

    // Permite al cliente consultar solo el precio de un producto
    static void clienteConsultar() {
        System.out.print("Ingrese el codigo del producto: ");
        String cod = sc.next();
        Producto p = buscarProducto(cod);
        if (p != null) p.mostrarPrecio();
        else System.out.println("Producto no encontrado.");
    }

    // Permite al cajero realizar una venta
    static void realizarVenta(Cajero c) {
        System.out.print("Ingrese el codigo del producto: ");
        String cod = sc.next();
        Producto p = buscarProducto(cod);
        if (p != null) {
            System.out.print("Cantidad a comprar: ");
            int cant = sc.nextInt();
            c.realizarVenta(p, cant);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    // Muestra todos los productos registrados
    static void mostrarTodos() {
        for (Producto p : productos) p.mostrarDetalle();
    }

    // Muestra todos los empleados registrados
    static void mostrarEmpleados() {
        for (Empleado e : empleados) e.mostrarInfo();
    }

    static void agregarProducto() {
        System.out.print("Codigo: ");
        String codigo = sc.next();
        System.out.print("Descripcion: ");
        String desc = sc.next();
        System.out.print("Ubicacion: ");
        String ubic = sc.next();
        System.out.print("Stock inicial: ");
        int stock = sc.nextInt();
        System.out.print("Precio: ");
        double precio = sc.nextDouble();

        System.out.println("Tipo de producto:");
        System.out.println("1. Mochila");
        System.out.println("2. Bolso");
        System.out.println("3. Maleta de viaje");
        System.out.println("4. Lonchera");
        int tipo = sc.nextInt();

        Producto nuevo = switch (tipo) {
            case 1 -> new Mochila(codigo, desc, ubic, stock, precio);
            case 2 -> new Bolso(codigo, desc, ubic, stock, precio);
            case 3 -> new MaletaViaje(codigo, desc, ubic, stock, precio);
            case 4 -> new Lonchera(codigo, desc, ubic, stock, precio);
            default -> null;
        };

        if (nuevo != null) {
            productos.add(nuevo);
            System.out.println("Producto agregado correctamente.");
        } else {
            System.out.println("Tipo no valido.");
        }
    }

    static void mostrarBajoStock() {
        System.out.println("\n--- Productos con stock menor a 3 ---");
        for (Producto p : productos) {
            if (p.getStock() < 3) {
                p.mostrarDetalle();
            }
        }
    }

    static void mostrarHistorialVentas() {
        if (historialVentas.isEmpty()) {
            System.out.println("No hay ventas registradas.");
            return;
        }
        for (Venta v : historialVentas) v.mostrarVenta();
    }

}

