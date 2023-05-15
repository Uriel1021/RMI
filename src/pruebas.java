import java.rmi.RemoteException;

public class pruebas {
    public static void main(String[] args) throws RemoteException {
        //prueba1(); //funcionoooooooooooooooo aaahhhhhh
        //prueba2(); //funcionooooooooooooooooooooooooooo tambieeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeen
        //prueba3(); //Awewooooooooooooooooooooooo
        //prueba4();
        //prueba5();
        prueba6();
    }

    public static void prueba1() throws RemoteException {
        DaoServiceImpl daoService = new DaoServiceImpl();
        ModeloEmpleo modeloEmpleo = new ModeloEmpleo();
        int idUsuario = 3;
        int idVacante = 3;
        boolean si = daoService.crearEmpleo(modeloEmpleo,idVacante,idUsuario);
        if (si == true){
            System.out.println("Genial");
        }else{
            System.out.println("No genial");
        }
    }

    public static void prueba2() throws RemoteException {
        DaoServiceImpl daoService = new DaoServiceImpl();
        ModeloEmpleo modeloEmpleo = new ModeloEmpleo();
        int idUsuario = 3;
        modeloEmpleo = daoService.obtenerEmpleo(idUsuario);
        System.out.println(modeloEmpleo.toString());
    }
    public static void prueba3() throws RemoteException {
        DaoServiceImpl daoService = new DaoServiceImpl();
        ModeloUsuario modeloUsuario = new ModeloUsuario();
        int idUsuario = 3;
        modeloUsuario = daoService.obtenerUsuario(idUsuario);
        System.out.println(modeloUsuario.toString());
    }
    public static void prueba4() throws RemoteException {
        DaoServiceImpl daoService = new DaoServiceImpl();

        String usuario = "Ariake";
        String password = "123456";
        int si = daoService.inicioSesion(usuario,password);
        if (si != 0){
            System.out.println("Genial, el id es: "+si);
        }else{
            System.out.println("No genial");
        }
    }

    public static void prueba5() throws RemoteException {
        DaoServiceImpl daoService = new DaoServiceImpl();
        ModeloProfesion modeloProfesion = new ModeloProfesion();
        int idUsuario = 1;
        modeloProfesion= daoService.obtenerProfesion(idUsuario);
        System.out.println(modeloProfesion.toString());
    }

    public static void prueba6() throws RemoteException {
        DaoServiceImpl daoService = new DaoServiceImpl();
        ModeloExperienciaAdicional modeloExperienciaAdicional;
        int idUsuario = 3;
        modeloExperienciaAdicional= daoService.obtenerExAdicional(idUsuario);
        System.out.println(modeloExperienciaAdicional.toString());
    }

}
