import java.io.Serializable;
import java.util.Date;

public class ModeloExperienciaLaboral implements Serializable {
    int id;
    int idUsuario;
    String nombreEmpresa;
    String fechaInicio;
    String fechaFin;
    String responsabilidades;

    public ModeloExperienciaLaboral(int id, int idUsuario, String nombreEmpresa, String fechaInicio, String fechaFin, String responsabilidades) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.nombreEmpresa = nombreEmpresa;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.responsabilidades = responsabilidades;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getResponsabilidades() {
        return responsabilidades;
    }

    public void setResponsabilidades(String responsabilidades) {
        this.responsabilidades = responsabilidades;
    }

    @Override
    public String toString() {
        return "ModeloExperienciaLaboral{" +
                "id=" + id +
                ", idUsuario=" + idUsuario +
                ", nombreEmpresa='" + nombreEmpresa + '\'' +
                ", fechaInicio='" + fechaInicio + '\'' +
                ", fechaFin='" + fechaFin + '\'' +
                ", responsabilidades='" + responsabilidades + '\'' +
                '}';
    }
}
