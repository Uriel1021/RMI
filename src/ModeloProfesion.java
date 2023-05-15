import java.io.Serializable;
import java.util.Date;

public class ModeloProfesion implements Serializable {
    int id;
    int idUsuario;
    String carreraEstudiada;
    String cedula;
    String escuela;
    String anioInicio;
    String anioFin;

    public ModeloProfesion(int id, int idUsuario, String carreraEstudiada, String cedula, String escuela, String anioInicio, String anioFin) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.carreraEstudiada = carreraEstudiada;
        this.cedula = cedula;
        this.escuela = escuela;
        this.anioInicio = anioInicio;
        this.anioFin = anioFin;
    }

    public ModeloProfesion() {

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

    public String getCarreraEstudiada() {
        return carreraEstudiada;
    }

    public void setCarreraEstudiada(String carreraEstudiada) {
        this.carreraEstudiada = carreraEstudiada;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    public String getAnioInicio() {
        return anioInicio;
    }

    public void setAnioInicio(String anioInicio) {
        this.anioInicio = anioInicio;
    }

    public String getAnioFin() {
        return anioFin;
    }

    public void setAnioFin(String anioFin) {
        this.anioFin = anioFin;
    }

    @Override
    public String toString() {
        return "ModeloProfesion{" +
                "id=" + id +
                ", idUsuario=" + idUsuario +
                ", carreraEstudiada='" + carreraEstudiada + '\'' +
                ", cedula='" + cedula + '\'' +
                ", escuela='" + escuela + '\'' +
                ", anioInicio='" + anioInicio + '\'' +
                ", anioFin='" + anioFin + '\'' +
                '}';
    }
}
