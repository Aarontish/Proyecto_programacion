package modelos;

public class Usuario {
    private int idUsuario;
    private String nombreUsuario; 
    private String contraseñaHash;
    private String rol;         

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombreUsuario, String contraseñaHash, String rol) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contraseñaHash = contraseñaHash;
        this.rol = rol;
    }

    // Getters y Setters
    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }

    public String getContraseñaHash() { return contraseñaHash; }
    public void setContraseñaHash(String contraseñaHash) { this.contraseñaHash = contraseñaHash; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    @Override
    public String toString() {
        return "Usuario{" +
               "idUsuario=" + idUsuario +
               ", nombreUsuario='" + nombreUsuario + '\'' +
               ", rol='" + rol + '\'' +
               '}';
    }
}
