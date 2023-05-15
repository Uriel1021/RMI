import javax.swing.*;
import java.awt.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class InformacionUsuario extends JFrame {
    private JLabel nombreLabel, apellidosLabel, contactoLabel, direccionLabel, paisLabel, estadoCivilLabel, usuarioLabel,
            contraseniaLabel,profesionLabel, carreraEstudiadaLabel, cedulaLabel, escuelaLabel, anioInicioLabel,
            anioFinLabel,experienciaLabel, empresaLabel, fechaInicioLabel, fechaFinLabel, responsabilidadesLabel,
            cursoLabel, documentoLabel, duracionLabel, institucionLabel, inicioLabel, finLabel;

    public InformacionUsuario(int id, String nombre, String apellidos, String contacto, String direccion, String pais,
                              String estadoCivil, String usuario, String contrasenia, String carreraEstudiada,
                              String cedula, String escuela, String anioInicio, String anioFin, String nombreEmpresa,
                              String fechaInicio, String fechaFin, String responsabilidades, String nombreCurso,
                              String documentoObtenido, String duracion, String institucion, String inicio, String fin) {
        // Configuración de la ventana
        setTitle("Información del Usuario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 500);
        setLayout(new BorderLayout());

        // Panel para los datos personales
        JPanel datosPanel = new JPanel();
        datosPanel.setLayout(new GridLayout(5, 4));
        datosPanel.setBorder(BorderFactory.createTitledBorder("Datos Personales"));

        nombreLabel = new JLabel("Nombre: " + nombre);
        datosPanel.add(nombreLabel);

        apellidosLabel = new JLabel("Apellidos: " + apellidos);
        datosPanel.add(apellidosLabel);

        contactoLabel = new JLabel("Contacto: " + contacto);
        datosPanel.add(contactoLabel);

        direccionLabel = new JLabel("Dirección: " + direccion);
        datosPanel.add(direccionLabel);

        paisLabel = new JLabel("País: " + pais);
        datosPanel.add(paisLabel);

        estadoCivilLabel = new JLabel("Estado Civil: " + estadoCivil);
        datosPanel.add(estadoCivilLabel);

        usuarioLabel = new JLabel("Usuario: " + usuario);
        datosPanel.add(usuarioLabel);

        contraseniaLabel = new JLabel("Contraseña: " + contrasenia);
        datosPanel.add(contraseniaLabel);

        // Panel para los datos de profesión
        JPanel profesionPanel = new JPanel();
        profesionPanel.setLayout(new GridLayout(14, 2));
        profesionPanel.setBorder(BorderFactory.createTitledBorder("Datos de Profesión"));

        profesionLabel = new JLabel("Profesión:");
        profesionPanel.add(profesionLabel);

        carreraEstudiadaLabel = new JLabel("Carrera Estudiada: " + carreraEstudiada);
        profesionPanel.add(carreraEstudiadaLabel);

        cedulaLabel = new JLabel("Cédula: " + cedula);
        profesionPanel.add(cedulaLabel);

        escuelaLabel = new JLabel("Escuela: " + escuela);
        profesionPanel.add(escuelaLabel);

        anioInicioLabel = new JLabel("Año de inicio: " + anioInicio);
        profesionPanel.add(anioInicioLabel);

        anioFinLabel = new JLabel("Año de finalización: " + anioFin);
        profesionPanel.add(anioFinLabel);

        // Panel para los datos de experiencia laboral
        JPanel experienciaPanel = new JPanel();
        experienciaPanel.setLayout(new GridLayout(14, 2));
        experienciaPanel.setBorder(BorderFactory.createTitledBorder("Experiencia Laboral"));

        experienciaLabel = new JLabel("Experiencia Laboral:");
        experienciaPanel.add(experienciaLabel);

        empresaLabel = new JLabel("Nombre de la Empresa: " + nombreEmpresa);
        experienciaPanel.add(empresaLabel);

        fechaInicioLabel = new JLabel("Fecha de Inicio: " + fechaInicio);
        experienciaPanel.add(fechaInicioLabel);

        fechaFinLabel = new JLabel("Fecha de Fin: " + fechaFin);
        experienciaPanel.add(fechaFinLabel);

        responsabilidadesLabel = new JLabel("Responsabilidades: " + responsabilidades);
        experienciaPanel.add(responsabilidadesLabel);

        // Panel para los datos de experiencia adicional
        JPanel adicionalPanel = new JPanel();
        adicionalPanel.setLayout(new GridLayout(14, 2));
        adicionalPanel.setBorder(BorderFactory.createTitledBorder("Experiencia Adicional"));

        cursoLabel = new JLabel("Nombre del Curso: " + nombreCurso);
        adicionalPanel.add(cursoLabel);

        documentoLabel = new JLabel("Documento Obtenido: " + documentoObtenido);
        adicionalPanel.add(documentoLabel);

        duracionLabel = new JLabel("Duración: " + duracion);
        adicionalPanel.add(duracionLabel);

        institucionLabel = new JLabel("Institución: " + institucion);
        adicionalPanel.add(institucionLabel);

        inicioLabel = new JLabel("Fecha de Inicio: " + inicio);
        adicionalPanel.add(inicioLabel);

        finLabel = new JLabel("Fecha de Fin: " + fin);
        adicionalPanel.add(finLabel);

        JPanel botonesPanel = new JPanel();
        datosPanel.setLayout(new GridLayout(6, 2));
        datosPanel.setBorder(BorderFactory.createTitledBorder(" "));

        // Botón para ver empleo
        JButton verEmpleoButton = new JButton("Mi empleo");
        verEmpleoButton.addActionListener(e -> {
            if (obtenerIdVacante(id) == 0){
                JOptionPane.showMessageDialog(InformacionUsuario.this, "No tiene empleo", "Desempleado jaja", JOptionPane.ERROR_MESSAGE);
            }
        });
        botonesPanel.add(verEmpleoButton);

        // Botón para agregar Datos de profesion
        JButton agregarDatosDeProfesionButton = new JButton("Agregar profesion");
        agregarDatosDeProfesionButton.addActionListener(e -> {
            RegistroProfesion registroProfesion = new RegistroProfesion(id);
        });
        botonesPanel.add(agregarDatosDeProfesionButton);

        // Botón para agregar experiencia laboral
        JButton agregarExperienciaLaboralButton = new JButton("Agregar laboral");
        agregarExperienciaLaboralButton.addActionListener(e -> {

        });
        botonesPanel.add(agregarExperienciaLaboralButton);

        // Botón para agregar experiencia adicional
        JButton agregarExperienciaAdicionalButton = new JButton("Agregar adicional");
        agregarExperienciaAdicionalButton.addActionListener(e -> {
            // Abrir ventana para agregar experiencia adicional

        });
        botonesPanel.add(agregarExperienciaAdicionalButton);


        // Botón para salir
        JButton cerrarButton = new JButton("Salir");
        cerrarButton.addActionListener(e -> {
            // cerrar ventana
            this.dispose();
        });
        botonesPanel.add(cerrarButton);

        // Agregar paneles a la ventana
        add(datosPanel, BorderLayout.NORTH);
        add(profesionPanel, BorderLayout.WEST);
        add(experienciaPanel, BorderLayout.CENTER);
        add(adicionalPanel, BorderLayout.EAST);
        add(botonesPanel,BorderLayout.SOUTH);

        // Mostrar ventana
        setVisible(true);
    }
    public int obtenerIdVacante(int id){
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            DaoService userService = (DaoService) registry.lookup("UserService");
            ModeloEmpleo modeloEmpleo = userService.obtenerEmpleo(id);
            ModeloVacante modeloVacante = userService.obtenerVacante(modeloEmpleo.idVacante);
            DetallesVacante detallesVacante = new DetallesVacante(modeloVacante.nombre, modeloVacante.empresa, modeloVacante.descripcion,
                    modeloVacante.salario, modeloVacante.experiencia, modeloVacante.fechaPublicacion, modeloVacante.estadoPublicacion, modeloVacante.categoria);
            detallesVacante.setVisible(true);
            return 1;
        } catch (Exception x) {
            x.printStackTrace();
            System.out.println(x.getMessage());
        }
        return 0;
    }
}

