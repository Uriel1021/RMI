import java.rmi.Remote;
import java.rmi.RemoteException;

import java.util.List;

public interface DaoService extends Remote {
    //public boolean crearVacante(ModeloVacante vacante) throws RemoteException;
    //public boolean deleteVacante(int id) throws RemoteException;
    //Para las vacantes
    public List<ModeloVacante> listarVacantes() throws RemoteException;
    public ModeloVacante obtenerVacante(int id) throws RemoteException;
    public boolean updateVacante(ModeloVacante vacante) throws RemoteException;
    //Para los usuarios
    public boolean crearUsuario(ModeloUsuario usuario) throws RemoteException;
    public ModeloUsuario obtenerUsuario(int id) throws  RemoteException;
    public int inicioSesion(String usuario, String contrasenia) throws  RemoteException;
    //Para empleo
    public boolean crearEmpleo(ModeloEmpleo empleo, int idVacante, int idUsuario) throws  RemoteException;
    public ModeloEmpleo obtenerEmpleo(int id) throws RemoteException;
    //Para profesion
    public boolean crearProfesion(ModeloProfesion profesion, int id) throws  RemoteException;
    public ModeloProfesion obtenerProfesion(int id) throws RemoteException;
    //Para experiencia adicional
    public boolean crearExperienciaAdicional(ModeloExperienciaAdicional exAdicional, int id) throws  RemoteException;
    public ModeloExperienciaAdicional obtenerExAdicional(int id) throws RemoteException;
    //Para experiencia loboral
    public boolean crearExperienciaLaboral(ModeloExperienciaLaboral exLaboral, int id) throws  RemoteException;
    public ModeloExperienciaLaboral obtenerExLaboral(int id) throws RemoteException;
}

