package es.masanz.da.model;

public class Usuario {

    private int id;
    private String nombre;
    private String apellido;
    private String password;
    private int rol;
    private int peso;

    public Usuario() {
        this(0, "", "", "", 0, 0);
    }

    public Usuario(int id, String nombre, String apellido, String password, int rol, int peso) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.rol = rol;
        this.peso = peso;
    }

    // region Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }



    // endregion

    public String toXml() {
        StringBuilder sb = new StringBuilder();
        sb.append("<usuario id='").append(id).append("'>");
        sb.append("<nombre>").append(nombre).append("</nombre>");
        sb.append("<apellido>").append(apellido).append("</apellido>");
        sb.append("<password>").append(password).append("</password>");
        sb.append("<rol>").append(rol).append("</rol>");
        sb.append("<peso>").append(peso).append("</peso>");
        sb.append("</usuario>");
        return sb.toString();
    }
}
