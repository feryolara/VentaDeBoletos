package sample.modelo;

public class Cliente {
    int clienteId;
    String nombre;
    String apellidos;
    String direccion;

   /*public Cliente(int clienteId, String nombre, String apellidos, String direccion) {
       this.clienteId = clienteId;
       this.nombre = nombre;
       this.apellidos = apellidos;

       this.direccion = direccion;
   }*/
    public int getId() {
        return clienteId;
    }

    public void setClienteId(int id) {
        this.clienteId = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
      return "Cliente{" + "clienteId=" + clienteId + ", nombre='" + nombre + '\'' +", apellidos='" + apellidos + '\'' +
              ", direccion='" + direccion + '\'' + '}';
    }
}
