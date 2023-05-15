import java.io.Serializable;

public class ModeloEmpleo implements Serializable {
    int id;
    int idVacante;
    int idUsuario;

    public ModeloEmpleo(int id, int idVacante, int idUsuario) {
        this.id = id;
        this.idVacante = idVacante;
        this.idUsuario = idUsuario;
    }

    public ModeloEmpleo() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVacante() {
        return idVacante;
    }

    public void setIdVacante(int idVacante) {
        this.idVacante = idVacante;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "ModeloEmpleo{" +
                "id=" + id +
                ", idVacante=" + idVacante +
                ", idUsuario=" + idUsuario +
                '}';
    }
}
