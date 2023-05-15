import com.mysql.cj.exceptions.StreamingNotifiable;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoServiceImpl extends UnicastRemoteObject implements DaoService {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/vacantes";
    private static final String DB_USER = "usr";
    private static final String DB_PASS = "Unsij2022";
    public DaoServiceImpl() throws RemoteException {
        super();
    }
    public boolean crearVacante(ModeloVacante vacante) throws RemoteException {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String sql = "INSERT INTO Vacante (id, nombre, empresa, descripcion, salario, experiencia, fechaPublicacion, estadoPublicacion, categoria, maxPostulaciones) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, vacante.getId());
            stmt.setString(2, vacante.getNombre());
            stmt.setString(3, vacante.getEmpresa());
            stmt.setString(4, vacante.getDescripcion());
            stmt.setDouble(5, vacante.getSalario());
            stmt.setString(6, vacante.getExperiencia());
            stmt.setString(7, vacante.getFechaPublicacion());
            stmt.setString(8, vacante.getEstadoPublicacion());
            stmt.setString(9, vacante.getCategoria());
            stmt.setInt(10, vacante.getMaxPostulaciones());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<ModeloVacante> listarVacantes() throws RemoteException {
        List<ModeloVacante> vacantes = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String sql = "SELECT * FROM Vacante";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String empresa = rs.getString("empresa");
                String descripcion = rs.getString("descripcion");
                Double salario = rs.getDouble("salario");
                String experiencia = rs.getString("experiencia");
                String fechaPublicacion = rs.getString("fechaPublicacion");
                String estadoPublicacion = rs.getString("estadoPublicacion");
                String categoria = rs.getString("categoria");
                int maxPostulaciones = rs.getInt("maxPostulaciones");
                vacantes.add(new ModeloVacante(id, nombre, empresa, descripcion, salario, experiencia, fechaPublicacion, estadoPublicacion, categoria, maxPostulaciones));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vacantes;
    }

    public ModeloVacante obtenerVacante(int id) throws RemoteException {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String sql = "SELECT * FROM Vacante WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String empresa = rs.getString("empresa");
                String descripcion = rs.getString("descripcion");
                Double salario = rs.getDouble("salario");
                String experiencia = rs.getString("experiencia");
                String fechaPublicacion = rs.getString("fechaPublicacion");
                String estadoPublicacion = rs.getString("estadoPublicacion");
                String categoria = rs.getString("categoria");
                int maxPostulaciones = rs.getInt("maxPostulaciones");
                return new ModeloVacante(id, nombre, empresa, descripcion, salario, experiencia, fechaPublicacion, estadoPublicacion, categoria, maxPostulaciones);
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateVacante(ModeloVacante vacante) throws RemoteException {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String sql = "UPDATE Vacante SET nombre = ?, empresa = ?, descripcion = ?, salario = ?, experiencia = ?, fechaPublicacion = ?, estadoPublicacion = ?, categoria = ?, maxPostulaciones = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, vacante.getNombre());
            stmt.setString(2, vacante.getEmpresa());
            stmt.setString(3, vacante.getDescripcion());
            stmt.setDouble(4, vacante.getSalario());
            stmt.setString(5, vacante.getExperiencia());
            stmt.setString(6, vacante.getFechaPublicacion());
            stmt.setString(7, vacante.getEstadoPublicacion());
            stmt.setString(8, vacante.getCategoria());
            stmt.setInt(9, vacante.getMaxPostulaciones());
            stmt.setInt(10, vacante.getId());
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteVacante(int id) throws RemoteException {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String sql = "DELETE FROM Vacante WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean crearUsuario(ModeloUsuario usuario) throws RemoteException {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String sql = "INSERT INTO Usuario (id, nombre, apellidos, contacto, direccion, pais, estadoCivil, usuario, contrasenia) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, usuario.getId());
            stmt.setString(2, usuario.getNombre());
            stmt.setString(3, usuario.getApellidos());
            stmt.setString(4, usuario.getContacto());
            stmt.setString(5, usuario.getDireccion());
            stmt.setString(6, usuario.getPais());
            stmt.setString(7, usuario.getEstadoCivil());
            stmt.setString(8, usuario.getUsuario());
            stmt.setString(9, usuario.getContrasenia());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public ModeloUsuario obtenerUsuario(int id) throws RemoteException {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String sql = "SELECT * FROM Usuario WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String contacto = rs.getString("contacto");
                String direccion = rs.getString("direccion");
                String pais = rs.getString("pais");
                String estadoCivil = rs.getString("estadoCivil");
                String usuario = rs.getString("usuario");
                String contrasenia = rs.getString("contrasenia");
                return new ModeloUsuario(id, nombre, apellidos, contacto, direccion, pais, estadoCivil, usuario, contrasenia);
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public int inicioSesion(String usuario, String contrasenia) throws RemoteException {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String sql = "SELECT * FROM Usuario WHERE usuario = ? AND contrasenia = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2,contrasenia);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String contacto = rs.getString("contacto");
                String direccion = rs.getString("direccion");
                String pais = rs.getString("pais");
                String estadoCivil = rs.getString("estadoCivil");
                String usuario1 = rs.getString("usuario");
                String contrasenia1 = rs.getString("contrasenia");

                if (id != 0){
                    return id;
                }else{
                    return 0;
                }

            } else {
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }


    public boolean crearEmpleo(ModeloEmpleo empleo, int idVacante, int idUsuario) throws RemoteException {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String sql = "INSERT INTO Empleos (id, idVacante, idUsuario) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, empleo.getId());
            stmt.setInt(2, idVacante);
            stmt.setInt(3, idUsuario);
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ModeloEmpleo obtenerEmpleo(int id) throws RemoteException {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String sql = "SELECT * FROM Empleos WHERE idUsuario = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int idEmpleo = rs.getInt("id");
                int idVacante = rs.getInt("idVacante");
                int idUsuario = rs.getInt("idUsuario");
                return new ModeloEmpleo(idEmpleo, idVacante, idUsuario);
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public boolean crearProfesion(ModeloProfesion profesion, int id) throws RemoteException {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String sql = "INSERT INTO Profesion (id, idUsuario, carerraEstudiada, cedula, escuela, anioInicio, anioFin) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, profesion.getId());
            stmt.setInt(2, id);
            stmt.setString(3, profesion.getCarreraEstudiada());
            stmt.setString(4,profesion.getCedula());
            stmt.setString(5,profesion.getEscuela());
            stmt.setString(6,profesion.getAnioInicio());
            stmt.setString(7,profesion.getAnioFin());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public ModeloProfesion obtenerProfesion(int id) throws RemoteException {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String sql = "SELECT * FROM Profesion WHERE idUsuario = ? LIMIT 1";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int idProfesion = rs.getInt("id");
                int idUsuario = rs.getInt("idUsuario");
                String carreraEstudiada = rs.getString("carreraEstudiada");
                String cedula = rs.getString("cedula");
                String escuela = rs.getString("escuela");
                String anioInicio = rs.getString("anioInicio");
                String anioFin = rs.getString("anioFin");
                return new ModeloProfesion(idProfesion, idUsuario, carreraEstudiada, cedula, escuela, anioInicio, anioFin);
            } else {
                return new ModeloProfesion(0, 0, "", "", "", "", "");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return new ModeloProfesion(0, 0, "", "", "", "", "");
        }
    }


    public boolean crearExperienciaAdicional(ModeloExperienciaAdicional exAdicional, int id) throws RemoteException {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String sql = "INSERT INTO ExperienciaAdicional (id, idUsuario, nombreCurso, documentoObtenido, duracion, institucion, " +
                    "fechaInicio, fechaFin) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, exAdicional.getId());
            stmt.setInt(2, id);
            stmt.setString(3, exAdicional.getNombreCurso());
            stmt.setString(4,exAdicional.getDocumentoObtenido());
            stmt.setString(5,exAdicional.getDuracion());
            stmt.setString(6,exAdicional.getInstitucion());
            stmt.setString(7,exAdicional.getFechaInicio());
            stmt.setString(8,exAdicional.getFechaFin());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public ModeloExperienciaAdicional obtenerExAdicional(int id) throws RemoteException {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String sql = "SELECT * FROM ExperienciaAdicional WHERE idUsuario = ? LIMIT 1";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int idExAdicional = rs.getInt("id");
                int idUsuario = rs.getInt("idUsuario");
                String nombreCurso = rs.getString("nombreCurso");
                String documento = rs.getString("documentoObtenido");
                String duracion = rs.getString("duracion");
                String institucion = rs.getString("institucion");
                String fechaInicio = rs.getString("fechaInicio");
                String fechaFin = rs.getString("fechaFin");
                return new ModeloExperienciaAdicional(idExAdicional,idUsuario,nombreCurso,documento,duracion,institucion,fechaInicio,fechaFin);
            } else {
                return new ModeloExperienciaAdicional(0,0,"","","","","","");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return new ModeloExperienciaAdicional(0,0,"","","","","","");

        }
    }


    public boolean crearExperienciaLaboral(ModeloExperienciaLaboral exLaboral, int id) throws RemoteException {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String sql = "INSERT INTO ExperienciaLaboral (id, idUsuario, nombreEmpresa, fechaInicio, fechaFin, responsabilidades) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, exLaboral.getId());
            stmt.setInt(2, id);
            stmt.setString(3, exLaboral.getNombreEmpresa());
            stmt.setString(4,exLaboral.getFechaInicio());
            stmt.setString(5, exLaboral.getFechaFin());
            stmt.setString(6,exLaboral.getResponsabilidades());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public ModeloExperienciaLaboral obtenerExLaboral(int id) throws RemoteException {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String sql = "SELECT * FROM ExperienciaLaboral WHERE idUsuario = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int idExLaboral = rs.getInt("id");
                int idUsuario = rs.getInt("idUsuario");
                String nombreEmpresa = rs.getString("nombreEmpresa");
                String fechaInicio = rs.getString("fechaInicio");
                String fechaFin = rs.getString("fechaFin");
                String responsabilidades = rs.getString("responsabilidades");
                return new ModeloExperienciaLaboral(idExLaboral,idUsuario,nombreEmpresa,fechaInicio,fechaFin,responsabilidades);
            } else {
                return new ModeloExperienciaLaboral(0,0,"","","","");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return new ModeloExperienciaLaboral(0,0,"","","","");
        }
    }
}
