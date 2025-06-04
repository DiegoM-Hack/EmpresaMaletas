abstract class Empleado {
    // Atributos protegidos accesibles por clases hijas
    protected String nombre;
    protected String id;
    protected String rol;

    // Constructor para inicializar los datos del empleado
    public Empleado(String nombre, String id, String rol) {
        this.nombre = nombre;
        this.id = id;
        this.rol = rol;
    }

    // Metodo para mostrar la informacion basica del empleado
    public void mostrarInfo() {
        System.out.println("Empleado: " + nombre + " | Rol: " + rol);
    }
}