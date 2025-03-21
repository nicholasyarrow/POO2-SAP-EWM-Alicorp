package model;

/**
 *
 * Clase que representa un usuario.
 */
public class Usuario {
    private int id;
    private String apellidos;
    private String nombres;
    private String usuario;
    private String clave;
    private String rol;

    // Constructor con todos los atributos
    public Usuario(int id, String apellidos, String nombres, String usuario, String clave, String rol) {
        this.id = id;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.usuario = usuario;
        this.clave = clave;
        this.rol = rol;
    }

    // Constructor vacío necesario para algunas operaciones
    public Usuario() {
    }

    // Métodos getter y setter para todos los atributos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
