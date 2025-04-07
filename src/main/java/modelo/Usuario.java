package modelo;
import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "id_usuario")
    private int id;

    @Column(name = "nombre_usuario")
    private String nombre;

    @Column(name = "contrasena_usuario")
    private String contrasena;

    @Column(name = "identificacion_usuario")
    private String identificacion;

    @Column(name = "correo_usuario")
    private String correo;

    public Usuario() {}

    public Usuario(int id, String nombre, String contrasena, String identificacion, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.identificacion = identificacion;
        this.correo = correo;
    }

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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
