import java.io.Serializable;
import java.util.Date;

public class ModeloExperienciaAdicional implements Serializable {
    int id;
    int idUsuario;
    String nombreCurso;
    String documentoObtenido;
    String duracion;
    String institucion;
    String fechaInicio;
    String fechaFin;

    public ModeloExperienciaAdicional(int id, int idUsuario, String nombreCurso, String documentoObtenido, String duracion, String institucion, String fechaInicio, String fechaFin) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.nombreCurso = nombreCurso;
        this.documentoObtenido = documentoObtenido;
        this.duracion = duracion;
        this.institucion = institucion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
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

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getDocumentoObtenido() {
        return documentoObtenido;
    }

    public void setDocumentoObtenido(String documentoObtenido) {
        this.documentoObtenido = documentoObtenido;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
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

    @Override
    public String toString() {
        return "ModeloExperienciaAdicional{" +
                "id=" + id +
                ", idUsuario=" + idUsuario +
                ", nombreCurso='" + nombreCurso + '\'' +
                ", documentoObtenido='" + documentoObtenido + '\'' +
                ", duracion='" + duracion + '\'' +
                ", institucion='" + institucion + '\'' +
                ", fechaInicio='" + fechaInicio + '\'' +
                ", fechaFin='" + fechaFin + '\'' +
                '}';
    }
}
