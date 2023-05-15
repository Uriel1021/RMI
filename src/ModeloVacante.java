import java.io.Serializable;

/*
La clase User es una clase simple de Java que implementa la interfaz Serializable. Esta interfaz permite que los objetos de la clase
se serialicen y se envíen a través de la red, lo que es necesario para que los clientes puedan acceder a los objetos remotos.
 */
public class ModeloVacante implements Serializable {
    int id;
    String nombre;
    String empresa;
    String descripcion;
    Double salario;
    String experiencia;
    String fechaPublicacion;
    String estadoPublicacion;
    String categoria;
    int maxPostulaciones;

    public ModeloVacante(int id, String nombre, String empresa, String descripcion, Double salario, String experiencia, String fechaPublicacion, String estadoPublicacion, String categoria, int maxPostulaciones) {
        this.id = id;
        this.nombre = nombre;
        this.empresa = empresa;
        this.descripcion = descripcion;
        this.salario = salario;
        this.experiencia = experiencia;
        this.fechaPublicacion = fechaPublicacion;
        this.estadoPublicacion = estadoPublicacion;
        this.categoria = categoria;
        this.maxPostulaciones = maxPostulaciones;
    }

    public ModeloVacante() {

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

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getEstadoPublicacion() {
        return estadoPublicacion;
    }

    public void setEstadoPublicacion(String estadoPublicacion) {
        this.estadoPublicacion = estadoPublicacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getMaxPostulaciones() {
        return maxPostulaciones;
    }

    public void setMaxPostulaciones(int maxPostulaciones) {
        this.maxPostulaciones = maxPostulaciones;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", empresa='" + empresa + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", salario=" + salario +
                ", experiencia='" + experiencia + '\'' +
                ", fechaPublicacion=" + fechaPublicacion +
                ", estadoPublicacion='" + estadoPublicacion + '\'' +
                ", categoria='" + categoria + '\'' +
                ", maxPostulaciones=" + maxPostulaciones +
                '}';
    }
}
