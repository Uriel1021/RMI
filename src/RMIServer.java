import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            DaoService userService = new DaoServiceImpl();
            //crea un registro RMI en el puerto 1099
            Registry registry = LocateRegistry.createRegistry(1099);
            //vincula la instancia de "DaoServiceImpl" con el nombre "UserService" en el registro RMI.
            // Esto significa que los clientes pueden buscar la instancia de "DaoServiceImpl" en el registro utilizando el nombre "UserService".
            registry.rebind("UserService", userService);
            System.out.println("Servidor Iniciado");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}